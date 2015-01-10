package persistence.fundos;

import business.building.DonativoRealizado;
import business.building.Projeto;
import business.funds.Donativo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import persistence.util.DAO;

public class DonativoDAO extends DAO<Donativo> {

    @Override
    public Donativo getById(int id) throws SQLException {
        newStatement();
        ResultSet rs = executeSelect("Select * from Donativo where idDon = " + id);
        closeStatemnet();

        return newObject(rs);
    }

    public ArrayList<DonativoRealizado> getByProjId(int idProj) throws SQLException {
        ArrayList<DonativoRealizado> r = new ArrayList<>();
        newStatement();
        ResultSet rs = executeSelect("Select d.*, dataDonProj, quantDonProj from Donativo d inner join DonativoProjeto dp on dp.idDon = d.idDon where idProj = " + idProj);
        while (rs.next()) {
            DonativoRealizado d = new DonativoRealizado(
                    newObject(rs),
                    fromSQL(rs.getDate("dataDonProj")),
                    rs.getInt("quantDonProj")
            );
            r.add(d);
        }
        closeStatemnet();

        return r;
    }

    public void insertRealizado(DonativoRealizado d, Projeto aThis) throws SQLException {
        newStatement();
        executeSQL("INSERT INTO DonativoProjeto(idDon, idProj, dataDonProj, quantDonProj, idFunc) VALUES ("
                + toSQL(d.getDonativo().getIdDon()) + ","
                + toSQL(aThis.getId()) + ","
                + toSQL(d.getData()) + ","
                + toSQL(d.getQuantidade()) + ","
                + toSQL(aThis.getFuncionarioId()) + ")");
        closeStatemnet();
    }

    public void updateRealizado(DonativoRealizado d, Projeto aThis) throws SQLException {
        newStatement();
        executeSQL("UPDATE DonativoProjeto SET "
                + "dataDonProj = " + toSQL(d.getData())
                + ", quantDonProj = " + toSQL(d.getQuantidade())
                + " where idDon = " + toSQL(d.getDonativo().getIdDon())
                + " and idProj = " + toSQL(aThis.getId())
        );
        closeStatemnet();
    }

    public void removeRealizado(DonativoRealizado d, Projeto aThis) throws SQLException {
        newStatement();
        executeSQL("DELETE FROM DonativoProjeto "
                + " where idDon = " + toSQL(d.getDonativo().getIdDon())
                + " and idProj = " + toSQL(aThis.getId())
        );
        closeStatemnet();
    }

    @Override
    public ArrayList<Donativo> getAll() throws SQLException {
        ArrayList<Donativo> r = new ArrayList<>();
        newStatement();

        ResultSet rs = executeSelect("Select * from Donativo");
        while (rs.next()) {
            r.add(newObject(rs));
        }
        closeStatemnet();

        return r;
    }

    @Override
    public int insert(Donativo d) throws SQLException {
        newStatement();

        int i = executeSQLWithId("INSERT INTO Donativo(descricao, quantInicial, quantAtual, idTipoDon, dataDon, idFunc, idEv, idIndiv) VALUES ("
                + toSQL(d.getDescricao()) + ","
                + toSQL(d.getQuantInicial()) + ","
                + toSQL(d.getQuantAtual()) + ","
                + toSQL(d.getIdTipoDon()) + ","
                + toSQL(d.getDataDon()) + ","
                + toSQL(d.getIdFunc()) + ","
                + toSQL(d.getIdEv()) + ","
                + toSQL(d.getIdIndiv()) + ")");
        closeStatemnet();

        return i;
    }

    @Override
    public int update(Donativo d) throws SQLException {
        newStatement();
        executeSQL("UPDATE Donativo SET  "
                + "descricao=" + toSQL(d.getDescricao())
                + ", quantInicial=" + toSQL(d.getQuantInicial())
                + ", quantAtual=" + toSQL(d.getQuantAtual())
                + ", idTipoDon=" + toSQL(d.getIdTipoDon())
                + ", dataDon=" + toSQL(d.getDataDon())
                + ", idFunc=" + toSQL(d.getIdFunc())
                + ", idEv=" + toSQL(d.getIdEv())
                + ", idIndiv=" + toSQL(d.getIdIndiv())
                + " WHERE idDon=" + toSQL(d.getIdDon()));
        closeStatemnet();
        return 0;
    }

    @Override
    public void remove(Donativo d) throws SQLException {
        newStatement();
        executeSQL("DELETE FROM DONATIVO WHERE idDon = " + d.getIdDon());
        closeStatemnet();
    }

    //@Override
    public Donativo newObject(ResultSet rs) throws SQLException {
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
