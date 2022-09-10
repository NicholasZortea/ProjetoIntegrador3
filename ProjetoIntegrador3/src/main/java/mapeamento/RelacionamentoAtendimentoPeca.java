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
    private Integer relacAtendPeca;
    
    @NotNull
    @JoinColumn(name = "RELACIONAMENTO_ATENDCOD", referencedColumnName = "ATEND_COD")
    @ManyToMany(fetch = FetchType.LAZY)
    private Atendimento relacAtendCod;
    
    @NotNull
    @JoinColumn(name = "RELACIONAMENTO_PECACOD", referencedColumnName = "PECA_COD")
    @ManyToMany(fetch = FetchType.LAZY)
    private Peca relacPecaCod;

    public RelacionamentoAtendimentoPeca(Integer relacAtendPeca, Atendimento relacAtendCod, Peca relacPecaCod) {
        this.relacAtendPeca = relacAtendPeca;
        this.relacAtendCod = relacAtendCod;
        this.relacPecaCod = relacPecaCod;
    }

    public Integer getRelacAtendPeca() {
        return relacAtendPeca;
    }

    public void setRelacAtendPeca(Integer relacAtendPeca) {
        this.relacAtendPeca = relacAtendPeca;
    }

    public Atendimento getRelacAtendCod() {
        return relacAtendCod;
    }

    public void setRelacAtendCod(Atendimento relacAtendCod) {
        this.relacAtendCod = relacAtendCod;
    }

    public Peca getRelacPecaCod() {
        return relacPecaCod;
    }

    public void setRelacPecaCod(Peca relacPecaCod) {
        this.relacPecaCod = relacPecaCod;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.relacAtendPeca);
        hash = 97 * hash + Objects.hashCode(this.relacAtendCod);
        hash = 97 * hash + Objects.hashCode(this.relacPecaCod);
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
        if (!Objects.equals(this.relacAtendPeca, other.relacAtendPeca)) {
            return false;
        }
        if (!Objects.equals(this.relacAtendCod, other.relacAtendCod)) {
            return false;
        }
        if (!Objects.equals(this.relacPecaCod, other.relacPecaCod)) {
            return false;
        }
        return true;
    }

    
    
    
    
}
