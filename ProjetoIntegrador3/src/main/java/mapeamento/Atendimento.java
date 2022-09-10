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
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Gabriel
 */
@Entity
@Table(name = "ATENDIMENTO")
public class Atendimento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ATENDIMENTO_SEQ")
    @SequenceGenerator(name = "ATENDIMENTO_SEQ", sequenceName = "ATENDIMENTO_SEQ", allocationSize = 1)
    @Column(name = "ATEND_COD")
    private Integer atendCod;

    @NotNull
    @Size(max = 6)
    @Column(name = "ATEND_KM")
    private String atendNome;

    @NotNull
    @JoinColumn(name = "ATEND_SERVCOD", referencedColumnName = "SERV_COD")
    @OneToOne(fetch = FetchType.LAZY)
    private Servico atendServcod;

    @NotNull
    @Size(max = 7)
    @JoinColumn(name = "ATEND_CARPLACA", referencedColumnName = "CAR_PLACA")
    @ManyToOne(fetch = FetchType.LAZY)
    private Carro atendCarPlaca;

    public Atendimento(Integer atendCod, String atendNome, Servico atendServcod, Carro atendCarPlaca) {
        this.atendCod = atendCod;
        this.atendNome = atendNome;
        this.atendServcod = atendServcod;
        this.atendCarPlaca = atendCarPlaca;
    }

    public Integer getAtendCod() {
        return atendCod;
    }

    public void setAtendCod(Integer atendCod) {
        this.atendCod = atendCod;
    }

    public String getAtendNome() {
        return atendNome;
    }

    public void setAtendNome(String atendNome) {
        this.atendNome = atendNome;
    }

    public Servico getAtendServcod() {
        return atendServcod;
    }

    public void setAtendServcod(Servico atendServcod) {
        this.atendServcod = atendServcod;
    }

    public Carro getAtendCarPlaca() {
        return atendCarPlaca;
    }

    public void setAtendCarPlaca(Carro atendCarPlaca) {
        this.atendCarPlaca = atendCarPlaca;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.atendCod);
        hash = 43 * hash + Objects.hashCode(this.atendNome);
        hash = 43 * hash + Objects.hashCode(this.atendServcod);
        hash = 43 * hash + Objects.hashCode(this.atendCarPlaca);
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
        final Atendimento other = (Atendimento) obj;
        if (!Objects.equals(this.atendNome, other.atendNome)) {
            return false;
        }
        if (!Objects.equals(this.atendCod, other.atendCod)) {
            return false;
        }
        if (!Objects.equals(this.atendServcod, other.atendServcod)) {
            return false;
        }
        return Objects.equals(this.atendCarPlaca, other.atendCarPlaca);
    }

}
