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
@Table(name = "PECA")
public class Peca implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PECA_COD")
    private Integer pecaCod;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PECA_QUANTIDADE")
    private int pecaQuantidade;
    @Size(max = 1)
    @Column(name = "PECA_LADO")
    private String pecaLado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "relacionamentoPecacod")
    private List<Atendimentoxpeca> atendimentoxpecaList;

    public Peca() {
    }

    public Peca(Integer pecaCod) {
        this.pecaCod = pecaCod;
    }

    public Peca(Integer pecaCod, int pecaQuantidade) {
        this.pecaCod = pecaCod;
        this.pecaQuantidade = pecaQuantidade;
    }

    public Integer getPecaCod() {
        return pecaCod;
    }

    public void setPecaCod(Integer pecaCod) {
        this.pecaCod = pecaCod;
    }

    public int getPecaQuantidade() {
        return pecaQuantidade;
    }

    public void setPecaQuantidade(int pecaQuantidade) {
        this.pecaQuantidade = pecaQuantidade;
    }

    public String getPecaLado() {
        return pecaLado;
    }

    public void setPecaLado(String pecaLado) {
        this.pecaLado = pecaLado;
    }

    public List<Atendimentoxpeca> getAtendimentoxpecaList() {
        return atendimentoxpecaList;
    }

    public void setAtendimentoxpecaList(List<Atendimentoxpeca> atendimentoxpecaList) {
        this.atendimentoxpecaList = atendimentoxpecaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pecaCod != null ? pecaCod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Peca)) {
            return false;
        }
        Peca other = (Peca) object;
        if ((this.pecaCod == null && other.pecaCod != null) || (this.pecaCod != null && !this.pecaCod.equals(other.pecaCod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mapeamento.Peca[ pecaCod=" + pecaCod + " ]";
    }
    
}
