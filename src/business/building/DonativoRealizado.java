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
/**
 * Construtor Vazio
 */
    public DonativoRealizado() {
    }
/**
 * Construtor Parametrizado
 * @param donativo Donativo Realizado
 * @param data Data de realização
 * @param quantidade Quantidade doada
 */
    public DonativoRealizado(Donativo donativo, GregorianCalendar data, int quantidade) {
        this.donativo = donativo;
        this.data = data;
        this.quantidade = quantidade;
    }

    
    /**
     * @return Donativo
     */
    public Donativo getDonativo() {
        return donativo;
    }

    /**
     * Modifica o Donativo
     * @param donativo Novo donativo 
     */
    public void setDonativo(Donativo donativo) {
        this.donativo = donativo;
    }

    /**
     * @return Data de realização
     */
    public GregorianCalendar getData() {
        return data;
    }

    /**
     * @param data Nova data de Realização
     */
    public void setData(GregorianCalendar data) {
        this.data = data;
    }

    /**
     * @return Quantidade do Donativo
     */
    public int getQuantidade() {
        return quantidade;
    }

    /**
     * @param quantidade Nova Quantidade do Donativo
     */
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
/**
 * Representação textual do Objecto usando o Donativo e a sua Quantidade
 * @return Representação textual do Objecto
 */
    @Override
    public String toString(){
        return new String(this.donativo.toString()+"."+this.quantidade);
    }
    
    
}
