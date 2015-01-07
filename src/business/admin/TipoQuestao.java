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
    
    public TipoQuestao() {
    }

    public TipoQuestao(int id, String descricao, boolean uso) {
        this.id = id;
        this.descricao = descricao;
        this.uso = uso;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getId() {
        return id;
    }

    public boolean isAtiva() {
        return uso;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAtiva(boolean uso) {
        this.uso = uso;
    }
    
    @Override
    public String toString(){
        return this.id+"."+this.descricao;
    }
}
