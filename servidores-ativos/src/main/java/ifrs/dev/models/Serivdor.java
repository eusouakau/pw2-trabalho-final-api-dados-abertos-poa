package ifrs.dev.models;

import javax.persistence.Entity;


import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter 
public class Serivdor  extends PanacheEntity{

    public Serivdor() {

    }
    
}                   
