
package menu.bean;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class Dao<T> {
    
    //DATA ACESS OBJECT

    @PersistenceContext(name = "sysdb")
    private EntityManager em;

    private Class<T> classe;

    public Class getEntityClass() {
        ParameterizedType pt = (ParameterizedType) getClass().getGenericSuperclass();
        return (Class) pt.getActualTypeArguments()[0];
    }

    public void salvar(T object) {
        em.merge(object);
        em.flush();
    }

    public void excluir(T object) {
        em.remove(em.merge(object));
        em.flush();
    }

    public T busca(Class cl, Integer id) {
        return em.find((Class<T>) cl, id);
    }
    
    public <T> List<T> executeNativeQuery(String sqlQuery, Class classe) {
        
        List<T> list = (List<T>) em.createNativeQuery(sqlQuery, classe).getResultList();
        return list;
    }
}
