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
@Table(name = "CIDADE")
public class Cidade implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CID_COD")
    private Integer cidCod;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "CID_NOME")
    private String cidNome;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "funcCidcod")
    private List<Funcionario> funcionarioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cliCidcod")
    private List<Cliente> clienteList;

    public Cidade() {
    }

    public Cidade(Integer cidCod) {
        this.cidCod = cidCod;
    }

    public Cidade(Integer cidCod, String cidNome) {
        this.cidCod = cidCod;
        this.cidNome = cidNome;
    }

    public Integer getCidCod() {
        return cidCod;
    }

    public void setCidCod(Integer cidCod) {
        this.cidCod = cidCod;
    }

    public String getCidNome() {
        return cidNome;
    }

    public void setCidNome(String cidNome) {
        this.cidNome = cidNome;
    }

    public List<Funcionario> getFuncionarioList() {
        return funcionarioList;
    }

    public void setFuncionarioList(List<Funcionario> funcionarioList) {
        this.funcionarioList = funcionarioList;
    }

    public List<Cliente> getClienteList() {
        return clienteList;
    }

    public void setClienteList(List<Cliente> clienteList) {
        this.clienteList = clienteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cidCod != null ? cidCod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cidade)) {
            return false;
        }
        Cidade other = (Cidade) object;
        if ((this.cidCod == null && other.cidCod != null) || (this.cidCod != null && !this.cidCod.equals(other.cidCod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mapeamento.Cidade[ cidCod=" + cidCod + " ]";
    }
    
}
