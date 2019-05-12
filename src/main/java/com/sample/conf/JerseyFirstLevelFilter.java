package com.sample.conf;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.annotation.Priority;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.Context;

/**
 * 
 * Print custom annotation value from resource method
 * 
 * https://stackoverflow.com/questions/20946815/how-can-i-get-resource-annotations-in-a-jersey-2-4-filter
 * Added PreMatching annotation so that the first level filter can be invoked before 
 * jersey resource class context injection <code>RestResource.initWithServletContext</code>
 * 
 */
@Priority(1)
public class JerseyFirstLevelFilter implements ContainerRequestFilter {
  
  @Context
  private ResourceInfo resourceInfo;

  @Override
  public void filter(ContainerRequestContext requestContext) throws IOException { 
    System.out.println("Jersey first level filter is applied");
    
    // Note that method was not injected if JerseyFirstLevelFilter annotated with @PreMatching
    Method method = resourceInfo.getResourceMethod();
    CustomAnnotation ca = method.getAnnotation(CustomAnnotation.class);
    System.out.println("Get custom anntoation name: " + ca.name() + ", value: " + ca.value());
  }

}
