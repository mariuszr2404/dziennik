package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Konta;
import model.Nieobecnosci;
import model.Oceny;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-05-17T09:15:44")
@StaticMetamodel(Nauczyciele.class)
public class Nauczyciele_ { 

    public static volatile SingularAttribute<Nauczyciele, Integer> idnauczyciela;
    public static volatile SingularAttribute<Nauczyciele, String> imie;
    public static volatile SingularAttribute<Nauczyciele, String> nazwisko;
    public static volatile CollectionAttribute<Nauczyciele, Nieobecnosci> nieobecnosciCollection;
    public static volatile CollectionAttribute<Nauczyciele, Oceny> ocenyCollection;
    public static volatile CollectionAttribute<Nauczyciele, Konta> kontaCollection;

}