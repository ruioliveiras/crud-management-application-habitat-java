package persistence.fundos;

import business.funds.Donativo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import persistence.util.DAO;



public class DonativoDAO extends DAO<Donativo> {

    @Override
    public Donativo getById(int id) throws SQLException{
        newStatement();
        ResultSet rs = executeSelect("Select * from Donativo where idDon = "+ id);
        closeStatemnet();
        
        return newObject(rs);
    }

    @Override
    public ArrayList<Donativo> getAll()throws SQLException {
        ArrayList<Donativo> r = new ArrayList<>();
        newStatement();
        
        ResultSet rs = executeSelect("Select * from Donativo");
        while(rs.next()) {
            r.add(newObject(rs));
        }
        closeStatemnet();
        
        return r;
    }

    @Override
    public int insert(Donativo d) throws SQLException {
        newStatement();
        
        int i = executeSQLWithId("INSERT INTO FAMILIA(idDon, descricao, quantInicial, quantAtual, idTipoDon, dataDon, idFunc, idEv, idIndiv) VALUES (" + 
                                    toSQL(d.getIdDon()) + "," + 
                                    toSQL(d.getDescricao()) + "," + 
                                    toSQL(d.getQuantInicial()) + "," + 
                                    toSQL(d.getQuantAtual()) + "," + 
                                    toSQL(d.getIdTipoDon()) + "," + 
                                    toSQL(d.getDataDon()) + "," + 
                                    toSQL(d.getIdFunc()) + "," + 
                                    toSQL(d.getIdEv()) + "," + 
                                    toSQL(d.getIdIndiv()) + ")");
        closeStatemnet();
        
        return i;
    }
    
    
   
    @Override
    public void update(Donativo d)throws SQLException{
        newStatement();
        executeSQL("UPDATE Donativo SET  " +
                "descricao=" + toSQL(d.getDescricao()) + 
                ", quantInicial=" + toSQL(d.getQuantInicial()) +
                ", quantAtual=" + toSQL(d.getQuantAtual()) + 
                ", isTipoDon=" + toSQL(d.getIdTipoDon()) + 
                ", dataDon=" + toSQL(d.getDataDon()) +
                ", idFunc=" + toSQL(d.getIdFunc()) + 
                ", idEv=" + toSQL(d.getIdEv()) + 
                ", idIndiv=" + toSQL(d.getIdIndiv()) +
                " WHERE idDon=" + toSQL(d.getIdDon()));
        closeStatemnet();
    }
    

    @Override
    public void remove(Donativo d) throws SQLException{
        newStatement();
        executeSQL("DELETE FROM DONATIVO WHERE idDon = " +  d.getIdDon());
        closeStatemnet();
    }
    
    //@Override
    public Donativo newObject(ResultSet rs) throws SQLException{
        return new Donativo(
            rs.getInt("idDon"),
            rs.getNString("descricao"),           
            rs.getInt("quantInicial"),
            rs.getInt("quantAtual"),
            rs.getInt("idTipoDon"),
            fromSQL(rs.getDate("dataDon")),
            rs.getInt("idFunc"),
            rs.getInt("idEv"),
            rs.getInt("idIndiv")
        );
    }

}