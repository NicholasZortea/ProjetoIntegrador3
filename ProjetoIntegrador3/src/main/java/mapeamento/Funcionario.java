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
@Table(name = "FUNCIONARIO")
public class Funcionario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "FUNC_ID")
    private Integer funcId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "FUNC_NOME")
    private String funcNome;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 14)
    @Column(name = "FUNC_CPF")
    private String funcCpf;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FUNC_TELEFONE")
    private int funcTelefone;
    @JoinColumn(name = "FUNC_CIDCOD", referencedColumnName = "CID_COD")
    @ManyToOne(optional = false)
    private Cidade funcCidcod;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "atendxfuncid")
    private List<Atendimentoxfuncionario> atendimentoxfuncionarioList;

    public Funcionario() {
    }

    public Funcionario(Integer funcId) {
        this.funcId = funcId;
    }

    public Funcionario(Integer funcId, String funcNome, String funcCpf, int funcTelefone) {
        this.funcId = funcId;
        this.funcNome = funcNome;
        this.funcCpf = funcCpf;
        this.funcTelefone = funcTelefone;
    }

    public Integer getFuncId() {
        return funcId;
    }

    public void setFuncId(Integer funcId) {
        this.funcId = funcId;
    }

    public String getFuncNome() {
        return funcNome;
    }

    public void setFuncNome(String funcNome) {
        this.funcNome = funcNome;
    }

    public String getFuncCpf() {
        return funcCpf;
    }

    public void setFuncCpf(String funcCpf) {
        this.funcCpf = funcCpf;
    }

    public int getFuncTelefone() {
        return funcTelefone;
    }

    public void setFuncTelefone(int funcTelefone) {
        this.funcTelefone = funcTelefone;
    }

    public Cidade getFuncCidcod() {
        return funcCidcod;
    }

    public void setFuncCidcod(Cidade funcCidcod) {
        this.funcCidcod = funcCidcod;
    }

    public List<Atendimentoxfuncionario> getAtendimentoxfuncionarioList() {
        return atendimentoxfuncionarioList;
    }

    public void setAtendimentoxfuncionarioList(List<Atendimentoxfuncionario> atendimentoxfuncionarioList) {
        this.atendimentoxfuncionarioList = atendimentoxfuncionarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (funcId != null ? funcId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Funcionario)) {
            return false;
        }
        Funcionario other = (Funcionario) object;
        if ((this.funcId == null && other.funcId != null) || (this.funcId != null && !this.funcId.equals(other.funcId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mapeamento.Funcionario[ funcId=" + funcId + " ]";
    }
    
}
