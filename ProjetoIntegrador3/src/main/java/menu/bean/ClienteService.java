/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package menu.bean;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import mapeamento.Cliente;

/**
 *
 * @author Gabriel
 */
@Stateless
@LocalBean
public class ClienteService extends Dao<Cliente> {

}
