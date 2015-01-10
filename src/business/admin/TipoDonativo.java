/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.admin;

/**
 * Classe representativa do Tipo de Donativo
 * @author ruioliveiras
 */
public class TipoDonativo {
    private int id;
    private String descricao;
    private String unidade;
    /**
     * Construtor Vazio
     */
    public TipoDonativo() {
    }
/**
 * Construtor Parametrizado
 * @param id Código identificativo do Tipo de Donativo
 * @param descricao Descrição do Tipo de Donativo 
 * @param unidade Representa a unidade que se mede o donativo(P.E.:"Kg")
 */
    public TipoDonativo(int id, String descricao, String unidade) {
        this.id = id;
        this.descricao = descricao;
        this.unidade = unidade;
    }

    
/**
 * Retorna a Descrição do Tipo de Donativo
 * @return Descrição
 */
    public String getDescricao() {
        return descricao;
    }
/**
 * Retorna o Código de Identificação do Tipo de Donativo
 * @return Identificador
 */
    public int getId() {
        return id;
    }
/**
 * Retorna a Unidade de Medida utilizada na doação
 * @return Unidade
 */
    public String getUnidade() {
        return unidade;
    }
    /**
     * Modifica a descrição do tipo de Donativo
     * @param descricao Nova descrição do tipo de Donativo
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
/**
 * Modifica o Identificador do tipo de Donativo
 * @param id Novo Identificador do Tipo de Donativo 
 */
    public void setId(int id) {
        this.id = id;
    }
/**
 * Modifica a unidade de Medida no Tipo de Donativo
 * @param unidade Nova Unidade De Medida
 */
    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof TipoDonativo){
            return this.getId() == ((TipoDonativo) obj).getId();
        }
        return false;
    }
    
    
    
/**
 * Retorna a Representação textual do Tipo de Donativo utilizando o Identificador, Descrição e Unidade de Medida
 * @return Representação textual do Tipo de Donativo
 */
    @Override
    public String toString(){
        return new String(this.id+"."+this.descricao+"."+this.unidade);
    }

}
