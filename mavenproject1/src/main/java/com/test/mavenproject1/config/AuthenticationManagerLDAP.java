package com.test.mavenproject1.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.filter.AndFilter;
import org.springframework.ldap.filter.EqualsFilter;
import javax.naming.directory.DirContext;
import org.springframework.ldap.core.support.LdapContextSource;
import org.springframework.stereotype.Component;

//@Component
public class AuthenticationManagerLDAP {

    @Autowired
    LdapTemplate ldapTemplate;

    @Autowired
    LdapContextSource cxtsrc;

    public String login(String userName, String password) {
        String lstUser = getUsers(userName, password);
        if (lstUser != null) {
            return lstUser;
        }
        return null;
    }

    public String getUsers(String userName, String password) {
        DirContext ctx;
        try {
            AndFilter filter = new AndFilter();
            filter.and(new EqualsFilter("cn", userName));
            if (ldapTemplate.authenticate("uid=admin,dc=example,dc=com", filter.toString(), password)) {
                return "Authenticated !!!";
            }
        } catch (org.springframework.ldap.NamingException ne) {
            return null;
        }
        return "Authenticated !!!";
    }

}
