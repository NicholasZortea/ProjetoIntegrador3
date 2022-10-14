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
import mapeamento.Cliente;
import mapeamento.Marca;
import service.ClienteService;

/**
 *
 * @author Gabriel
 */
@Named
@RequestScoped
public class ClienteConverter implements Converter, Serializable {

    @EJB
    private ClienteService clienteService;

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String codigo) {

        if (codigo != null || !codigo.isEmpty()) {
            return clienteService.busca(Cliente.class, Integer.valueOf(codigo));
        }

        return null;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object obj) {
        if (obj != null && !obj.equals("")) {
            Cliente cliente = (Cliente) obj;
            if (cliente.getCliId() != null) {
                return cliente.getCliNome();
            }
        }
        return null;
    }

}
