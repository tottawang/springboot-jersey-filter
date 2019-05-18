package com.sample.conf;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CustomAnnotationAspect {
  
  @Around("@annotation(customAnnotation)")
  public Object aroundAnalyticsDataProvider(ProceedingJoinPoint joinPoint, CustomAnnotation customAnnotation)
          throws Throwable {
      long startTime = System.currentTimeMillis();
      String name = customAnnotation.name();
      try {        
          return joinPoint.proceed();
      } finally {
          long endTime = System.currentTimeMillis();
          System.out.println("Operation: " + name + ", duration: " + String.valueOf(endTime - startTime));
      }
  }

}
