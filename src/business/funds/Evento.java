package business.funds;

import business.funds.Donativo;
import java.util.ArrayList;
import java.util.GregorianCalendar;


public class Evento {
	private String designacao;
	private GregorianCalendar data;
	private String descricao;
	private ArrayList<Donativo> donativos;

    public Evento(String designacao, GregorianCalendar data, String descricao, 
            ArrayList<Donativo> donativos) {
        this.designacao = designacao;
        this.data = data;
        this.descricao = descricao;
        this.donativos = new ArrayList<Donativo>();
        for(Donativo d : donativos)
            this.donativos.add(d);
    }

    public Evento(Evento e) {
        designacao = e.getDesignacao();
        data = e.getData();
        descricao = e.getDescricao();
        donativos = e.getDonativos();
    }
    
    
    public void addDonativo(Donativo d)
    {
        donativos.add(d.clone());
    }
    
    
    public String getDesignacao() {
        return designacao;
    }

    public void setDesignacao(String designacao) {
        this.designacao = designacao;
    }

    public GregorianCalendar getData() {
        return data;
    }

    public void setData(GregorianCalendar data) {
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public ArrayList<Donativo> getDonativos() 
    {
        ArrayList<Donativo> ret = new ArrayList<Donativo>();
        
        for(Donativo d : this.donativos)
            ret.add(d);
        return ret;
    }

    public void setDonativos(ArrayList<Donativo> donativos) 
    {
        this.donativos.clear();
        
        for(Donativo d : donativos)
            this.donativos.add(d);
    }
    
    public Evento clone()
    {
        return new Evento(this);
    }
        
        
}