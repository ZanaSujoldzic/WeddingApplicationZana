package wedding.entity.facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import wedding.entity.User;

@Stateless
public class LoginFacade implements LoginFacadeLocal {

    @PersistenceContext(unitName = "TestWebPU")
    private EntityManager entitiyManager;


    @Override
    public User login(String username, String password) {

        try {
            return (User) entitiyManager.createNamedQuery("User.findByUsernameAndPassword")
                    .setParameter("username", username)
                    .setParameter("password", password)
                    .getSingleResult();
        } catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
    }
}
