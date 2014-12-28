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
public class TipoTarefa {
        private int id;
    private String descricao;

    public TipoTarefa() {
    }

    public TipoTarefa(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getId() {
        return id;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setId(int id) {
        this.id = id;
    }


}
