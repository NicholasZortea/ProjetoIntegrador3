package mapeamento;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Mecanica
 */
@Entity
@Table(name = "MODELO")
public class Modelo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "MOD_COD")
    private Integer modCod;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "MOD_MODELO")
    private String modModelo;
    @JoinColumn(name = "MOD_MARCCOD", referencedColumnName = "MARC_COD")
    @ManyToOne(optional = false)
    private Marca modMarccod;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "carModcod")
    private List<Carro> carroList;

    public Modelo() {
    }

    public Modelo(Integer modCod) {
        this.modCod = modCod;
    }

    public Modelo(Integer modCod, String modModelo) {
        this.modCod = modCod;
        this.modModelo = modModelo;
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

    public Marca getModMarccod() {
        return modMarccod;
    }

    public void setModMarccod(Marca modMarccod) {
        this.modMarccod = modMarccod;
    }

    public List<Carro> getCarroList() {
        return carroList;
    }

    public void setCarroList(List<Carro> carroList) {
        this.carroList = carroList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (modCod != null ? modCod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Modelo)) {
            return false;
        }
        Modelo other = (Modelo) object;
        if ((this.modCod == null && other.modCod != null) || (this.modCod != null && !this.modCod.equals(other.modCod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mapeamento.Modelo[ modCod=" + modCod + " ]";
    }

}
