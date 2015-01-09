/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.admin;

/**
 * 
 * @author ruioliveiras
 */
public class TipoQuestao {
    private int id;
    private String descricao;
    private boolean uso;
    /**
     * Construtor Vazio
     */
    public TipoQuestao() {
    }
    /**
     * Construtor Parametrizado
     * @param id Código identificativo
     * @param descricao Descrição do Tipo de Questão 
     * @param uso Se a questão é apresentada ou não nas candidaturas 
     */
    public TipoQuestao(int id, String descricao, boolean uso) {
        this.id = id;
        this.descricao = descricao;
        this.uso = uso;
    }
/**
 * Retorna a Descrição do Tipo de Questão
 * @return Descrição
 */
    public String getDescricao() {
        return descricao;
    }
/**
 * Retorna o Identificador do Tipo de Questão
 * @return Identificador
 */
    public int getId() {
        return id;
    }
/**
 * Retorna a Utilização da Questão
 * @return Utilização da Questão
 */
    public boolean isAtiva() {
        return uso;
    }
/**
 * Modifica a Descrição da Questão
 * @param descricao Nova Descrição
 */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
/**
 * Modifica o Identificador
 * @param id Novo Identificador
 */
    public void setId(int id) {
        this.id = id;
    }
/**
 * Modifica o estado de utilização
 * @param uso Novo estado de Utilização
 */
    public void setAtiva(boolean uso) {
        this.uso = uso;
    }
    /**
     * Retorna a representação textual usando o Identificador e a descrição
     * @return Representação textual
     */
    @Override
    public String toString(){
        return this.id+"."+this.descricao;
    }
}
