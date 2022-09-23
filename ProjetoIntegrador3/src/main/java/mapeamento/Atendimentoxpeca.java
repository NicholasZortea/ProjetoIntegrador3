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
@Table(name = "ATENDIMENTOXPECA")
public class Atendimentoxpeca implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "RELACIONAMENTO_ATENDIMENTOPECA")
    private Integer relacionamentoAtendimentopeca;
    @JoinColumn(name = "RELACIONAMENTO_ATENDCOD", referencedColumnName = "ATEND_COD")
    @ManyToOne(optional = false)
    private Atendimento relacionamentoAtendcod;
    @JoinColumn(name = "RELACIONAMENTO_PECACOD", referencedColumnName = "PECA_COD")
    @ManyToOne(optional = false)
    private Peca relacionamentoPecacod;

    public Atendimentoxpeca() {
    }

    public Atendimentoxpeca(Integer relacionamentoAtendimentopeca) {
        this.relacionamentoAtendimentopeca = relacionamentoAtendimentopeca;
    }

    public Integer getRelacionamentoAtendimentopeca() {
        return relacionamentoAtendimentopeca;
    }

    public void setRelacionamentoAtendimentopeca(Integer relacionamentoAtendimentopeca) {
        this.relacionamentoAtendimentopeca = relacionamentoAtendimentopeca;
    }

    public Atendimento getRelacionamentoAtendcod() {
        return relacionamentoAtendcod;
    }

    public void setRelacionamentoAtendcod(Atendimento relacionamentoAtendcod) {
        this.relacionamentoAtendcod = relacionamentoAtendcod;
    }

    public Peca getRelacionamentoPecacod() {
        return relacionamentoPecacod;
    }

    public void setRelacionamentoPecacod(Peca relacionamentoPecacod) {
        this.relacionamentoPecacod = relacionamentoPecacod;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (relacionamentoAtendimentopeca != null ? relacionamentoAtendimentopeca.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Atendimentoxpeca)) {
            return false;
        }
        Atendimentoxpeca other = (Atendimentoxpeca) object;
        if ((this.relacionamentoAtendimentopeca == null && other.relacionamentoAtendimentopeca != null) || (this.relacionamentoAtendimentopeca != null && !this.relacionamentoAtendimentopeca.equals(other.relacionamentoAtendimentopeca))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mapeamento.Atendimentoxpeca[ relacionamentoAtendimentopeca=" + relacionamentoAtendimentopeca + " ]";
    }
    
}
