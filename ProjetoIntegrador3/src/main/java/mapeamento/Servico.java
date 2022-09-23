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
@Table(name = "SERVICO")
public class Servico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "SERV_COD")
    private Integer servCod;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "SERV_TIPO")
    private String servTipo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "atendServcod")
    private List<Atendimento> atendimentoList;

    public Servico() {
    }

    public Servico(Integer servCod) {
        this.servCod = servCod;
    }

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

    public List<Atendimento> getAtendimentoList() {
        return atendimentoList;
    }

    public void setAtendimentoList(List<Atendimento> atendimentoList) {
        this.atendimentoList = atendimentoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (servCod != null ? servCod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Servico)) {
            return false;
        }
        Servico other = (Servico) object;
        if ((this.servCod == null && other.servCod != null) || (this.servCod != null && !this.servCod.equals(other.servCod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mapeamento.Servico[ servCod=" + servCod + " ]";
    }
    
}
