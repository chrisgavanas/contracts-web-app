package com.impl.api;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.RestController;

import com.api.LoginApi;
import com.security.Credentials;

@RestController
public class LoginApiImpl implements LoginApi {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public Map<String, Object> login(Credentials credentials) {
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(credentials.getUsername(), credentials.getPassword());

        Authentication authentication = authenticationManager.authenticate(token);

        String basicAuthToken = credentials.getUsername() + ":" + credentials.getPassword();

        Map<String, Object> response = new HashMap<>();
        response.put("token", "Basic " + String.valueOf(Base64.getEncoder().encodeToString(basicAuthToken.getBytes())));
        response.put("username", authentication.getName());
        response.put("roles", authentication.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()));

        return response;
    }
}
