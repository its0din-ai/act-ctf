import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Scanner;
public class Main {
    private static final String ALGORITHM = "AES/CTR/NoPadding";
    private static final String SECRET_KEY = "8a4f76b12e5d93c0c3e8f9127a07b9a4";
    private static final String IV = "b7ac5f313b520468adfd77d08adb0b20";
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Hi! Ini adalah test seberapa JAWIR andaa!");
        System.out.println("Username: ");
        String usrnm = scn.nextLine();
        System.out.println("Password: ");
        String psswrd = scn.nextLine();
        secret(usrnm, psswrd);
    }
    public static void secret(String usrnm, String psswrd) {
        String username = System.getenv("ACTUSER");
        String password = System.getenv("ACTPASS");
        if (username != null && password != null && usrnm.equals(username) && psswrd.equals(password)) {
            String AES_FLAG = "4FVEgrY2MEJJGvYJMXTm/eZ+I3PURyN9APstXnmapa3qForMxP9VTw==";
            System.out.println(decrypt(AES_FLAG));
        }
    }
    public static String decrypt(String ciphertext) {
        try {
            byte[] secretKeyBytes = hexStringToByteArray(SECRET_KEY);
            SecretKeySpec secretKey = new SecretKeySpec(secretKeyBytes, "AES");
            IvParameterSpec iv = new IvParameterSpec(hexStringToByteArray(IV));
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, secretKey, iv);
            byte[] ciphertextBytes = Base64.getDecoder().decode(ciphertext);
            byte[] decryptedBytes = cipher.doFinal(ciphertextBytes);
            return new String(decryptedBytes, "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
            return "Dihh. Jawir Gadungan!";
        }
    }
    private static byte[] hexStringToByteArray(String hex) {
        int len = hex.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(hex.charAt(i), 16) << 4) + Character.digit(hex.charAt(i + 1), 16));
        }
        return data;
    }
}
