package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Nauczyciele;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-05-17T09:15:44")
@StaticMetamodel(Konta.class)
public class Konta_ { 

    public static volatile SingularAttribute<Konta, String> username;
    public static volatile SingularAttribute<Konta, Nauczyciele> idnauczyciela;
    public static volatile SingularAttribute<Konta, String> email;
    public static volatile SingularAttribute<Konta, String> password;
    public static volatile SingularAttribute<Konta, Integer> idkonta;

}