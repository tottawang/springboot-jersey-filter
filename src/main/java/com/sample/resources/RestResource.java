package com.sample.resources;

import javax.servlet.ServletContext;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Component;

import com.sample.conf.CustomAnnotation;

@Component
@Produces(MediaType.APPLICATION_JSON)
@Path("/api")
public class RestResource {
  
  /**
   * Resource class context injection gets called before all registered filters. Filter needs to be annotated 
   * with @PreMatching if you want to call it after a filter.
   */
  @Context
  public void initWithServletContext(ServletContext context) {
    System.out.println("contect injection is applied");
    
    // this is to verify that when exception is thrown in the process of jersey resource class context injection
    // the exception will be suppressed if AOP is involved in the resource class. For more details, please refer 
    // to SpringComponentProvider.SpringManagedBeanFactory.provide implementation
    throw new RuntimeException();
  }

  @POST
  @Path("test")
  @CustomAnnotation(name = "sendRequestName", value="sendRequestValue")
  public String sendRequest(SampleRequest sampleRequest) {
    return sampleRequest.getName();
  }
}
