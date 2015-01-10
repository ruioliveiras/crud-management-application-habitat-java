/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence.fundos;

import business.building.Tarefa;
import business.building.VoluntariadoRealizado;
import business.funds.Equipa;
import business.funds.Voluntariado;
import business.funds.Voluntario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import persistence.util.DAO;

/**
 *
 * @author ruioliveiras
 */
public class EquipaDAO extends DAO<Equipa> {

    private VoluntarioDAO voluntarioDAO = new VoluntarioDAO();

    public ArrayList<Voluntario> getMembros(int id) throws SQLException {
        ArrayList<Voluntario> r = new ArrayList<>();
        newStatement();
        ResultSet rs = executeSelect("SELECT ID.* FROM EquipaIndividuo AS IE INNER JOIN Individuo AS ID ON IE.idIndiv=ID.idIndiv WHERE idEq = " + id);
        while (rs.next()) {
            r.add(voluntarioDAO.newObject(rs));
        }
        closeStatemnet();
        return r;
    }

    @Override
    public Equipa getById(int id) throws SQLException {
        newStatement();
        ResultSet rs = executeSelect("Select * from Equipa where idEq = " + id);
        Equipa r = newObj(rs);

        closeStatemnet();

        return r;
    }

    @Override
    public ArrayList<Equipa> getAll() throws SQLException {
        newStatement();
        ArrayList<Equipa> r = new ArrayList<>();

        ResultSet rs = executeSelect("Select * from Equipa");
        while (rs.next()) {
            Equipa e = newObj(rs);

            r.add(e);
        }
        closeStatemnet();

        return r;
    }

    public ArrayList<VoluntariadoRealizado> getByTarefa(Tarefa t) throws SQLException {
        newStatement();
        ArrayList<VoluntariadoRealizado> r = new ArrayList<>();

        ResultSet rs = executeSelect("Select i.*,dataTrabalho, duracao from Equipa i inner join EquipaTarefaProjeto itp on itp.idEq = i.idEq "
                + " where itp.idProj = " + t.getIdProj() + " and itp.idTar = " + t.getIdTar());
        while (rs.next()) {
            VoluntariadoRealizado vr = new VoluntariadoRealizado(
                    t,
                    newObj(rs),
                    fromSQL(rs.getDate("dataTrabalho")),
                    rs.getInt("duracao")
            );
            r.add(vr);
        }
        closeStatemnet();

        return r;
    }

    public void updateTarefaRealizada(VoluntariadoRealizado voluntariadoRealizado) throws SQLException {
        newStatement();
        executeSQL("UPDATE EquipaTarefaProjeto SET "
                + "dataTrabalho = " + toSQL(voluntariadoRealizado.getData())
                + " ,duracao = " + toSQL(voluntariadoRealizado.getDurationMinutos())
                + " where idEq = " + toSQL(((Equipa) voluntariadoRealizado.getVoluntariado()).getIdEq())
                + " and idProj = " + toSQL(voluntariadoRealizado.getTarefa().getIdProj())
                + " and idTar = " + toSQL(voluntariadoRealizado.getTarefa().getIdTar()));
        newStatement();
    }

    public void insertTarefaRealizada(VoluntariadoRealizado voluntariadoRealizado) throws SQLException {
        newStatement();
        executeSQL("INSERT INTO EquipaTarefaProjeto(dataTrabalho,duracao,idEq,idProj,idTar)  VALUES ("
                + "" + toSQL(voluntariadoRealizado.getData())
                + "," + toSQL(voluntariadoRealizado.getDurationMinutos())
                + "," + toSQL(((Equipa) voluntariadoRealizado.getVoluntariado()).getIdEq())
                + "," + toSQL(voluntariadoRealizado.getTarefa().getIdProj())
                + "," + toSQL(voluntariadoRealizado.getTarefa().getIdTar())
                + ")"
        );
        newStatement();
    }

    @Override
    public int insert(Equipa e) throws SQLException {
        newStatement();

        int i = executeSQLWithId("INSERT INTO Equipa(nacionalidadeEq, designacao, dataCriaEq, idfunc) VALUES ("
                + toSQL(e.getNacionalidadeEq()) + ","
                + toSQL(e.getDesignacao()) + ","
                + toSQL(e.getDataCriaEq()) + ","
                + toSQL(e.getIdFunc()));
        closeStatemnet();
        return i;
    }

    public int insert(Equipa e, List<Voluntario> list) throws SQLException {
        int ret = insert(e);
        newStatement();
        String query = "INSERT INTO EquipaIndividuo(idIndiv,IdEq) VALUES ";
        for (Voluntario list1 : list) {
            query += " (" + toSQL(list1.getIdIndiv()) + " , " + toSQL(e.getIdEq()) + "),";
        }
        query = query.substring(0, query.length() - 1);

        executeSQL(query);

        closeStatemnet();
        return ret;
    }

    @Override
    public void remove(Equipa d) throws SQLException {
        newStatement();
        executeSQL("DELETE FROM Equipa WHERE idEq = " + d.getIdEq());
        closeStatemnet();
    }

    @Override
    public int update(Equipa e) throws SQLException {
        newStatement();
        executeSQL("UPDATE Equipa SET "
                + "nacionalidadeEq=" + toSQL(e.getNacionalidadeEq())
                + ", designacao=" + toSQL(e.getDesignacao())
                + ", dataCriaEq=" + toSQL(e.getDataCriaEq())
                + ", idfunc=" + toSQL(e.getIdFunc())
                + " Where idEq=" + toSQL(e.getIdEq())
        );
        closeStatemnet();
                return 0;
    }

    public void update(Equipa e, List<Voluntario> list, List<Voluntario> rem) throws SQLException {
        update(e);
        newStatement();
        for (Voluntario list1 : list) {
            executeSQL("INSERT IGNORE INTO EquipaIndividuo(idIndiv, idEq) VALUES "
                    + " (" + toSQL(list1.getIdIndiv()) + " , " + toSQL(e.getIdEq()) + ")");

        }
        for (Voluntario list1 : rem) {
            executeSQL(" DELETE IGNORE FROM EquipaIndividuo WHERE idIndiv = " + list1.getIdIndiv() + " and idEq = " + e.getIdEq());
        }
        closeStatemnet();
    }

    public Equipa newObj(ResultSet rs) throws SQLException {
        return new Equipa(
                rs.getInt("idEq"),
                rs.getNString("nacionalidadeEq"),
                rs.getNString("designacao"),
                fromSQL(rs.getDate("dataCriaEq")),
                rs.getInt("idFunc")
        );
    }

}
