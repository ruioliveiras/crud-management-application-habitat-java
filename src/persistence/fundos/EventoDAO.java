package persistence.fundos;

import business.funds.Evento;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import persistence.util.DAO;

public class EventoDAO  extends DAO<Evento> {

    @Override
    public Evento getById(int id) throws SQLException {
        newStatement();
        ResultSet rs = executeSelect("Select * from Evento where idEv = "+ id);
        Evento r = newObj(rs);
       
        closeStatemnet();
        
        return r;    }

    @Override
    public ArrayList<Evento> getAll() throws SQLException {
        newStatement();
        ArrayList<Evento> r = new ArrayList<>();
       
        ResultSet rs = executeSelect("Select * from Evento");
        while(rs.next()) {
            Evento e = newObj(rs);
            
            r.add(e);
        }
        closeStatemnet();
        
        return r;    }

    @Override
    public int insert(Evento e) throws SQLException {
        newStatement();
        
        int i = executeSQLWithId("INSERT INTO Evento(designacao, data, idFunc, descricao) VALUES (" +
                                    toSQL(e.getDesignacao()) + "," + 
                                    toSQL(e.getData()) + "," + 
                                    toSQL(e.getIdFunc()) + "," + 
                                    toSQL(e.getDescricao()) + ")") ;
        closeStatemnet();
        return i;
    }

    @Override
    public void remove(Evento d) throws SQLException {
        newStatement();
        executeSQL("DELETE FROM Evento WHERE idEv = " +  d.getIdEv());
        closeStatemnet();    
    }

    @Override
    public void update(Evento e) throws SQLException {
        newStatement();
        executeSQL("UPDATE Evento SET " +
                "designacao=" + toSQL(e.getDesignacao()) + 
                ", data=" + toSQL(e.getData()) +
                ", idfunc=" + toSQL(e.getIdFunc()) + 
                ", descricao=" + toSQL(e.getDescricao()) +
                " Where idEv=" + toSQL(e.getIdEv())
        );
        closeStatemnet();
    }
    
    public Evento newObj(ResultSet rs) throws SQLException{
        return new Evento(
            rs.getInt("idEv"),
            rs.getNString("designacao"),
            fromSQL(rs.getDate("data")),
            rs.getInt("idFunc"),
            rs.getNString("descricao")
        );
    }
}
