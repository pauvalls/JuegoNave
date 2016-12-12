/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author pauva
 */
@Entity
@Table(name = "pavallsuser")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pavallsuser.findAll", query = "SELECT p FROM Pavallsuser p"),
    @NamedQuery(name = "Pavallsuser.findByIduser", query = "SELECT p FROM Pavallsuser p WHERE p.iduser = :iduser"),
    @NamedQuery(name = "Pavallsuser.findByNameuser", query = "SELECT p FROM Pavallsuser p WHERE p.nameuser = :nameuser"),
    @NamedQuery(name = "Pavallsuser.findByPassuser", query = "SELECT p FROM Pavallsuser p WHERE p.passuser = :passuser")})
public class Pavallsuser implements Serializable {

    @OneToMany(mappedBy = "idjugador")
    private Collection<Pavallsscore> pavallsscoreCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "iduser")
    private Integer iduser;
    @Column(name = "nameuser")
    private String nameuser;
    @Column(name = "passuser")
    private String passuser;

    public Pavallsuser() {
    }

    public Pavallsuser(Integer iduser) {
        this.iduser = iduser;
    }

    public Integer getIduser() {
        return iduser;
    }

    public void setIduser(Integer iduser) {
        this.iduser = iduser;
    }

    public String getNameuser() {
        return nameuser;
    }

    public void setNameuser(String nameuser) {
        this.nameuser = nameuser;
    }

    public String getPassuser() {
        return passuser;
    }

    public void setPassuser(String passuser) {
        this.passuser = passuser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iduser != null ? iduser.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pavallsuser)) {
            return false;
        }
        Pavallsuser other = (Pavallsuser) object;
        if ((this.iduser == null && other.iduser != null) || (this.iduser != null && !this.iduser.equals(other.iduser))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Pavallsuser[ iduser=" + iduser + " ]";
    }

    @XmlTransient
    public Collection<Pavallsscore> getPavallsscoreCollection() {
        return pavallsscoreCollection;
    }

    public void setPavallsscoreCollection(Collection<Pavallsscore> pavallsscoreCollection) {
        this.pavallsscoreCollection = pavallsscoreCollection;
    }
    
}
