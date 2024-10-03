package com.spring.spring.utilidades;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Criptografar {

    public Criptografar() {

    }

    public static String criptografarSHA256(String input) {
        try {
            // Cria uma instância do MessageDigest para SHA-256
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            // Gera o hash como um array de bytes
            byte[] hashBytes = digest.digest(input.getBytes());

            // Converte os bytes em uma representação hexadecimal
            StringBuilder sb = new StringBuilder();
            for (byte b : hashBytes) {
                sb.append(String.format("%02x", b)); // Formatação para hexadecimal
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

}
