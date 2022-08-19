/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menu.bean;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import menu.jpa.Carro;

/**
 *
 * @author Matheus
 */
@Stateless
@LocalBean
public class bancoservice extends Dao<Carro>{
    
    @Override
    public void salvar(Carro carro){
        super.salvar(carro);
    }
    
    
    
}
