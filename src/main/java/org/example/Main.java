package org.example;

//import static org.example.getAreaCode.evaluate;
import static org.example.getEnterId.evaluate;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.sql.Array;

public class Main {

    public static void main(String[] args) {
        String[] strData = new String[2];
        strData[0] = "北京广德天宝建设有限公司";
        strData[1] = "442000";

        evaluate(strData);
    }
}