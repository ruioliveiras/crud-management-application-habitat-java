package business.familiy;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import business.admin.Questao;
import business.building.Projeto;


public class Candidatura 
{
    private GregorianCalendar dataCand;
    private int rendimento, id;
    private String estado;
    private Familia familia;
    private Projeto projeto;
    private HashMap<Integer, Questao> questoes;

    public Candidatura(GregorianCalendar dataCand, int rendimento, int id, 
            String estado, Familia familia, Projeto projeto, HashMap<Integer, Questao> questoes) {
        this.dataCand = dataCand;
        this.rendimento = rendimento;
        this.id = id;
        this.estado = estado;
        this.familia = familia;
        this.projeto = projeto;
        this.questoes = new HashMap<Integer, Questao>();
        for(Map.Entry<Integer, Questao> e : questoes.entrySet())
            this.questoes.put(e.getKey(), e.getValue());
    }
    
    public Candidatura(Candidatura c) 
    {
        this.dataCand = c.getDataCand();
        this.rendimento = c.getRendimento();
        this.id = c.getId();
        this.estado = c.getEstado();
        this.familia = c.getFamilia();
        this.projeto = c.getProjeto();
        this.questoes = c.getQuestoes();
    }
    

    public GregorianCalendar getDataCand() {
        return dataCand;
    }

    public void setDataCand(GregorianCalendar dataCand) {
        this.dataCand = dataCand;
    }

    public int getRendimento() {
        return rendimento;
    }

    public void setRendimento(int rendimento) {
        this.rendimento = rendimento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Familia getFamilia() {
        return familia.clone();
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
        HashMap<Integer, Questao> q = new HashMap<Integer, Questao>();
        
        for(Map.Entry<Integer, Questao> entry : this.questoes.entrySet()) 
        {
            q.put(entry.getKey(), entry.getValue());
        }
        
        return q;
    }

    public void setQuestoes(HashMap<Integer, Questao> questoes) 
    {   
        this.questoes.clear();
        for(Map.Entry<Integer, Questao> e : this.questoes.entrySet())
            this.questoes.put(e.getKey(), e.getValue());
    }

    @Override
    public Candidatura clone()
    {
        return new Candidatura(this);
    }
    
}