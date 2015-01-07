/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.building;

import business.funds.Voluntariado;
import java.util.GregorianCalendar;

/**
 *
 * @author ruioliveiras
 */
public class VoluntariadoRealizado{
    private Voluntariado voluntariado;
    private GregorianCalendar data;
    private int durationMinutos;

    public VoluntariadoRealizado() {
    }

    public VoluntariadoRealizado(Voluntariado voluntariado, GregorianCalendar data, int durationMinutos) {
        this.voluntariado = voluntariado;
        this.data = data;
        this.durationMinutos = durationMinutos;
    }
    
    /**
     * @return the voluntariado
     */
    public Voluntariado getVoluntariado() {
        return voluntariado;
    }

    /**
     * @param voluntariado the voluntariado to set
     */
    public void setVoluntariado(Voluntariado voluntariado) {
        this.voluntariado = voluntariado;
    }

    /**
     * @return the data
     */
    public GregorianCalendar getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(GregorianCalendar data) {
        this.data = data;
    }

    /**
     * @return the durationMinutos
     */
    public int getDurationMinutos() {
        return durationMinutos;
    }

    /**
     * @param durationMinutos the durationMinutos to set
     */
    public void setDurationMinutos(int durationMinutos) {
        this.durationMinutos = durationMinutos;
    }

    @Override
    public String toString(){
        return new String(this.voluntariado.toString()+"."+this.durationMinutos);
    }
}
