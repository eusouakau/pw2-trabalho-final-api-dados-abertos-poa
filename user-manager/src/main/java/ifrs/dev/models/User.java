package ifrs.dev.models;


import java.util.Date;

import javax.persistence.Entity;


import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter 
public class User extends PanacheEntity{
    private String name;
    private Date birthDate;
    private String email;
    private String password;
    

    public User() {
      
    }
    
    public User(String name, Date birthDate, String email, String password) {
        this.name = name;
        this.birthDate = birthDate;
        this.email = email;
        this.password = password;
    }




}