package com.sample.resources;

import java.io.Serializable;

public class SampleRequest implements Serializable {

  private static final long serialVersionUID = 1L;  
  
  private String name;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }    

}
