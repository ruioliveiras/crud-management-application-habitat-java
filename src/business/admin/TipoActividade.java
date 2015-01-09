/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.admin;

/**
 * Classe que representa o tipo de Actividade 
 * @author ruioliveiras
 */
public class TipoActividade {
        private int id = -1;
    private String descricao;
/**
 * Construtor Vazio
 */
    public TipoActividade() {
    }
/**
 * Construtor Parametrizado
 * @param id Código de Identificação do Tipo de Actividade
 * @param descricao Descrição do Tipo de Actividade
 */
    public TipoActividade(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }
/**
 * Retorna a Descrição do tipo de Actividade
 * @return Descrição
 */
    public String getDescricao() {
        return descricao;
    }
/**
 * Retorna o Código de Identificação
 * @return Identificador
 */
    public int getId() {
        return id;
    }
/**
 * Modifica a descrição do Tipo de Actividade
 * @param descricao Nova descrição
 */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
/**
 * Modifica o Identificador do Tipo de Actividade
 * @param id Novo Identificador
 */
    public void setId(int id) {
        this.id = id;
    }

/**
 * Retorna a representação textual do Tipo de Actividade utilizando o Identificador e a Descrição
 * @return Representação Textual do Tipo de Actividade
 */
    @Override
    public String toString(){
        return new String(this.id+"."+this.descricao);
    }
}
