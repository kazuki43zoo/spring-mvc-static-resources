package com.example.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.resource.EncodedResourceResolver;
import org.springframework.web.servlet.resource.VersionResourceResolver;

@ComponentScan("com.example.component.controller")
@Configuration
@EnableWebMvc
public class WebMvcConfig implements WebMvcConfigurer {

  @Override
  public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
    configurer.enable();
  }

  @Override
  public void configureViewResolvers(ViewResolverRegistry registry) {
    registry.jsp();
  }

  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry.addResourceHandler("/resources/**")
        .addResourceLocations("classpath:/static/")
        .setCachePeriod(604800)
        .resourceChain(false)
        .addResolver(new VersionResourceResolver()
            .addContentVersionStrategy("/**/*-content*.css")
            .addFixedVersionStrategy("v1.0.0", "/**/*-fix.css")
        );
    registry.addResourceHandler("/webjars/**")
        .addResourceLocations("classpath:/META-INF/resources/webjars/")
        .resourceChain(false)
        .addResolver(new EncodedResourceResolver());
  }

}
