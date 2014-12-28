/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.util;

import javax.swing.JList;
import javax.swing.JPanel;
import business.admin.Actividade;
import business.admin.Funcionario;
import business.admin.Questao;
import business.admin.TipoDonativo;
import business.admin.TipoTarefa;
import ui.MainFrame;
import ui.creation.AdminActivity;
import ui.creation.AdminDonationType;
import ui.creation.AdminEmployee;
import ui.creation.AdminQuestion;
import ui.creation.AdminTaks;
import ui.details.AdminDetailsActivity;
import ui.details.AdminDetailsDonationtype;
import ui.details.AdminDetailsEmployee;
import ui.details.AdminDetailsQuestion;
import ui.details.AdminDetailsTask;
import ui.tabs.AdminToolBar;
import ui.tabs.BuilddingToolBar;
import ui.tabs.FamilyToolBar;
import ui.tabs.FundsToolBar;
import ui.tabs.SkelatonPanel;

/**
 *
 * @author ruioliveiras
 */
public class AppState {

    public void start() {
        main.setVisible(true);
    }


    public static enum ViewDimension{

        ADMIN("Admin"), FUNDS("Com. Fundos"), FAMILY("Com. Fam"), BUILDING("Com. Obras");
        private final String title;

        private ViewDimension(String title) {
            this.title = title;
        }

        public String getTitle() {
            return title;
        }
    };
    private final SkelatonPanel admin = new SkelatonPanel(ViewDimension.ADMIN, new AdminToolBar(this), this);
    private final SkelatonPanel funds = new SkelatonPanel(ViewDimension.FUNDS, new FundsToolBar(this), this);
    private final SkelatonPanel family = new SkelatonPanel(ViewDimension.FAMILY, new FamilyToolBar(this), this);
    private final SkelatonPanel building = new SkelatonPanel(ViewDimension.BUILDING, new BuilddingToolBar(this), this);

    private MainFrame main = new MainFrame(admin, funds, family, building);

    public static enum SubDimension {

        ADMIN_TAREFA, ADMIN_QUESTAO, ADMIN_TIPODON, ADMIN_ACTIVIDADE, ADMIN_FUNCIO,
        BUILD_PROJECT, BUILD_TAKS, BUILD_DONATIONS, BUILD_VOLUNTEERS,
        FAMILY_FAMILY, FAMILY_CAND,
        FUNDS_VOLUNTERS, FUNDS_EVENTS, FUNDS_DONORS, FUNDS_DONATIONS,
    };
    private final UIDimension<TipoTarefa> adminTarefa = new UIDimension<>(new AdminTaks(), new AdminDetailsTask());
    private final UIDimension<Questao> adminQuestao = new UIDimension<>(new AdminQuestion(), new AdminDetailsQuestion());
    private final UIDimension<TipoDonativo> adminTipodon = new UIDimension<>(new AdminDonationType(), new AdminDetailsDonationtype());
    private final UIDimension<Actividade> adminActividade = new UIDimension<>(new AdminActivity(), new AdminDetailsActivity());
    private final UIDimension<Funcionario> adminFuncionario = new UIDimension<>(new AdminEmployee(), new AdminDetailsEmployee());
    private final UIDimension<Object> buildProject = new UIDimension<>();
    private final UIDimension<Object> buildTaks = new UIDimension<>();
    private final UIDimension<Object> buildDonations = new UIDimension<>();
    private final UIDimension<Object> buildVolunteers = new UIDimension<>();
    private final UIDimension<Object> familyFamily = new UIDimension<>();
    private final UIDimension<Object> familyCand = new UIDimension<>();
    private final UIDimension<Object> fundsVolunters = new UIDimension<>();
    private final UIDimension<Object> fundsEvents = new UIDimension<>();
    private final UIDimension<Object> fundsDonors = new UIDimension<>();
    private final UIDimension<Object> fundsDonations = new UIDimension<>();
    
    private UIDimension<?> adminSelected;
    private UIDimension<?> buildSelected;
    private UIDimension<?> familySelected;
    private UIDimension<?> fundsSelected;
    private JList adminList;
    private JPanel adminDetails;

    public UIDimension<?> selected(ViewDimension ad) {
        switch (ad) {
            case ADMIN:
                return adminSelected();
            case BUILDING:
                return buildSelected();
            case FAMILY:
                return familySelected();
            case FUNDS:
                return fundsSelected();
        }
        return null;
    }
    
    public UIDimension<?> adminSelected() {
        return adminSelected;
    }

    public UIDimension<?> buildSelected() {
        return buildSelected;
    }

    public UIDimension<?> familySelected() {
        return familySelected;
    }

    public UIDimension<?> fundsSelected() {
        return fundsSelected;
    }

    public void adminSelect(SubDimension ad) {
        switch (ad) {
            case ADMIN_TAREFA:
                adminSelected = adminTarefa;
                break;
            case ADMIN_QUESTAO:
                adminSelected = adminQuestao;
                break;
            case ADMIN_TIPODON:
                adminSelected = adminTipodon;
                break;
            case ADMIN_ACTIVIDADE:
                adminSelected = adminActividade;
                break;
            case ADMIN_FUNCIO:
                adminSelected = adminFuncionario;
                break;
        }
        admin.setDimension(adminSelected);
    }

    public void buildSelect(SubDimension ad) {
        switch (ad) {
            case BUILD_PROJECT:
                buildSelected = buildProject;
                break;
            case BUILD_TAKS:
                buildSelected = buildTaks;
                break;
            case BUILD_DONATIONS:
                buildSelected = buildDonations;
                break;
            case BUILD_VOLUNTEERS:
                buildSelected = buildVolunteers;
                break;
        }
        building.setDimension(buildSelected);
    }

    public void familySelect(SubDimension ad) {
        switch (ad) {
            case FAMILY_FAMILY:
                familySelected = familyFamily;
                break;
            case FAMILY_CAND:
                familySelected = familyCand;
                break;
        }
        family.setDimension(familySelected);
    }

    public void fundsSelect(SubDimension ad) {
        switch (ad) {
            case FUNDS_VOLUNTERS:
                fundsSelected = fundsVolunters;
                break;
            case FUNDS_EVENTS:
                fundsSelected = fundsEvents;
                break;
            case FUNDS_DONORS:
                fundsSelected = fundsDonors;
                break;
            case FUNDS_DONATIONS:
                fundsSelected = fundsDonations;
                break;
        }
        funds.setDimension(fundsSelected);
    }
}
