/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author KRLOS
 */
@Embeddable
public class NotaPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "codmateria")
    private int codmateria;
    @Basic(optional = false)
    @Column(name = "codestudiante")
    private int codestudiante;
    @Basic(optional = false)
    @Column(name = "id")
    private int id;

    public NotaPK() {
    }

    public NotaPK(int codmateria, int codestudiante, int id) {
        this.codmateria = codmateria;
        this.codestudiante = codestudiante;
        this.id = id;
    }

    public int getCodmateria() {
        return codmateria;
    }

    public void setCodmateria(int codmateria) {
        this.codmateria = codmateria;
    }

    public int getCodestudiante() {
        return codestudiante;
    }

    public void setCodestudiante(int codestudiante) {
        this.codestudiante = codestudiante;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codmateria;
        hash += (int) codestudiante;
        hash += (int) id;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NotaPK)) {
            return false;
        }
        NotaPK other = (NotaPK) object;
        if (this.codmateria != other.codmateria) {
            return false;
        }
        if (this.codestudiante != other.codestudiante) {
            return false;
        }
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.NotaPK[ codmateria=" + codmateria + ", codestudiante=" + codestudiante + ", id=" + id + " ]";
    }
    
}
