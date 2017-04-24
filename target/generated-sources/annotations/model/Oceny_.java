package model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Nauczyciele;
import model.Rodzajeocen;
import model.Uczniowie;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-05-17T09:15:44")
@StaticMetamodel(Oceny.class)
public class Oceny_ { 

    public static volatile SingularAttribute<Oceny, Uczniowie> iducznia;
    public static volatile SingularAttribute<Oceny, Nauczyciele> idnauczyciela;
    public static volatile SingularAttribute<Oceny, Integer> ocena;
    public static volatile SingularAttribute<Oceny, Rodzajeocen> idrodzajuOceny;
    public static volatile SingularAttribute<Oceny, Date> datawystawienia;
    public static volatile SingularAttribute<Oceny, Integer> idoceny;

}