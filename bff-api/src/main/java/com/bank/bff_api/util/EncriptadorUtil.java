package com.bank.bff_api.util;

import java.util.Base64;

public class EncriptadorUtil {

    public static String desencriptar(String codigoEncriptado) {
        return new String(Base64.getDecoder().decode(codigoEncriptado));
    }
}
