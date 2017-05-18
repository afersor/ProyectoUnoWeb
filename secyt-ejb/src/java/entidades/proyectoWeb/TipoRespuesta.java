/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.proyectoWeb;

/**
 *
 * @author franco
 */
public enum TipoRespuesta {
    
SI("Si"),
NO("No"),
NO_CORRESPONDE("No Corresponde");

private String name ;

private TipoRespuesta(String name){
this.name = name;
}

public String getName() {
return name;
}

@Override
public String toString(){
//para llenar combo box
return name;
}
}
