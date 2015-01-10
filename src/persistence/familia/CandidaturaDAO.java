/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence.familia;

import business.building.Projeto;
import business.familiy.Candidatura;
import business.familiy.Questao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import org.eclipse.persistence.internal.jaxb.many.MapEntry;
import persistence.util.GenericDAO;
import persistence.util.KeyValue;

/**
 *
 * @author ruioliveiras
 */
public class CandidaturaDAO extends GenericDAO<Candidatura> {

    protected QuestaoDAO questaoDAO = new QuestaoDAO();

    protected enum Attr {

        idCand, idFam, dataCand, rendimento, estado
    };

    public CandidaturaDAO() {
        super(Attr.values(), 1, "Candidatura");
    }

    @Override
    protected String getToBD(Candidatura p, Enum<?> en) {
        Attr a = (Attr) en;
        switch (a) {
            case idCand:
                return toSQL(p.getId());
            case idFam:
                return toSQL(p.getFamilia().getId());
            case dataCand:
                return toSQL(p.getDataCand());
            case rendimento:
                return toSQL(p.getRendimento());
            case estado:
                return toSQL(p.getEstado().name());
            default:
                throw new AssertionError(a.name());

        }
    }

    @Override
    public int insert(Candidatura obj) throws SQLException {
        int ret = super.insert(obj); //To change body of generated methods, choose Tools | Templates.
        obj.setId(ret);
        for (Questao q : obj.getQuestoesList()) {
            KeyValue<Integer, Questao> qv = new KeyValue<>(obj.getId(), q);
            //martelada -.-
            questaoDAO.insertNoAuto(qv);
        }
        return ret;
    }

    @Override
    public int update(Candidatura obj) throws SQLException {
        super.update(obj); //To change body of generated methods, choose Tools | Templates.
        for (Questao q : obj.getQuestoesList()) {
            KeyValue<Integer, Questao> qv = new KeyValue<>(obj.getId(), q);
            if (questaoDAO.update(qv) == 0){
                 //martelada -.-
                questaoDAO.insertNoAuto(qv);
            }
        }
        return 0;
    }

    public void updateEstado(Candidatura obj) throws SQLException {
        newStatement();
        executeSQL("UPDATE Candidatura SET estado = '" + obj.getEstado() + "' WHERE idCand =" + obj.getId());
        closeStatemnet();
    }

    @Override
    public Candidatura newObject(ResultSet rs) throws SQLException {
        Candidatura.CandidaturaEstado estado;

        if (rs.getString("estado") != null) {
            estado = Candidatura.CandidaturaEstado.valueOf(rs.getString("estado"));
        } else {
            estado = Candidatura.CandidaturaEstado.PENDENTE;
        }

        return new Candidatura(
                fromSQL(rs.getDate("dataCand")),
                rs.getInt("rendimento"),
                rs.getInt("idCand"),
                estado
        );
    }

    @Override
    public void beforeReturn(List<Candidatura> a) throws SQLException {
        for (Candidatura c : a) {
            KeyValue<Integer, Questao> qv = new KeyValue<>(c.getId(), null);
            HashMap<Integer,Questao> map= new HashMap<>();
            for (KeyValue<Integer, Questao> a1 : this.questaoDAO.getAllBy(qv, QuestaoDAO.AttrQuestao.idCand)) {
                map.put(a1.getValue().getPerguntaId(), a1.getValue());
            }
            c.setQuestoes(map);
        }
    }

    public Candidatura getByIdFam(int idFam) throws SQLException {
        Candidatura c = null;

        newStatement();
        ResultSet rs = executeSelect("SELECT * FROM Candidatura WHERE idFam = " + idFam
                + " ORDER BY dataCand DESC LIMIT 1");
        if (rs.next()) {
            c = newObject(rs);
        }

        closeStatemnet();
        if (c != null) {
            beforeReturn(Arrays.asList(c));
        }
        return c;
    }
    
    public ArrayList<Candidatura> getAllByIdFam(int idFam) throws SQLException {
        ArrayList<Candidatura> c = new ArrayList<>();

        newStatement();
        ResultSet rs = executeSelect("SELECT * FROM Candidatura WHERE idFam = " + idFam
                + " ORDER BY dataCand");

        while (rs.next()) {
            c.add(newObject(rs));
        }

        closeStatemnet();
        beforeReturn(c);
        return c;
    }
    
    public ArrayList<Candidatura> getAprovadoSProjeto() throws SQLException {
        ArrayList<Candidatura> c = new ArrayList<>();

        newStatement();
        ResultSet rs = executeSelect("SELECT * From Candidatura WHERE Estado = "
                + "'APROVADO' AND  idCand NOT IN(SELECT idCand FROM Projeto);");
        
        while(rs.next()) {
            c.add(newObject(rs));
        }

        closeStatemnet();
        beforeReturn(c);
        return c;
    }
    
    public Candidatura getCandidaturaProjeto(Projeto p) throws SQLException {
        Candidatura c = null;

        newStatement();
        ResultSet rs = executeSelect("SELECT * From Candidatura WHERE idCand = " + p.getCandidaturaId());
        
        if(rs.next()) {
            c = newObject(rs);
        }

        closeStatemnet();
        return c;
    }

    public static class QuestaoDAO extends GenericDAO<KeyValue<Integer, Questao>> {

        public enum AttrQuestao {

            idCand, idQuestao, resposta
        }

        public QuestaoDAO() {
            super(AttrQuestao.values(), 2, "CandidaturaQuestao", "ViewCandidaturaQuestao");
        }
        
        @Override
        protected String getToBD(KeyValue<Integer, Questao> p, Enum<?> a) {
            AttrQuestao e = (AttrQuestao) a;
            switch (e) {
                case idCand:
                    return toSQL(p.getKey());
                case idQuestao:
                    return toSQL(p.getValue().getPerguntaId());
                case resposta:
                    return toSQL(p.getValue().getResposta());
            }
            return "";
        }

        @Override
        public KeyValue<Integer, Questao> newObject(ResultSet rs) throws SQLException {
            return new KeyValue<>(
                    rs.getInt("idCand"),
                    new Questao(rs.getInt("idQuestao"), rs.getString("questao"), rs.getString("resposta"))
            );
        }

    }

}
