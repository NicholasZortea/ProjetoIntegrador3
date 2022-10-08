package beans;

import java.io.Serializable;
import java.util.List;
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
    private MarcaService marcaService;
    @EJB
    private ClienteService clienteService;

    private Carro carro = new Carro();
    private Marca marca;
    private Modelo modelo;
    private String placa;
    private int anoFabric;

    @PostConstruct
    private void init() {
        buscarMarcas();
        buscarModelos();

    }

    public void salvar() {
        Cliente cliente = clienteService.busca(Cliente.class, 2);

        carro.setCarPlaca(this.placa);
        carro.setCarAnofabric(this.anoFabric);
        carro.setCarCliid(cliente);
        carro.setCarModcod(this.modelo);

        carroService.salvar(carro);
    }

    public List<Marca> buscarMarcas() {
        String sqlQuery = "SELECT * FROM MARCA m ";
        return marcaService.executeNativeQuery(sqlQuery, Marca.class);
    }

    public List<Modelo> buscarModelos() {
        String sqlQuery;

        if (this.marca != null) {
            sqlQuery = "SELECT * FROM MODELO mo WHERE MOD_MARCCOD = ".concat(String.valueOf(this.marca.getMarcCod().toString()));
        } else {
            sqlQuery = "SELECT * FROM MODELO mo";
        }
        return modeloService.executeNativeQuery(sqlQuery, Modelo.class);
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

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }

}
