package mapeamento;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Mecanica
 */
@Entity
@Table(name = "MARCA")
public class Marca implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "MARC_COD")
    private Integer marcCod;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "MARC_MARCA")
    private String marcMarca;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "modMarccod")
    private List<Modelo> modeloList;

    public Marca() {
    }

    public Marca(Integer marcCod) {
        this.marcCod = marcCod;
    }

    public Marca(Integer marcCod, String marcMarca) {
        this.marcCod = marcCod;
        this.marcMarca = marcMarca;
    }

    public Integer getMarcCod() {
        return marcCod;
    }

    public void setMarcCod(Integer marcCod) {
        this.marcCod = marcCod;
    }

    public String getMarcMarca() {
        return marcMarca;
    }

    public void setMarcMarca(String marcMarca) {
        this.marcMarca = marcMarca;
    }

    public List<Modelo> getModeloList() {
        return modeloList;
    }

    public void setModeloList(List<Modelo> modeloList) {
        this.modeloList = modeloList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (marcCod != null ? marcCod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Marca)) {
            return false;
        }
        Marca other = (Marca) object;
        if ((this.marcCod == null && other.marcCod != null) || (this.marcCod != null && !this.marcCod.equals(other.marcCod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mapeamento.Marca[ marcCod=" + marcCod + " ]";
    }
    
}
