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
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Matheus
 */
@Entity
@Table(name = "RELACIONAMENTO_ATENDIMENTOPECA")
public class RelacionamentoAtendimentoPeca implements Serializable{
    
     @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RELACIONAMENTOPECA_SEQ")
    @SequenceGenerator(name = "RELACIONAMENTOPECA_SEQ", sequenceName = "RELACIONAMENTOPECA_SEQ", allocationSize = 1)
    @Column(name = "RELACIONAMENTO_ATENDIMENTOPECA")
    private Integer relacionamentoAtendimentoPeca;
    
    @NotNull
    @JoinColumn(name = "RELACIONAMENTO_ATENDCOD", referencedColumnName = "ATEND_COD")
    @ManyToMany(fetch = FetchType.LAZY)
    private Atendimento relacionamentoAtendCod;
    
    @NotNull
    @JoinColumn(name = "RELACIONAMENTO_PECACOD", referencedColumnName = "PECA_COD")
    @ManyToMany(fetch = FetchType.LAZY)
    private Peca relacionamentoPecaCod;

    public RelacionamentoAtendimentoPeca(Integer relacionamentoAtendimentoPeca, Atendimento relacionamentoAtendCod, Peca relacionamentoPecaCod) {
        this.relacionamentoAtendimentoPeca = relacionamentoAtendimentoPeca;
        this.relacionamentoAtendCod = relacionamentoAtendCod;
        this.relacionamentoPecaCod = relacionamentoPecaCod;
    }

    public Integer getRelacionamentoAtendimentoPeca() {
        return relacionamentoAtendimentoPeca;
    }

    public void setRelacionamentoAtendimentoPeca(Integer relacionamentoAtendimentoPeca) {
        this.relacionamentoAtendimentoPeca = relacionamentoAtendimentoPeca;
    }

    public Atendimento getRelacionamentoAtendCod() {
        return relacionamentoAtendCod;
    }

    public void setRelacionamentoAtendCod(Atendimento relacionamentoAtendCod) {
        this.relacionamentoAtendCod = relacionamentoAtendCod;
    }

    public Peca getRelacionamentoPecaCod() {
        return relacionamentoPecaCod;
    }

    public void setRelacionamentoPecaCod(Peca relacionamentoPecaCod) {
        this.relacionamentoPecaCod = relacionamentoPecaCod;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.relacionamentoAtendimentoPeca);
        hash = 37 * hash + Objects.hashCode(this.relacionamentoAtendCod);
        hash = 37 * hash + Objects.hashCode(this.relacionamentoPecaCod);
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
        final RelacionamentoAtendimentoPeca other = (RelacionamentoAtendimentoPeca) obj;
        if (!Objects.equals(this.relacionamentoAtendimentoPeca, other.relacionamentoAtendimentoPeca)) {
            return false;
        }
        if (!Objects.equals(this.relacionamentoAtendCod, other.relacionamentoAtendCod)) {
            return false;
        }
        if (!Objects.equals(this.relacionamentoPecaCod, other.relacionamentoPecaCod)) {
            return false;
        }
        return true;
    }
    
    
    
}
