package com.example.config;

import org.springframework.web.servlet.resource.ResourceUrlEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.*;
import java.util.Collections;

public class MyDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

  @Override
  protected Class<?>[] getRootConfigClasses() {
    return new Class[]{AppConfig.class};
  }

  @Override
  protected Class<?>[] getServletConfigClasses() {
    return new Class[]{WebMvcConfig.class};
  }

  @Override
  protected String[] getServletMappings() {
    return new String[]{"/"};
  }

  @Override
  protected Filter[] getServletFilters() {
    return new Filter[]{new ResourceUrlEncodingFilter()};
  }

  @Override
  public void onStartup(ServletContext servletContext) throws ServletException {
    servletContext.setSessionTrackingModes(Collections.singleton(SessionTrackingMode.COOKIE));
    super.onStartup(servletContext);
  }
}