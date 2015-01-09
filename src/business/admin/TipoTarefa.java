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
/**
 * Construtor Vazio
 */
    public TipoTarefa() {
    }
/**
 * Construtor Parametrizado
 * @param id Código identificativo
 * @param descricao Descrição
 */
    public TipoTarefa(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }
/**
 * Retorna a Descrição
 * @return Descrição
 */
    public String getDescricao() {
        return descricao;
    }
/**
 * Retorna o Código Identificativo 
 * @return ID
 */
    public int getId() {
        return id;
    }
/**
 * Modifica a Descrição 
 * @param descricao Nova Descrição
 */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
/**
 * Modifica o Código Identificativo
 * @param id Novo Código
 */
    public void setId(int id) {
        this.id = id;
    }
/**
 * Método de verificação de igualdade semântica entre dois objectos
 * @param obj Objecto que será comparado a this
 * @return True se this e obj forem semanticamente iguais <p> Caso Contrário False
 */
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
/**
 * 
 * @return Código Hash
 */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.id;
        hash = 89 * hash + Objects.hashCode(this.descricao);
        return hash;
    }
/**
 * Retorna a Representação textual do objecto
 * @return Representação textual
 */
    @Override
    public String toString(){
        return new String(this.id+"."+this.descricao);
    }
}
