package business.familiy;

import business.admin.TipoQuestao;
import business.building.Projeto;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import persistence.admin.TipoQuestaoDAO;


public class Candidatura 
{
    public enum CandidaturaEstado{APROVADO,NAOAPROVADO,NAOACEITE,PENDENTE};
    
    private static final TipoQuestaoDAO questaoDAO = new TipoQuestaoDAO();
    
    private GregorianCalendar dataCand;
    private double rendimento;
    private int id;
    private CandidaturaEstado estado;
    private Familia familia;
    private Projeto projeto;
    private HashMap<Integer, Questao> questoes;
/**
 * Construtor Vazio
 */
    public Candidatura() {
        questoes = new HashMap<>();
        projeto = null;
        estado = Candidatura.CandidaturaEstado.PENDENTE;
    }
/**
 * Construtor Parametrizado
 * @param f Família à qual pertence a Candidatura
 */    
    public Candidatura(Familia f){
        this();
        familia = f;
     }
    /**
     * Construtor Parametrizado
     * @param dataCand Data de realização da Candidatura
     * @param rendimento Rendimento Anual
     * @param id Identificador da Candidatura
     * @param estado Estado da Candidatura
     * @param familia Família à qual pertence a Candidatura
     * @param projeto Projecto resultante da Candidatura
     * @param questoes Questões Respondidas
     */
    public Candidatura(GregorianCalendar dataCand, double rendimento, int id, 
            CandidaturaEstado estado, Familia familia, Projeto projeto, HashMap<Integer, Questao> questoes) {
        this.dataCand = dataCand;
        this.rendimento = rendimento;
        this.id = id;
        this.estado = estado;
        this.familia = familia.clone();
        this.projeto = projeto.clone();
        this.questoes = new HashMap<Integer, Questao>();
        for(Map.Entry<Integer, Questao> e : questoes.entrySet())
            this.questoes.put(e.getKey(), e.getValue());
    }
/**
 * Construtor Parametrizado
 * @param dataCand Data de Candidatura
 * @param rendimento Rendimento Bruto Anual
 * @param id Identificador da Candidatura 
 * @param estado Estado da Candidatura
 */    
    public Candidatura(GregorianCalendar dataCand, double rendimento, int id, 
            CandidaturaEstado estado) {
        this.dataCand = dataCand;
        this.rendimento = rendimento;
        this.id = id;
        this.estado = estado;
        this.questoes = new HashMap<Integer, Questao>();
    }
/**
 * Construtor por cópia
 * @param c Candidatura a ser copiada
 */    
    public Candidatura(Candidatura c) 
    {
        this.dataCand = c.getDataCand();
        this.rendimento = c.getRendimento();
        this.id = c.getId();
        this.estado = c.getEstado();
        this.questoes = c.getQuestoes();
    }
    
/**
 * Retorna a data da Candidatura
 * @return Data de Candidatura
 */
    public GregorianCalendar getDataCand() {
        return dataCand;
    }
/**
 * Modifica a data de Candidatura 
 * @param dataCand Nova Data de Candidatura
 */
    public void setDataCand(GregorianCalendar dataCand) {
        this.dataCand = dataCand;
    }
/**
 * Retorna o Rendimento Anual da Família
 * @return Rendimento
 */
    public double getRendimento() {
        return this.rendimento;
    }
/**
 * Modifica o rendimento da família 
 * @param rendimento Novo Rendimento da Familia
 */
    public void setRendimento(double rendimento) {
        this.rendimento = rendimento;
    }
/**
 * Retorna o Identificador da Candidatura
 * @return Identificador da Candidatura
 */
    public int getId() {
        return id;
    }
/**
 * Modifica o Identificador da Candidatura
 * @param id Novo Identificador da Família
 */
    public void setId(int id) {
        this.id = id;
    }
/**
 * Retorna o estado da Candidatura
 * @return Estado
 */
    public CandidaturaEstado getEstado() {
        return estado;
    }
/**
 * Modifica o Estado da Candidatura
 * @param estado Novo estado 
 */
    public void setEstado(CandidaturaEstado estado) {
        this.estado = estado;
    }
/**
 * Retorna a Família 
 * @return Família
 */
    public Familia getFamilia() {
        return familia;
    }
/**
 * Modifica a Família 
 * @param familia Nova Família
 */
    public void setFamilia(Familia familia) {
        this.familia = familia;
    }
/**
 * Retorna o Projeto resultante
 * @return Projeto
 */
    public Projeto getProjeto() {
        return projeto.clone();
    }
/**
 * Modifica o Projeto resultante
 * @param projeto Novo Projeto
 */
    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }
/**
 * Retorna as Questões respondidas na Candidatura
 * @return Questões
 */
    public HashMap<Integer, Questao> getQuestoes() 
    {
        if (this.questoes == null){ return null;}
        
        HashMap<Integer, Questao> q = new HashMap<Integer, Questao>();
        for(Map.Entry<Integer, Questao> entry : this.questoes.entrySet()) 
        {
            q.put(entry.getKey(), entry.getValue());
        }
        
        return q;
    }
    /**
     * Retorna as Questões respondidas na Candidatura
     * @return Lista com todas as Questões respondidas
     */
    public ArrayList<Questao> getQuestoesList() 
    {
        if (this.questoes == null){ return null;}
        
        ArrayList<Questao> q = new ArrayList<>();
        for(Map.Entry<Integer, Questao> entry : this.questoes.entrySet()) 
        {
            q.add(entry.getValue());
        }
        
        return q;
    }
/**
 * Responder a uma Questão
 * @param key Chave da Questão
 * @param text Resposta 
 */
    public void putResposta(Integer key, String text) {
        Questao q = questoes.get(key);
        if (q != null){
            q.setResposta(text);
        }
    }
/**
 * Coloca Respostas vazias às questão 
 * @throws SQLException Caso exista problemas na ligação à Base de Dados
 */    
    public void setQuestoesDefault() throws SQLException{
        ArrayList<TipoQuestao> tipoQuestoes = questaoDAO.getAllAtive();
        questoes = new HashMap<>();
        for (TipoQuestao t : tipoQuestoes) {
            questoes.put(t.getId(), new Questao(t.getId() , t.getDescricao(), ""));
        }
    }
/**
 * Modifica as Questões da Candidatura
 * @param questoes Novas Questões
 */
    public void setQuestoes(HashMap<Integer, Questao> questoes) 
    {   
        this.questoes = new HashMap<Integer, Questao>();
        for (Map.Entry<Integer, Questao> entrySet : questoes.entrySet()) {
            Integer key = entrySet.getKey();
            Questao value = entrySet.getValue();
            this.questoes.put(key, value);
        }
      }
            
/**
 * Retorna uma Cópia da Instância Actual
 * @return Cópia da Instância Actual
 */
    @Override
    public Candidatura clone()
    {
        return new Candidatura(this);
    }
    /**
     * Retorna a representação textual da Candidatura Utilizando o Identificador, Estado e Rendimento
     * @return Representação textual da Candidatura
     */
    public String toString(){
        return new String(this.id+"."+this.estado+"."+this.rendimento);
    }
}