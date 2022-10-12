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
import mapeamento.Modelo;
import service.ModeloService;

/**
 *
 * @author Gabriel
 */
@Named
@RequestScoped
public class ModeloConverter implements Converter, Serializable {

    @EJB
    private ModeloService modeloService;

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String codigo) {

        if (codigo != null && !codigo.isEmpty()) {
            return modeloService.busca(Modelo.class, Integer.valueOf(codigo));
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object obj) {
        if (obj != null && !obj.equals("")) {
            Modelo modelo = (Modelo) obj;
            if (modelo.getModCod() != null) {
                return modelo.getModCod().toString();
            }
        }
        return null;
    }

}
