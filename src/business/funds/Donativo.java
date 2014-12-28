package business.funds;

import java.util.GregorianCalendar;
import persistence.DoadorDAO;

public class Donativo {
    private static DoadorDAO doadorDAO = new DoadorDAO();
            
    private int quantidade, quantidadeActual;
    private GregorianCalendar data;
    private String unidade, descricao, designacao;
    private GregorianCalendar dataDoacao;
    /*public Pessoa pessoa;
     public Empresa empresa;*/
    public boolean ismaterial;
    private Evento evento;
    /*public DonativoDAOunnamed_DonativoDAO;
     public Tipo_de_Donativo tipoDon;
     private DoadorDAO doadorDao;*/

    public Donativo(int quantidade, int quantidadeActual, GregorianCalendar data,
            String unidade, String descricao, String designacao,
            GregorianCalendar dataDoacao, Evento angaria, boolean ismaterial) {
        this.quantidade = quantidade;
        this.quantidadeActual = quantidadeActual;
        this.data = data;
        this.unidade = unidade;
        this.descricao = descricao;
        this.designacao = designacao;
        this.dataDoacao = dataDoacao;
        this.ismaterial = ismaterial;
        /*this._unnamed_DonativoDAO_ =unnamed_DonativoDAO;
         this.tipoDon = tipoDon;
         this.doadorDao = doadorDao;*/
    }

    public Donativo(Donativo d) {
        this.quantidade = d.getQuantidade();
        this.quantidadeActual = d.getQuantidadeActual();
        this.data = d.getData();
        this.unidade = d.getUnidade();
        this.descricao = d.getDescricao();
        this.designacao = d.getDesignacao();
        this.dataDoacao = d.getDataDoacao();
        /*this._unnamed_DonativoDAO_ =unnamed_DonativoDAO;
         this.tipoDon = tipoDon;
         this.doadorDao = doadorDao;*/
    }

    public boolean ismaterial() {
        return ismaterial;
    }

    public void setEventos(Evento eventos) {
        this.evento = eventos;
    }

    public Evento getEventos() {
        return evento.clone();
    }

    public void setIsmaterial(boolean ismaterial) {
        this.ismaterial = ismaterial;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getQuantidadeActual() {
        return quantidadeActual;
    }

    public void setQuantidadeActual(int quantidadeActual) {
        this.quantidadeActual = quantidadeActual;
    }

    public GregorianCalendar getData() {
        return data;
    }

    public void setData(GregorianCalendar data) {
        this.data = data;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDesignacao() {
        return designacao;
    }

    public void setDesignacao(String designacao) {
        this.designacao = designacao;
    }

    public GregorianCalendar getDataDoacao() {
        return dataDoacao;
    }

    public void setDataDoacao(GregorianCalendar dataDoacao) {
        this.dataDoacao = dataDoacao;
    }

    public Donativo clone() {
        return new Donativo(this);
    }

}
