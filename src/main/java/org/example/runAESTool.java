package org.example;

import org.apache.hadoop.hive.ql.exec.UDF;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;

public class runAESTool extends UDF {

    private static final String KEY = "AxYzqwes";

    public static String main(String[] input) {
        String decrypted = decrypt(input[0], KEY);
        return decrypted;
    }

    private static String decrypt(String input, String key) {
        try {
            SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), "DES");
            IvParameterSpec iv = new IvParameterSpec(key.getBytes(StandardCharsets.UTF_8));
            Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, keySpec, iv);

            byte[] decodedInput = hexStringToByteArray(input);
            byte[] decryptedBytes = cipher.doFinal(decodedInput);

            return new String(decryptedBytes, StandardCharsets.UTF_8);
        } catch (Exception e) {
            throw new RuntimeException("Failed to decrypt", e);
        }
    }

    private static byte[] hexStringToByteArray(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                    + Character.digit(s.charAt(i + 1), 16));
        }
        return data;
    }
}


