package business.funds;

import java.sql.SQLException;
import java.util.GregorianCalendar;
import persistence.fundos.DoadorDAO;

public class Donativo {
    private static DoadorDAO doadorDAO = new DoadorDAO();

    private int idDon;
    private String descricao;
    private int quantInicial, quantAtual, idTipoDon;
    private GregorianCalendar dataDon;
    private int idFunc, idEv, idIndiv;
/**
 * Construtor Vazio
 */
    public Donativo() {
        dataDon = new GregorianCalendar();
        idDon = -1;
    }
    /**
     * Construtor Parametrizado
     * @param idDon Identificador da doação
     * @param descricao Descrição
     * @param quantInicial Quantidade Inicial
     * @param quantAtual Quantidade Actual
     * @param idTipoDon Identificador de Tipo de Donativo
     * @param dataDon Data de Donativo
     * @param idFunc Identificador de Funcionário
     * @param idEv Identificador de Evento
     * @param idIndiv Identificador de Indivíduo
     */
    public Donativo(int idDon, String descricao, int quantInicial, int quantAtual, int idTipoDon, GregorianCalendar dataDon, int idFunc, int idEv, int idIndiv) {
        this.idDon = idDon;
        this.descricao = descricao;
        this.quantInicial = quantInicial;
        this.quantAtual = quantAtual;
        this.idTipoDon = idTipoDon;
        this.dataDon = dataDon;
        this.idFunc = idFunc;
        this.idEv = idEv;
        this.idIndiv = idIndiv;
    }
    /**
     * Construtor de Cópia
     * @param d Donativo a ser copiado
     */
    public Donativo(Donativo d){
        this.idDon = d.getIdDon();
        this.descricao = d.getDescricao();
        this.quantInicial = d.getQuantInicial();
        this.quantAtual = d.getQuantAtual();
        this.idTipoDon = d.getIdTipoDon();
        this.dataDon = d.getDataDon();
        this.idFunc = d.getIdFunc();
        this.idEv = d.getIdEv();
        this.idIndiv = d.getIdIndiv();
    }
/**
 * 
 * @return Data do Donativo 
 */
    public GregorianCalendar getDataDon() {
        return dataDon;
    }
/**
 * 
 * @return Descrição do Donativo
 */
    public String getDescricao() {
        return descricao;
    }
/**
 * 
 * @return Identificador do Donativo
 */
    public int getIdDon() {
        return idDon;
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
 * @return Identificador do Funcionário
 */
    public int getIdFunc() {
        return idFunc;
    }
/**
 * 
 * @return Identificador do Indivíduo
 */
    public int getIdIndiv() {
        return idIndiv;
    }
/**
 * 
 * @return Identificador do Tipo de Donativo
 */
    public int getIdTipoDon() {
        return idTipoDon;
    }
/**
 * 
 * @return Quantidade Atual
 */
    public int getQuantAtual() {
        return quantAtual;
    }
/**
 * 
 * @return Quantidade Inicial
 */
    public int getQuantInicial() {
        return quantInicial;
    }
/**
 * Modifica a data de Donativo
 * @param dataDon Nova data de Donativo
 */
    public void setDataDon(GregorianCalendar dataDon) {
        this.dataDon = dataDon;
    }
/**
 * Modifica a descrição do Donativo
 * @param descricao Nova Descrição do Donativo
 */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
/**
 * Modifica o ID do Donativo
 * @param idDon Novo ID do Donativo
 */
    public void setIdDon(int idDon) {
        this.idDon = idDon;
    }
    /**
     * @return Doador que fez este donativo.
     * @throws SQLException 
     */
     public Doador getDoador() throws SQLException{
        return doadorDAO.getById(idIndiv);
    }
    
/**
 * Modifica o Identificador do Evento
 * @param idEv Novo Identificador do Evento
 */
    public void setIdEv(int idEv) {
        this.idEv = idEv;
    }
/**
 * Modifica o Identificador de Funcionário Receptor
 * @param idFunc Novo Identificador de Funcionário
 */
    public void setIdFunc(int idFunc) {
        this.idFunc = idFunc;
    }
/**
 * Modifica o Identificador de Indivíduo
 * @param idIndiv Novo Identificador
 */
    public void setIdIndiv(int idIndiv) {
        this.idIndiv = idIndiv;
    }
/**
 * Modifica o ID de Tipo de Donativo
 * @param idTipoDon Novo ID de Tipo de Donativo
 */
    public void setIdTipoDon(int idTipoDon) {
        this.idTipoDon = idTipoDon;
    }
/**
 * Modifica a Quantidade Atual
 * @param quantAtual Nova quantidade atual
 */
    public void setQuantAtual(int quantAtual) {
        this.quantAtual = quantAtual;
    }
/**
 * Modifica a Quantidade Inicial
 * @param quantInicial Nova Quantidade Inicial
 */
    public void setQuantInicial(int quantInicial) {
        this.quantInicial = quantInicial;
    }
/**
 * 
 * @return Cópia da Instância actual
 */    
    @Override
    public Donativo clone() {
        return new Donativo(this);
    }
/**
 * 
 * @return Representação textual do Donativo utilizando o ID, Descrição e Quantidade Inicial
 */    
    @Override
    public String toString(){
        return this.idDon+"."+this.descricao+"."+this.quantInicial;
    }
}