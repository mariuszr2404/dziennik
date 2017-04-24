package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Uczniowie;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-05-17T09:15:44")
@StaticMetamodel(Klasy.class)
public class Klasy_ { 

    public static volatile CollectionAttribute<Klasy, Uczniowie> uczniowieCollection;
    public static volatile SingularAttribute<Klasy, String> semestr;
    public static volatile SingularAttribute<Klasy, String> nazwa;
    public static volatile SingularAttribute<Klasy, Integer> idklasy;

}