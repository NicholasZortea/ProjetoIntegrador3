/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package beans;

import java.io.Serializable;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author Gabriel
 */
@Named
@ViewScoped
public class IndexBean implements Serializable {

    public String doIrCliente() {
        return "cadastroCliente.xhtml";
    }

    public String doIrCarro() {
        return "cadastroCarro.xhtml";
    }

    public String doIrAgenda() {
        return "Agenda.xhtml";
    }

}
