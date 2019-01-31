package com.example.demo.helper;

public interface AuthenticationToken {
    public void JWTToken(String token);

    public Object getPrincipal();

    public Object getCredentials();
}
