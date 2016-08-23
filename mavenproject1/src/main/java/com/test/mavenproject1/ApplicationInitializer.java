package com.test.mavenproject1;


import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{
         //   JPAConfig.class,
//            LDAPConfig.class,
//            OAuth2AuthorizationServerConfig.class,
//            OAuth2ResourceServerConfig.class,
//            SecurityConfig.class
        };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {        
        return new Class[]{
       //     AppConfig.class
        };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

}
