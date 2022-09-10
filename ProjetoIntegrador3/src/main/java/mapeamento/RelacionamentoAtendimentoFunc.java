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

/**
 *
 * @author Gabriel
 */
@Entity
@Table(name = "RELACIONAMENTO_ATENDIMENTOFUNC")
public class RelacionamentoAtendimentoFunc implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RELACIONAMENTO_FUNC_SEQ")
    @SequenceGenerator(name = "RELACIONAMENTO_FUNC_SEQ", sequenceName = "RELACIONAMENTO_FUNC_SEQ", allocationSize = 1)
    @Column(name = "RELACIONAMENTO_ATENDIMENTOFUNC")
    private Integer relatAtendFunc;

    @NotNull
    @JoinColumn(name = "RELACIONAMENTO_ATENDCOD", referencedColumnName = "ATEND_COD")
    @ManyToOne(fetch = FetchType.LAZY)
    private Atendimento relatAtendCod;

    @NotNull
    @JoinColumn(name = "RELACIONAMENTO_FUNCID", referencedColumnName = "FUNC_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Funcionario relatFuncID;

    public RelacionamentoAtendimentoFunc(Integer relatAtendFunc, Atendimento relatAtendCod, Funcionario relatFuncID) {
        this.relatAtendFunc = relatAtendFunc;
        this.relatAtendCod = relatAtendCod;
        this.relatFuncID = relatFuncID;
    }

    public Integer getRelatAtendFunc() {
        return relatAtendFunc;
    }

    public void setRelatAtendFunc(Integer relatAtendFunc) {
        this.relatAtendFunc = relatAtendFunc;
    }

    public Atendimento getRelatAtendCod() {
        return relatAtendCod;
    }

    public void setRelatAtendCod(Atendimento relatAtendCod) {
        this.relatAtendCod = relatAtendCod;
    }

    public Funcionario getRelatFuncID() {
        return relatFuncID;
    }

    public void setRelatFuncID(Funcionario relatFuncID) {
        this.relatFuncID = relatFuncID;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.relatAtendFunc);
        hash = 47 * hash + Objects.hashCode(this.relatAtendCod);
        hash = 47 * hash + Objects.hashCode(this.relatFuncID);
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
        final RelacionamentoAtendimentoFunc other = (RelacionamentoAtendimentoFunc) obj;
        if (!Objects.equals(this.relatAtendFunc, other.relatAtendFunc)) {
            return false;
        }
        if (!Objects.equals(this.relatAtendCod, other.relatAtendCod)) {
            return false;
        }
        return Objects.equals(this.relatFuncID, other.relatFuncID);
    }

}
