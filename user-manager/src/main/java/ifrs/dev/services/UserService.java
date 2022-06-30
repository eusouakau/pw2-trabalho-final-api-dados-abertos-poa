package ifrs.dev.services;

import java.util.List;
import java.util.Objects;

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
    public User createUser(User user) {
        userRepository.persist(user);

        return user;
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
