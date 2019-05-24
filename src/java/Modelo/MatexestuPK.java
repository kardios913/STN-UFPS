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
public class MatexestuPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "codmate")
    private int codmate;
    @Basic(optional = false)
    @Column(name = "codestu")
    private int codestu;

    public MatexestuPK() {
    }

    public MatexestuPK(int codmate, int codestu) {
        this.codmate = codmate;
        this.codestu = codestu;
    }

    public int getCodmate() {
        return codmate;
    }

    public void setCodmate(int codmate) {
        this.codmate = codmate;
    }

    public int getCodestu() {
        return codestu;
    }

    public void setCodestu(int codestu) {
        this.codestu = codestu;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codmate;
        hash += (int) codestu;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MatexestuPK)) {
            return false;
        }
        MatexestuPK other = (MatexestuPK) object;
        if (this.codmate != other.codmate) {
            return false;
        }
        if (this.codestu != other.codestu) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.MatexestuPK[ codmate=" + codmate + ", codestu=" + codestu + " ]";
    }
    
}
