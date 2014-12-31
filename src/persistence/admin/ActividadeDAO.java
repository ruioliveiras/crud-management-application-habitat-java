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

/**
 *
 * @author ruioliveiras
 */
public class ActividadeDAO extends GenericDAO<TipoActividade>{

    public enum Attr{
        idAtividade, designacao
    }
    
    public ActividadeDAO() {
        super(Attr.values(), 1 , "Actividade");
    }

    
    
    @Override
    protected String getToBD(TipoActividade p, Enum<?> en) {
        Attr a = (Attr) en;
        switch(a){
            case idAtividade: return toSQL(p.getId());
            case designacao: return toSQL(p.getDescricao());
            default:
                return "";
        }
    }

    @Override
    public TipoActividade newObject(ResultSet rs) throws SQLException {
        return new TipoActividade(rs.getInt("idAtividade"),rs.getNString("designacao"));
    }
    
    
    public static void main(String[] args) throws NamingException, SQLException {
        GenericDAO.initConnection();
        ActividadeDAO adao = new ActividadeDAO();
        TipoActividade c = adao.getAll().get(4);
        adao.insert(new TipoActividade(-1, "Contrutor"));
        adao.update(new TipoActividade(4, "Contrutor"));
        adao.remove(c);
    }
}

//    
//    
//    @Override
//    public TipoActividade getById(int id) throws SQLException{
//        newStatement();
//        ResultSet rs = executeSelect("Select idAtividade, designacao from TipoActividade where idActividade = "+ id);
//        TipoActividade a = new TipoActividade(rs.getInt("idAtividade"),rs.getNString("designacao"));
//        closeStatemnet();
//        return a;
//    }
//
//    @Override
//    public ArrayList<Actividade> getAll()throws SQLException {
//        ArrayList<Actividade> list = new ArrayList<>();
//        newStatement();
//        ResultSet rs = executeSelect("Select idAtividade, designacao from TipoActividade");
//        while(rs.next()) {
//            TipoActividade a = new TipoActividade(rs.getInt("idAtividade"),rs.getNString("designacao"));
//            list.add(a);
//        }
//        closeStatemnet();
//        return list;
//    }
//
//    @Override
//    public void insert(TipoActividade obj)throws SQLException{
//        newStatement();
//        executeSQL("INSERT INTO TipoActividade(designacao)"
//                + "VALUES ('" + obj.getDescricao() +  "')");
//        closeStatemnet();
//    }
//
//    @Override
//    public void remove(TipoActividade obj) throws SQLException{
//        newStatement();
//        executeSQL("DELETE FROM TipoActividade WHERE idAtividade = " + obj.getId());
//        closeStatemnet();
//    }
//
//    @Override
//    public void update(TipoActividade obj)throws SQLException{
//        newStatement();
//        executeSQL("UPDATE TipoActividade SET designacao = '" + obj.getDescricao()+ "'"
//                + " where idAtividade = " + obj.getId());
//        closeStatemnet();
//    }