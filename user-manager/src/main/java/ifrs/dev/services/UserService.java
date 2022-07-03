package ifrs.dev.services;

import java.util.List;
import java.util.Objects;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import org.eclipse.microprofile.jwt.Claim;
import org.eclipse.microprofile.jwt.Claims;

import ifrs.dev.exception.Exception;
import ifrs.dev.models.User;
import ifrs.dev.repository.UserRepository;

@ApplicationScoped
public class UserService {
    
    @Inject
    UserRepository userRepository;
    
    @Inject
    @Claim(standard = Claims.full_name)
    String fullName;

    @Transactional
    @RolesAllowed("User")
    public List<User> getAllUsers() {
        return userRepository.listAll();
    }

    @Transactional
    @RolesAllowed({ "User" })
    public User getUserById(long id) {
        return userRepository.findById(id);
    }

    @Transactional
    @RolesAllowed({ "User" })
    public User getUserByName(String name) {
        return userRepository.findByName(name);
    }

    @Transactional
    @PermitAll
    public User createUser(User user) {

        if (Objects.nonNull(userRepository.findByEmail(user.getEmail()))) {
            throw new Exception("Email already exists");
        } else {
             userRepository.persist(user);
        }

        return user;
    }

    @Transactional
    @PermitAll
    public User login(String email, String password) {
        User user = userRepository.findByEmail(email);
        if (Objects.nonNull(user)) {
            if (user.getPassword().equals(password)) {
                return user;
            } else {
                throw new Exception("Invalid password");
            }
        } else {
            throw new Exception("User not found");
        }
    }


    @Transactional
    @RolesAllowed({ "User" })
    public User updateUser(User user) {
        User userTemp = userRepository.findById(user.getId());
        if(Objects.equals(userTemp, null)){
          throw new Exception("Usuario não encontrado");
        }

        userTemp.setName(user.getName());
        userTemp.setBirthDate(user.getBirthDate());
        userTemp.setEmail(user.getEmail());
        userTemp.setPassword(user.getPassword());

        userRepository.persist(userTemp);
        return userTemp;
    }

    @Transactional
    @RolesAllowed({ "User" })
    public Boolean deleteUser(long id) {
        User userTemp = userRepository.findById(id);
        if(Objects.equals(userTemp, null)){
           throw new Exception("Usuario não encontrado");
        }

        userRepository.delete(userTemp);
        return true;
    }
}
