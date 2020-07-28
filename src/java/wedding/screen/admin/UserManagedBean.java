
package wedding.screen.admin;

import java.io.Serializable;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import wedding.entity.User;
import wedding.entity.facade.UserFacadeLocal;

@Named
@ViewScoped
public class UserManagedBean implements Serializable{
    
    @Inject
    private UserFacadeLocal userFacadeLocal;
    private User user= new User();

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
    
    
     public void add(){
        userFacadeLocal.create(user);
        this.user= new User();
    }
    
    public void delete(User user){
        userFacadeLocal.remove(user);
    }
    
    public String edit(User user){
        return "editUser";
    }
    
    public String edit(){
        userFacadeLocal.edit(user);
        return "adminUsers";
    }
}
