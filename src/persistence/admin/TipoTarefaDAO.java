/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence.admin;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.NamingException;
import persistence.util.GenericDAO;
import business.admin.TipoTarefa;

/**
 *
 * @author ruioliveiras
 */
public class TipoTarefaDAO extends GenericDAO<TipoTarefa>{
    
    public enum Attr{
        idTar, designacao
    }
    
    public TipoTarefaDAO() {
        super(Attr.values(), 1 , "Tarefa");
    }

    
    
    @Override
    protected String getToBD(TipoTarefa p, Enum<?> en) {
        Attr a = (Attr) en;
        switch(a){
            case idTar: return toSQL(p.getId());
            case designacao: return toSQL(p.getDescricao());
            default:
                return "";
        }
    }

    @Override
    public TipoTarefa newObject(ResultSet rs) throws SQLException {
        return new TipoTarefa(rs.getInt("idTar"),rs.getNString("designacao"));
    }
   
    public static void main(String[] args) throws NamingException, SQLException {
        GenericDAO.initConnection();
        TipoTarefaDAO adao = new TipoTarefaDAO();
        TipoTarefa c = adao.getAll().get(5);
        adao.insert(new TipoTarefa(-1, "Contruir parede"));
        adao.update(new TipoTarefa(4, "Contriuir ou destruir"));
        adao.remove(c);
    }
}


/**
 * 
 * 
 *  
    @Override
    public TipoTarefa getById(int id) throws SQLException{
        newStatement();
        ResultSet rs = executeSelect("Select idTar, designacao from Tarefa where idTipoTarefa = "+ id);
        TipoTarefa a = new TipoTarefa(rs.getInt("idTar"),rs.getNString("designacao"));
        closeStatemnet();
        return a;
    }

    @Override
    public ArrayList<TipoTarefa> getAll()throws SQLException {
        ArrayList<TipoTarefa> list = new ArrayList<>();
        newStatement();
        ResultSet rs = executeSelect("Select idTar, designacao from Tarefa");
        while(rs.next()) {
            TipoTarefa a = new TipoTarefa(rs.getInt("idTar"),rs.getNString("designacao"));
            list.add(a);
        }
        closeStatemnet();
        return list;
    }

    @Override
    public void insert(TipoTarefa obj)throws SQLException{
        newStatement();
        executeSQL("INSERT INTO Tarefa(designacao)"
                + "VALUES ('" + obj.getDescricao() +  "')");
        closeStatemnet();
    }

    @Override
    public void remove(TipoTarefa obj) throws SQLException{
        newStatement();
        executeSQL("DELETE FROM Tarefa WHERE idTar = " + obj.getId());
        closeStatemnet();
    }

    @Override
    public void update(TipoTarefa obj)throws SQLException{
        newStatement();
        executeSQL("UPDATE Tarefa SET designacao = '" + obj.getDescricao()+ "'"
                + " where idTar = " + obj.getId());
        closeStatemnet();
    }
    
    * 
 */