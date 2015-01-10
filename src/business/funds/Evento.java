package business.funds;

import java.util.GregorianCalendar;

public class Evento{
    private int idEv;
    private String designacao;
    private GregorianCalendar data;
    private int idFunc;
    private String descricao;
/**
 * Construtor Vazio
 */
    public Evento() {
        data = new GregorianCalendar();
    }    /**
     * Construtor Parametrizado
     * @param idEv Identificador do Evento
     * @param designacao Designação do Evento
     * @param data Data de Realização do Evento
     * @param idFunc Identificador do Funcionário Criador
     * @param descricao Descrição do Evento
     */
    public Evento(int idEv, String designacao, GregorianCalendar data, int idFunc, String descricao) {
        this.idEv = idEv;
        this.designacao = designacao;
        this.data = data;
        this.idFunc = idFunc;
        this.descricao = descricao;
    }
    /**
     * Construtor de Cópia 
     * @param e Evento a ser Copiado
     */
    public Evento(Evento e) {
        this.idEv = e.getIdEv();
        this.designacao = e.getDesignacao();
        this.data = e.getData();
        this.idFunc = e.getIdFunc();
        this.descricao = e.getDescricao();
    }    
/**
 * 
 * @return Data de realização
 */
    public GregorianCalendar getData() {
        return data;
    }
/**
 * 
 * @return Descrição do Evento
 */
    public String getDescricao() {
        return descricao;
    }
/**
 * 
 * @return Designação do Evento
 */
    public String getDesignacao() {
        return designacao;
    }
/**
 * 
 * @return Identificador do Evento
 */
    public int getIdEv() {
        return idEv;
    }
/**
 * 
 * @return Identificador do Funcionário Criador
 */
    public int getIdFunc() {
        return idFunc;
    }
/**
 * Modifica a data de Realização do Evento
 * @param data Nova data de Realização do Evento
 */
    public void setData(GregorianCalendar data) {
        this.data = data;
    }
/**
 * Modifica a Descrição do Evento
 * @param descricao Nova Descrição do Evento
 */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
/**
 * Modifica a Designação do Evento
 * @param designacao Nova Designação
 */
    public void setDesignacao(String designacao) {
        this.designacao = designacao;
    }
/**
 * Modifica o Identificador do Evento
 * @param idEv Novo Identificador do Evento
 */
    public void setIdEv(int idEv) {
        this.idEv = idEv;
    }
/**
 * Modifica o Identificador de Funcionário Criador
 * @param idFunc Novo Identificador de Funcionário
 */
    public void setIdFunc(int idFunc) {
        this.idFunc = idFunc;
    }
    /**
     * 
     * @return Objecto como Cópia da instância actual
     */
    public Evento clone() {
        return new Evento(this);
    }
    /**
     * 
     * @return Representação textual do Evento utilizando o Identificador, Designação e Descrição.
     */
    public String toString(){
        return new String(this.idEv+"."+this.designacao+"."+this.descricao);
    }
}