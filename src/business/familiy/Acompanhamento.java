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
    private String descricao;
    private GregorianCalendar data;
    /*relatorio*/

    public Acompanhamento(String descricao, GregorianCalendar data) {
        this.descricao = descricao;
        this.data = data;
        /*relatorio*/
    }

    public Acompanhamento(Acompanhamento a) {
        descricao = a.getDescricao();
        data = a.getData();
        /*relatorio*/
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
