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
import javax.validation.constraints.Size;
import org.antlr.v4.runtime.misc.NotNull;

/**
 *
 * @author Gabriel
 */
@Entity
@Table(name = "CLIENTES")
public class Clientes implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CLIENTE_SEQ")
    @SequenceGenerator(name = "CLIENTE_SEQ", sequenceName = "CLIENTE_SEQ", allocationSize = 1)
    @Column(name = "CLI_ID")
    private Integer cliId;
    
    @NotNull
    @Size(max = 150)
    @Column(name = "CLI_NOME")
    private String cliNome;
    
    @NotNull
    @Size(max = 14)
    @Column(name = "CLI_CPF")
    private String cliCpf;
    
    @NotNull
    @Column(name = "CLI_TELEFONE")
    private int cliTelefone;
    
    @Size(max = 100)
    @Column(name = "CLI_EMAIL")
    private String cliEmail;
    
    @NotNull
    @JoinColumn(name = "CLI_CIDCOD", referencedColumnName = "CID_COD")
    @ManyToOne(fetch = FetchType.LAZY)
    private Cidade clidCidCod ;
    
    

    public Clientes(Integer cliId, String cliNome, String cliCpf, int cliTelefone,Cidade clidCidCod) {
        this.cliId = cliId;
        this.cliNome = cliNome;
        this.cliCpf = cliCpf;
        this.cliTelefone = cliTelefone;
        this.clidCidCod = clidCidCod;
    }

    public Integer getCliId() {
        return cliId;
    }

    public void setCliId(Integer cliId) {
        this.cliId = cliId;
    }

    public String getCliNome() {
        return cliNome;
    }

    public void setCliNome(String cliNome) {
        this.cliNome = cliNome;
    }

    public String getCliCpf() {
        return cliCpf;
    }

    public void setCliCpf(String cliCpf) {
        this.cliCpf = cliCpf;
    }

    public int getCliTelefone() {
        return cliTelefone;
    }

    public void setCliTelefone(int cliTelefone) {
        this.cliTelefone = cliTelefone;
    }

    public String getCliEmail() {
        return cliEmail;
    }

    public void setCliEmail(String cliEmail) {
        this.cliEmail = cliEmail;
    }

    public Cidade getClidCidCod() {
        return clidCidCod;
    }

    public void setClidCidCod(Cidade clidCidCod) {
        this.clidCidCod = clidCidCod;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.cliId);
        hash = 79 * hash + Objects.hashCode(this.cliNome);
        hash = 79 * hash + Objects.hashCode(this.cliCpf);
        hash = 79 * hash + this.cliTelefone;
        hash = 79 * hash + Objects.hashCode(this.cliEmail);
        hash = 79 * hash + Objects.hashCode(this.clidCidCod);
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
        final Clientes other = (Clientes) obj;
        if (this.cliTelefone != other.cliTelefone) {
            return false;
        }
        if (!Objects.equals(this.cliNome, other.cliNome)) {
            return false;
        }
        if (!Objects.equals(this.cliCpf, other.cliCpf)) {
            return false;
        }
        if (!Objects.equals(this.cliEmail, other.cliEmail)) {
            return false;
        }
        if (!Objects.equals(this.cliId, other.cliId)) {
            return false;
        }
        return Objects.equals(this.clidCidCod, other.clidCidCod);
    }
    
}
