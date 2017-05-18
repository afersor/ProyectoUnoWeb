    package beanConvocatoria;



import entidades.proyectoWeb.Ubicacion;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class UbicacionBean {

    private Ubicacion ubicacion;

    public UbicacionBean() {
        ubicacion = new Ubicacion();
    }

    public Ubicacion getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }

}
