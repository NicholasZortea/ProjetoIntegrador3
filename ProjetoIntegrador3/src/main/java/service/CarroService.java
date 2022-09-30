package service;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import mapeamento.Carro;

/**
 *
 * @author Gabriel
 */
@Stateless
@LocalBean
public class CarroService extends Dao<Carro> {

}
