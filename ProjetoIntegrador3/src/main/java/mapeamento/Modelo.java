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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Matheus
 */

@Entity
@Table(name = "MODELO")
public class Modelo implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MODELO_SEQ")
    @SequenceGenerator(name = "MODELO_SEQ", sequenceName = "MODELO_SEQ", allocationSize = 1)
    @Column(name = "MOD_COD")
    private Integer modCod;
    
    @NotNull
    @Size(max = 100)
    @Column(name = "MOD_MODELO")
    private String modModelo;
    
    @NotNull
    @JoinColumn(name = "MOD_MARCCOD", referencedColumnName = "MARC_COD")
    @ManyToOne(fetch = FetchType.LAZY)
    private Modelo modMarcCod;

    public Modelo(Integer modCod, String modModelo, Modelo modMarcCod) {
        this.modCod = modCod;
        this.modModelo = modModelo;
        this.modMarcCod = modMarcCod;
    }

    public Integer getModCod() {
        return modCod;
    }

    public void setModCod(Integer modCod) {
        this.modCod = modCod;
    }

    public String getModModelo() {
        return modModelo;
    }

    public void setModModelo(String modModelo) {
        this.modModelo = modModelo;
    }

    public Modelo getModMarcCod() {
        return modMarcCod;
    }

    public void setModMarcCod(Modelo modMarcCod) {
        this.modMarcCod = modMarcCod;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.modCod);
        hash = 79 * hash + Objects.hashCode(this.modModelo);
        hash = 79 * hash + Objects.hashCode(this.modMarcCod);
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
        final Modelo other = (Modelo) obj;
        if (!Objects.equals(this.modModelo, other.modModelo)) {
            return false;
        }
        if (!Objects.equals(this.modCod, other.modCod)) {
            return false;
        }
        if (!Objects.equals(this.modMarcCod, other.modMarcCod)) {
            return false;
        }
        return true;
    }
    
    
    
}
