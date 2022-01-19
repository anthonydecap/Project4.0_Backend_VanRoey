package fact.it.project40backendvanroey.model;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Login {
    private String email;
    private String password;

    public Login() {
    }

    public Login(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(password.getBytes());

            byte [] byteArray = messageDigest.digest();

            StringBuilder pw = new StringBuilder();

            for (byte b : byteArray) {
                pw.append(String.format("%02x", b));
            }

            this.password = pw.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}
