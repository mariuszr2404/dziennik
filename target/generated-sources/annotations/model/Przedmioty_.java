package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Nieobecnosci;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-05-17T09:15:44")
@StaticMetamodel(Przedmioty.class)
public class Przedmioty_ { 

    public static volatile SingularAttribute<Przedmioty, Integer> idprzedmiotu;
    public static volatile SingularAttribute<Przedmioty, String> nazwa;
    public static volatile CollectionAttribute<Przedmioty, Nieobecnosci> nieobecnosciCollection;

}