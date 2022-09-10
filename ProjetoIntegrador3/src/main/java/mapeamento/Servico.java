/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapeamento;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Matheus
 */
@Entity
@Table(name = "SERVICO")
public class Servico implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SERVICO_SEQ")
    @SequenceGenerator(name = "SERVICO_SEQ", sequenceName = "SERVICO_SEQ", allocationSize = 1)
    @Column(name = "SERV_COD")
    private Integer servCod;
    
    @NotNull
    @Size(max = 50)
    @Column(name = "SERV_TIPO")
    private String servTipo;

    public Servico(Integer servCod, String servTipo) {
        this.servCod = servCod;
        this.servTipo = servTipo;
    }

    public Integer getServCod() {
        return servCod;
    }

    public void setServCod(Integer servCod) {
        this.servCod = servCod;
    }

    public String getServTipo() {
        return servTipo;
    }

    public void setServTipo(String servTipo) {
        this.servTipo = servTipo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.servCod);
        hash = 73 * hash + Objects.hashCode(this.servTipo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Servico other = (Servico) obj;
        if (!Objects.equals(this.servTipo, other.servTipo)) {
            return false;
        }
        if (!Objects.equals(this.servCod, other.servCod)) {
            return false;
        }
        return true;
    }
    
    
    
    
    
}
