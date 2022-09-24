package beans;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import mapeamento.Carro;
import menu.bean.CarroService;

/**
 *
 * @author Gabriel
 */
public class CarroBean implements Serializable {

    @EJB
    private CarroService carroService;

    private Carro carro;

    @PostConstruct
    private void init() {
        Carro carro = new Carro();
    }

    public void salvar() {
        carroService.salvar(carro);
    }

}
