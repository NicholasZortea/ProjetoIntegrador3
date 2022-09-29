/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapeamento;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Mecanica
 */
@Entity
@Table(name = "AGENDA")
@NamedQueries({
    @NamedQuery(name = "Agenda.findAll", query = "SELECT a FROM Agenda a"),
    @NamedQuery(name = "Agenda.findByAgendaCod", query = "SELECT a FROM Agenda a WHERE a.agendaCod = :agendaCod"),
    @NamedQuery(name = "Agenda.findByAgendaDesc", query = "SELECT a FROM Agenda a WHERE a.agendaDesc = :agendaDesc"),
    @NamedQuery(name = "Agenda.findByAgendaData", query = "SELECT a FROM Agenda a WHERE a.agendaData = :agendaData")})
public class Agenda implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "AGENDA_COD")
    private Integer agendaCod;
    @Size(max = 500)
    @Column(name = "AGENDA_DESC")
    private String agendaDesc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "AGENDA_DATA")
    @Temporal(TemporalType.DATE)
    private Date agendaData;
    @JoinColumn(name = "AGENDA_CARPLACA", referencedColumnName = "CAR_PLACA")
    @ManyToOne(optional = false)
    private Carro agendaCarplaca;
    @JoinColumn(name = "AGENDA_CLIID", referencedColumnName = "CLI_ID")
    @ManyToOne(optional = false)
    private Cliente agendaCliid;

    public Agenda() {
    }

    public Agenda(Integer agendaCod) {
        this.agendaCod = agendaCod;
    }

    public Agenda(Integer agendaCod, Date agendaData) {
        this.agendaCod = agendaCod;
        this.agendaData = agendaData;
    }

    public Integer getAgendaCod() {
        return agendaCod;
    }

    public void setAgendaCod(Integer agendaCod) {
        this.agendaCod = agendaCod;
    }

    public String getAgendaDesc() {
        return agendaDesc;
    }

    public void setAgendaDesc(String agendaDesc) {
        this.agendaDesc = agendaDesc;
    }

    public Date getAgendaData() {
        return agendaData;
    }

    public void setAgendaData(Date agendaData) {
        this.agendaData = agendaData;
    }

    public Carro getAgendaCarplaca() {
        return agendaCarplaca;
    }

    public void setAgendaCarplaca(Carro agendaCarplaca) {
        this.agendaCarplaca = agendaCarplaca;
    }

    public Cliente getAgendaCliid() {
        return agendaCliid;
    }

    public void setAgendaCliid(Cliente agendaCliid) {
        this.agendaCliid = agendaCliid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (agendaCod != null ? agendaCod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Agenda)) {
            return false;
        }
        Agenda other = (Agenda) object;
        if ((this.agendaCod == null && other.agendaCod != null) || (this.agendaCod != null && !this.agendaCod.equals(other.agendaCod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mapeamento.Agenda[ agendaCod=" + agendaCod + " ]";
    }
    
}
