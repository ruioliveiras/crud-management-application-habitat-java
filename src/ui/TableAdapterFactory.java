/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import business.admin.TipoTarefa;

/**
 *
 * @author ruioliveiras
 */
public class TableAdapterFactory {
    
    
    public static class TipoTarefaTA extends TableAdapter<TipoTarefa>{
        public static enum Attr{Id,Descricao};
        
        public TipoTarefaTA() {
            super(Attr.values());
        }
        
        @Override
        public Object get(Enum<?> en, TipoTarefa value) {
            Attr a = (Attr) en;
            switch (a) {
                case Id:
                    return value.getId();
                case Descricao:
                    return value.getDescricao();
            }
            return null;
        }   
    }
}
