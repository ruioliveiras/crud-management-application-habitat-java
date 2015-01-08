/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package business.familiy;

import java.util.GregorianCalendar;

/**
 *
 * @author Jose
 */
public class Prestacao 
{
    private int valor, idFunc, idFam, id;
    private GregorianCalendar data;

    public Prestacao() {
    }

    public Prestacao(int id, int valor, int idFunc, int idFam, GregorianCalendar data) {
        this.id = id;
        this.valor = valor;
        this.idFunc = idFunc;
        this.idFam = idFam;
        this.data = data;
    }
    
    public Prestacao(Prestacao p) {
        this.id = p.getId();
        this.valor = p.getValor();
        this.idFunc = p.getIdFunc();
        this.idFam = p.getIdFam();
        this.data = p.getData();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getIdFunc() {
        return idFunc;
    }

    public void setIdFunc(int idFunc) {
        this.idFunc = idFunc;
    }

    public int getIdFam() {
        return idFam;
    }

    public void setIdFam(int idFam) {
        this.idFam = idFam;
    }

    public GregorianCalendar getData() {
        return data;
    }

    public void setData(GregorianCalendar data) {
        this.data = data;
    }
    
    public Prestacao clone()
    {
        return new Prestacao(this);
    }
    
    public String toString(){
        return new String(this.idFam+"."+this.valor+"."+this.idFunc);
    }
}
