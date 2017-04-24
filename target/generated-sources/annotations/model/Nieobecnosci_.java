package model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Nauczyciele;
import model.Przedmioty;
import model.Uczniowie;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-05-17T09:15:44")
@StaticMetamodel(Nieobecnosci.class)
public class Nieobecnosci_ { 

    public static volatile SingularAttribute<Nieobecnosci, Uczniowie> iducznia;
    public static volatile SingularAttribute<Nieobecnosci, Nauczyciele> idnauczyciela;
    public static volatile SingularAttribute<Nieobecnosci, Przedmioty> idprzedmiotu;
    public static volatile SingularAttribute<Nieobecnosci, Date> dataNieobecnosci;
    public static volatile SingularAttribute<Nieobecnosci, Integer> idnieobecnosci;

}