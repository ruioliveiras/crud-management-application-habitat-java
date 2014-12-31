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
import business.admin.TipoQuestao;
import business.admin.TipoDonativo;

/**
 *
 * @author ruioliveiras
 */
public class TipoDonativoDAO extends GenericDAO<TipoDonativo>{
        
    public enum Attr{
       idTipoDon, designacao, unidade 
    }
    
    public TipoDonativoDAO() {
        super(Attr.values(), 1 , "TipoDonativo");
    }
    
    @Override
    protected String getToBD(TipoDonativo p, Enum<?> en) {
        Attr a = (Attr) en;
        switch(a){
            case idTipoDon: return toSQL(p.getId());
            case designacao: return toSQL(p.getDescricao());
            case unidade: return toSQL(p.getUnidade());
            default:
                return "";
        }
    }

    @Override
    public TipoDonativo newObject(ResultSet rs) throws SQLException {
        return new TipoDonativo(rs.getInt("idTipoDon"),rs.getNString("designacao"), rs.getNString("unidade"));
    }
  
    
    public static void main(String[] args) throws NamingException, SQLException {
        GenericDAO.initConnection();
        TipoDonativoDAO adao = new TipoDonativoDAO();
        TipoDonativo td = adao.getAll().get(4);
        adao.insert(new TipoDonativo(-1, "lixo","m2"));
        adao.update(new TipoDonativo(4, "Pareleo", "kg"));
        adao.remove(td);
//adao.update(new TipoDonativo(4, "Contrutor"));
    }
}

/**
 *   
    @Override
    public TipoDonativo getById(int id) throws SQLException{
        newStatement();
        ResultSet rs = executeSelect("Select idTipoDon, designacao, unidade from TipoDonativo where idTipoDonativo = "+ id);
        TipoDonativo a = new TipoDonativo(rs.getInt("idTipoDon"),rs.getNString("designacao"),rs.getNString("unidade"));
        closeStatemnet();
        return a;
    }

    @Override
    public ArrayList<TipoDonativo> getAll()throws SQLException {
        ArrayList<TipoDonativo> list = new ArrayList<>();
        newStatement();
        ResultSet rs = executeSelect("Select idTipoDon, designacao, unidade from TipoDonativo");
        while(rs.next()) {
            TipoDonativo a = new TipoDonativo(rs.getInt("idTipoDon"),rs.getNString("designacao"),rs.getNString("unidade"));
            list.add(a);
        }
        closeStatemnet();
        return list;
    }

    @Override
    public void insert(TipoDonativo obj)throws SQLException{
        newStatement();
        executeSQL("INSERT INTO TipoDonativo(designacao,unidade)"
                + "VALUES ("
                + "'" + obj.getDescricao() +  "',"
                + "'"+ obj.getUnidade() +"')");
        closeStatemnet();
    }

    @Override
    public void remove(TipoDonativo obj) throws SQLException{
        newStatement();
        executeSQL("DELETE FROM TipoDonativo WHERE idTipoDon = " + obj.getId());
        closeStatemnet();
    }

    @Override
    public void update(TipoDonativo obj)throws SQLException{
        newStatement();
        executeSQL("UPDATE TipoDonativo SET "
                + "designacao = '" + obj.getDescricao()+ "', "
                + "unidade = '" + obj.getUnidade() + "' " 
                + "where idTipoDon = " + obj.getId());
        closeStatemnet();
    }
 * 
 */