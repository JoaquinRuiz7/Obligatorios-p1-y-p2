package obligatorio2;

import java.util.*;

public class Sistema {
    private  ArrayList<Actividad> actividades = new ArrayList<Actividad>();
    private  ArrayList<Inspector> inspectores = new ArrayList<Inspector>();
    private  ArrayList<Encargado> encargados = new ArrayList<Encargado>();
    private  ArrayList<Inspeccion> inspecciones = new ArrayList<Inspeccion>();
  

    
    public Sistema() {
        actividades = new ArrayList<Actividad>();
        inspectores = new ArrayList<Inspector>();
        encargados = new ArrayList<Encargado>();
        inspecciones = new ArrayList<Inspeccion>();
       
        
        
    }

    public void setActividades(ArrayList<Actividad> actividades) {
        this.actividades = actividades;
    }

    public void setInspectores(ArrayList<Inspector> inspectores) {
        this.inspectores = inspectores;
    }

    public void setEncargados(ArrayList<Encargado> encargados) {
        this.encargados = encargados;
    }

    public void setInspecciones(ArrayList<Inspeccion> inspecciones) {
        this.inspecciones = inspecciones;
    }

   

    public  ArrayList<Actividad> getActividades() {
        return actividades;
    }

    public  ArrayList<Inspector> getInspectores() {
        return inspectores;
    }

    public  ArrayList<Encargado> getEncargados() {
        return encargados;
    }

    public  ArrayList<Inspeccion> getInspecciones() {
        return inspecciones;
    }

    
}

   