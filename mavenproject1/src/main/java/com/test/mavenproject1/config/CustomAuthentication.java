package com.test.mavenproject1.config;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.core.support.LdapContextSource;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

//@Component
public class CustomAuthentication implements AuthenticationProvider {

    @Autowired
    AuthenticationManagerLDAP authManager;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        if (isValidLADPUser(authentication.getPrincipal(), authentication.getCredentials())) {
            List<GrantedAuthority> grantedAuthorities = new ArrayList();
            UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(authentication.getPrincipal(),
                    authentication.getCredentials(), grantedAuthorities);
            return auth;
        } else {
            throw new BadCredentialsException("Bad User Credentials PROVIDED.");
        }
    }

    @Override
    public boolean supports(Class<?> arg0) {
        return true;
    }

    public boolean isValidLADPUser(Object username, Object password) {
        String userDetails = null;
        if (null != username && null != password) {
            userDetails = authManager.login(username.toString(), password.toString());
        }
        return (null != userDetails);
    }
}
