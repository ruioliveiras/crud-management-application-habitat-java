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

/**
 *
 * @author ruioliveiras
 */
public class ActividadeDAO extends GenericDAO<Actividade>{

    public enum Attr{
        idAtividade, designacao
    }
    
    public ActividadeDAO() {
        super(Attr.values(), 1 , "Actividade");
    }

    
    
    @Override
    protected String getToBD(Actividade p, Enum<?> en) {
        Attr a = (Attr) en;
        switch(a){
            case idAtividade: return toSQL(p.getId());
            case designacao: return toSQL(p.getDescricao());
            default:
                return "";
        }
    }

    @Override
    public Actividade newObject(ResultSet rs) throws SQLException {
        return new Actividade(rs.getInt("idAtividade"),rs.getNString("designacao"));
    }
    
    
    public static void main(String[] args) throws NamingException, SQLException {
        GenericDAO.initConnection();
        ActividadeDAO adao = new ActividadeDAO();
        Actividade c = adao.getAll().get(4);
        adao.insert(new Actividade(-1, "Contrutor"));
        adao.update(new Actividade(4, "Contrutor"));
        adao.remove(c);
    }
}

//    
//    
//    @Override
//    public Actividade getById(int id) throws SQLException{
//        newStatement();
//        ResultSet rs = executeSelect("Select idAtividade, designacao from Actividade where idActividade = "+ id);
//        Actividade a = new Actividade(rs.getInt("idAtividade"),rs.getNString("designacao"));
//        closeStatemnet();
//        return a;
//    }
//
//    @Override
//    public ArrayList<Actividade> getAll()throws SQLException {
//        ArrayList<Actividade> list = new ArrayList<>();
//        newStatement();
//        ResultSet rs = executeSelect("Select idAtividade, designacao from Actividade");
//        while(rs.next()) {
//            Actividade a = new Actividade(rs.getInt("idAtividade"),rs.getNString("designacao"));
//            list.add(a);
//        }
//        closeStatemnet();
//        return list;
//    }
//
//    @Override
//    public void insert(Actividade obj)throws SQLException{
//        newStatement();
//        executeSQL("INSERT INTO Actividade(designacao)"
//                + "VALUES ('" + obj.getDescricao() +  "')");
//        closeStatemnet();
//    }
//
//    @Override
//    public void remove(Actividade obj) throws SQLException{
//        newStatement();
//        executeSQL("DELETE FROM Actividade WHERE idAtividade = " + obj.getId());
//        closeStatemnet();
//    }
//
//    @Override
//    public void update(Actividade obj)throws SQLException{
//        newStatement();
//        executeSQL("UPDATE Actividade SET designacao = '" + obj.getDescricao()+ "'"
//                + " where idAtividade = " + obj.getId());
//        closeStatemnet();
//    }