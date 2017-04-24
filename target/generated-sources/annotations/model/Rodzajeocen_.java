package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Oceny;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-05-17T09:15:44")
@StaticMetamodel(Rodzajeocen.class)
public class Rodzajeocen_ { 

    public static volatile SingularAttribute<Rodzajeocen, Integer> idrodzajuOceny;
    public static volatile SingularAttribute<Rodzajeocen, String> nazwa;
    public static volatile CollectionAttribute<Rodzajeocen, Oceny> ocenyCollection;

}