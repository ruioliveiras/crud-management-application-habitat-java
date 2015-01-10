package business.funds;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import persistence.fundos.EquipaDAO;

public class Equipa implements Voluntariado {
    private int idEq;
    private String nacionalidadeEq, designacao;
    private GregorianCalendar dataCriaEq;
    private int idFunc;

    /**
     * Construtor Vazio
     */
    public Equipa() {
        dataCriaEq = new GregorianCalendar();
    }
    /**
     * Construtor Parametrizado
     * @param idEq Identificador da Equipa 
     * @param nacionalidadeEq Nacionalidade da Equipa
     * @param designacao Designação da Equipa
     * @param dataCriaEq Data de Criação da Equipa
     * @param idFunc Identificador do Funcionário Responsável
     */
    public Equipa(int idEq, String nacionalidadeEq, String designacao, GregorianCalendar dataCriaEq, int idFunc) {
        this.idEq = idEq;
        this.nacionalidadeEq = nacionalidadeEq;
        this.designacao = designacao;
        this.dataCriaEq = dataCriaEq;
        this.idFunc = idFunc;
    }
    
    /**
     * Construtor de Cópia
     * @param e Equipa a ser Copiada
     */
    public Equipa(Equipa e) {
        this.idEq = e.getIdEq();
        this.nacionalidadeEq = e.getNacionalidadeEq();
        this.designacao = e.getDesignacao();
        this.dataCriaEq = e.getDataCriaEq();
        this.idFunc = e.getIdFunc();
    }
    /**
     * 
     * @return Lista com todos os membros da equipa
     * @throws SQLException Caso hajam problemas de ligação à Base de Dados
     */
    public ArrayList<Voluntario> getMembros() throws SQLException {
        EquipaDAO ed = new EquipaDAO();
        return ed.getMembros(this.idEq);
    }
/**
 * 
 * @return Data de Criação da Equipa
 */
    public GregorianCalendar getDataCriaEq() {
        return dataCriaEq;
    }
/**
 * 
 * @return Designação da Equipa
 */
    public String getDesignacao() {
        return designacao;
    }
/**
 * 
 * @return Identificador da Equipa
 */
    public int getIdEq() {
        return idEq;
    }
/**
 * 
 * @return Identificador do Funcionário Responsável
 */
    public int getIdFunc() {
        return idFunc;
    }
/**
 * 
 * @return Nacionalidade da Equipa
 */
    public String getNacionalidadeEq() {
        return nacionalidadeEq;
    }
/**
 * Modifica a data de Criação da Equipa
 * @param dataCriaEq Nova data de Criação da Equipa
 */
    public void setDataCriaEq(GregorianCalendar dataCriaEq) {
        this.dataCriaEq = dataCriaEq;
    }
/**
 * Modifica a designação da Equipa
 * @param designacao Nova designação
 */
    public void setDesignacao(String designacao) {
        this.designacao = designacao;
    }
/**
 * Modifica o Identificador de Equipa
 * @param idEq Novo Identificador de Equipa
 */
    public void setIdEq(int idEq) {
        this.idEq = idEq;
    }
/**
 * Modifica o Identificador de Funcionário
 * @param idFunc 
 */
    public void setIdFunc(int idFunc) {
        this.idFunc = idFunc;
    }
/**
 * Modifica a Nacionalidade da Equipa
 * @param nacionalidadeEq Nova Nacionalidade da Equipa
 */
    public void setNacionalidadeEq(String nacionalidadeEq) {
        this.nacionalidadeEq = nacionalidadeEq;
    }
/**
 * 
 * @return Cópia da Instância Actual
 */    
    public Equipa clone(){
        return new Equipa(this);
    }
    /**
     * 
     * @return Representação textual da Equipa usando o Identificador, Nacionalidade e Designação
     */
    public String toString(){
        return new String(this.idEq+"."+this.nacionalidadeEq+"."+this.designacao);
    }
}