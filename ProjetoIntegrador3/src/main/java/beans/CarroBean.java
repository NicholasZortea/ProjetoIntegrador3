/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package beans;

import java.io.Serializable;
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

    public CarroService getCarroService() {
        return carroService;
    }

    public void setCarroService(CarroService carroService) {
        this.carroService = carroService;
    }

    public void salvar() {
        carroService.salvar(carro);
    }

}
