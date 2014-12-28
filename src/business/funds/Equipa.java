package business.funds;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Equipa implements Voluntariado {
    private String designacao;
    private String nacionalidade;
    private GregorianCalendar dataCriaEq;
    private ArrayList<Voluntario> voluntarios;

    public Equipa(String designacao, String nacionalidade, GregorianCalendar dataCriaEq, 
            ArrayList<Voluntario> voluntarios) {
        this.designacao = designacao;
        this.nacionalidade = nacionalidade;
        this.dataCriaEq = dataCriaEq;
        this.voluntarios = new ArrayList<Voluntario>();
        for(Voluntario d : voluntarios)
            this.voluntarios.add(d);
    }

    public Equipa(Equipa e) {
        this.designacao = e.getDesignacao();
        this.nacionalidade = e.getNacionalidade();
        this.dataCriaEq = e.getDataCriaEq();
        this.voluntarios = e.getVoluntarios();
    }

    public ArrayList<Voluntario> getVoluntarios() 
    {
        ArrayList<Voluntario> ret = new ArrayList<Voluntario>();
        
        for(Voluntario v : this.voluntarios)
            ret.add(v);
        
        return ret;
    }

    public void setVoluntarios(ArrayList<Voluntario> voluntarios) 
    {
        this.voluntarios.clear();
        
        for(Voluntario v : voluntarios)
            this.voluntarios.add(v);
    }
    
    
    public void addVoluntario(Voluntario v) {
        voluntarios.add(v.clone());
    }
    

    public String getDesignacao() {
        return designacao;
    }

    public void setDesignacao(String designacao) {
        this.designacao = designacao;
    }
    
    
    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    
    public GregorianCalendar getDataCriaEq() {
        return dataCriaEq;
    }

    public void setDataCriaEq(GregorianCalendar dataCriaEq) {
        this.dataCriaEq = dataCriaEq;
    }
    
    public Equipa clone()
    {
        return new Equipa(this);
    }

}