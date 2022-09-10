/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapeamento;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Matheus
 */
@Entity
@Table(name = "FUNCIONARIO")
public class Funcionario implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FUNCIONARIO_SEQ")
    @SequenceGenerator(name = "FUNCIONARIO_SEQ", sequenceName = "FUNCIONARIO_SEQ", allocationSize = 1)
    @Column(name = "FUNC_ID")
    private Integer funcId;
    
    @NotNull
    @Size(max = 150)
    @Column(name = "FUNC_NOME")
    private String funcNome;
    
    @NotNull
    @Size(max = 14)
    @Column(name = "FUNC_CPF")
    private String funcCpf;
    
    @NotNull
    @Size(max = 11)
    @Column(name = "FUNC_TELEFONE")
    private int funcTelefone;
    
    @NotNull
    @JoinColumn(name = "FUNC_CIDCOD", referencedColumnName = "CID_COD")
    @ManyToOne(fetch = FetchType.LAZY)
    private Cidade funcCidCod;

    public Funcionario(Integer funcId, String funcNome, String funcCpf, int funcTelefone, Cidade funcCidCod) {
        this.funcId = funcId;
        this.funcNome = funcNome;
        this.funcCpf = funcCpf;
        this.funcTelefone = funcTelefone;
        this.funcCidCod = funcCidCod;
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

    public Cidade getFuncCidCod() {
        return funcCidCod;
    }

    public void setFuncCidCod(Cidade funcCidCod) {
        this.funcCidCod = funcCidCod;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.funcId);
        hash = 83 * hash + Objects.hashCode(this.funcNome);
        hash = 83 * hash + Objects.hashCode(this.funcCpf);
        hash = 83 * hash + this.funcTelefone;
        hash = 83 * hash + Objects.hashCode(this.funcCidCod);
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
        final Funcionario other = (Funcionario) obj;
        if (this.funcTelefone != other.funcTelefone) {
            return false;
        }
        if (!Objects.equals(this.funcNome, other.funcNome)) {
            return false;
        }
        if (!Objects.equals(this.funcCpf, other.funcCpf)) {
            return false;
        }
        if (!Objects.equals(this.funcId, other.funcId)) {
            return false;
        }
        if (!Objects.equals(this.funcCidCod, other.funcCidCod)) {
            return false;
        }
        return true;
    }

    

  
    
    
}
