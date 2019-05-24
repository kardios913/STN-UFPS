package Modelo;

import Modelo.Materiaxestudiante;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-12-05T20:21:16")
@StaticMetamodel(Estudiante.class)
public class Estudiante_ { 

    public static volatile SingularAttribute<Estudiante, Integer> codigo;
    public static volatile SingularAttribute<Estudiante, String> password;
    public static volatile CollectionAttribute<Estudiante, Materiaxestudiante> materiaxestudianteCollection;
    public static volatile SingularAttribute<Estudiante, String> nombre;
    public static volatile SingularAttribute<Estudiante, String> email;

}