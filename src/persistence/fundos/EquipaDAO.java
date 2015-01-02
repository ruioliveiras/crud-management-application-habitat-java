/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence.fundos;

import business.building.VoluntariadoRealizado;
import business.funds.Equipa;
import business.funds.Voluntariado;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import persistence.util.DAO;

/**
 *
 * @author ruioliveiras
 */
public class EquipaDAO extends DAO<Equipa>{

    @Override
    public Equipa getById(int id) throws SQLException {
        newStatement();
        ResultSet rs = executeSelect("Select * from Equipa where idEq = "+ id);
        Equipa r = newObj(rs);
       
        closeStatemnet();
        
        return r;    }

    @Override
    public ArrayList<Equipa> getAll() throws SQLException {
        newStatement();
        ArrayList<Equipa> r = new ArrayList<>();
       
        ResultSet rs = executeSelect("Select * from Equipa");
        while(rs.next()) {
            Equipa e = newObj(rs);
            
            r.add(e);
        }
        closeStatemnet();
        
        return r;    }

    
    public ArrayList<VoluntariadoRealizado> getByTarefa(int idProj, int idTar) throws SQLException {
        newStatement();
        ArrayList<VoluntariadoRealizado> r = new ArrayList<>();
       
        ResultSet rs = executeSelect("Select i.*,dataTrabalho, duracao from Equipa i inner join EquipaTarefaProjeto itp on itp.idEq = i.idEq "
                        + " where itp.idProj = " + idProj + " and itp.idTar = "+ idTar);
        while(rs.next()) {
            VoluntariadoRealizado vr = new VoluntariadoRealizado(
                    newObj(rs),
                    fromSQL(rs.getDate("dataTrabalho")),
                    rs.getInt("duracao")
            );
            r.add(vr);
        }
        closeStatemnet();
        
        return r;    
    }
    
    @Override
    public int insert(Equipa e) throws SQLException {
        newStatement();
        
        int i = executeSQLWithId("INSERT INTO Equipa(idEq, nacionalidadeEq, designacao, dataCriaEq, idfunc) VALUES (" +
                                    toSQL(e.getIdEq()) + "," + 
                                    toSQL(e.getNacionalidadeEq()) + "," + 
                                    toSQL(e.getDesignacao()) + "," + 
                                    toSQL(e.getDataCriaEq()) + "," + 
                                    toSQL(e.getIdFunc()));
        closeStatemnet();
        return i;
    }

    @Override
    public void remove(Equipa d) throws SQLException {
        newStatement();
        executeSQL("DELETE FROM Equipa WHERE idEq = " +  d.getIdEq());
        closeStatemnet();    
    }

    @Override
    public void update(Equipa e) throws SQLException {
        newStatement();
        executeSQL("UPDATE Equipa SET " +
                "nacionalidadeEq=" + toSQL(e.getNacionalidadeEq()) + 
                ", designacao=" + toSQL(e.getDesignacao()) + 
                ", dataCriaEq=" + toSQL(e.getDataCriaEq()) +
                ", idfunc=" + toSQL(e.getIdFunc()) + 
                " Where idEq=" + toSQL(e.getIdEq())
        );
        closeStatemnet();
    }
    
    public Equipa newObj(ResultSet rs) throws SQLException{
        return new Equipa(
            rs.getInt("idEq"),
            rs.getNString("nacionalidadeEq"),
            rs.getNString("designacao"),
            fromSQL(rs.getDate("dataCriaEq")),
            rs.getInt("idFunc")
        );
    }

}
