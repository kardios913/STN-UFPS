/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author KRLOS
 */
@Entity
@Table(name = "matexestu")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Matexestu.findAll", query = "SELECT m FROM Matexestu m")
    , @NamedQuery(name = "Matexestu.findByCodmate", query = "SELECT m FROM Matexestu m WHERE m.matexestuPK.codmate = :codmate")
    , @NamedQuery(name = "Matexestu.findByCodestu", query = "SELECT m FROM Matexestu m WHERE m.matexestuPK.codestu = :codestu")})
public class Matexestu implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MatexestuPK matexestuPK;

    public Matexestu() {
    }

    public Matexestu(MatexestuPK matexestuPK) {
        this.matexestuPK = matexestuPK;
    }

    public Matexestu(int codmate, int codestu) {
        this.matexestuPK = new MatexestuPK(codmate, codestu);
    }

    public MatexestuPK getMatexestuPK() {
        return matexestuPK;
    }

    public void setMatexestuPK(MatexestuPK matexestuPK) {
        this.matexestuPK = matexestuPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (matexestuPK != null ? matexestuPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Matexestu)) {
            return false;
        }
        Matexestu other = (Matexestu) object;
        if ((this.matexestuPK == null && other.matexestuPK != null) || (this.matexestuPK != null && !this.matexestuPK.equals(other.matexestuPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.Matexestu[ matexestuPK=" + matexestuPK + " ]";
    }
    
}
