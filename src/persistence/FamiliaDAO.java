/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import business.familiy.Prestacao;
import business.familiy.Candidatura;
import business.familiy.ElementoFamilia;
import business.familiy.Familia;
import business.familiy.Questao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import persistence.util.GenericDAO;

public class FamiliaDAO extends GenericDAO<Familia> {

    protected enum Attr {

        idFam, nome, morada, telefone, nif, idFunc, dataNascimento, apelido, dataCriaFam
    };

    public FamiliaDAO() {
        super(Attr.values(), 1, "Familia");
    }

    protected String getToBD(Familia p, Enum<?> en) {
        Attr a = (Attr) en;
        switch (a) {
            case idFam:
                return toSQL(p.getId());
            case nome:
                return toSQL(p.getNomeRepresentante());
            case morada:
                return toSQL(p.getMoradaRepresentante());
            case telefone:
                return toSQL(p.getContactoRepresentate());
            case nif:
                return toSQL(p.getNif());
            case idFunc:
                return toSQL(p.getIdFunc());
            case dataNascimento:
                return toSQL(p.getDataNascimento());
            case apelido:
                return toSQL(p.getApelido());
            case dataCriaFam:
                return toSQL(p.getDataCriaFam());
            default:
                return toSQL((String) null);
        }
    }

    //preciso da lista dos attrs,
    //contruir por rs
    //aceder dinamicamente;
    public Familia newObject(ResultSet rs) throws SQLException {
        return new Familia(
                rs.getNString(Attr.nome.name()),
                rs.getString(Attr.telefone.name()),
                rs.getNString(Attr.morada.name()),
                rs.getInt(Attr.nif.name()),
                rs.getInt(Attr.idFunc.name()),
                rs.getInt(Attr.idFam.name()),
                fromSQL(rs.getDate(Attr.dataNascimento.name())),
                fromSQL(rs.getDate(Attr.dataCriaFam.name())),
                rs.getNString(Attr.apelido.name())
        );
    }

    public void insertAcompanhamento() {

    }

    public void alterarPrestacao(Prestacao p) throws SQLException {
        newStatement();
        executeSQL("INSERT INTO Prestacao (idFam, idFunc, valor, data) VALUES ("
                + toSQL(p.getIdFam()) + ", " + toSQL(p.getIdFunc()) + ", " + toSQL(p.getValor()) + ", NOW());");
        closeStatemnet();
    }

    public void mudarEstadoCand(String estado, int idCand) throws SQLException {
        newStatement();
        executeSQL("UPDATE Candidatura SET estado = '" + estado + "' WHERE idCand = " + idCand);
        closeStatemnet();
    }

    public void insertFamilia(Familia f) throws SQLException {
        int id;
        id = insert(f);
        insertCand(f.getCandidatura(), id);
        insertElementosFam(f.getElementosFamilia(), id);
    }

    protected void insertElementosFam(ArrayList<ElementoFamilia> elementosFamilia, int idFam) throws SQLException {
        newStatement();
        for (ElementoFamilia e : elementosFamilia) {
            executeSQL("INSERT INTO ElementoFamilia (idFamilia, nome, parentesco, dataNascimento,"
                    + " estadoCivil, ocupacao, escolaridade) VALUES(" + idFam + ", "
                    + toSQL(e.getNome()) + ", " + toSQL(e.getParentesco()) + ", " + toSQL(e.getDataNascimento())
                    + ", " + toSQL(e.getEstadoCivil()) + ", " + toSQL(e.getOcupacao())
                    + ", " + toSQL(e.getEscolaridade()) + ")");
        }
        closeStatemnet();
    }

    public void insertCand(Candidatura c, int idFam) throws SQLException {
        int id;

        newStatement();
        id = executeSQLWithId("INSERT INTO Candidatura (idFam, rendimento, dataCand) VALUES("
                + idFam + ", " + toSQL(c.getRendimento()) + ", " + toSQL(c.getDataCand()) + ")");
        closeStatemnet();
        insertQuestoes(c.getQuestoes(), id);
    }

    protected void insertQuestoes(HashMap<Integer, Questao> questoes, int idCand) throws SQLException {
        newStatement();
        for (Map.Entry<Integer, Questao> q : questoes.entrySet()) {
            executeSQL("INSERT INTO CandidaturaQuestao (idCan, idQuestao, resposta) VALUES("
                    + idCand + ", " + toSQL(q.getKey()) + ", " + toSQL(q.getValue().getResposta()) + ")");
        }
        closeStatemnet();
    }

    public ArrayList<Familia> getFamilias() throws SQLException {
        ArrayList<Familia> familias = new ArrayList<Familia>();

        newStatement();
        ResultSet rs = executeSelect("SELECT * FROM Familia");
        while (rs.next()) 
        {
            Familia f = new Familia(rs.getString("nome"), rs.getString("telefone"), rs.getString("morada"),
                    rs.getInt("nif"), rs.getInt("idFunc"), rs.getInt("idFam"),
                    fromSQL(rs.getDate("dataNascimento")), fromSQL(rs.getDate("dataCriaFam")),
                    rs.getString("apelido"));
            familias.add(f);
        }
      
        closeStatemnet();
        
        for (Familia familia : familias) {  
            familia.setCandidatura(this.getCandidatura(familia.getId()));         
            familia.setElementosFamilia(this.getElementosFamilia(familia.getId()));
        }
        return familias;
    }

    public Candidatura getCandidatura(int idFam) throws SQLException {
        Candidatura c = null;

        newStatement();
        ResultSet rs = executeSelect("SELECT * FROM Candidatura WHERE idFam = " + idFam
                + " ORDER BY dataCand DESC LIMIT 1");
        if (rs.next()) 
        {
            c = new Candidatura(fromSQL(rs.getDate("dataCand")), rs.getInt("rendimento"),
                    rs.getInt("idCand"), rs.getString("estado"));
        }
        
        closeStatemnet();
        if (c != null)
        c.setQuestoes(this.getQuestoes(c.getId()));
        return c;
    }

    public HashMap<Integer, Questao> getQuestoes(int idCand) throws SQLException {
        HashMap<Integer, Questao> q = new HashMap<Integer, Questao>();

        newStatement();
        ResultSet rs = executeSelect("SELECT CQ.idQuestao, CQ.resposta, QE.descricao "
                + "FROM CandidaturaQuestao AS CQ INNER JOIN Questao AS QE ON QE.idQuestao"
                + " = CQ.idQuestao WHERE idCand=" + idCand);
        while (rs.next()) {
            q.put(rs.getInt("idQuestao"), new Questao(rs.getString("resposta"), rs.getString("descricao")));
        }
        closeStatemnet();

        return q;
    }

    public ArrayList<ElementoFamilia> getElementosFamilia(int idFam) throws SQLException {
        ArrayList<ElementoFamilia> elems = new ArrayList<ElementoFamilia>();

        newStatement();
        ResultSet rs = executeSelect("SELECT * FROM ElementoFamilia "
                + "WHERE idFam=" + idFam);
        while (rs.next()) {
            elems.add(new ElementoFamilia(rs.getInt("idElemento"), rs.getString("nome"),
                    rs.getString("ocupacao"), rs.getString("parentesco"), rs.getString("escolaridade"),
                    rs.getString("estadoCivil"), fromSQL(rs.getDate("dataNascimento"))));
        }
        closeStatemnet();

        return elems;
    }

    public ArrayList<Candidatura> getCandidaturas() throws SQLException {
        ArrayList<Candidatura> candidaturas = new ArrayList<Candidatura>();

        newStatement();
        ResultSet rs = executeSelect("SELECT * FROM Candidatura");
        while (rs.next()) {
            Candidatura c = new Candidatura(fromSQL(rs.getDate("dataCand")), rs.getInt("rendimento"),
                    rs.getInt("idCand"), rs.getString("estado"));
            candidaturas.add(c);
        }

        closeStatemnet();
        
        for (Candidatura candidatura : candidaturas) {
            candidatura.setQuestoes(getQuestoes(rs.getInt("idCand")));
        }
        return candidaturas;
    }

//    @Override
//    public Familia getById(int id) throws SQLException{
//        newStatement();
//        ResultSet rs = executeQuery("Select * from Familia where id = "+ id);
//       /** Aqui contruir a familia utilizando os metodos:
//        * rs.getNString("nome coluna")
//        * ..
//        * entre outros
//        * 
//        * Familia f = new Familia(rs.getNString("nome"));
//        * */
//        closeStatemnet();
//    }
//
//    @Override
//    public ArrayList<Familia> getAll()throws SQLException {
//       newStatement();
//        ResultSet rs = executeQuery("Select * from Familia");
//        while(rs.next()) {
//            Familia f = new Familia(rs.getNString("nome"));
//            //Contruir Familias e adicioanr no array;
//        }
//        closeStatemnet();
//    }
//
//    @Override
//    public void insert(Familia obj)throws SQLException{
//        newStatement();
//        
//        ResultSet rs = executeQuery("INSERT INTO FAMILIA(..., comunas da familia) "
//                + "VALUES (" + obj.getNome()... +  "")");
//        closeStatemnet();
//    }
//
//    @Override
//    public void remove(Familia obj) throws SQLException{
//        newStatement();
//        executeQuery("REMOVE FROM FAMILIA WHERE idFam = " +  obj.getId());
//        closeStatemnet();
//    }
//
//    @Override
//    public void update(Familia obj)throws SQLException{
//        newStatement();
//        executeQuery("UPDATE FAMILIA SET NOME = "+ obj.getNome()...);
//        closeStatemnet();
//    }
    public static void main(String[] args) {
        FamiliaDAO fd = new FamiliaDAO();
        //testar o DAO aqui
    }
}
