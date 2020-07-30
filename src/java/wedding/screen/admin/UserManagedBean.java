package wedding.screen.admin;

import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import wedding.entity.User;
import wedding.entity.facade.UserFacadeLocal;

@Named
@SessionScoped
public class UserManagedBean implements Serializable{
    
    @Inject
    private UserFacadeLocal userFacadeLocal;
    private User user = new User();

    public UserManagedBean() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
     public List<User> loadAll() {
        return userFacadeLocal.findAll();

    }
    
    
     public String add(User user){
        this.userFacadeLocal.create(this.user);
        this.clear();
        return "adminUsers";
    }
    
    public void delete(User user){
       userFacadeLocal.remove(user);
    }
    
    public String edit(User user){
        this.user = user;
        return "editUser";
    }
    
      public String edit() {
        this.userFacadeLocal.edit(this.user);
        return "adminUsers";
    }

     public void clear() {
        this.user.setName(null);
        this.user.setSurname(null);
        this.user.setUsername(null);
        this.user.setPassword(null);
       

    }
}
