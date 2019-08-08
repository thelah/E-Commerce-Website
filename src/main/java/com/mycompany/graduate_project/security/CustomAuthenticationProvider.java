/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.graduate_project.security;


import com.mycompany.graduate_project.entities.AccountEntity;
import com.mycompany.graduate_project.entities.RoleEntity;
import com.mycompany.graduate_project.service.AccountService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

/**
 *
 * @author AnhLe
 */
@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private AccountService accountService;

    @Override
    public Authentication authenticate(Authentication a) throws AuthenticationException {
        String userName = a.getName();
        String password = a.getCredentials().toString();
        AccountEntity accountEntity = accountService.findByUserNameAndPassword(userName, password);
        if (accountEntity != null && accountEntity.isActive()) {
            List<GrantedAuthority> authorities = new ArrayList<>();
            // get list role            
            for (RoleEntity role : accountEntity.getRoleEntity()) {
                String roleName = role.getRole().toString();
                authorities.add(new SimpleGrantedAuthority(roleName));
            }
            return new UsernamePasswordAuthenticationToken(
                    accountEntity, userName, authorities);
        } else {
            return null;
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

}
