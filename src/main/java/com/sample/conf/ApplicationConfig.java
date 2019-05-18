package com.sample.conf;

import javax.servlet.Filter;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig extends ResourceConfig {

  public ApplicationConfig() {
    packages("com.sample.resources");
    //this.register(JerseyFirstLevelFilter.class);
    //this.register(JerseySecondLevelFilter.class);
  }

  @Bean
  public FilterRegistrationBean myFilter() {
    FilterRegistrationBean registration = new FilterRegistrationBean();
    registration.setFilter(appFilter());
    registration.addUrlPatterns("/*");
    return registration;
  }

  @Bean(name = "appFilter")
  public Filter appFilter() {
    return new ServletFilter();
  }
}
