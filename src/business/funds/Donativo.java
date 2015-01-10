package business.funds;

import java.sql.SQLException;
import java.util.GregorianCalendar;
import persistence.fundos.DoadorDAO;

public class Donativo {
    private static DoadorDAO doadorDAO = new DoadorDAO();
    
    private int idDon;
    private String descricao;
    private int quantInicial, quantAtual, idTipoDon;
    private GregorianCalendar dataDon;
    private int idFunc, idEv, idIndiv;

    public Donativo() {
        dataDon = new GregorianCalendar();
    }

    public Donativo(int idDon, String descricao, int quantInicial, int quantAtual, int idTipoDon, GregorianCalendar dataDon, int idFunc, int idEv, int idIndiv) {
        this.idDon = idDon;
        this.descricao = descricao;
        this.quantInicial = quantInicial;
        this.quantAtual = quantAtual;
        this.idTipoDon = idTipoDon;
        this.dataDon = dataDon;
        this.idFunc = idFunc;
        this.idEv = idEv;
        this.idIndiv = idIndiv;
    }

    public Donativo(Donativo d) {
        this.idDon = d.getIdDon();
        this.descricao = d.getDescricao();
        this.quantInicial = d.getQuantInicial();
        this.quantAtual = d.getQuantAtual();
        this.idTipoDon = d.getIdTipoDon();
        this.dataDon = d.getDataDon();
        this.idFunc = d.getIdFunc();
        this.idEv = d.getIdEv();
        this.idIndiv = d.getIdIndiv();
    }

    public GregorianCalendar getDataDon() {
        return dataDon;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getIdDon() {
        return idDon;
    }

    public int getIdEv() {
        return idEv;
    }

    public int getIdFunc() {
        return idFunc;
    }

    public int getIdIndiv() {
        return idIndiv;
    }

    public int getIdTipoDon() {
        return idTipoDon;
    }

    public int getQuantAtual() {
        return quantAtual;
    }

    public int getQuantInicial() {
        return quantInicial;
    }

    public void setDataDon(GregorianCalendar dataDon) {
        this.dataDon = dataDon;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setIdDon(int idDon) {
        this.idDon = idDon;
    }

    public void setIdEv(int idEv) {
        this.idEv = idEv;
    }

    public void setIdFunc(int idFunc) {
        this.idFunc = idFunc;
    }

    public void setIdIndiv(int idIndiv) {
        this.idIndiv = idIndiv;
    }

    public Doador getDoador() throws SQLException{
        return doadorDAO.getById(idIndiv);
    }
    
    public void setIdTipoDon(int idTipoDon) {
        this.idTipoDon = idTipoDon;
    }

    public void setQuantAtual(int quantAtual) {
        this.quantAtual = quantAtual;
    }

    public void setQuantInicial(int quantInicial) {
        this.quantInicial = quantInicial;
    }

    @Override
    public Donativo clone() {
        return new Donativo(this);
    }

    @Override
    public String toString() {
        return this.idDon + "." + this.descricao + "." + this.quantInicial;
    }

}
