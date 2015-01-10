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
    private int idFunc, idFam, id;
    private double valor;
    private GregorianCalendar data;
/**
 * Construtor Vazio
 */
    public Prestacao() {
        this.valor = 0;
        this.data = new GregorianCalendar();
    }
/**
 * Construtor Parametrizado
 * @param id Identificador da Prestação 
 * @param valor Valor a pagar por mês
 * @param idFunc Identificador do Funcionário Responsável
 * @param idFam Identificador da Família 
 * @param data Data da Prestação
 */
    public Prestacao(int id, double valor, int idFunc, int idFam, GregorianCalendar data) {
        this.id = id;
        this.valor = valor;
        this.idFunc = idFunc;
        this.idFam = idFam;
        this.data = data;
    }
/**
 * Construtor de cópia
 * @param p Prestação a ser copiada
 */    
    public Prestacao(Prestacao p) {
        this.id = p.getId();
        this.valor = p.getValor();
        this.idFunc = p.getIdFunc();
        this.idFam = p.getIdFam();
        this.data = p.getData();
    }
/**
 * Retorna o Identificador da Prestação 
 * @return Identificador da Prestação
 */
    public int getId() {
        return id;
    }
/**
 * Modifica o Identificador da Prestação
 * @param id Novo Identificador de Prestação
 */
    public void setId(int id) {
        this.id = id;
    }
/**
 * Retorna o Valor da prestação paga
 * @return Valor
 */    
    public double getValor() {
        return valor;
    }
/**
 * Modifica o Valor da prestação 
 * @param valor Novo valor da prestação
 */
    public void setValor(double valor) {
        this.valor = valor;
    }
/**
 * Retorna o identificador do Funcionário
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
 * Retorna o identificador da Família
 * @return Identificador da Família
 */
    public int getIdFam() {
        return idFam;
    }
/**
 * Modifica o Identificador da Família
 * @param idFam Novo Identificador da Família
 */
    public void setIdFam(int idFam) {
        this.idFam = idFam;
    }
/**
 * Retorna a data da prestação
 * @return Data
 */
    public GregorianCalendar getData() {
        return data;
    }
/**
 * Modifica a data da prestação
 * @param data Nova data
 */
    public void setData(GregorianCalendar data) {
        this.data = data;
    }
/**
 * Retorna um objecto como cópia da instância actual
 * @return Cópia da Instância actual
 */    
    public Prestacao clone()
    {
        return new Prestacao(this);
    }
/**
 * Retorna a representação textual da Prestação usando o ID da Família, Valor da prestação e ID do funcionário
 * @return Representação textual da Prestação 
 */    
    public String toString(){
        return new String(this.idFam+" - "+this.valor+" - "+this.idFunc);
    }
}
