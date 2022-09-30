package beans;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import mapeamento.Carro;
import menu.bean.CarroService;

/**
 *
 * @author Gabriel
 */
@Named
@ViewScoped
public class CarroBean implements Serializable {

    @EJB
    private CarroService carroService;

    private String placa;
    private int anoFabric;

    @PostConstruct
    private void init() {
        Carro carro = new Carro();
    }
    
    public void salvar() {
        Carro carro = new Carro();

        carro.setCarPlaca(this.placa);
        carro.setCarAnofabric(this.anoFabric);

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
