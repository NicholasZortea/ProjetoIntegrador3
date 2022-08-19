package menu.jpa;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Gabriel Baldez 11/02/2021
 */
@Entity
@Table(name = "carro")
public class Carro implements Serializable {

    private static final long serialVersionUID = 1L;


    @Id
    @Column(name = "CARROID")
    protected int carroid;
    
    @Column(name = "montadora")
    private String montadora;
    
    @Column(name = "modelo")
    private String modelo;
    
    @Column(name = "ano")
    private String ano;
    
    @Column(name = "potencia_motor")
    private String potenciaMotor;
    
    @Column(name = "valvulas_motor")
    private String valvulasMotor;
    
    @Column(name = "tipo_motor")
    private String tipoMotor;
    
    @Column(name = "cilindradas_motor")
    private String cilindradasMotor;
    
    @Column(name = "litros_oleo")
    private Double litrosOleo;
    
    @Column(name = "viscosidade_oleo")
    private String viscosidadeOleo;
    
    @Column(name = "filtro_oleo")
    private String filtrooleo;

    public int getCarroid() {
        return carroid;
    }

    public void setCarroid(int carroid) {
        this.carroid = carroid;
    }

    public String getMontadora() {
        return montadora;
    }

    public void setMontadora(String montadora) {
        this.montadora = montadora;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getPotenciaMotor() {
        return potenciaMotor;
    }

    public void setPotenciaMotor(String potenciaMotor) {
        this.potenciaMotor = potenciaMotor;
    }

    public String getValvulasMotor() {
        return valvulasMotor;
    }

    public void setValvulasMotor(String valvulasMotor) {
        this.valvulasMotor = valvulasMotor;
    }

    public String getTipoMotor() {
        return tipoMotor;
    }

    public void setTipoMotor(String tipoMotor) {
        this.tipoMotor = tipoMotor;
    }

    public String getCilindradasMotor() {
        return cilindradasMotor;
    }

    public void setCilindradasMotor(String cilindradasMotor) {
        this.cilindradasMotor = cilindradasMotor;
    }

    public Double getLitrosOleo() {
        return litrosOleo;
    }

    public void setLitrosOleo(Double litrosOleo) {
        this.litrosOleo = litrosOleo;
    }

    public String getViscosidadeOleo() {
        return viscosidadeOleo;
    }

    public void setViscosidadeOleo(String viscosidadeOleo) {
        this.viscosidadeOleo = viscosidadeOleo;
    }

    public String getFiltrooleo() {
        return filtrooleo;
    }

    public void setFiltrooleo(String filtrooleo) {
        this.filtrooleo = filtrooleo;
    }

    @Override
    public String toString() {
        return "carro{" + "carroid=" + carroid + ", montadora=" + montadora + ", modelo=" + modelo + ", ano=" + ano + ", potenciaMotor=" + potenciaMotor + ", valvulasMotor=" + valvulasMotor + ", tipoMotor=" + tipoMotor + ", cilindradasMotor=" + cilindradasMotor + ", litrosOleo=" + litrosOleo + ", viscosidadeOleo=" + viscosidadeOleo + ", filtrooleo=" + filtrooleo + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 31 * hash + this.carroid;
        hash = 31 * hash + Objects.hashCode(this.montadora);
        hash = 31 * hash + Objects.hashCode(this.modelo);
        hash = 31 * hash + Objects.hashCode(this.ano);
        hash = 31 * hash + Objects.hashCode(this.potenciaMotor);
        hash = 31 * hash + Objects.hashCode(this.valvulasMotor);
        hash = 31 * hash + Objects.hashCode(this.tipoMotor);
        hash = 31 * hash + Objects.hashCode(this.cilindradasMotor);
        hash = 31 * hash + Objects.hashCode(this.litrosOleo);
        hash = 31 * hash + Objects.hashCode(this.viscosidadeOleo);
        hash = 31 * hash + Objects.hashCode(this.filtrooleo);
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
        if (this.carroid != other.carroid) {
            return false;
        }
        if (!Objects.equals(this.montadora, other.montadora)) {
            return false;
        }
        if (!Objects.equals(this.modelo, other.modelo)) {
            return false;
        }
        if (!Objects.equals(this.ano, other.ano)) {
            return false;
        }
        if (!Objects.equals(this.potenciaMotor, other.potenciaMotor)) {
            return false;
        }
        if (!Objects.equals(this.valvulasMotor, other.valvulasMotor)) {
            return false;
        }
        if (!Objects.equals(this.tipoMotor, other.tipoMotor)) {
            return false;
        }
        if (!Objects.equals(this.cilindradasMotor, other.cilindradasMotor)) {
            return false;
        }
        if (!Objects.equals(this.litrosOleo, other.litrosOleo)) {
            return false;
        }
        if (!Objects.equals(this.viscosidadeOleo, other.viscosidadeOleo)) {
            return false;
        }
        if (!Objects.equals(this.filtrooleo, other.filtrooleo)) {
            return false;
        }
        return true;
    }
    



  
}
