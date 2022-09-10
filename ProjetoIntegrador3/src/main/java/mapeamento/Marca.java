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
@Table(name = "MARCA")
public class Marca implements Serializable{
    
     @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MARCA_SEQ")
    @SequenceGenerator(name = "MARCA_SEQ", sequenceName = "MARCA_SEQ", allocationSize = 1)
    @Column(name = "MARC_COD")
    private Integer marcCod;
    
    @NotNull
    @Size(max = 100)
    @Column(name = "MARC_MARCA")
    private String marcMarca;

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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.marcCod);
        hash = 47 * hash + Objects.hashCode(this.marcMarca);
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
        final Marca other = (Marca) obj;
        if (!Objects.equals(this.marcMarca, other.marcMarca)) {
            return false;
        }
        if (!Objects.equals(this.marcCod, other.marcCod)) {
            return false;
        }
        return true;
    }
    
    
}
