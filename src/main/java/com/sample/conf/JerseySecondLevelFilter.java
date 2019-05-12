package com.sample.conf;

import java.io.IOException;

import javax.annotation.Priority;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;

@Priority(2)
public class JerseySecondLevelFilter implements ContainerRequestFilter {  
  
  @Override
  public void filter(ContainerRequestContext requestContext) throws IOException {        
    // TODO Auto-generated method stub
    System.out.println("Jersey second level filter is applied");
  }

}
