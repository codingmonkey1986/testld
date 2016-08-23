package com.test.mavenproject1.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.core.support.LdapContextSource;

@Configuration
@PropertySource(value = "classpath:application.properties")
public class LDAPConfig {

    @Autowired
    private Environment env;

    @Bean
    public LdapContextSource contextSourceTarget() {
        LdapContextSource ldapContextSource = new LdapContextSource();
        ldapContextSource.setUrl(env.getProperty("ldap.url"));
        ldapContextSource.setBase(env.getProperty("ldap.base"));
        ldapContextSource.setUserDn(env.getProperty("ldap.userDn"));
        ldapContextSource.setPassword(env.getProperty("ldap.password"));
        ldapContextSource.afterPropertiesSet();
        return ldapContextSource;

    }

    @Bean
    public LdapTemplate ldapTemplate() throws Exception {
        LdapTemplate lt = new LdapTemplate(contextSourceTarget());
        lt.afterPropertiesSet();
        return lt;
    }
}
