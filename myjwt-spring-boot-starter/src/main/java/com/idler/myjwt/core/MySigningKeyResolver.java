package com.idler.myjwt.core;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwsHeader;
import io.jsonwebtoken.SigningKeyResolverAdapter;

import java.security.Key;
import java.security.spec.InvalidKeySpecException;

public class MySigningKeyResolver extends SigningKeyResolverAdapter {

    static String publicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAsJQALztBNnMwt9vNkdU9UXaVka7Cn0L4JCcvontQo/OfLjWmyDAeHyriKQyFydniu511lEsN5K8P3Ou48RD68f1aLrUv+bcg1bjQsMoS2Aokx7DGfbZYTt6Y3DvldJfOFnh0BA/kTdaHLZd8+h2LPM4opZqfd/m8ZKdngtWHBD4/gpAMzRjIUpCZzSqOmM1S0MybOjN9/TdB9BeraIwtuNrgUYLlJMPff8e9YCnpqlsLLqmJ6BzOutw9BTB6iO4pAnZOKt5SmYZz6ATXsPCvOja/wghYDnQJOEQpTFVCpGqMxHB+sjfwTpwkXtrxpp0xlnJ/BKRmaFBBb93svAM5iQIDAQAB";

    @Override
    public Key resolveSigningKey(JwsHeader jwsHeader, Claims claims) {
        // implement me
        String keyId = jwsHeader.getKeyId(); //or any other field that you need to inspect

        Key key = null; //implement me
        try {
            key = RSAUtils.getPublicKey(publicKey);
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        }

        return key;
    }
}