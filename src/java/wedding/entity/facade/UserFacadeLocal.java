
package wedding.entity.facade;

import java.util.List;
import javax.ejb.Local;
import wedding.entity.User;


@Local
public interface UserFacadeLocal {

    void create(User user);

    void edit(User user);

    void remove(User user);

    User find(Object id);

    List<User> findAll();

    List<User> findRange(int[] range);

    int count();
    
    
    public User findUserByUsername(String username);
    
}
