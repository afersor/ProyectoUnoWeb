/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.proyectoWeb.RN;

import DAO.ProyectoWebFacadeLocal;
import entidades.proyectoWeb.BienConsumoWeb;
import entidades.proyectoWeb.BienNoPersonalWeb;
import entidades.proyectoWeb.BienUsoWeb;
import entidades.proyectoWeb.GastoViajeWeb;
import entidades.proyectoWeb.ParticipacionWeb;
import entidades.proyectoWeb.ProyectoWeb;
import entidades.proyectoWeb.TipoRespuesta;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;


/**
 *
 * @author diego
 */
@Stateless
public class ProyectoWebRN implements ProyectoWebRNLocal {

    @EJB
    private ProyectoWebFacadeLocal proyectoWebFacadeLocal;

    @Override
    public void guardar(ProyectoWeb proyectoWeb, int pantalla) throws Exception {
        /*System.out.println("uno: " + proyectoWeb.getPresupuestoWebAnioUno().getBienConsumoWeb().get(0).getValor());
         //System.out.println("dos: " + proyectoWeb.getPresupuestoWebAnioDos().getBienConsumoWeb().get(0).getValor());
         proyectoWeb.setPresupuestoWebAnioDos(null);
         proyectoWeb.setPresupuestoWebAnioTres(null);
         proyectoWeb.setPresupuestoWebAnioCuatro(null);*/
        this.validar(proyectoWeb, pantalla);


        proyectoWebFacadeLocal.edit(proyectoWeb);
    }

    @Override
    public void delete(ProyectoWeb proyectoWeb) throws Exception {

        proyectoWebFacadeLocal.remove(proyectoWeb);
    }

    private void validar(ProyectoWeb proyectoWeb, int pantalla) throws Exception {
        /* calculo los años para validar despues */
        if (proyectoWeb.getFechaInicio() == null) {
            throw new Exception("Debe ingresar la fecha inicial");
        }//fin if

        if (proyectoWeb.getFechaFinalizacion() == null) {
            throw new Exception("Debe ingresar la fecha de finalización");
        }//fin if

        Calendar calIni1 = Calendar.getInstance();
        Calendar calFin1 = Calendar.getInstance();
        calIni1.setTime(proyectoWeb.getFechaInicio());
        calFin1.setTime(proyectoWeb.getFechaFinalizacion());
        calFin1.add(Calendar.DATE, 1);
        long difDia1 = (calFin1.get(Calendar.DATE) - calIni1.get(Calendar.DATE))
                + (calFin1.get(Calendar.MONTH) - calIni1.get(Calendar.MONTH))
                + (calFin1.get(Calendar.YEAR) - calIni1.get(Calendar.YEAR));

        if (proyectoWeb.getId() == null) {
            if (this.findProyectoWebByDirectorYConvocatoria(
                    proyectoWeb.getParticipacionesWeb().get(0).getId(), proyectoWeb.getConvocatoria().getId())
                    .size() > 1) {
                throw new Exception("No puede cargar mas proyectos. Solo se permiten dos por convocatoria");
            }//fin if
        }//fin if

        switch (pantalla) {
            
            case 11:
            /*case 10:
                System.out.println("Entro al 10: " + proyectoWeb.getProyectoWebSegSaludBioseg());
                if (proyectoWeb.getProyectoWebSegSaludBioseg() == null) {
                    throw new Exception("No respondio las pregunta de la pantalla X. Declaración Relativa a Seguridad, Salud Ocupacional y Bioseguridad");
                }

                if (proyectoWeb.getProyectoWebSegSaludBioseg().getIncluyeTareaCampo() == null) {
                    throw new Exception("No respondio la pregunta 1 de la pantalla X. Declaración Relativa a Seguridad, Salud Ocupacional y Bioseguridad.");
                }//fin if

                if (proyectoWeb.getProyectoWebSegSaludBioseg().getCuentraProfesional() == null) {
                    throw new Exception("No respondio la pregunta 2 de la pantalla X. Declaración Relativa a Seguridad, Salud Ocupacional y Bioseguridad.");
                }//fin if

                if (proyectoWeb.getProyectoWebSegSaludBioseg().getExisteComiteSegBioseg() == null) {
                    throw new Exception("No respondio la pregunta 3 de la pantalla X. Declaración Relativa a Seguridad, Salud Ocupacional y Bioseguridad.");
                }//fin if

                if (proyectoWeb.getProyectoWebSegSaludBioseg().getRiesgosFisicos() == null) {
                    throw new Exception("No respondio la pregunta 4 de la pantalla X. Declaración Relativa a Seguridad, Salud Ocupacional y Bioseguridad.");
                }//fin if

                if (proyectoWeb.getProyectoWebSegSaludBioseg().getSustanciasQuimicas() == null) {
                    throw new Exception("No respondio la pregunta 5 de la pantalla X. Declaración Relativa a Seguridad, Salud Ocupacional y Bioseguridad.");
                } else {

                    if (proyectoWeb.getProyectoWebSegSaludBioseg().getSustanciasQuimicas().equals(TipoRespuesta.SI)) {
                        if (proyectoWeb.getProyectoWebSegSaludBioseg().getSustancias() == null
                                || proyectoWeb.getProyectoWebSegSaludBioseg().getSustancias().isEmpty()) {
                            throw new Exception("No respondio la pregunta 6 de la pantalla X. Declaración Relativa a Seguridad, Salud Ocupacional y Bioseguridad.");
                        }//fin if
                    }//fin if
                }

                if (proyectoWeb.getProyectoWebSegSaludBioseg().getCampanaExtraccion() == null) {
                    throw new Exception("No respondio la pregunta 7 de la pantalla X. Declaración Relativa a Seguridad, Salud Ocupacional y Bioseguridad.");
                }//fin if

                if (proyectoWeb.getProyectoWebSegSaludBioseg().getRiesgosBiologicos()== null) {
                    throw new Exception("No respondio la pregunta 8 de la pantalla X. Declaración Relativa a Seguridad, Salud Ocupacional y Bioseguridad.");
                } else {

                    if (proyectoWeb.getProyectoWebSegSaludBioseg().getRiesgosBiologicos().equals(TipoRespuesta.SI)) {
                        if (proyectoWeb.getProyectoWebSegSaludBioseg().getNivelSeguridadInstalaciones() == null
                                || proyectoWeb.getProyectoWebSegSaludBioseg().getNivelSeguridadInstalaciones().isEmpty()) {
                            throw new Exception("No respondio la pregunta 9 de la pantalla X. Declaración Relativa a Seguridad, Salud Ocupacional y Bioseguridad.");
                        }//fin if
                    }//fin if
                }

                if (proyectoWeb.getProyectoWebSegSaludBioseg().getAprobadoComite() == null) {
                    throw new Exception("No respondio la pregunta 10 de la pantalla X. Declaración Relativa a Seguridad, Salud Ocupacional y Bioseguridad.");
                }//fin if

                if (proyectoWeb.getProyectoWebSegSaludBioseg().getRealizaInmunizacion() == null) {
                    throw new Exception("No respondio la pregunta 11 de la pantalla X. Declaración Relativa a Seguridad, Salud Ocupacional y Bioseguridad.");
                }//fin if

                if (proyectoWeb.getProyectoWebSegSaludBioseg().getAdvertenciaRiesgoMujeres() == null) {
                    throw new Exception("No respondio la pregunta 12 de la pantalla X. Declaración Relativa a Seguridad, Salud Ocupacional y Bioseguridad.");
                }//fin if

                if (proyectoWeb.getProyectoWebSegSaludBioseg().getExisteGestionResiduos() == null) {
                    throw new Exception("No respondio la pregunta 13 de la pantalla X. Declaración Relativa a Seguridad, Salud Ocupacional y Bioseguridad.");
                }//fin if

                if (proyectoWeb.getProyectoWebSegSaludBioseg().getPersonalCapacitadoPrevencion() == null) {
                    throw new Exception("No respondio la pregunta 14 de la pantalla X. Declaración Relativa a Seguridad, Salud Ocupacional y Bioseguridad.");
                }//fin if

                if (proyectoWeb.getProyectoWebSegSaludBioseg().getCantPersEspacioTrabajo() == null) {
                    throw new Exception("No respondio la pregunta 15 de la pantalla X. Declaración Relativa a Seguridad, Salud Ocupacional y Bioseguridad.");
                }//fin if

                if (proyectoWeb.getProyectoWebSegSaludBioseg().getMtsCantPersonas() == null) {
                    throw new Exception("No respondio la pregunta 16 de la pantalla X. Declaración Relativa a Seguridad, Salud Ocupacional y Bioseguridad.");
                }//fin if*/
            case 9: 
                System.out.println("Entro al 9: " + proyectoWeb.getProyectoWebAspEti());
                if (proyectoWeb.getProyectoWebAspEti() == null) {
                    throw new Exception("No respondio las pregunta de la pantalla IX. Aspectos Éticos");
                }

                if (proyectoWeb.getProyectoWebAspEti().getEticoSeguridad() == null) {
                    throw new Exception("No respondio la pregunta 1 de la pantalla IX. Aspectos Éticos");
                }//fin if

                if (proyectoWeb.getProyectoWebAspEti().getComprendeInvestigacionHumana() == null) {
                    throw new Exception("No respondio la pregunta 2 de la pantalla IX. Aspectos Éticos");
                }//fin if

                if (proyectoWeb.getProyectoWebAspEti().getEstudioFarmaTecno() == null) {
                    throw new Exception("No respondio la pregunta 3 de la pantalla IX. Aspectos Éticos");
                }//fin if

                if (proyectoWeb.getProyectoWebAspEti().getEstudioClinQuiruBasi() == null) {
                    throw new Exception("No respondio la pregunta 4 de la pantalla IX. Aspectos Éticos");
                }//fin if

                if (proyectoWeb.getProyectoWebAspEti().getEstudioEpideSociaPsico() == null) {
                    throw new Exception("No respondio la pregunta 5 de la pantalla IX. Aspectos Éticos");
                }//fin if

                if (proyectoWeb.getProyectoWebAspEti().getEquipamientoMedico() == null) {
                    throw new Exception("No respondio la pregunta 6 de la pantalla IX. Aspectos Éticos");
                }//fin if

                if (proyectoWeb.getProyectoWebAspEti().getEquipamientoImgRadia() == null) {
                    throw new Exception("No respondio la pregunta 7 de la pantalla IX. Aspectos Éticos");
                }//fin if

                if (proyectoWeb.getProyectoWebAspEti().getUsoHistoClinica() == null) {
                    throw new Exception("No respondio la pregunta 8 de la pantalla IX. Aspectos Éticos");
                }//fin if

                if (proyectoWeb.getProyectoWebAspEti().getUsoMuestBiolog() == null) {
                    throw new Exception("No respondio la pregunta 9 de la pantalla IX. Aspectos Éticos");
                }//fin if

                if (proyectoWeb.getProyectoWebAspEti().getEstudioComunAborig() == null) {
                    throw new Exception("No respondio la pregunta 10 de la pantalla IX. Aspectos Éticos");
                }//fin if

                if (proyectoWeb.getProyectoWebAspEti().getInformePlanInv() == null) {
                    throw new Exception("No respondio la pregunta 11 de la pantalla IX. Aspectos Éticos");
                }//fin if
            case 8: //bibliografia
            case 7: 
                //archivos
                //verificar que sea la misma cantidad que participantes
                if (proyectoWeb.getLstArchivoWeb() == null) {
                    throw new Exception("Debe adjuntar los curriculum de todos los participantes");
                }//fin if

               
                if (proyectoWeb.getLstArchivoWeb().size() < (proyectoWeb.getParticipacionesWeb().size() + 1)) {
                    throw new Exception("Debe adjuntar los curriculum de todos los participantes y el cronograma de trabajo");
                }//fin if

            case 6:
            case 5:

                //Listados por año, año 1
                List<BienUsoWeb> bienUsoWeb1 = new ArrayList<BienUsoWeb>();
                List<BienConsumoWeb> bienConsumoWeb1 = new ArrayList<BienConsumoWeb>();
                List<BienNoPersonalWeb> bienNoPersonalWeb1 = new ArrayList<BienNoPersonalWeb>();
                List<GastoViajeWeb> gastosViajeWeb1 = new ArrayList<GastoViajeWeb>();
                if (proyectoWeb.getPresupuestoWebAnioUno() != null) {
                    bienUsoWeb1 = proyectoWeb.getPresupuestoWebAnioUno().getBienUsoWeb();
                    bienConsumoWeb1 = proyectoWeb.getPresupuestoWebAnioUno().getBienConsumoWeb();
                    bienNoPersonalWeb1 = proyectoWeb.getPresupuestoWebAnioUno().getBienNoPersonalWeb();
                    gastosViajeWeb1 = proyectoWeb.getPresupuestoWebAnioUno().getGastosViajeWeb();
                }
                //2
                List<BienUsoWeb> bienUsoWeb2 = new ArrayList<BienUsoWeb>();
                List<BienConsumoWeb> bienConsumoWeb2 = new ArrayList<BienConsumoWeb>();
                List<BienNoPersonalWeb> bienNoPersonalWeb2 = new ArrayList<BienNoPersonalWeb>();
                List<GastoViajeWeb> gastosViajeWeb2 = new ArrayList<GastoViajeWeb>();
                if (proyectoWeb.getPresupuestoWebAnioDos() != null) {
                    bienUsoWeb2 = proyectoWeb.getPresupuestoWebAnioDos().getBienUsoWeb();
                    bienConsumoWeb2 = proyectoWeb.getPresupuestoWebAnioDos().getBienConsumoWeb();
                    bienNoPersonalWeb2 = proyectoWeb.getPresupuestoWebAnioDos().getBienNoPersonalWeb();
                    gastosViajeWeb2 = proyectoWeb.getPresupuestoWebAnioDos().getGastosViajeWeb();
                }
                // 3
                List<BienUsoWeb> bienUsoWeb3 = new ArrayList<BienUsoWeb>();
                List<BienConsumoWeb> bienConsumoWeb3 = new ArrayList<BienConsumoWeb>();
                List<BienNoPersonalWeb> bienNoPersonalWeb3 = new ArrayList<BienNoPersonalWeb>();
                List<GastoViajeWeb> gastosViajeWeb3 = new ArrayList<GastoViajeWeb>();
                if (proyectoWeb.getPresupuestoWebAnioTres() != null) {

                    bienUsoWeb3 = proyectoWeb.getPresupuestoWebAnioTres().getBienUsoWeb();
                    bienConsumoWeb3 = proyectoWeb.getPresupuestoWebAnioTres().getBienConsumoWeb();
                    bienNoPersonalWeb3 = proyectoWeb.getPresupuestoWebAnioTres().getBienNoPersonalWeb();
                    gastosViajeWeb3 = proyectoWeb.getPresupuestoWebAnioTres().getGastosViajeWeb();
                }  //4

                List<BienUsoWeb> bienUsoWeb4 = new ArrayList<BienUsoWeb>();
                List<BienConsumoWeb> bienConsumoWeb4 = new ArrayList<BienConsumoWeb>();
                List<BienNoPersonalWeb> bienNoPersonalWeb4 = new ArrayList<BienNoPersonalWeb>();
                List<GastoViajeWeb> gastosViajeWeb4 = new ArrayList<GastoViajeWeb>();

                if (proyectoWeb.getPresupuestoWebAnioCuatro() != null) {
                    bienUsoWeb4 = proyectoWeb.getPresupuestoWebAnioCuatro().getBienUsoWeb();
                    bienConsumoWeb4 = proyectoWeb.getPresupuestoWebAnioCuatro().getBienConsumoWeb();
                    bienNoPersonalWeb4 = proyectoWeb.getPresupuestoWebAnioCuatro().getBienNoPersonalWeb();
                    gastosViajeWeb4 = proyectoWeb.getPresupuestoWebAnioCuatro().getGastosViajeWeb();
                } //sumadores
                BigDecimal totalUso = BigDecimal.ZERO;
                BigDecimal totalConsumo = BigDecimal.ZERO;
                BigDecimal totalGastosViaje = BigDecimal.ZERO;
                BigDecimal totalNoPersonal = BigDecimal.ZERO;
                BigDecimal total1 = BigDecimal.ZERO;
                BigDecimal total2 = BigDecimal.ZERO;
                BigDecimal total3 = BigDecimal.ZERO;
                BigDecimal total4 = BigDecimal.ZERO;
                /* año 1 */

                if (bienUsoWeb1 != null) {
                    for (BienUsoWeb bc : bienUsoWeb1) {
                        totalUso = totalUso.add(bc.getValor());
                        total1 = total1.add(bc.getValor());
                    }
                }

                if (bienConsumoWeb1 != null) {
                    for (BienConsumoWeb bc : bienConsumoWeb1) {
                        totalConsumo = totalConsumo.add(bc.getValor());
                        total1 = total1.add(bc.getValor());
                    }
                }

                if (gastosViajeWeb1 != null) {
                    for (GastoViajeWeb bc : gastosViajeWeb1) {
                        totalGastosViaje = totalGastosViaje.add(bc.getValor());
                        total1 = total1.add(bc.getValor());
                    }
                }

                if (bienNoPersonalWeb1 != null) {
                    for (BienNoPersonalWeb bc : bienNoPersonalWeb1) {
                        totalNoPersonal = totalNoPersonal.add(bc.getValor());
                        total1 = total1.add(bc.getValor());
                    }
                }

                /* año 2 */
                if (bienUsoWeb2 != null) {
                    for (BienUsoWeb bc : bienUsoWeb2) {
                        totalUso = totalUso.add(bc.getValor());
                        total2 = total2.add(bc.getValor());
                    }
                }

                if (bienConsumoWeb2 != null) {
                    for (BienConsumoWeb bc : bienConsumoWeb2) {
                        totalConsumo = totalConsumo.add(bc.getValor());
                        total2 = total2.add(bc.getValor());
                    }
                }

                if (gastosViajeWeb2 != null) {
                    for (GastoViajeWeb bc : gastosViajeWeb2) {
                        totalGastosViaje = totalGastosViaje.add(bc.getValor());
                        total2 = total2.add(bc.getValor());
                    }
                }

                if (bienNoPersonalWeb2 != null) {
                    for (BienNoPersonalWeb bc : bienNoPersonalWeb2) {
                        totalNoPersonal = totalNoPersonal.add(bc.getValor());
                        total2 = total2.add(bc.getValor());
                    }
                }
                if (difDia1 != 2) {   /* año 3 */

                    if (bienUsoWeb3 != null) {
                        for (BienUsoWeb bc : bienUsoWeb3) {
                            totalUso = totalUso.add(bc.getValor());
                            total3 = total3.add(bc.getValor());
                        }
                    }

                    System.out.println("bienConsumoWeb3: " + bienConsumoWeb3);
                    if (bienConsumoWeb3 != null) {
                        for (BienConsumoWeb bc : bienConsumoWeb3) {
                            totalConsumo = totalConsumo.add(bc.getValor());
                            total3 = total3.add(bc.getValor());
                        }
                    }

                    if (gastosViajeWeb3 != null) {
                        for (GastoViajeWeb bc : gastosViajeWeb3) {
                            totalGastosViaje = totalGastosViaje.add(bc.getValor());
                            total3 = total3.add(bc.getValor());
                        }
                    }

                    if (bienNoPersonalWeb3 != null) {
                        for (BienNoPersonalWeb bc : bienNoPersonalWeb3) {
                            totalNoPersonal = totalNoPersonal.add(bc.getValor());
                            total3 = total3.add(bc.getValor());
                        }
                    }
                    /* año 4 */
                    if (bienUsoWeb4 != null) {
                        for (BienUsoWeb bc : bienUsoWeb4) {
                            totalUso = totalUso.add(bc.getValor());
                            total4 = total4.add(bc.getValor());
                        }
                    }

                    if (bienConsumoWeb4 != null) {
                        for (BienConsumoWeb bc : bienConsumoWeb4) {
                            totalConsumo = totalConsumo.add(bc.getValor());
                            total4 = total4.add(bc.getValor());
                        }
                    }

                    if (gastosViajeWeb4 != null) {
                        for (GastoViajeWeb bc : gastosViajeWeb4) {
                            totalGastosViaje = totalGastosViaje.add(bc.getValor());
                            total4 = total4.add(bc.getValor());
                        }
                    }

                    if (bienNoPersonalWeb4 != null) {
                        for (BienNoPersonalWeb bc : bienNoPersonalWeb4) {
                            totalNoPersonal = totalNoPersonal.add(bc.getValor());
                            total4 = total4.add(bc.getValor());
                        }
                    }

                }

                if (total1.compareTo(proyectoWeb.getConvocatoria().getMontoMaximo()) > 0) {
                    throw new Exception("El plan de ejecución financiera para el año 1 "
                            + "no debe superar el monto de "
                            + proyectoWeb.getConvocatoria().getMontoMaximo());
                }//fin if
                if (total2.compareTo(proyectoWeb.getConvocatoria().getMontoMaximo()) > 0) {
                    throw new Exception("El plan de ejecución financiera para el año 2 "
                            + "no debe superar el monto de "
                            + proyectoWeb.getConvocatoria().getMontoMaximo());
                }//fin if

                if (total1.add(total2).compareTo(BigDecimal.ZERO) == 0) {
                    throw new Exception("Debe completar todos los años del 'Plan de ejecución financiera para los dos y/o cuatro años'");
                }

                if (difDia1 != 2) {

                    if (total3.compareTo(proyectoWeb.getConvocatoria().getMontoMaximo()) > 0) {
                        throw new Exception("El plan de ejecución financiera para el año 3 "
                                + "no debe superar el monto de "
                                + proyectoWeb.getConvocatoria().getMontoMaximo());
                    }//fin if
                    if (total4.compareTo(proyectoWeb.getConvocatoria().getMontoMaximo()) > 0) {
                        throw new Exception("El plan de ejecución financiera para el año 4 "
                                + "no debe superar el monto de "
                                + proyectoWeb.getConvocatoria().getMontoMaximo());
                    }//fin if

                    if (total1.add(total2.add(total3.add(total4))).compareTo(BigDecimal.ZERO) == 0) {
                        throw new Exception("Debe completar todos los años del 'Plan de ejecución financiera para los dos y/o cuatro años'");
                    }

                }
                /* validaciones diego */

                if (difDia1 != 2 && difDia1 != 4) {
                    throw new Exception("EL proyecto debe tener una duración de 2 o 4 años. Verifique las fechas");
                }//fin if

                if (difDia1 == 2) {
                    try {
                        if (proyectoWeb.getPresupuestoWeb().getBienConsumo() != null) {
                            if (proyectoWeb.getPresupuestoWeb().getBienConsumo().size() > 2) {
                                throw new Exception("Una vez que a empezado a completar el presupuesto no puede modificar la fecha para un proyecto de 2 años");
                            }
                        }
                    } catch (Exception e) {
                    }
                }
            case 4:

//valido que haya al menos 4 investigadores categorizados por proyecto
                
                if(proyectoWeb.getParticipacionesWeb() != null){
                    int cantidadInvestigadoresCategorizados = 0;
                    for (ParticipacionWeb p : proyectoWeb.getParticipacionesWeb()) {
                        if (!p.getInvestigador().getCategorizaciones().isEmpty()) {
                        cantidadInvestigadoresCategorizados++;
                        }
                    }
                    if (cantidadInvestigadoresCategorizados < 4) {
                        throw new Exception("El proyecto debe tener al menos 4 investigadores categorizados");
                    }
                }
            case 3:
            case 2:

                for (int i = 4; i < 0; i--) {
                    if (proyectoWeb.getPalabrasClaves().get(i).isEmpty()) {
                        proyectoWeb.getPalabrasClaves().remove(i);
                    }//fin if
                }//fin for

                for (int i = 4; i < 0; i--) {
                    if (proyectoWeb.getKeywords().get(i).isEmpty()) {
                        proyectoWeb.getKeywords().remove(i);
                    }//fin if
                }//fin for

            case 1: //PROYECTO I
                //PROYECTO I

                if (proyectoWeb.getTitulo().isEmpty()) {
                    throw new Exception("Debe ingresar el nombre del proyecto");
                }//fin if

                //que no exista un proyecto con el mismo nombre
                if (this.proyectoWebFacadeLocal.findProyectoWebByTitulo(proyectoWeb.getTitulo(), proyectoWeb.getId())) {
                    throw new Exception("Ya existe un proyecto con el nombre ingresado");
                }//fin if

                if (proyectoWeb.getFechaInicio().compareTo(proyectoWeb.getFechaFinalizacion()) > 0) {
                    throw new Exception("La fecha inical debe ser menor a la fecha de finalización");
                }//fin if

                //la fecha inicial y finalal deben tener una diferencia de 2 o 4 años
                if (difDia1 != 2 && difDia1 != 4) {
                    throw new Exception("EL proyecto debe tener una duración de 2 o 4 años. Verifique las fechas");
                }//fin if

                if (difDia1 == 2) {
                    try {
                        if (proyectoWeb.getPresupuestoWeb().getBienConsumo() != null) {

                            if (proyectoWeb.getPresupuestoWeb().getBienConsumo().size() > 2) {
                                throw new Exception("Una vez que a empezado a completar el presupuesto no puede modificar la fecha para un proyecto de 2 años");
                            }
                        }
                    } catch (Exception e) {
                    }

                    /* proyectoWeb.getPresupuestoWeb().getBienConsumo().remove(3);
                     proyectoWeb.getPresupuestoWeb().getBienConsumo().remove(2);
                            
                     proyectoWeb.getPresupuestoWeb().getBienNoPersonal().remove(3);
                     proyectoWeb.getPresupuestoWeb().getBienNoPersonal().remove(2);
                            
                     proyectoWeb.getPresupuestoWeb().getBienUso().remove(3);
                     proyectoWeb.getPresupuestoWeb().getBienUso().remove(2);
                            
                     proyectoWeb.getPresupuestoWeb().getGastosViaje().remove(3);
                     proyectoWeb.getPresupuestoWeb().getGastosViaje().remove(2);
                            
                     }//fin if
                     }//fin if  */
                }//fin if

                if (proyectoWeb.getCodigo() == null) {
                    Calendar cal = Calendar.getInstance();
                    cal.setTime(new Date());
                    int hora = cal.get(Calendar.HOUR_OF_DAY);
                    int minuto = cal.get(Calendar.MINUTE);
                    int segundo = cal.get(Calendar.SECOND);

                    int suma = hora + minuto + segundo;

                    //EL CODIGO ES CON LA UNIVERSIDAD Y EL DNI DEL INVESTIGADOR
                    /*System.out.println("Universidad: " + proyectoWeb.getParticipacionesWeb().get(0).getInvestigador().getUniversidad().getDescripcion());
                    
                     if(proyectoWeb.getParticipacionesWeb().get(0).getInvestigador().getUniversidad()== null){
                     proyectoWeb.setCodigo("SD");
                     }else{
                     if(proyectoWeb.getParticipacionesWeb().get(0).getInvestigador().getUniversidad().getDescripcion().isEmpty()){
                     proyectoWeb.setCodigo("SD");
                     }//fin if
                        
                     proyectoWeb.setCodigo(proyectoWeb.getParticipacionesWeb().get(0).getInvestigador().getUniversidad().getDescripcion());
                     }//fin if-else*/
                    proyectoWeb.setCodigo(proyectoWeb.getConvocatoria().getId() + "-"
                            + cal.get(Calendar.DATE) + cal.get(Calendar.MARCH) + cal.get(Calendar.YEAR)
                            + "-" + suma);

                    if (this.proyectoWebFacadeLocal.findProyectoWebByCodigo(proyectoWeb.getCodigo())) {
                        throw new Exception("Cambie el código de identificación. Ya existe un proyecto con el código ingresado");
                    }//fin if
                }//fin if

                if (proyectoWeb.getParticipacionesWeb().get(0).getInvestigador() == null) {
                    throw new Exception("Debe seleccionar el director del proyecto");
                }//fin if

                if (proyectoWeb.getParticipacionesWeb().get(1).getInvestigador() == null) {
                    throw new Exception("Debe seleccionar el co-director del proyecto");
                }//fin if

                /*  if (proyectoWeb.getParticipacionesWeb().get(1).getInvestigador() == null) {
                 throw new Exception("Debe seleccionar el codirector del proyecto");
                 }//fin if
                 //puede haber proyectos sin codirector


                 if (proyectoWeb.getParticipacionesWeb().get(0).getInvestigador().equals(
                 proyectoWeb.getParticipacionesWeb().get(1).getInvestigador())) {
                 throw new Exception("El director y el codirector no puede se el mismo");
                 }*/
                break;

        }
    }//fin if

    private void validar(ProyectoWeb proyectoWeb) throws Exception {

        //PROYECTO V
        System.out.println("this proyecto: " + proyectoWeb);
        System.out.println("this proyecto p: " + proyectoWeb.getPresupuestoWeb());
        //plan de ejecucion tiene que tener dos o cuatro años
        if (proyectoWeb.getPresupuestoWeb() != null) {
            if (!proyectoWeb.getPresupuestoWeb().getBienConsumo().isEmpty()) {

                int cantElementos = proyectoWeb.getPresupuestoWeb().getBienConsumo().size();

                if (cantElementos != 2 && cantElementos != 4) {
                    throw new Exception("No completo todos los años del plan de ejecución financiera");
                }//fin if
            }//fin if
        }//fin if

    }//fin validar

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Override
    public List<ProyectoWeb> findProyectoWebByDirector(Long idInvestigador) throws Exception {
        return this.proyectoWebFacadeLocal.findProyectoWebByDirector(idInvestigador);
    }

    @Override
    public Long findIdProyectoWebByCodigo(String codigo) throws Exception {
        return this.proyectoWebFacadeLocal.findIdProyectoWebByCodigo(codigo);
    }

    @Override
    public List<ProyectoWeb> findProyectoWebByDirectorYConvocatoria(Long idInvestigador, Long idConvocatoria) throws Exception {
        return this.proyectoWebFacadeLocal.findProyectoWebByDirectorYConvocatoria(idInvestigador, idConvocatoria);
    }

    @Override
    public List<ProyectoWeb> findAll() throws Exception {
        return this.proyectoWebFacadeLocal.findAll();
    }
}
