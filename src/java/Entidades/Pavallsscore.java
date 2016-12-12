/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author pauva
 */
@Entity
@Table(name = "pavallsscore")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pavallsscore.findAll", query = "SELECT p FROM Pavallsscore p"),
    @NamedQuery(name = "Pavallsscore.findByIdpartida", query = "SELECT p FROM Pavallsscore p WHERE p.idpartida = :idpartida"),
    @NamedQuery(name = "Pavallsscore.findByInicio", query = "SELECT p FROM Pavallsscore p WHERE p.inicio = :inicio"),
    @NamedQuery(name = "Pavallsscore.findByFinal1", query = "SELECT p FROM Pavallsscore p WHERE p.final1 = :final1"),
    @NamedQuery(name = "Pavallsscore.findByPuntuacion", query = "SELECT p FROM Pavallsscore p WHERE p.puntuacion = :puntuacion")})
public class Pavallsscore implements Serializable {

    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "puntuacion")
    private Double puntuacion;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idpartida")
    private Integer idpartida;
    @Column(name = "inicio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date inicio;
    @Column(name = "final")
    @Temporal(TemporalType.TIMESTAMP)
    private Date final1;
    @JoinColumn(name = "idjugador", referencedColumnName = "iduser")
    @ManyToOne
    private Pavallsuser idjugador;

    public Pavallsscore() {
    }

    public Pavallsscore(Integer idpartida) {
        this.idpartida = idpartida;
    }

    public Integer getIdpartida() {
        return idpartida;
    }

    public void setIdpartida(Integer idpartida) {
        this.idpartida = idpartida;
    }

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Date getFinal1() {
        return final1;
    }

    public void setFinal1(Date final1) {
        this.final1 = final1;
    }


    public Pavallsuser getIdjugador() {
        return idjugador;
    }

    public void setIdjugador(Pavallsuser idjugador) {
        this.idjugador = idjugador;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpartida != null ? idpartida.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pavallsscore)) {
            return false;
        }
        Pavallsscore other = (Pavallsscore) object;
        if ((this.idpartida == null && other.idpartida != null) || (this.idpartida != null && !this.idpartida.equals(other.idpartida))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Pavallsscore[ idpartida=" + idpartida + " ]";
    }

    public void setIdjugador(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Double getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(Double puntuacion) {
        this.puntuacion = puntuacion;
    }
    
}
