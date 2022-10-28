/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Converters;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Named;
import mapeamento.Carro;
import service.CarroService;

/**
 *
 * @author Gabriel
 */
@Named
@RequestScoped
public class CarroConverter implements Converter, Serializable {

    @EJB
    private CarroService carroService;

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String codigo) {

        if (codigo != null || !codigo.isEmpty()) {
            return carroService.busca(Carro.class, codigo);
        }

        return null;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object obj) {
        if (obj != null && !obj.equals("")) {
            Carro carro = (Carro) obj;
            if (carro.getCarPlaca() != null) {
                return carro.getCarPlaca();
            }
        }
        return null;
    }

}
