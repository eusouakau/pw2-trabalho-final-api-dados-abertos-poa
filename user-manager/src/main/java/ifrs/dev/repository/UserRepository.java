package ifrs.dev.repository;
import javax.enterprise.context.ApplicationScoped;

import ifrs.dev.models.User;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class UserRepository implements PanacheRepository<User>{
    
    public User findByName(String name){
        return find("name", name).firstResult();
    }

    public User findByEmail(String email){
        return find("email", email).firstResult();
    }
    
}
