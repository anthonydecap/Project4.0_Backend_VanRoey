package fact.it.project40backendvanroey.model;

import org.apache.tomcat.util.security.MD5Encoder;

import javax.persistence.*;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Entity
public class Administrator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int administratorID;
    private String name;
    private String lastname;
    private String password;
    @Column(unique = true)
    private String email;

    public Administrator() {
    }

    public Administrator(String name, String lastname, String password, String email) {
        this.name = name;
        this.lastname = lastname;
        this.email = email;
    }

    public int getAdministratorID() {
        return administratorID;
    }

    public void setAdministratorID(int administratorID) {
        this.administratorID = administratorID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");

            messageDigest.update(password.getBytes());
            byte[] resultByteArray = messageDigest.digest();

            StringBuilder sb = new StringBuilder();

            for(byte b: resultByteArray) {
                sb.append(String.format("%02x", b));
            }

            this.password = sb.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
