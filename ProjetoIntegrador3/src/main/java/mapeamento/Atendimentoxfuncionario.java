package mapeamento;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Mecanica
 */
@Entity
@Table(name = "ATENDIMENTOXFUNCIONARIO")
public class Atendimentoxfuncionario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ATENDXFUNC")
    private Integer atendxfunc;
    @JoinColumn(name = "ATENDXCOD", referencedColumnName = "ATEND_COD")
    @ManyToOne(optional = false)
    private Atendimento atendxcod;
    @JoinColumn(name = "ATENDXFUNCID", referencedColumnName = "FUNC_ID")
    @ManyToOne(optional = false)
    private Funcionario atendxfuncid;

    public Atendimentoxfuncionario() {
    }

    public Atendimentoxfuncionario(Integer atendxfunc) {
        this.atendxfunc = atendxfunc;
    }

    public Integer getAtendxfunc() {
        return atendxfunc;
    }

    public void setAtendxfunc(Integer atendxfunc) {
        this.atendxfunc = atendxfunc;
    }

    public Atendimento getAtendxcod() {
        return atendxcod;
    }

    public void setAtendxcod(Atendimento atendxcod) {
        this.atendxcod = atendxcod;
    }

    public Funcionario getAtendxfuncid() {
        return atendxfuncid;
    }

    public void setAtendxfuncid(Funcionario atendxfuncid) {
        this.atendxfuncid = atendxfuncid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (atendxfunc != null ? atendxfunc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Atendimentoxfuncionario)) {
            return false;
        }
        Atendimentoxfuncionario other = (Atendimentoxfuncionario) object;
        if ((this.atendxfunc == null && other.atendxfunc != null) || (this.atendxfunc != null && !this.atendxfunc.equals(other.atendxfunc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mapeamento.Atendimentoxfuncionario[ atendxfunc=" + atendxfunc + " ]";
    }
    
}
