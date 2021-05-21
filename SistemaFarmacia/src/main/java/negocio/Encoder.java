package negocio;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

 public class Encoder {

    public static String encrypt(String pass) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        String code = pass;
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte senhaBytes[] = md.digest(code.getBytes("UTF-8"));
        StringBuilder hex = new StringBuilder();
        for (byte b : senhaBytes) {
            hex.append(String.format("%02X", 0xFF & b));
        }
        code = hex.toString();
        return code;

    }

    public static boolean validate(String pass, String passBD) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        String temp = encrypt(pass);
        boolean ok = false;
        if (temp.equals(passBD)) {
            ok = true;
        }
        return ok;
    }
}
