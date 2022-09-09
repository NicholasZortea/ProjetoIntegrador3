
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
import javax.validation.constraints.Size;
import org.antlr.v4.runtime.misc.NotNull;

/**
 *
 * @author Gabriel
 */
@Entity
@Table(name = "CIDADE")
public class Cidade implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CIDADE_SEQ")
    @SequenceGenerator(name = "CIDADE_SEQ", sequenceName = "CIDADE_SEQ", allocationSize = 1)
    @Column(name = "CID_COD")
    private Integer cidId;
    
    @NotNull
    @Size(max = 100)
    @Column(name = "CID_NOME")
    private String cidNome;

    public Cidade(Integer cidId, String cidNome) {
        this.cidId = cidId;
        this.cidNome = cidNome;
    }

    public String getCidNome() {
        return cidNome;
    }

    public void setCidNome(String cidNome) {
        this.cidNome = cidNome;
    }
    
    public Integer getCidId() {
        return cidId;
    }

    public void setCidId(Integer cidId) {
        this.cidId = cidId;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + Objects.hashCode(this.cidId);
        hash = 41 * hash + Objects.hashCode(this.cidNome);
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
        final Cidade other = (Cidade) obj;
        if (!Objects.equals(this.cidNome, other.cidNome)) {
            return false;
        }
        return Objects.equals(this.cidId, other.cidId);
    }
}
