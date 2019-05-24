package Modelo;

import Modelo.Materiaxestudiante;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-12-05T20:21:16")
@StaticMetamodel(Materia.class)
public class Materia_ { 

    public static volatile SingularAttribute<Materia, Integer> codigo;
    public static volatile CollectionAttribute<Materia, Materiaxestudiante> materiaxestudianteCollection;
    public static volatile SingularAttribute<Materia, String> nombre;

}