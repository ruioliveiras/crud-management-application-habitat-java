/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence.admin;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.naming.NamingException;
import persistence.util.GenericDAO;
import business.admin.Actividade;
import business.admin.Questao;
import business.admin.Questao;

/**
 *
 * @author ruioliveiras
 */
public class QuestaoDAO extends GenericDAO<Questao>{
    
    public enum Attr{
       idQuestao, descricao, ativa 
    }
    
    public QuestaoDAO() {
        super(Attr.values(), 1 , "Questao");
    }

    
    
    @Override
    protected String getToBD(Questao p, Enum<?> en) {
        Attr a = (Attr) en;
        switch(a){
            case idQuestao: return toSQL(p.getId());
            case descricao: return toSQL(p.getDescricao());
            case ativa: return toSQL(p.isAtiva());
            default:
                return "";
        }
    }

    @Override
    public Questao newObject(ResultSet rs) throws SQLException {
        return new Questao(rs.getInt("idQuestao"),rs.getNString("descricao"), rs.getBoolean("ativa"));
    }
    
    public static void main(String[] args) throws NamingException, SQLException {
        GenericDAO.initConnection();
        QuestaoDAO adao = new QuestaoDAO();
        Questao q = adao.getAll().get(6);
        adao.insert(new Questao(-1, "Vosse esta disposto a ter uma casa?",false));
        adao.update(new Questao(4, "Contrutor", true));
        adao.remove(q);
    }
}


//    
//    
//    @Override
//    public Questao getById(int id) throws SQLException{
//        newStatement();
//        ResultSet rs = executeSelect("Select idQuestao, designacao, true as ativa from Questao where idQuestao = "+ id);
//        Questao a = new Questao(rs.getInt("idQuestao"),rs.getNString("designacao"),rs.getBoolean("ativa"));
//        closeStatemnet();
//        return a;
//    }
//
//    @Override
//    public ArrayList<Questao> getAll()throws SQLException {
//        ArrayList<Questao> list = new ArrayList<>();
//        newStatement();
//        ResultSet rs = executeSelect("Select idQuestao, designacao, true as ativa from Questao");
//        while(rs.next()) {
//            Questao a = new Questao(rs.getInt("idQuestao"),rs.getNString("designacao"), rs.getBoolean("ativa"));
//            list.add(a);
//        }
//        closeStatemnet();
//        return list;
//    }
//
//    @Override
//    public void insert(Questao obj)throws SQLException{
//        newStatement();
//        executeSQL("INSERT INTO Questao(designacao, ativa)"
//                + "VALUES ('" + obj.getDescricao() +  "',"+ obj.isAtiva()+")");
//        closeStatemnet();
//    }
//
//    @Override
//    public void remove(Questao obj) throws SQLException{
//        newStatement();
//        executeSQL("DELETE FROM Questao WHERE idQuestao = " + obj.getId());
//        closeStatemnet();
//    }
//
//    @Override
//    public void update(Questao obj)throws SQLException{
//        newStatement();
//        executeSQL("UPDATE Questao SET "
//                + "designacao = '" + obj.getDescricao()+ "', "
//                + "ativa = " + obj.isAtiva()+ " "
//                + " where idQuestao = " + obj.getId());
//        closeStatemnet();
//    }
//    