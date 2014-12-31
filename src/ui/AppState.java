/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import business.Habitat;
import javax.swing.JList;
import javax.swing.JPanel;
import business.admin.TipoActividade;
import business.admin.Funcionario;
import business.admin.TipoQuestao;
import business.admin.TipoDonativo;
import business.admin.TipoTarefa;
import business.building.Projeto;
import business.building.Tarefa;
import business.familiy.Candidatura;
import business.familiy.Familia;
import business.funds.Doador;
import business.funds.Donativo;
import business.funds.Equipa;
import business.funds.Evento;
import business.funds.Voluntariado;
import java.awt.Dimension;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import javax.swing.ListModel;
import ui.MainFrame;
import ui.admin.AdminActivity;
import ui.admin.AdminDonationtype;
import ui.admin.AdminEmployee;
import ui.admin.AdminEmployeeDetails;
import ui.admin.AdminQuestion;
import ui.admin.AdminTask;
import ui.building.BuildingProjectCreateEdit;
import ui.building.BuildingProjectPanel;
import ui.building.BuildingProjectGeralVision;
import ui.building.BuildingTask;
import ui.tabs.AdminToolBar;
import ui.tabs.BuilddingToolBar;
import ui.tabs.FamilyToolBar;
import ui.tabs.FundsToolBar;
import ui.util.SkelatonPanel;
import ui.util.UIDimension;

/**
 *
 * @author ruioliveiras
 */
public class AppState {

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

    private Habitat habitat = new Habitat();

    private final SkelatonPanel admin;
    private final SkelatonPanel funds;
    private final SkelatonPanel family;
    private final SkelatonPanel building;

    private final MainFrame main;
    private final LoginFrame login;
    
    public static enum SubDimension {

        ADMIN_TAREFA, ADMIN_QUESTAO, ADMIN_TIPODON, ADMIN_ACTIVIDADE, ADMIN_FUNCIO,
        BUILD_PROJECT, BUILD_TAKS, BUILD_DONATIONS, BUILD_VOLUNTEERS,
        FAMILY_FAMILY, FAMILY_CAND,
        FUNDS_VOLUNTERS, FUNDS_EVENTS, FUNDS_DONORS, FUNDS_DONATIONS,
    };

    private final UIDimension<TipoTarefa> adminTarefa;
    private final UIDimension<TipoQuestao> adminQuestao;
    private final UIDimension<TipoDonativo> adminTipodon;
    private final UIDimension<TipoActividade> adminActividade;
    private final UIDimension<Funcionario> adminFuncionario;
    private final UIDimension<Projeto> buildProject;
    private final UIDimension<Tarefa> buildTaks;
    private final UIDimension<Donativo> buildDonations = new UIDimension<>();
    private final UIDimension<Voluntariado> buildVolunteers = new UIDimension<>();
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

    public AppState() throws SQLException {
        /** Bloco de codigo de contrução das dimenenções da aplicação, cada dimensao
         * representa uma determinada "coisa" que é preciso gerir
         * Como por exemplos no caso do adminstrador terá que inserir remover editar ver
         * os dados do tipo de tarefa, Actividades, e Questoes
         * 
         * Assim sendo o contrutor da Dimension recebe os frames que que serão executados,
         * Mostrados quando se carrega nos botoes "Editar" "Adicionar" "Remover" "Detalhes"
         * UIDimension tambem recebe como paramentro o 
         * 
         * Para que se pode fazer com um Dimension?
         * 1 - showEdit, showCreate, panelDetails -> isto serve para mostar os pop's quer servem para gerir
         * 2 - listRefresh e listModel -> servem para preparar os dados para serem colucadaas nas lista
         * 
         * <As dimensões são identificadas por a Class<?> que ela gere>
         * Ou seja pode-se consultar a dimensao apartir da class<?> como: "public <A> UIDimension<A> get(Class<A> cl)"
         * 
         * 
         *  ## Como estas Dimesions podem ser usadas? ##
         * Quando ser clica num botao "Tarefas" , fazemos appState.adminSelect(Tarefas.class)
         *         1º vamos buscar a Diimension com o get(class),
         *         2º guarda o selecionado com a variavel adminSelected.
         * 
         * Depois quando se clica num botao Editar por exemplo 
         *      1º vamos buscar a actual dimensao selecionado, com o adminSelected-
         *      2º e com essa dimesao fazemos showEdit
         * 
         */
        this.adminFuncionario = new UIDimension<>(
                new AdminEmployeeDetails(),
                new AdminEmployee(UIDimension.EditonType.EDIT),
                new AdminEmployee(UIDimension.EditonType.NEW),
                new AdminEmployee(UIDimension.EditonType.DETAILS),
                new AdminEmployee(UIDimension.EditonType.DELETE)
        );
        this.adminActividade = new UIDimension<>(
                new AdminActivity(),
                new AdminActivity(UIDimension.EditonType.EDIT),
                new AdminActivity(UIDimension.EditonType.NEW),
                new AdminActivity(UIDimension.EditonType.DETAILS),
                new AdminActivity(UIDimension.EditonType.DELETE)
        );
        this.adminTipodon = new UIDimension<>(
                new AdminDonationtype(),
                new AdminDonationtype(UIDimension.EditonType.EDIT),
                new AdminDonationtype(UIDimension.EditonType.NEW),
                new AdminDonationtype(UIDimension.EditonType.DETAILS),
                new AdminDonationtype(UIDimension.EditonType.DELETE)
        );
        this.adminQuestao = new UIDimension<>(
                new AdminQuestion(),
                new AdminQuestion(UIDimension.EditonType.EDIT),
                new AdminQuestion(UIDimension.EditonType.NEW),
                new AdminQuestion(UIDimension.EditonType.DETAILS),
                new AdminQuestion(UIDimension.EditonType.DELETE)
        );
        this.adminTarefa = new UIDimension<>(
                new AdminTask(),
                new AdminTask(UIDimension.EditonType.EDIT),
                new AdminTask(UIDimension.EditonType.NEW),
                new AdminTask(UIDimension.EditonType.DETAILS),
                new AdminTask(UIDimension.EditonType.DELETE),
                habitat.tipoTarefaGetAll()
        );
        this.buildTaks = new UIDimension<>(
                new BuildingTask(this),
                new BuildingTask(UIDimension.EditonType.EDIT, this),
                new BuildingTask(UIDimension.EditonType.NEW, this),
                new BuildingTask(UIDimension.EditonType.DETAILS, this),
                new BuildingTask(UIDimension.EditonType.DELETE, this)
        );
        this.buildProject = new UIDimension<>(
                new BuildingProjectPanel(),
                new BuildingProjectCreateEdit(UIDimension.EditonType.EDIT),
                new BuildingProjectCreateEdit(UIDimension.EditonType.NEW),
                new BuildingProjectGeralVision(), new BuildingProjectCreateEdit(UIDimension.EditonType.DELETE)
        );
        
        login = new LoginFrame(this);
        
        AdminToolBar adminToolBar = new AdminToolBar(this);
        FundsToolBar fundsToolBar = new FundsToolBar(this);
        FamilyToolBar familyToolBar = new FamilyToolBar(this);
        BuilddingToolBar builddingToolBar = new BuilddingToolBar(this);
        
        this.admin = new SkelatonPanel(ViewDimension.ADMIN, adminToolBar, this);
        this.funds = new SkelatonPanel(ViewDimension.FUNDS, fundsToolBar, this);
        this.family = new SkelatonPanel(ViewDimension.FAMILY, familyToolBar, this);
        this.building = new SkelatonPanel(ViewDimension.BUILDING, builddingToolBar, this);

        adminToolBar.btnTarefasAction();
        builddingToolBar.btnSelectProjectAction();
        
        this.main = new MainFrame(admin, funds, family, building);
    }
    
    
    public void startMain(Funcionario.Tipo who) {
        if (who != Funcionario.Tipo.ADMIN) {
            this.main.removeTab(admin);
            this.funds.setRight(who == Funcionario.Tipo.FUNDOS);
            this.family.setRight(who == Funcionario.Tipo.FAM);
            this.building.setRight(who == Funcionario.Tipo.OBRAS);
        }

        main.setVisible(true);
    }

    public Habitat habitat() {
        return habitat;
    }

    public UIDimension<?> selected(ViewDimension ad) {
        switch (ad) {
            case ADMIN:
                return adminSelected;
            case BUILDING:
                return buildSelected;
            case FAMILY:
                return familySelected;
            case FUNDS:
                return fundsSelected;
        }
        return null;
    }
    
    public <A> UIDimension<A> get(Class<A> cl) {
        // ADMIN 
        if (cl.equals(TipoDonativo.class)) {
            return (UIDimension<A>) adminTipodon;
        } else if (cl.equals(TipoTarefa.class)) {
            return (UIDimension<A>) adminTarefa;
        } else if (cl.equals(TipoActividade.class)) {
            return (UIDimension<A>) adminActividade;
        } else if (cl.equals(Funcionario.class)) {
            return (UIDimension<A>) adminFuncionario;
        } else if (cl.equals(TipoQuestao.class)) {
            return (UIDimension<A>) adminQuestao;
            // COntrutção
        } else if (cl.equals(Projeto.class)) {
            return (UIDimension<A>) buildProject;
        } else if (cl.equals(Tarefa.class)) {
            return (UIDimension<A>) buildTaks;
        } else if (cl.equals(Donativo.class)) {
            return (UIDimension<A>) buildDonations;
        } else if (cl.equals(Voluntariado.class)) {
            return (UIDimension<A>) buildVolunteers;
            // Familia
        } else if (cl.equals(Familia.class)) {
            return (UIDimension<A>) familyFamily;
        } else if (cl.equals(Candidatura.class)) {
            return (UIDimension<A>) familyCand;
            // fundos
        } else if (cl.equals(Evento.class)) {
            return (UIDimension<A>) adminFuncionario;
        } else if (cl.equals(Donativo.class)) {
            return (UIDimension<A>) adminFuncionario;
        } else if (cl.equals(Voluntariado.class)) {
            return (UIDimension<A>) adminFuncionario;
        } else if (cl.equals(Doador.class)) {
            return (UIDimension<A>) adminFuncionario;
        } else {
            return null;
        }
    }

    public <A> void adminSelect(Class<A> cl, List<A> lm) {
        UIDimension<A> dim = get(cl);
        dim.listRefresh(lm.size(), lm);
        adminSelected = dim;
        admin.setDimension(adminSelected);
    }

    public <A> void BuildingSelect(Class<A> cl, List<A> lm) {
        UIDimension<A> dim = get(cl);
        dim.listRefresh(lm.size(), lm);
        buildSelected = dim;
        building.setDimension(buildSelected);
    }

    public <A> void FamilySelect(Class<A> cl, List<A> lm) {
        UIDimension<A> dim = get(cl);
        dim.listRefresh(lm.size(), lm);
        familySelected = dim;
        family.setDimension(familySelected);
    }
    
    public <A> void FundsSelect(Class<A> cl, List<A> lm) {
        UIDimension<A> dim = get(cl);
        dim.listRefresh(lm.size(), lm);
        fundsSelected = dim;
        funds.setDimension(fundsSelected);
    }
}
