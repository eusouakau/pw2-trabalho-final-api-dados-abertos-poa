package ifrs.dev.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter 
@Table(name = "usuarios")
public class User extends PanacheEntityBase{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String name;

    @Column(name = "data_nascimento")
    private Date birthDate;

    @Column(name = "email")
    private String email;

    @Column(name = "senha")
    private String password;
    
    @Transient
    private String token;

    public User() {
      
    }
    
    public User(String name, Date birthDate, String email, String password, long id, String token) {
        this.name = name;
        this.birthDate = birthDate;
        this.email = email;
        this.password = password;
        this.id = id;
        this.token = token;
    }

}