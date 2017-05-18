package beanConvocatoria;


import entidades.proyectoWeb.Ubicacion;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class UbicacionLstBean implements Serializable{

private List<Ubicacion> lstUbicacion;


public UbicacionLstBean() {
}

public List<Ubicacion> getLstUbicacion() { 
   
return lstUbicacion;
}

public void setLstUbicacion(List<Ubicacion> lstUbicacion) { 
    
this.lstUbicacion = lstUbicacion;
}

}
