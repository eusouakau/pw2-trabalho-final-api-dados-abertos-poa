package ifrs.dev.services;

import java.util.List;
import java.util.Objects;

import javax.annotation.security.PermitAll;
import javax.inject.Inject;
import javax.transaction.Transactional;

import org.eclipse.microprofile.jwt.Claim;
import org.eclipse.microprofile.jwt.Claims;
import org.eclipse.microprofile.jwt.JsonWebToken;

import ifrs.dev.exception.Exception;
import ifrs.dev.models.User;
import ifrs.dev.repository.UserRepository;

@Transactional
public class UserService {
    
    @Inject
    UserRepository userRepository;
    
    @Inject
    @Claim(standard = Claims.full_name)
    String fullName;

    @Inject
    JsonWebToken jwt;

    public List<User> getAllUsers() {
        try{
            return userRepository.listAll().isEmpty() ? null : userRepository.listAll();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public User getUserByName(String name) {
        try{
            if(Objects.isNull(name)) {
                throw new Exception("Nenhum usuario encontrado");
            }
            return userRepository.findByName(name);
        } catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @PermitAll
    public User createUser(User user) {
        try{
            if (Objects.nonNull(userRepository.findByEmail(user.getEmail()))) {
                throw new Exception("Email já cadastrado");
            } else {
                userRepository.getEntityManager().merge(user);
            }
            
            return user;
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @PermitAll
    public User login(User user) {
        try{
            User userFound = userRepository.findByEmail(user.getEmail());
            if (Objects.isNull(userFound)) {
                throw new Exception("Email não cadastrado");
            }
            if (!userFound.getPassword().equals(user.getPassword())) {
                throw new Exception("Senha incorreta");
            }
            return userFound;
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }


    public User updateUser(User user) {
        try{
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
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }

    public Boolean deleteUser(long id) {
        try{
            User userTemp = userRepository.findById(id);
            if(Objects.equals(userTemp, null)){
            throw new Exception("Usuario não encontrado");
            }

            userRepository.delete(userTemp);
            return true;
        } catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
