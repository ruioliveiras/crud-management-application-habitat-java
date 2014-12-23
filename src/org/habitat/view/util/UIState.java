/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.habitat.view.util;

import javax.swing.JList;
import javax.swing.JPanel;
import org.habitat.view.creation.AdminActivity;
import org.habitat.view.creation.AdminDonationType;
import org.habitat.view.creation.AdminEmployee;
import org.habitat.view.creation.AdminQuestion;
import org.habitat.view.creation.AdminTaks;
import org.habitat.view.details.AdminDetailsActivity;
import org.habitat.view.details.AdminDetailsDonationtype;
import org.habitat.view.details.AdminDetailsEmployee;
import org.habitat.view.details.AdminDetailsQuestion;
import org.habitat.view.details.AdminDetailsTask;

/**
 *
 * @author ruioliveiras
 */
public class UIState {
    public static enum AdminDimension{TAREFA,QUESTAO,TIPODON,ACTIVIDADE,FUNCIO}
    private final UIDimension<Object> adminTarefa = new UIDimension<>(new AdminTaks(), new AdminDetailsTask());
    private final UIDimension<Object> adminQuestao = new UIDimension<>(new AdminQuestion(), new AdminDetailsQuestion());
    private final UIDimension<Object> adminTipodon = new UIDimension<>(new AdminDonationType(), new AdminDetailsDonationtype());
    private final UIDimension<Object> adminActividade = new UIDimension<>(new AdminActivity(), new AdminDetailsActivity());
    private final UIDimension<Object> adminFuncionario = new UIDimension<>(new AdminEmployee(), new AdminDetailsEmployee());
    private UIDimension<?> adminSelected;
    private JList adminList;
    private JPanel adminDetails;

    public UIDimension<?> adminSelected() {
        return adminSelected;
    }
    
    public void adminSelect(AdminDimension ad) {
        switch(ad){
            case TAREFA: adminSelected = adminTarefa; break;
            case QUESTAO: adminSelected = adminQuestao; break;
            case TIPODON: adminSelected = adminTipodon; break;
            case ACTIVIDADE: adminSelected = adminActividade; break;
            case FUNCIO:  adminSelected = adminFuncionario; break;
        }
    } 
}
