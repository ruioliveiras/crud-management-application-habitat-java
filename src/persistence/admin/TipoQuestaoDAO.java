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
import business.admin.TipoActividade;
import business.admin.TipoQuestao;
import business.admin.TipoQuestao;

/**
 *
 * @author ruioliveiras
 */
public class TipoQuestaoDAO extends GenericDAO<TipoQuestao>{
    
    public enum Attr{
       idQuestao, descricao, ativa 
    }
    
    public TipoQuestaoDAO() {
        super(Attr.values(), 1 , "Questao");
    }

    
    public ArrayList<TipoQuestao> getAllAtive() throws SQLException {
        TipoQuestao t = new TipoQuestao();
        t.setAtiva(true);
        return getAllBy(t, Attr.ativa);
    }
    
    @Override
    protected String getToBD(TipoQuestao p, Enum<?> en) {
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
    public TipoQuestao newObject(ResultSet rs) throws SQLException {
        return new TipoQuestao(rs.getInt("idQuestao"),rs.getNString("descricao"), rs.getBoolean("ativa"));
    }
    
    public static void main(String[] args) throws NamingException, SQLException {
        GenericDAO.initConnection();
        TipoQuestaoDAO adao = new TipoQuestaoDAO();
        TipoQuestao q = adao.getAll().get(6);
        adao.insert(new TipoQuestao(-1, "Vosse esta disposto a ter uma casa?",false));
        adao.update(new TipoQuestao(4, "Contrutor", true));
        adao.remove(q);
    }
}


//    
//    
//    @Override
//    public TipoQuestao getById(int id) throws SQLException{
//        newStatement();
//        ResultSet rs = executeSelect("Select idQuestao, designacao, true as ativa from TipoQuestao where idQuestao = "+ id);
//        TipoQuestao a = new TipoQuestao(rs.getInt("idQuestao"),rs.getNString("designacao"),rs.getBoolean("ativa"));
//        closeStatemnet();
//        return a;
//    }
//
//    @Override
//    public ArrayList<Questao> getAll()throws SQLException {
//        ArrayList<Questao> list = new ArrayList<>();
//        newStatement();
//        ResultSet rs = executeSelect("Select idQuestao, designacao, true as ativa from TipoQuestao");
//        while(rs.next()) {
//            TipoQuestao a = new TipoQuestao(rs.getInt("idQuestao"),rs.getNString("designacao"), rs.getBoolean("ativa"));
//            list.add(a);
//        }
//        closeStatemnet();
//        return list;
//    }
//
//    @Override
//    public void insert(TipoQuestao obj)throws SQLException{
//        newStatement();
//        executeSQL("INSERT INTO TipoQuestao(designacao, ativa)"
//                + "VALUES ('" + obj.getDescricao() +  "',"+ obj.isAtiva()+")");
//        closeStatemnet();
//    }
//
//    @Override
//    public void remove(TipoQuestao obj) throws SQLException{
//        newStatement();
//        executeSQL("DELETE FROM TipoQuestao WHERE idQuestao = " + obj.getId());
//        closeStatemnet();
//    }
//
//    @Override
//    public void update(TipoQuestao obj)throws SQLException{
//        newStatement();
//        executeSQL("UPDATE TipoQuestao SET "
//                + "designacao = '" + obj.getDescricao()+ "', "
//                + "ativa = " + obj.isAtiva()+ " "
//                + " where idQuestao = " + obj.getId());
//        closeStatemnet();
//    }
//    