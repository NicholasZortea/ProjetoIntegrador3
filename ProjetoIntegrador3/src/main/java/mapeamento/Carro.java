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
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Matheus
 */
@Entity
@Table(name = "CARRO")
public class Carro implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CARRO_SEQ")
    @SequenceGenerator(name = "CARRO_SEQ", sequenceName = "CARRO_SEQ", allocationSize = 1)
    @Column(name = "CAR_PLACA")
    private String carPlaca;
    
    @NotNull
    @Size(max = 4)
    @Column(name = "CLI_NOME")
    private int carAnoFabric;
    
    @NotNull
    @JoinColumn(name = "CAR_MODCOD", referencedColumnName = "MOD_COD")
    @OneToOne(fetch = FetchType.LAZY)
    private Modelo carModCod;

@NotNull
    @JoinColumn(name = "CAR_CLIID", referencedColumnName = "CLI_ID")
    @OneToOne(fetch = FetchType.LAZY)
    private Cliente carCliID;

    public Carro(String carPlaca, int carAnoFabric, Modelo carModCod, Cliente carCliID) {
        this.carPlaca = carPlaca;
        this.carAnoFabric = carAnoFabric;
        this.carModCod = carModCod;
        this.carCliID = carCliID;
    }

    public String getCarPlaca() {
        return carPlaca;
    }

    public void setCarPlaca(String carPlaca) {
        this.carPlaca = carPlaca;
    }

    public int getCarAnoFabric() {
        return carAnoFabric;
    }

    public void setCarAnoFabric(int carAnoFabric) {
        this.carAnoFabric = carAnoFabric;
    }

    public Modelo getCarModCod() {
        return carModCod;
    }

    public void setCarModCod(Modelo carModCod) {
        this.carModCod = carModCod;
    }

    public Cliente getCarCliID() {
        return carCliID;
    }

    public void setCarCliID(Cliente carCliID) {
        this.carCliID = carCliID;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.carPlaca);
        hash = 37 * hash + this.carAnoFabric;
        hash = 37 * hash + Objects.hashCode(this.carModCod);
        hash = 37 * hash + Objects.hashCode(this.carCliID);
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
        final Carro other = (Carro) obj;
        if (this.carAnoFabric != other.carAnoFabric) {
            return false;
        }
        if (!Objects.equals(this.carPlaca, other.carPlaca)) {
            return false;
        }
        if (!Objects.equals(this.carModCod, other.carModCod)) {
            return false;
        }
        if (!Objects.equals(this.carCliID, other.carCliID)) {
            return false;
        }
        return true;
    }



}
