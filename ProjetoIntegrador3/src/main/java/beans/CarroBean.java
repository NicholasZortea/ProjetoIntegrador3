package beans;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import mapeamento.Carro;
import mapeamento.Cliente;
import mapeamento.Marca;
import mapeamento.Modelo;
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
public class CarroBean implements Serializable {

    @EJB
    private CarroService carroService;
    @EJB
    private ModeloService modeloService;
    @EJB
    private ClienteService clienteService;

    private String placa;
    private int anoFabric;

    @PostConstruct
    private void init() {
        Carro carro = new Carro();
    }

    public void salvar() {
        Carro carro = new Carro();
        Cliente cliente = clienteService.busca(Cliente.class, 2);
        Modelo modelo = modeloService.busca(Modelo.class, 1);

        carro.setCarPlaca(this.placa);
        carro.setCarAnofabric(this.anoFabric);
        carro.setCarCliid(cliente);
        carro.setCarModcod(modelo);

        carroService.salvar(carro);
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getAnoFabric() {
        return anoFabric;
    }

    public void setAnoFabric(int anoFabric) {
        this.anoFabric = anoFabric;
    }

}
