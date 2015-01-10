package business.building;

import business.familiy.Candidatura;
import business.funds.Voluntariado;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import persistence.ProjetoDAO;
import persistence.familia.CandidaturaDAO;
import persistence.fundos.DonativoDAO;

public class Projeto {
    private static ProjetoDAO projetoDAO = new ProjetoDAO();
    private static DonativoDAO donativoDAO = new DonativoDAO();
    
    private int id,idFunc,idCand;
    private int orcamento;
    private Double prestacao;
    private String designacao, descricao;
    private GregorianCalendar dataInicio, dataFim, dataCriaProj, prazo;
	
        /*public Comissao_Obras supervisiona;
	public Comissao_de_Familias aprova;
	public ProjetoDAO unnamed_ProjetoDAO_;
	public Candidatura candidatura;
	public Vector<Donativo> donativos = new Vector<Donativo>();
        public Plano_Pagamento unnamed_Plano_Pagamento_;
	public TarefaDAO unnamed_TarefaDAO_;
	public DonativoDAO donativoDAO;
	public DonativoDAO unnamed_DonativoDAO_;
	public TarefaDAO tarefaDAO;*/
        
    /**
     * Construtor Parametrizado
     * @param id Código de Identificação
     * @param idFunc Identificação do funcionário que supervisiona a execução
     * @param idCand Identificação da candidatura que originou o projecto 
     * @param orcamento Orçamento disponível para o Projeto
     * @param prestacao Prestação Mensal a pagar pela Família
     * @param designacao Nome do Projeto
     * @param descricao Descrição do Projecto
     * @param dataInicio Data de Início da Obra
     * @param dataFim Data de Fim da Obra
     * @param dataCriaProj Data de Criação do Projeto
     * @param prazo Prazo de Finalização do Projeto
     */    
    public Projeto(int id,int idFunc,int idCand, int orcamento, Double prestacao, String designacao, 
            String descricao, GregorianCalendar dataInicio, GregorianCalendar dataFim, 
            GregorianCalendar dataCriaProj, GregorianCalendar prazo) {
        this.id = id;
        this.idCand = idCand;
        this.idFunc = idFunc;
        this.orcamento = orcamento;
        this.prestacao = prestacao;
        this.designacao = designacao;
        this.descricao = descricao;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.dataCriaProj = dataCriaProj;
        this.prazo = prazo;
    }
    /**
     * Construtor Parametrizado sem prestação
     * @param id Código de Identificação
     * @param idFunc Identificação do funcionário que supervisiona a execução
     * @param idCand Identificação da candidatura que originou o projecto 
     * @param orcamento Orçamento disponível para o Projeto
     * @param designacao Nome do Projeto
     * @param descricao Descrição do Projecto
     * @param dataInicio Data de Início da Obra
     * @param dataFim Data de Fim da Obra
     * @param dataCriaProj Data de Criação do Projeto
     * @param prazo Prazo de Finalização do Projeto
     */    
    public Projeto(int id,int idFunc,int idCand, int orcamento, String designacao, 
            String descricao, GregorianCalendar dataInicio, GregorianCalendar dataFim, 
            GregorianCalendar dataCriaProj, GregorianCalendar prazo) {
        this.id = id;
        this.idCand = idCand;
        this.idFunc = idFunc;
        this.orcamento = orcamento;
        this.designacao = designacao;
        this.descricao = descricao;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.dataCriaProj = dataCriaProj;
        this.prazo = prazo;
    }  
    /**
     * Construtor de Cópia
     * @param p Projecto a ser Copiado
     */
    public Projeto(Projeto p) {
        this.idCand = p.getCandidaturaId();
        this.idFunc = p.getFuncionarioId();
        this.id = p.getId();
        this.orcamento = p.getOrcamento();
        this.prestacao = p.getPrestacao();
        this.designacao = p.getDesignacao();
        this.descricao = p.getDescricao();
        this.dataInicio = p.getDataInicio();
        this.dataFim = p.getDataFim();
        this.dataCriaProj = p.getDataCriaProj();
        this.prazo = p.getPrazo();
    }
    /**
    * Construtor de vazio
    * 
    */
    public Projeto() {
        this.idCand = 0;
        this.idFunc = 0;
        this.id = 0;
        this.orcamento = 0;
        this.prestacao = 0.0;
        this.designacao = "";
        this.descricao = "";
        this.dataInicio = new GregorianCalendar();
        this.dataFim = new GregorianCalendar();
        this.dataCriaProj = new GregorianCalendar();
        this.prazo = new GregorianCalendar();
    }
/**
 * Retorna Identificador do Projeto
 * @return id
 */
    public int getId() {
        return id;
    }
/**
 * Retorna o Identificador da Candidatura
 * @return id da Candidatura
 */
    public int getCandidaturaId(){
        return idCand;
    }
/**
 * Retorna o Identificador do Funcionário
 * @return id do Funcionário
 */    
    public int getFuncionarioId(){
        return idFunc;
    }
/**
 * Retorna a descrição do projeto
 * @return Descrição
 */    
    public String getDescricao() {
        return descricao;
    }
/**
 * Modifica a descrição do Projeto
 * @param descricao Nova descrição
 */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
/**
 * Retorna o prazo de finalização do projeto
 * @return Prazo
 */
    public GregorianCalendar getPrazo() {
        return prazo;
    }
/**
 * Modifica o prazo de Finalização do projeto
 * @param prazo Novo Prazo
 */
    public void setPrazo(GregorianCalendar prazo) {
        this.prazo = prazo;
    }
/**
 * Retorna a data de Criação do Projeto
 * @return Data de Criação do Projeto
 */
    public GregorianCalendar getDataCriaProj() {
        return dataCriaProj;
    }
/**
 * Retorna a data de Fim do Projeto
 * @return Data de Fim
 */
    public GregorianCalendar getDataFim() {
        return dataFim;
    }
/**
 * Retorna a data de Início do Projeto
 * @return Data de Início
 */
    public GregorianCalendar getDataInicio() {
        return dataInicio;
    }
/**
 * Retorna a Designação do Projeto
 * @return Designação
 */
    public String getDesignacao() {
        return designacao;
    }
/**
 * Retorna o Orçamento para a obra
 * @return Orçamento
 */
    public int getOrcamento() {
        return orcamento;
    }
/**
 * Retorna a Prestação a ser paga pela Família
 * @return Prestação
 */
    public Double getPrestacao() {
        return prestacao;
    }
/**
 * Modifica o Identificador
 * @param id Novo Identificador
 */
    public void setId(int id) {
        this.id = id;
    }
/**
 * Modifica a data de Criação do Projeto
 * @param dataCriaProj Nova data de Criação
 */
    public void setDataCriaProj(GregorianCalendar dataCriaProj) {
        this.dataCriaProj = dataCriaProj;
    }
/**
 * Modifica a data de fim do Projeto
 * @param dataFim Nova data de Fim
 */
    public void setDataFim(GregorianCalendar dataFim) {
        this.dataFim = dataFim;
    }
/**
 * Modifica a data de início do Projeto
 * @param dataInicio Nova data de Início
 */
    public void setDataInicio(GregorianCalendar dataInicio) {
        this.dataInicio = dataInicio;
    }
/**
 * Modifica a designação do Projeto
 * @param designacao Nova designação do Projecto
 */
    public void setDesignacao(String designacao) {
        this.designacao = designacao;
    }
/**
 * Modifica o Orçamento do Projeto
 * @param orcamento Novo Orçamento do Projeto
 */
    public void setOrcamento(int orcamento) {
        this.orcamento = orcamento;
    }
/**
 * Modifica a Prestação
 * @param prestacao Nova Prestação
 */
    public void setPrestacao(Double prestacao) {
        this.prestacao = prestacao;
    }
   /**
    * Adiciona uma Tarefa ao plano de obra do Projeto
    * @param t Tarefa a ser adicionada
    */
    public void addTarefa(Tarefa t) {
       
    }
    /**
     * Edita uma Tarefa do plano de obra do Projeto
     * @param t Tarefa a ser editada
     */
    public void editTarefa(Tarefa t) {
        
    }
    /**
     * Retorna as Tarefas que estão associadas ao projeto
     * @return Lista com as tarefas associadas ao projeto
     * @throws SQLException Caso exista problemas na ligação à Base de Dados 
     */
    public List<Tarefa> getTarefas() throws SQLException{
        return projetoDAO.getTarefasAllByIdProg(id);
    }
    /**
     * Retorna Os Voluntários que trabalharam para este Projeto
     * @return Lista com todos os Voluntariados realizados neste Projeto
     * @throws SQLException Caso exista problemas na ligação à Base de Dados 
     */
    public List<Voluntariado> getVoluntariados() throws SQLException{
        
        return null;
    }
    /**
     * Retorna os Donativos realizados para este projeto
     * @return Lista com todos os donativos realizados para este projeto
     * @throws SQLException Caso exista problemas na ligação à Base de Dados 
     */
    public List<DonativoRealizado> getDonativos() throws SQLException {
        return donativoDAO.getByProjId(id);
    }
    /**
     * Criação de uma cópia da Instância actual
     * @return Cópia da Instância actual
     */
    public Projeto clone()
    {
        return new Projeto(this);
    }
    
/**
 * Retorna a representação textual do Projeto usando o Identificador, Orçamento e Descrição
 * @return Representação textual do Projeto
 */
    @Override
    public String toString(){
        return new String(this.id+"."+this.orcamento+"."+this.descricao);
    }
}