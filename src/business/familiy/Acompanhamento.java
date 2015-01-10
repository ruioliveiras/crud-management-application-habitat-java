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
/**
 * Construtor Vazio
 */
    public Acompanhamento() {
        data = new GregorianCalendar();
    }
/**
 * Construtor Parametrizado
 * @param id Identificador do Acompanhamento 
 * @param idFunc Identificador do funcionário responsável pelo acompanhamento
 * @param idFam Identificador da família acompanhada
 * @param descricao Descrição do Acompanhamento à família
 * @param data Data do acompanhamento 
 */
    public Acompanhamento(int id, int idFunc,int idFam, String descricao, GregorianCalendar data) {
        this.id = id;
        this.idFunc = idFunc;
        this.idFam = idFam;
        this.descricao = descricao;
        this.data = data;
    }
/**
 * Construtor de cópia
 * @param a Acompanhamento a ser copiado
 */
    public Acompanhamento(Acompanhamento a) {
        descricao = a.getDescricao();
        data = a.getData();
        this.id = a.getId();
        this.idFunc = a.getIdFunc();
        /*relatorio*/
    }
/**
 * Retorna o Identificador do acompanhamento
 * @return Identificador do Acompanhamento
 */
    public int getId() {
        return id;
    }
/**
 * Modifica o Identificador do acompanhamento
 * @param id Novo Identificador do Acompanhamento
 */
    public void setId(int id) {
        this.id = id;
    }
/**
 * Retorna o Identificador do Funcionário responsável
 * @return Identificador do Funcionário
 */
    public int getIdFunc() {
        return idFunc;
    }
/**
 * Modifica o Identificador do Funcionário Responsável
 * @param idFunc Novo Identificador do Funcionário
 */
    public void setIdFunc(int idFunc) {
        this.idFunc = idFunc;
    }
/**
 * Retorna o Identificador da Família Acompanhada
 * @return Identificador da Família
 */
    public int getIdFam() {
        return idFam;
    }
/**
 * Modifica o Identificador da Família Acompanhada
 * @param idFam Novo Identificador da Família
 */
    public void setIdFam(int idFam) {
        this.idFam = idFam;
    }

    /**
     * Retorna a data do Acompanhamento 
     * @return Data de Acompanhamento
     */
    public GregorianCalendar getData() {
        return data;
    }
/**
 * Retorna a descrição do Acompanhamento
 * @return Descrição do Acompanhamento
 */
    public String getDescricao() {
        return descricao;
    }
/**
 * Modifica a data de Realização do Acompanhamento
 * @param data Nova data de Realização
 */
    public void setData(GregorianCalendar data) {
        this.data = data;
    }
/**
 * Modifica a descrição do Acompanhamento
 * @param descricao Nova descrição
 */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
/**
 * Retorna uma cópia da instância actual
 * @return Cópia da Instância actual
 */    
    public Acompanhamento clone()
    {
        return new Acompanhamento(this);
    }
/**
 * Retorna a representação textual do Objeto usando a descrição e data de realização
 * @return Representação do Acompanhamento
 */        
    public String toString(){
        // nao testado
        return new String(this.descricao+"."+this.data.getDisplayName(Calendar.DATE, Calendar.LONG, Locale.ENGLISH));
    }
}
