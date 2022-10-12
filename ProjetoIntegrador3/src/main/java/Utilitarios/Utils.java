package Utilitarios;


import java.io.Serializable;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 * @author Gabriel
 */
public class Utils implements Serializable {

    public static FacesContext getFC() {
        return FacesContext.getCurrentInstance();
    }

    public static ExternalContext getEC() {
        return FacesContext.getCurrentInstance().getExternalContext();
    }

    public static String getCurrentPage() {
        return getFC().getViewRoot().getViewId();
    }

    public static String getAppPath() {
        return getEC().getRequestContextPath();
    }

}
