package business.building;

import business.funds.Donativo;
import business.funds.Voluntariado;
import java.sql.SQLException;
import java.util.GregorianCalendar;
import java.util.List;
import persistence.ProjetoDAO;

public class Projeto {
    private static ProjetoDAO projetoDAO = new ProjetoDAO();
    
    private int id,idFunc,idCand;
    private Double orcamento;
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
        
        
    public Projeto(int id,int idFunc,int idCant, Double orcamento, Double prestacao, String designacao, 
            String descricao, GregorianCalendar dataInicio, GregorianCalendar dataFim, 
            GregorianCalendar dataCriaProj, GregorianCalendar prazo) {
        this.id = id;
        this.idCand = idCant;
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

    public int getId() {
        return id;
    }

    public int getCandidaturaId(){
        return idCand;
    }
    
    public int getFuncionarioId(){
        return idFunc;
    }
    
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public GregorianCalendar getPrazo() {
        return prazo;
    }

    public void setPrazo(GregorianCalendar prazo) {
        this.prazo = prazo;
    }

    public GregorianCalendar getDataCriaProj() {
        return dataCriaProj;
    }

    public GregorianCalendar getDataFim() {
        return dataFim;
    }

    public GregorianCalendar getDataInicio() {
        return dataInicio;
    }

    public String getDesignacao() {
        return designacao;
    }

    public Double getOrcamento() {
        return orcamento;
    }

    public Double getPrestacao() {
        return prestacao;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDataCriaProj(GregorianCalendar dataCriaProj) {
        this.dataCriaProj = dataCriaProj;
    }

    public void setDataFim(GregorianCalendar dataFim) {
        this.dataFim = dataFim;
    }

    public void setDataInicio(GregorianCalendar dataInicio) {
        this.dataInicio = dataInicio;
    }

    public void setDesignacao(String designacao) {
        this.designacao = designacao;
    }

    public void setOrcamento(Double orcamento) {
        this.orcamento = orcamento;
    }

    public void setPrestacao(Double prestacao) {
        this.prestacao = prestacao;
    }
   
    public List<Tarefa> getTarefas() throws SQLException{
        return projetoDAO.getTarefasAllByIdProg(id);
    }
    
    public List<Voluntariado> getVoluntariados() throws SQLException{
        
        return null;
    }
    
    public List<Donativo> getDonativos(){
        return null;
    }
    
    public Projeto clone()
    {
        return new Projeto(this);
    }
}