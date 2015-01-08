package business.familiy;

import business.admin.TipoQuestao;
import business.building.Projeto;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import persistence.admin.QuestaoDAO;


public class Candidatura 
{
    public enum CandidaturaEstado{APROVADO,NAOAPROVADO,NAOACEITE,PENDENTE};
    
    private static final QuestaoDAO questaoDAO = new QuestaoDAO();
    
    private GregorianCalendar dataCand;
    private double rendimento;
    private int id;
    private CandidaturaEstado estado;
    private Familia familia;
    private Projeto projeto;
    private HashMap<Integer, Questao> questoes;

    public Candidatura() {
        questoes = new HashMap<>();
    }
    
    public Candidatura(Familia f){
        familia = f;
        projeto = null;
        questoes = null;
    }
    
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
    
    public Candidatura(GregorianCalendar dataCand, double rendimento, int id, 
            CandidaturaEstado estado) {
        this.dataCand = dataCand;
        this.rendimento = rendimento;
        this.id = id;
        this.estado = estado;
        this.questoes = new HashMap<Integer, Questao>();
    }
    
    public Candidatura(Candidatura c) 
    {
        this.dataCand = c.getDataCand();
        this.rendimento = c.getRendimento();
        this.id = c.getId();
        this.estado = c.getEstado();
        this.questoes = c.getQuestoes();
    }
    

    public GregorianCalendar getDataCand() {
        return dataCand;
    }

    public void setDataCand(GregorianCalendar dataCand) {
        this.dataCand = dataCand;
    }

    public double getRendimento() {
        return this.rendimento;
    }

    public void setRendimento(double rendimento) {
        this.rendimento = rendimento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CandidaturaEstado getEstado() {
        return estado;
    }

    public void setEstado(CandidaturaEstado estado) {
        this.estado = estado;
    }

    public Familia getFamilia() {
        return familia;
    }

    public void setFamilia(Familia familia) {
        this.familia = familia;
    }

    public Projeto getProjeto() {
        return projeto.clone();
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }

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

    public void putResposta(Integer key, String text) {
        Questao q = questoes.get(key);
        if (q != null){
            q.setResposta(text);
        }
    }
    
    public void setQuestoesDefault() throws SQLException{
        ArrayList<TipoQuestao> tipoQuestoes = questaoDAO.getAllAtive();
        questoes = new HashMap<>();
        for (TipoQuestao t : tipoQuestoes) {
            questoes.put(t.getId(), new Questao(t.getId() , t.getDescricao(), ""));
        }
    }

    public void setQuestoes(HashMap<Integer, Questao> questoes) 
    {   
        this.questoes = new HashMap<Integer, Questao>();
        for (Map.Entry<Integer, Questao> entrySet : questoes.entrySet()) {
            Integer key = entrySet.getKey();
            Questao value = entrySet.getValue();
            this.questoes.put(key, value);
        }
      }
            

    @Override
    public Candidatura clone()
    {
        return new Candidatura(this);
    }
    public String toString(){
        return new String(this.id+"."+this.estado+"."+this.rendimento);
    }
}