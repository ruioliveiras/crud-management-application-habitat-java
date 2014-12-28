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
public class TipoDonativo {
    private int id;
    private String descricao;
    private String unidade;
    
    public TipoDonativo() {
    }

    public TipoDonativo(int id, String descricao, String unidade) {
        this.id = id;
        this.descricao = descricao;
        this.unidade = unidade;
    }

    

    public String getDescricao() {
        return descricao;
    }

    public int getId() {
        return id;
    }

    public String getUnidade() {
        return unidade;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }


}
