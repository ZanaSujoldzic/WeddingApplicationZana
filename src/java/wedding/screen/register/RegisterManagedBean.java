package wedding.screen.register;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import wedding.entity.facade.RegisterFacadeLocal;

@Named
@SessionScoped
public class RegisterManagedBean implements Serializable {

    @Inject
    private RegisterFacadeLocal registerFacadeLocal;

    private String name;
    private String surname;
    private String username;
    private String password;

    public RegisterManagedBean() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String register() {
        boolean userCreated = registerFacadeLocal.register(name, surname, username, password);
        if (userCreated) {
            return "index";
        }

        System.out.println("Please fill out the form");

        return "register";
    }

}
