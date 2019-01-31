package com.example.demo.helper;

public class JwtToken implements AuthenticationToken {

    // 密钥
    private String token;


    @Override
    public void JWTToken(String token) {
        this.token = token;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }

}
