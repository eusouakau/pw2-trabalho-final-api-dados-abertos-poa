package ifrs.dev.models;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter 
@Table(name = "usuarios")
public class User extends PanacheEntity{

    @Column(name = "nome")
    private String name;

    @Column(name = "data_nascimento")
    private Date birthDate;

    @Column(name = "email")
    private String email;

    @Column(name = "senha")
    private String password;

    @Column(name = "id")
    private long id;
    

    public User() {
      
    }
    
    public User(String name, Date birthDate, String email, String password, long id) {
        this.name = name;
        this.birthDate = birthDate;
        this.email = email;
        this.password = password;
        this.id = id;
    }

}