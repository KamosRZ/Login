package com.fmiproject.login;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.resource.ResourceServerProperties;
import org.springframework.boot.autoconfigure.security.oauth2.resource.UserInfoTokenServices;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.filter.OAuth2ClientAuthenticationProcessingFilter;
import org.springframework.security.oauth2.client.filter.OAuth2ClientContextFilter;
import org.springframework.security.oauth2.client.token.grant.code.AuthorizationCodeResourceDetails;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;



@SpringBootApplication
@EnableOAuth2Client
@RestController
public class SocialApplication extends WebSecurityConfigurerAdapter {

        @RequestMapping("/user")
        public Principal user(Principal principal) {
         return principal;
        }
        
	public static void main(String[] args) {
		SpringApplication.run(SocialApplication.class, args);
	}
        
        private OAuth2ClientAuthenticationProcessingFilter ssoFilter() {
            OAuth2ClientAuthenticationProcessingFilter facebookFilter = new OAuth2ClientAuthenticationProcessingFilter("/login/facebook");
            OAuth2RestTemplate facebookTemplate = new OAuth2RestTemplate(facebook(), oauth2ClientContext);
            facebookFilter.setRestTemplate(facebookTemplate);
            UserInfoTokenServices tokenServices = new UserInfoTokenServices(facebookResource().getUserInfoUri(), facebook().getClientId());
            tokenServices.setRestTemplate(facebookTemplate);
            facebookFilter.setTokenServices(tokenServices);
            return facebookFilter;
        }
        
        @Bean
        public FilterRegistrationBean<OAuth2ClientContextFilter> oauth2ClientFilterRegistration(OAuth2ClientContextFilter filter) {
        FilterRegistrationBean<OAuth2ClientContextFilter> registration = new FilterRegistrationBean<OAuth2ClientContextFilter>();
        registration.setFilter(filter);
        registration.setOrder(-100);
       	return registration;
	}
        
        @Bean
        @ConfigurationProperties("facebook.client")
        public AuthorizationCodeResourceDetails facebook() {
        return new AuthorizationCodeResourceDetails();
        }
        
        @Bean
        public RestTemplate restTemplate() {
            return new RestTemplate();
        }
        
        @Bean
        @ConfigurationProperties("facebook.resource")
        public ResourceServerProperties facebookResource() {
        return new ResourceServerProperties();
        }
        
        @Autowired
        OAuth2ClientContext oauth2ClientContext;
        
        @Override
        protected void configure(HttpSecurity http) throws Exception {
        http.antMatcher("/**") 
         .antMatcher("/**")
         .authorizeRequests()
         .antMatchers("/", "/login**", "/webjars/**", "/error**")
         .permitAll()
         .anyRequest()
         .authenticated()
         .and().logout().logoutSuccessUrl("/").permitAll()
         .and().csrf().disable()
         .addFilterBefore(ssoFilter(), BasicAuthenticationFilter.class);
        
        }
}
