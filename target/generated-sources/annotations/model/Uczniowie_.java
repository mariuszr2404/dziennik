package model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Klasy;
import model.Nieobecnosci;
import model.Oceny;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-05-17T09:15:44")
@StaticMetamodel(Uczniowie.class)
public class Uczniowie_ { 

    public static volatile SingularAttribute<Uczniowie, Date> dataurodzenia;
    public static volatile SingularAttribute<Uczniowie, Integer> iducznia;
    public static volatile SingularAttribute<Uczniowie, String> imie;
    public static volatile SingularAttribute<Uczniowie, Klasy> idklasy;
    public static volatile SingularAttribute<Uczniowie, String> nazwisko;
    public static volatile SingularAttribute<Uczniowie, String> plec;
    public static volatile CollectionAttribute<Uczniowie, Nieobecnosci> nieobecnosciCollection;
    public static volatile CollectionAttribute<Uczniowie, Oceny> ocenyCollection;

}