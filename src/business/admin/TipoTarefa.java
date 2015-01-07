/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.admin;

import java.util.Objects;

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

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof TipoTarefa)) return false;
        TipoTarefa t = (TipoTarefa) obj;
        if (t.getId() == this.getId()){
            return true;
        }else if (t.getDescricao().equals(this.getDescricao())){
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.id;
        hash = 89 * hash + Objects.hashCode(this.descricao);
        return hash;
    }

    @Override
    public String toString(){
        return new String(this.id+"."+this.descricao);
    }
}
