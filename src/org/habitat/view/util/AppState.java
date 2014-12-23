/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.habitat.view.util;

import javax.swing.JList;
import javax.swing.JPanel;
import org.habitat.view.MainFrame;
import org.habitat.view.MainFrame1;
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
import org.habitat.view.tabs.AdminToolBar;
import org.habitat.view.tabs.BuilddingToolBar;
import org.habitat.view.tabs.BuildingPanel;
import org.habitat.view.tabs.FamilyToolBar;
import org.habitat.view.tabs.FundsToolBar;
import org.habitat.view.tabs.SkelatonPanel;
import org.habitat.view.util.UIDimension;

/**
 *
 * @author ruioliveiras
 */
public class AppState {

    public void start() {
        main.setVisible(true);
    }

    public static enum ViewDimension {

        ADMIN("Admin"), FUNDS("Com. Fundos"), FAMILY("Com. Fam"), BUILDING("Com. Obras");
        private final String title;

        private ViewDimension(String title) {
            this.title = title;
        }

        public String getTitle() {
            return title;
        }
    };
    private final SkelatonPanel admin = new SkelatonPanel(ViewDimension.ADMIN, new AdminToolBar(this));
    private final SkelatonPanel funds = new SkelatonPanel(ViewDimension.FUNDS, new FundsToolBar(this));
    private final SkelatonPanel family = new SkelatonPanel(ViewDimension.FAMILY, new FamilyToolBar(this));
    private final SkelatonPanel building = new SkelatonPanel(ViewDimension.BUILDING, new BuilddingToolBar(this));

    private MainFrame1 main = new MainFrame1(admin, funds, family, building);

    public static enum SubDimension {

        ADMIN_TAREFA, ADMIN_QUESTAO, ADMIN_TIPODON, ADMIN_ACTIVIDADE, ADMIN_FUNCIO,
        BUILD_PROJECT, BUILD_TAKS, BUILD_DONATIONS, BUILD_VOLUNTEERS,
        FAMILY_FAMILY, FAMILY_CAND,
        FUNDS_VOLUNTERS, FUNDS_EVENTS, FUNDS_DONORS, FUNDS_DONATIONS,
    };
    private final UIDimension<Object> adminTarefa = new UIDimension<>(new AdminTaks(), new AdminDetailsTask());
    private final UIDimension<Object> adminQuestao = new UIDimension<>(new AdminQuestion(), new AdminDetailsQuestion());
    private final UIDimension<Object> adminTipodon = new UIDimension<>(new AdminDonationType(), new AdminDetailsDonationtype());
    private final UIDimension<Object> adminActividade = new UIDimension<>(new AdminActivity(), new AdminDetailsActivity());
    private final UIDimension<Object> adminFuncionario = new UIDimension<>(new AdminEmployee(), new AdminDetailsEmployee());
    private final UIDimension<Object> buildProject = new UIDimension<>(new AdminTaks(), new AdminDetailsTask());
    private final UIDimension<Object> buildTaks = new UIDimension<>(new AdminTaks(), new AdminDetailsTask());
    private final UIDimension<Object> buildDonations = new UIDimension<>(new AdminTaks(), new AdminDetailsTask());
    private final UIDimension<Object> buildVolunteers = new UIDimension<>(new AdminTaks(), new AdminDetailsTask());
    private final UIDimension<Object> familyFamily = new UIDimension<>(new AdminTaks(), new AdminDetailsTask());
    private final UIDimension<Object> familyCand = new UIDimension<>(new AdminTaks(), new AdminDetailsTask());
    private final UIDimension<Object> fundsVolunters = new UIDimension<>(new AdminTaks(), new AdminDetailsTask());
    private final UIDimension<Object> fundsEvents = new UIDimension<>(new AdminTaks(), new AdminDetailsTask());
    private final UIDimension<Object> fundsDonors = new UIDimension<>(new AdminTaks(), new AdminDetailsTask());
    private final UIDimension<Object> fundsDonations = new UIDimension<>(new AdminTaks(), new AdminDetailsTask());

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
