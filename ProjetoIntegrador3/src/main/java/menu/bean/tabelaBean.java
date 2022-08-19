package menu.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import menu.jpa.Carro;

/**
 *
 * @author Gabriel
 */
@Named
@SessionScoped
public class tabelaBean implements Serializable {

    @EJB
    private bancoservice bcs;

    private int idcarro;

    private String montadora;

    private String modelo;

    private String ano;

    private String potenciaMotor;

    private String valvulasMotor;

    private String tipoMotor;

    private String cilindradasMotor;

    private String litrosOleo;

    private String viscosidadeOleo;

    private String filtrooleo;

    private List<Carro> listaTabelaCarro = new ArrayList<>();

    public List<Carro> retornoBusca() {
        this.listaTabelaCarro = bcs.executeNativeQuery(montaSql(), Carro.class);

        if (this.listaTabelaCarro.isEmpty()) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "", "Nenhum carro encontrado"));
            return null;
        } else {
            return listaTabelaCarro;
        }
    }

    public String montaSql() {

        String sqlQuery = "SELECT * FROM CARRO C "
                + " WHERE ";
        int contadorAnd = 0;
        if (this.ano != null) {
            if (contadorAnd == 0) {
                sqlQuery = sqlQuery + " C.ANO = " + "'" + this.ano + "'";
                contadorAnd++;
            } else {
                sqlQuery = sqlQuery + " AND C.ANO = " + "'" + this.ano + "'";

            }
        }
        if (this.montadora != null) {
            if (contadorAnd == 0) {
                sqlQuery = sqlQuery + " C.MONTADORA = " + "'" + this.montadora + "'";
                contadorAnd++;
            } else {
                sqlQuery = sqlQuery + " AND  C.MONTADORA = " + "'" + this.montadora + "'";

            }
        }
        if (this.modelo != null) {
            if (contadorAnd == 0) {
                sqlQuery = sqlQuery + " C.MODELO = " + "'" + this.modelo + "'";
                contadorAnd++;

            } else {
                sqlQuery = sqlQuery + " AND  C.MODELO = " + "'" + this.modelo + "'";
            }
        }
        if (this.potenciaMotor != null) {
            if (contadorAnd == 0) {
                sqlQuery = sqlQuery + " C.POTENCIA_MOTOR = " + this.potenciaMotor;
                contadorAnd++;

            } else {
                sqlQuery = sqlQuery + " AND  C.POTENCIA_MOTOR = " + this.potenciaMotor;
            }
        }
        if (this.valvulasMotor != null) {
            if (contadorAnd == 0) {
                sqlQuery = sqlQuery + " C.VALVULAS_MOTOR = " + this.valvulasMotor;
                contadorAnd++;

            } else {
                sqlQuery = sqlQuery + " AND  C.VALVULAS_MOTOR = " + this.valvulasMotor;
            }
        }
        if (this.tipoMotor != null) {
            if (contadorAnd == 0) {
                sqlQuery = sqlQuery + " C.TIPO_MOTOR = " + "'" + this.tipoMotor + "'";
                contadorAnd++;

            } else {
                sqlQuery = sqlQuery + " AND  C.TIPO_MOTOR = " + "'" + this.tipoMotor + "'";
            }
        }
        if (this.cilindradasMotor != null) {
            if (contadorAnd == 0) {
                sqlQuery = sqlQuery + " C.CILINDRADAS_MOTOR = " + "'" + this.cilindradasMotor + "'";
                contadorAnd++;

            } else {
                sqlQuery = sqlQuery + " AND  C.CILINDRADAS_MOTOR = " + "'" + this.cilindradasMotor + "'";
            }
        }
        if (this.litrosOleo != null) {
            if (contadorAnd == 0) {
                sqlQuery = sqlQuery + " C.LITROS_OLEO = " + this.litrosOleo;
                contadorAnd++;
            } else {
                sqlQuery = sqlQuery + " AND  C.LITROS_OLEO = " + this.litrosOleo;
            }
        }
        if (this.viscosidadeOleo != null) {
            if (contadorAnd == 0) {
                sqlQuery = sqlQuery + " C.VISCOSIDADE_OLEO = " + "'" + this.viscosidadeOleo + "'";
                contadorAnd++;

            } else {
                sqlQuery = sqlQuery + " AND  C.VISCOSIDADE_OLEO = " + "'" + this.viscosidadeOleo + "'";
            }
        }
        if (this.filtrooleo != null) {
            if (contadorAnd == 0) {
                sqlQuery = sqlQuery + " C.FILTRO_OLEO = " + "'" + this.filtrooleo + "'";
                contadorAnd++;

            } else {
                sqlQuery = sqlQuery + " AND  C.FILTRO_OLEO = " + "'" + this.filtrooleo + "'";
            }
        }

        return sqlQuery;
    }

    public String doBuscar() {
        if ("Chevrolet".equals(this.montadora)) {
            
            return "chevrolet.xhtml";
        }

        if ("Toyota".equals(this.montadora)) {
            return "toyota.xhtml";
        }

        if ("Volkswagen".equals(this.montadora)) {
            return "volkswagen.xhtml";
        }
         FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "", "Selecione uma Montadora"));
        return null;
    }

    public String doVoltar() {
        this.listaTabelaCarro.clear();
        this.montadora = null;
        this.ano= null;
        this.modelo = null;
        this.potenciaMotor = null;
        this.valvulasMotor = null;
        this.tipoMotor = null;
        this.cilindradasMotor = null;
              
        return "indexPrincipal.xhtml";
    }

    public void retorno() {
        retornoBusca();
    }

    public bancoservice getBcs() {
        return bcs;
    }

    public void setBcs(bancoservice bcs) {
        this.bcs = bcs;
    }

    public String getMontadora() {
        return montadora;
    }

    public void setMontadora(String montadora) {
        this.montadora = montadora;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getPotenciaMotor() {
        return potenciaMotor;
    }

    public void setPotenciaMotor(String potenciaMotor) {
        this.potenciaMotor = potenciaMotor;
    }

    public String getValvulasMotor() {
        return valvulasMotor;
    }

    public void setValvulasMotor(String valvulasMotor) {
        this.valvulasMotor = valvulasMotor;
    }

    public String getTipoMotor() {
        return tipoMotor;
    }

    public void setTipoMotor(String tipoMotor) {
        this.tipoMotor = tipoMotor;
    }

    public String getCilindradasMotor() {
        return cilindradasMotor;
    }

    public void setCilindradasMotor(String cilindradasMotor) {
        this.cilindradasMotor = cilindradasMotor;
    }

    public String getLitrosOleo() {
        return litrosOleo;
    }

    public void setLitrosOleo(String litrosOleo) {
        this.litrosOleo = litrosOleo;
    }

    public String getViscosidadeOleo() {
        return viscosidadeOleo;
    }

    public void setViscosidadeOleo(String viscosidadeOleo) {
        this.viscosidadeOleo = viscosidadeOleo;
    }

    public String getFiltrooleo() {
        return filtrooleo;
    }

    public void setFiltrooleo(String filtrooleo) {
        this.filtrooleo = filtrooleo;
    }

    public List<Carro> getListaTabelaCarro() {
        return listaTabelaCarro;
    }

    public void setListaTabelaCarro(List<Carro> listaTabelaCarro) {
        this.listaTabelaCarro = listaTabelaCarro;
    }

    public int getIdcarro() {
        return idcarro;
    }

    public void setIdcarro(int idcarro) {
        this.idcarro = idcarro;
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final tabelaBean other = (tabelaBean) obj;
        if (!Objects.equals(this.montadora, other.montadora)) {
            return false;
        }
        if (!Objects.equals(this.modelo, other.modelo)) {
            return false;
        }
        if (!Objects.equals(this.ano, other.ano)) {
            return false;
        }
        if (!Objects.equals(this.potenciaMotor, other.potenciaMotor)) {
            return false;
        }
        if (!Objects.equals(this.valvulasMotor, other.valvulasMotor)) {
            return false;
        }
        if (!Objects.equals(this.tipoMotor, other.tipoMotor)) {
            return false;
        }
        if (!Objects.equals(this.cilindradasMotor, other.cilindradasMotor)) {
            return false;
        }
        if (!Objects.equals(this.litrosOleo, other.litrosOleo)) {
            return false;
        }
        if (!Objects.equals(this.viscosidadeOleo, other.viscosidadeOleo)) {
            return false;
        }
        if (!Objects.equals(this.filtrooleo, other.filtrooleo)) {
            return false;
        }
        if (!Objects.equals(this.bcs, other.bcs)) {
            return false;
        }
        if (!Objects.equals(this.listaTabelaCarro, other.listaTabelaCarro)) {
            return false;
        }
        return true;
    }

}
