
package wedding.entity.facade;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import wedding.entity.Privilege;
import wedding.entity.User;


@Stateless
public class RegisterFacade extends AbstractFacade<User> implements RegisterFacadeLocal {

    @Inject
    private PrivilegeFacadeLocal privilegeFacadeLocal;
    
    public RegisterFacade() {
        super(User.class);
    }

    @PersistenceContext(unitName = "TestWebPU")
    private EntityManager entityManager;

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }

    
    

    @Override
    public boolean register(String name, String surname, String username, String password) {

        try {
            Query query = entityManager.createNamedQuery("User.findByUsername").setParameter("username", username);
            List<User> users = (List<User>) query.getResultList();
            if (!users.isEmpty()) {
                return false;
            }
            User user = new User();
            user.setName(name);
            user.setSurname(surname);
            user.setUsername(username);
            user.setPassword(password);
            Privilege privilege = privilegeFacadeLocal.find("user");
            user.setIdPrivilege(privilege);
            entityManager.persist(user);
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());

        } 
    }

}
