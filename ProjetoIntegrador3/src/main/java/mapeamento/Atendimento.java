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
@Table(name = "ATENDIMENTO")
public class Atendimento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ATEND_COD")
    private Integer atendCod;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "ATEND_KM")
    private String atendKm;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "relacionamentoAtendcod")
    private List<Atendimentoxpeca> atendimentoxpecaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "atendxcod")
    private List<Atendimentoxfuncionario> atendimentoxfuncionarioList;
    @JoinColumn(name = "ATEND_CARPLACA", referencedColumnName = "CAR_PLACA")
    @ManyToOne(optional = false)
    private Carro atendCarplaca;
    @JoinColumn(name = "ATEND_SERVCOD", referencedColumnName = "SERV_COD")
    @ManyToOne(optional = false)
    private Servico atendServcod;

    public Atendimento() {
    }

    public Atendimento(Integer atendCod) {
        this.atendCod = atendCod;
    }

    public Atendimento(Integer atendCod, String atendKm) {
        this.atendCod = atendCod;
        this.atendKm = atendKm;
    }

    public Integer getAtendCod() {
        return atendCod;
    }

    public void setAtendCod(Integer atendCod) {
        this.atendCod = atendCod;
    }

    public String getAtendKm() {
        return atendKm;
    }

    public void setAtendKm(String atendKm) {
        this.atendKm = atendKm;
    }

    public List<Atendimentoxpeca> getAtendimentoxpecaList() {
        return atendimentoxpecaList;
    }

    public void setAtendimentoxpecaList(List<Atendimentoxpeca> atendimentoxpecaList) {
        this.atendimentoxpecaList = atendimentoxpecaList;
    }

    public List<Atendimentoxfuncionario> getAtendimentoxfuncionarioList() {
        return atendimentoxfuncionarioList;
    }

    public void setAtendimentoxfuncionarioList(List<Atendimentoxfuncionario> atendimentoxfuncionarioList) {
        this.atendimentoxfuncionarioList = atendimentoxfuncionarioList;
    }

    public Carro getAtendCarplaca() {
        return atendCarplaca;
    }

    public void setAtendCarplaca(Carro atendCarplaca) {
        this.atendCarplaca = atendCarplaca;
    }

    public Servico getAtendServcod() {
        return atendServcod;
    }

    public void setAtendServcod(Servico atendServcod) {
        this.atendServcod = atendServcod;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (atendCod != null ? atendCod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Atendimento)) {
            return false;
        }
        Atendimento other = (Atendimento) object;
        if ((this.atendCod == null && other.atendCod != null) || (this.atendCod != null && !this.atendCod.equals(other.atendCod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mapeamento.Atendimento[ atendCod=" + atendCod + " ]";
    }
    
}
