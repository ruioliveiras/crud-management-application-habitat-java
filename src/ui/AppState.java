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
import business.building.DonativoRealizado;
import business.building.Projeto;
import business.building.Tarefa;
import business.building.VoluntariadoRealizado;
import business.familiy.Acompanhamento;
import business.familiy.Candidatura;
import business.familiy.Familia;
import business.familiy.Prestacao;
import business.funds.Doador;
import business.funds.Donativo;
import business.funds.Equipa;
import business.funds.Evento;
import business.funds.Voluntariado;
import business.funds.Voluntario;
import java.sql.SQLException;
import java.util.List;
import ui.admin.AdminActivity;
import ui.admin.AdminDonationtype;
import ui.admin.AdminEmployee;
import ui.admin.AdminEmployeeDetails;
import ui.admin.AdminQuestion;
import ui.admin.AdminTask;
import ui.building.BuildingDonationReal;
import ui.building.BuildingProjectCreateEdit;
import ui.building.BuildingProjectPanel;
import ui.building.BuildingProjectGeralVision;
import ui.building.BuildingTask;
import ui.familiy.FamilyDetalhesPane;
import ui.familiy.familia.FamilyDetalhes;
import ui.building.BuildingVolunteerReal;
<<<<<<< HEAD
import ui.familiy.candidatura.FamilyCanPane;
import ui.familiy.candidatura.FamilyCandCreate;
import ui.familiy.candidatura.FamilyCandDetalhes;
import ui.familiy.familia.FamilyCreate;
=======
import ui.funds.FundsDetalhesDoador;
import ui.funds.FundsDetalhesDonativo;
import ui.funds.FundsDetalhesEquipa;
import ui.funds.FundsDetalhesEvento;
import ui.funds.FundsDetalhesVolunt;
>>>>>>> 05d3dbbc02583c6279a90af389c3d0f68d1151ff
import ui.funds.FundsDonateCreateMaterial;
import ui.funds.FundsDonatorCreate;
import ui.funds.FundsEventCreate;
import ui.funds.FundsTeamCreate;
import ui.funds.FundsVolunteerCreate;
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
    private final UIDimension<DonativoRealizado> buildDonationsReal;
    private final UIDimension<VoluntariadoRealizado> buildVolunteersReal;
    private final UIDimension<Familia> familyFamily;
    private final UIDimension<Candidatura> familyCand;
    private final UIDimension<Prestacao> familyPrestacao;
    private final UIDimension<Acompanhamento> familyAcompanhamento;
    private final UIDimension<Voluntario> fundsVolunters;
    private final UIDimension<Equipa> fundsEquipa; 
    private final UIDimension<Evento> fundsEvents;
    private final UIDimension<Doador> fundsDonors;
    private final UIDimension<Donativo> fundsDonations;
    
    private UIDimension<?> adminSelected;
    private UIDimension<?> buildSelected;
    private UIDimension<?> familySelected;
    private UIDimension<?> fundsSelected;
    private JList adminList;
    private JPanel adminDetails;

    public AppState() throws SQLException {
        this.login = new LoginFrame(this);
        
        AdminToolBar adminToolBar = new AdminToolBar(this);
        FundsToolBar fundsToolBar = new FundsToolBar(this);
        FamilyToolBar familyToolBar = new FamilyToolBar(this);
        BuilddingToolBar builddingToolBar = new BuilddingToolBar(this);
        
        this.admin = new SkelatonPanel(ViewDimension.ADMIN, adminToolBar, this);
        this.funds = new SkelatonPanel(ViewDimension.FUNDS, fundsToolBar, this);
        this.family = new SkelatonPanel(ViewDimension.FAMILY, familyToolBar, this);
        this.building = new SkelatonPanel(ViewDimension.BUILDING, builddingToolBar, this);
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
                this.admin,
                new AdminEmployeeDetails(),
                new AdminEmployee(this,UIDimension.EditonType.EDIT),
                new AdminEmployee(this,UIDimension.EditonType.NEW),
                new AdminEmployee(this,UIDimension.EditonType.DETAILS),
                new AdminEmployee(this,UIDimension.EditonType.DELETE)
        );
        this.adminActividade = new UIDimension<>(
                this.admin,
                new AdminActivity(this),
                new AdminActivity(this,UIDimension.EditonType.EDIT),
                new AdminActivity(this,UIDimension.EditonType.NEW),
                new AdminActivity(this,UIDimension.EditonType.DETAILS),
                new AdminActivity(this,UIDimension.EditonType.DELETE)
        );
        this.adminTipodon = new UIDimension<>(
                this.admin,
                new AdminDonationtype(this),
                new AdminDonationtype(this,UIDimension.EditonType.EDIT),
                new AdminDonationtype(this,UIDimension.EditonType.NEW),
                new AdminDonationtype(this,UIDimension.EditonType.DETAILS),
                new AdminDonationtype(this,UIDimension.EditonType.DELETE)
        );
        this.adminQuestao = new UIDimension<>(
                this.admin,
                new AdminQuestion(this),
                new AdminQuestion(this,UIDimension.EditonType.EDIT),
                new AdminQuestion(this,UIDimension.EditonType.NEW),
                new AdminQuestion(this,UIDimension.EditonType.DETAILS),
                new AdminQuestion(this,UIDimension.EditonType.DELETE)
        );
        this.adminTarefa = new UIDimension<>(
                this.admin,
                new AdminTask(this),
                new AdminTask(this,UIDimension.EditonType.EDIT),
                new AdminTask(this,UIDimension.EditonType.NEW),
                new AdminTask(this,UIDimension.EditonType.DETAILS),
                new AdminTask(this,UIDimension.EditonType.DELETE),
                habitat.tipoTarefaGetAll()
        );
        this.buildTaks = new UIDimension<>(
                this.building,
                new BuildingTask(this),
                new BuildingTask(UIDimension.EditonType.EDIT, this),
                new BuildingTask(UIDimension.EditonType.NEW, this),
                new BuildingTask(UIDimension.EditonType.DETAILS, this),
                new BuildingTask(UIDimension.EditonType.DELETE, this)
        );
        this.buildProject = new UIDimension<>(
                this.building,
                new BuildingProjectPanel(),
                new BuildingProjectCreateEdit(UIDimension.EditonType.EDIT),
                new BuildingProjectCreateEdit(UIDimension.EditonType.NEW),
                new BuildingProjectGeralVision(), 
                new BuildingProjectCreateEdit(UIDimension.EditonType.DELETE)
        );
        this.familyFamily = new UIDimension<>(
                this.family,
                new FamilyDetalhesPane(),
                new FamilyCreate(UIDimension.EditonType.EDIT, this),
                new FamilyCreate(UIDimension.EditonType.NEW, this),
                new FamilyDetalhes(),
                new FamilyCreate(this)
        );
        this.familyCand = new UIDimension<>(
            this.family,
            new FamilyCanPane(),
            new FamilyCandCreate(UIDimension.EditonType.EDIT, this),
            new FamilyCandCreate(UIDimension.EditonType.NEW, this),
            new FamilyCandDetalhes(),
            new FamilyCandDetalhes()
        );
        this.familyAcompanhamento = new UIDimension<>();
        this.familyPrestacao = new UIDimension<>();
        this.buildVolunteersReal = new UIDimension<>(
                this.building,
                new BuildingVolunteerReal(this),
                new BuildingVolunteerReal(this,UIDimension.EditonType.EDIT),
                new BuildingVolunteerReal(this,UIDimension.EditonType.NEW),
                new BuildingVolunteerReal(this,UIDimension.EditonType.DETAILS), 
                new BuildingVolunteerReal(this,UIDimension.EditonType.DELETE)
        );
        this.buildDonationsReal = new UIDimension<>(
                this.building,
                new BuildingDonationReal(this),
                new BuildingDonationReal(this,UIDimension.EditonType.EDIT),
                new BuildingDonationReal(this,UIDimension.EditonType.NEW),
                new BuildingDonationReal(this,UIDimension.EditonType.DETAILS), 
                new BuildingDonationReal(this,UIDimension.EditonType.DELETE)
        );

        this.fundsDonations = new UIDimension<>(
            this.funds,
            new FundsDetalhesDonativo(),
            new FundsDonateCreateMaterial(this,UIDimension.EditonType.EDIT),
            new FundsDonateCreateMaterial(this,UIDimension.EditonType.NEW),
            new FundsDonateCreateMaterial(this,UIDimension.EditonType.DETAILS), 
            new FundsDonateCreateMaterial(this,UIDimension.EditonType.DELETE)
        );
        this.fundsDonors = new UIDimension<>(
            this.funds,
            new FundsDetalhesDoador(),
            new FundsDonatorCreate(this,UIDimension.EditonType.EDIT),
            new FundsDonatorCreate(this,UIDimension.EditonType.NEW),
            new FundsDonatorCreate(this,UIDimension.EditonType.DETAILS), 
            new FundsDonatorCreate(this,UIDimension.EditonType.DELETE)
        );
        this.fundsEvents = new UIDimension<>(
            this.funds,
            new FundsDetalhesEvento(),
            new FundsEventCreate(this,UIDimension.EditonType.EDIT),
            new FundsEventCreate(this,UIDimension.EditonType.NEW),
            new FundsEventCreate(this,UIDimension.EditonType.DETAILS), 
            new FundsEventCreate(this,UIDimension.EditonType.DELETE)
        );
        
        this.fundsVolunters = new UIDimension<>(
            this.funds,
            new FundsDetalhesVolunt(),
            new FundsVolunteerCreate(this,UIDimension.EditonType.EDIT),
            new FundsVolunteerCreate(this,UIDimension.EditonType.NEW),
            new FundsVolunteerCreate(this,UIDimension.EditonType.DETAILS), 
            new FundsVolunteerCreate(this,UIDimension.EditonType.DELETE)
        );

        this.fundsEquipa = new UIDimension<>(
            this.funds,
            new FundsDetalhesEquipa(),
            new FundsTeamCreate(this,UIDimension.EditonType.EDIT),
            new FundsTeamCreate(this,UIDimension.EditonType.NEW),
            new FundsTeamCreate(this,UIDimension.EditonType.DETAILS), 
            new FundsTeamCreate(this,UIDimension.EditonType.DELETE)
        );

        adminToolBar.btnTarefasAction();
        builddingToolBar.btnSelectProjectAction();
        familyToolBar.btnFamiliyAction();
        fundsToolBar.btnVoluntariosAction();
        
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
        } else if (cl.equals(DonativoRealizado.class)) {
            return (UIDimension<A>) buildDonationsReal;
        } else if (cl.equals(VoluntariadoRealizado.class)) {
            return (UIDimension<A>) buildVolunteersReal;
            // Familia
        } else if (cl.equals(Familia.class)) {
            return (UIDimension<A>) familyFamily;
        } else if (cl.equals(Candidatura.class)) {
            return (UIDimension<A>) familyCand;
        } else if (cl.equals(Prestacao.class)) {
            return (UIDimension<A>) familyPrestacao;
        } else if (cl.equals(Acompanhamento.class)) {
            return (UIDimension<A>) familyAcompanhamento;
        } else if (cl.equals(Evento.class)) {
            return (UIDimension<A>) fundsEvents;
        } else if (cl.equals(Donativo.class)) {
            return (UIDimension<A>) fundsDonations;
        } else if (cl.equals(Voluntario.class)) {
            return (UIDimension<A>) fundsVolunters;
        } else if (cl.equals(Doador.class)) {
            return (UIDimension<A>) fundsDonors;
        } else if (cl.equals(Equipa.class)) {
            return (UIDimension<A>) fundsEquipa;
        } else {
            return null;
        }
    }
     public <A> void FamilySelect(Class<A> cl, List<A> lm) {
        UIDimension<A> dim = get(cl);
        dim.listRefresh(lm);
        familySelected = dim;
        family.setDimension(familySelected);
    }
    
    public <A> void adminSelect(Class<A> cl, List<A> lm) {
        UIDimension<A> dim = get(cl);
        dim.listRefresh(lm);
        adminSelected = dim;
//        admin.setDimension(adminSelected);
    }

    public <A> void BuildingSelect(Class<A> cl, List<A> lm) {
        UIDimension<A> dim = get(cl);
        dim.listRefresh( lm);
        buildSelected = dim;
        building.setDimension(buildSelected);
    }
    
    public <A> void FundsSelect(Class<A> cl, List<A> lm) {
        UIDimension<A> dim = get(cl);
        dim.listRefresh(lm);
        fundsSelected = dim;
       funds.setDimension(fundsSelected);
    }
    
    
    public SkelatonPanel getSkelaton(ViewDimension viewDimension) {
        switch (viewDimension){
            case ADMIN: return admin;
            case FUNDS: return funds;
            case FAMILY: return family;
            case BUILDING: return building;
        }
        return null;
    }

}
