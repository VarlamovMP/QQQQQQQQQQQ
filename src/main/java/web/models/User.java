package web.models;

import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Table(name = "users")
public class User {

    private int id;

    @NotEmpty(message = "Name not empty")
    @Size(min = 2, max = 15, message = "Name lenght >2 & <15")
    private String name;

    @NotEmpty(message = "Email not empty")
    @Email(message = "Email error")
    private String email;

    public User() {
    }

    public User(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
