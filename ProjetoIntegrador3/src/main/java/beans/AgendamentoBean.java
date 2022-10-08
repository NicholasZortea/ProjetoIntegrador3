package beans;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import mapeamento.Agenda;
import mapeamento.Carro;
import mapeamento.Cliente;
import mapeamento.Marca;
import mapeamento.Modelo;
import service.AgendamentoService;
import service.CarroService;
import service.ClienteService;
import service.MarcaService;
import service.ModeloService;

/**
 *
 * @author Gabriel
 */
@Named
@ViewScoped
public class AgendamentoBean implements Serializable {

    @EJB
    private AgendamentoService agendamentoService;
    
     @EJB
    private CarroService carroService;
     
     @EJB
    private ModeloService modeloService;

    private String agendaDesc;
    private Date agendaData;

    @PostConstruct
    private void init() {
        Agenda agenda = new Agenda();
    }

    public void salvar() {
        Agenda agenda = new Agenda();
        
        
        
        agenda.setAgendaCarplaca(carro);
        agenda.setAgendaData(this.agendaData);
        agenda.setAgendaDesc(this.agendaDesc);
        
       agendamentoService.salvar(agenda);
    }

    public String getAgendaDesc() {
        return agendaDesc;
    }

    public void setAgendaDesc(String agendaDesc) {
        this.agendaDesc = agendaDesc;
    }

    public Date getAgendaData() {
        return agendaData;
    }

    public void setAgendaData(Date agendaData) {
        this.agendaData = agendaData;
    }

    
   

}
