/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.proyectoWeb;

/**
 *
 * @author franco
 */
public enum TipoEstadoSecyt {
    
ENREVISIÓN ("En Revisión"),
Aprobado ("Aprobado"),
Desaprobado ("Desaprobado");

private String name ;

private TipoEstadoSecyt(String name){
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
