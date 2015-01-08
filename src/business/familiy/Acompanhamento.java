/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package business.familiy;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

public class Acompanhamento 
{
    private int id;
    private int idFunc, idFam;
    private String descricao;
    private GregorianCalendar data;
    /*relatorio*/

    public Acompanhamento() {
        data = new GregorianCalendar();
    }

    public Acompanhamento(int id, int idFunc,int idFam, String descricao, GregorianCalendar data) {
        this.id = id;
        this.idFunc = idFunc;
        this.idFam = idFam;
        this.descricao = descricao;
        this.data = data;
    }

    public Acompanhamento(Acompanhamento a) {
        descricao = a.getDescricao();
        data = a.getData();
        this.id = a.getId();
        this.idFunc = a.getIdFunc();
        /*relatorio*/
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getDescricao() {
        return descricao;
    }

    public void setData(GregorianCalendar data) {
        this.data = data;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public Acompanhamento clone()
    {
        return new Acompanhamento(this);
    }
        
    public String toString(){
        // nao testado
        return new String(this.descricao+"."+this.data.getDisplayName(Calendar.DATE, Calendar.LONG, Locale.ENGLISH));
    }
}
