package business.funds;

import java.util.GregorianCalendar;

public class Evento{
    private int idEv;
    private String designacao;
    private GregorianCalendar data;
    private int idFunc;
    private String descricao;

    public Evento(int idEv, String designacao, GregorianCalendar data, int idFunc, String descricao) {
        this.idEv = idEv;
        this.designacao = designacao;
        this.data = data;
        this.idFunc = idFunc;
        this.descricao = descricao;
    }
    
    public Evento(Evento e) {
        this.idEv = e.getIdEv();
        this.designacao = e.getDesignacao();
        this.data = e.getData();
        this.idFunc = e.getIdFunc();
        this.descricao = e.getDescricao();
    }    

    public GregorianCalendar getData() {
        return data;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getDesignacao() {
        return designacao;
    }

    public int getIdEv() {
        return idEv;
    }

    public int getIdFunc() {
        return idFunc;
    }

    public void setData(GregorianCalendar data) {
        this.data = data;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setDesignacao(String designacao) {
        this.designacao = designacao;
    }

    public void setIdEv(int idEv) {
        this.idEv = idEv;
    }

    public void setIdFunc(int idFunc) {
        this.idFunc = idFunc;
    }
    
    public Evento clone() {
        return new Evento(this);
    }
    
    public String toString(){
        return new String(this.idEv+"."+this.designacao+"."+this.descricao);
    }
}