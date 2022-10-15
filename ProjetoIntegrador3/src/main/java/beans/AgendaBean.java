package beans;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import mapeamento.Agenda;
import mapeamento.Carro;
import mapeamento.Cliente;
import mapeamento.Marca;
import mapeamento.Modelo;
import service.CarroService;
import service.ClienteService;
import service.MarcaService;
import service.ModeloService;
import service.AgendaService;

/**
 *
 * @author Gabriel
 */
@Named
@ViewScoped
public class AgendaBean implements Serializable {
    
    @EJB
    private AgendaService agendaService;
    
    @EJB
    private CarroService carroService;
    @EJB
    private ModeloService modeloService;
    @EJB
    private MarcaService marcaService;
    @EJB
    private ClienteService clienteService;

    private int agendaCod;
    private String agendaDesc;
    private Date agendaData;
    private int agendaCliid;
    private String agendaCarplaca;
    private Cliente cliente;
    private Carro carro;
   
    
    @PostConstruct
    private void init() {
        Agenda agenda = new Agenda();
    }

    public void salvar() {  
        
        Agenda agenda = new Agenda();

        agenda.setAgendaCod(this.agendaCod);
        agenda.setAgendaDesc(this.agendaDesc);
        agenda.setAgendaData(this.agendaData);
        agenda.setAgendaCliid(this.cliente);
        agenda.setAgendaCarplaca(this.carro);

        agendaService.salvar(agenda);
    }

    public List<Modelo> buscarCliente() {
        String sqlQuery = "SELECT * FROM CLIENTE cli";
        return clienteService.executeNativeQuery(sqlQuery, Cliente.class);
    }
    
    public List<Marca> buscarCarro() {
        String sqlQuery = "SELECT * FROM CARRO c ";
        return carroService.executeNativeQuery(sqlQuery, Carro.class);
    }

    public int getAgendaCod() {
        return agendaCod;
    }

    public void setAgendaCod(int agendaCod) {
        this.agendaCod = agendaCod;
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

    public int getAgendaCliid() {
        return agendaCliid;
    }

    public void setAgendaCliid(int agendaCliid) {
        this.agendaCliid = agendaCliid;
    }

    public String getAgendaCarplaca() {
        return agendaCarplaca;
    }

    public void setAgendaCarplaca(String agendaCarplaca) {
        this.agendaCarplaca = agendaCarplaca;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }
    
}
