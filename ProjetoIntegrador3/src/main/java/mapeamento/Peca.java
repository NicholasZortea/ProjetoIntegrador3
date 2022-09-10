package mapeamento;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Peca implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PECA_SEQ")
    @SequenceGenerator(name = "PECA_SEQ", sequenceName = "PECA_SEQ", allocationSize = 1)
    @Column(name = "PECA_ID")
    private Integer pecaId;

    @NotNull
    @Column(name = "PECA_QUANTIDADE")
    private String pecaQuantidade;

    @Size(max = 14)
    @Column(name = "PECA_LADO")
    private String pecaLado;

    public Peca(Integer pecaId, String pecaQuantidade) {
        this.pecaId = pecaId;
        this.pecaQuantidade = pecaQuantidade;
    }

    public Integer getPecaId() {
        return pecaId;
    }

    public void setPecaId(Integer pecaId) {
        this.pecaId = pecaId;
    }

    public String getPecaQuantidade() {
        return pecaQuantidade;
    }

    public void setPecaQuantidade(String pecaQuantidade) {
        this.pecaQuantidade = pecaQuantidade;
    }

    public String getPecaLado() {
        return pecaLado;
    }

    public void setPecaLado(String pecaLado) {
        this.pecaLado = pecaLado;
    }

    public String descricaoLado() {
        if ("E".equals(pecaLado)) {
            return "Esquerda";
        } else {
            return "Direita";
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.pecaId);
        hash = 67 * hash + Objects.hashCode(this.pecaQuantidade);
        hash = 67 * hash + Objects.hashCode(this.pecaLado);
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
        final Peca other = (Peca) obj;
        if (!Objects.equals(this.pecaQuantidade, other.pecaQuantidade)) {
            return false;
        }
        if (!Objects.equals(this.pecaLado, other.pecaLado)) {
            return false;
        }
        return Objects.equals(this.pecaId, other.pecaId);
    }
}
