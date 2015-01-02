/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.building;

import business.funds.Donativo;
import java.util.GregorianCalendar;

/**
 *
 * @author ruioliveiras
 */
public class DonativoRealizado{
    private Donativo donativo;
    private GregorianCalendar data;
    private int quantidade;

    public DonativoRealizado() {
    }

    public DonativoRealizado(Donativo donativo, GregorianCalendar data, int quantidade) {
        this.donativo = donativo;
        this.data = data;
        this.quantidade = quantidade;
    }

    
    /**
     * @return the donativo
     */
    public Donativo getDonativo() {
        return donativo;
    }

    /**
     * @param donativo the donativo to set
     */
    public void setDonativo(Donativo donativo) {
        this.donativo = donativo;
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
     * @return the quantidade
     */
    public int getQuantidade() {
        return quantidade;
    }

    /**
     * @param quantidade the quantidade to set
     */
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    
    
    
}
