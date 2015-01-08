package business.funds;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import persistence.fundos.EquipaDAO;

public class Equipa implements Voluntariado {

    private int idEq;
    private String nacionalidadeEq, designacao;
    private GregorianCalendar dataCriaEq;
    private int idFunc;

    public Equipa() {
        dataCriaEq = new GregorianCalendar();
    }

    public Equipa(int idEq, String nacionalidadeEq, String designacao, GregorianCalendar dataCriaEq, int idFunc) {
        this.idEq = idEq;
        this.nacionalidadeEq = nacionalidadeEq;
        this.designacao = designacao;
        this.dataCriaEq = dataCriaEq;
        this.idFunc = idFunc;
    }

    public Equipa(Equipa e) {
        this.idEq = e.getIdEq();
        this.nacionalidadeEq = e.getNacionalidadeEq();
        this.designacao = e.getDesignacao();
        this.dataCriaEq = e.getDataCriaEq();
        this.idFunc = e.getIdFunc();
    }

    public ArrayList<Voluntario> getMembros() throws SQLException {
        EquipaDAO ed = new EquipaDAO();
        return ed.getMembros(this.idEq);
    }

    public GregorianCalendar getDataCriaEq() {
        return dataCriaEq;
    }

    public String getDesignacao() {
        return designacao;
    }

    public int getIdEq() {
        return idEq;
    }

    public int getIdFunc() {
        return idFunc;
    }

    public String getNacionalidadeEq() {
        return nacionalidadeEq;
    }

    public void setDataCriaEq(GregorianCalendar dataCriaEq) {
        this.dataCriaEq = dataCriaEq;
    }

    public void setDesignacao(String designacao) {
        this.designacao = designacao;
    }

    public void setIdEq(int idEq) {
        this.idEq = idEq;
    }

    public void setIdFunc(int idFunc) {
        this.idFunc = idFunc;
    }

    public void setNacionalidadeEq(String nacionalidadeEq) {
        this.nacionalidadeEq = nacionalidadeEq;
    }

    public Equipa clone() {
        return new Equipa(this);
    }

    public String toString() {
        return new String(this.idEq + "." + this.nacionalidadeEq + "." + this.designacao);
    }
}
