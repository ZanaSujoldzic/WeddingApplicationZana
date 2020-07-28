
package wedding.entity.facade;

import javax.ejb.Local;
import wedding.entity.User;


@Local
public interface LoginFacadeLocal {

    public User login(String username, String password);

}
