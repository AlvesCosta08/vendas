package com.vendas.vendas.utils;

import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.util.Base64;

@Component
public class SecretKeyGenerator {

    public String gerarChaveSecreta(int numBytes) {
        SecureRandom secureRandom = new SecureRandom();
        byte[] key = new byte[numBytes];
        secureRandom.nextBytes(key);
        return Base64.getEncoder().encodeToString(key); // Usa a classe Base64 do Java
    }
}
