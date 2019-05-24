package Modelo;

import Modelo.Estudiante;
import Modelo.Materia;
import Modelo.MateriaxestudiantePK;
import Modelo.Nota;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-12-05T20:21:16")
@StaticMetamodel(Materiaxestudiante.class)
public class Materiaxestudiante_ { 

    public static volatile SingularAttribute<Materiaxestudiante, Estudiante> estudiante;
    public static volatile CollectionAttribute<Materiaxestudiante, Nota> notaCollection;
    public static volatile SingularAttribute<Materiaxestudiante, Materia> materia;
    public static volatile SingularAttribute<Materiaxestudiante, MateriaxestudiantePK> materiaxestudiantePK;

}