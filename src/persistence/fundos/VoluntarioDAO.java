package persistence.fundos;

import business.Individuo;
import business.building.Tarefa;
import business.building.VoluntariadoRealizado;
import business.funds.Equipa;
import business.funds.Voluntariado;
import business.funds.Voluntario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import persistence.util.DAO;

public class VoluntarioDAO  extends DAO<Voluntario> {
    

    @Override
    public Voluntario getById(int id) throws SQLException{
        newStatement();
       
        ResultSet rs = executeSelect("Select * from Individuo where idIndiv = "+ id);
        Voluntario r = newObject(rs);
       
        closeStatemnet();
        
        return r;
    }

    public ArrayList<VoluntariadoRealizado> getByTarefa(Tarefa t) throws SQLException {
        newStatement();
        ArrayList<VoluntariadoRealizado> r = new ArrayList<>();
       
        ResultSet rs = executeSelect("Select i.*,dataTrabalho, duracao from Individuo i inner join IndividuoTarefaProjeto itp on itp.idIndiv = i.idIndiv "
                + " where itp.idProj = " + t.getIdProj() + " and itp.idTar = "+ t.getIdTar());
        while(rs.next()) {
            VoluntariadoRealizado vr = new VoluntariadoRealizado(
                    t,
                    newObject(rs),
                    fromSQL(rs.getDate("dataTrabalho")),
                    rs.getInt("duracao")
            );
            r.add(vr);
        }
        
        closeStatemnet();
        
        return r;   
    }
    
    public void removeTarefaRealizada(VoluntariadoRealizado voluntariadoRealizado) throws SQLException {
        newStatement();
        executeSQL("DELETE FROM IndividuoTarefaProjeto "
                + " where idIndiv = " + toSQL(((Voluntario) voluntariadoRealizado.getVoluntariado()).getIdIndiv())
                + " and idProj = " + toSQL(voluntariadoRealizado.getTarefa().getIdProj())
                + " and idTar = " + toSQL(voluntariadoRealizado.getTarefa().getIdTar()));
        newStatement();
    }

        public void updateTarefaRealizada(VoluntariadoRealizado voluntariadoRealizado) throws SQLException {
        newStatement();
        executeSQL("UPDATE IndividuoTarefaProjeto SET "
                + "dataTrabalho = " + toSQL(voluntariadoRealizado.getData())
                + " ,duracao = " + toSQL(voluntariadoRealizado.getDurationMinutos())
                + " where idIndiv = " + toSQL(((Voluntario) voluntariadoRealizado.getVoluntariado()).getIdIndiv())
                + " and idProj = " + toSQL(voluntariadoRealizado.getTarefa().getIdProj())
                + " and idTar = " + toSQL(voluntariadoRealizado.getTarefa().getIdTar()));
        newStatement();
    }

    public void insertTarefaRealizada(VoluntariadoRealizado voluntariadoRealizado) throws SQLException {
        newStatement();
        executeSQL("INSERT INTO IndividuoTarefaProjeto(dataTrabalho,duracao,idIndiv,idProj,idTar)  VALUES ("
                + "" + toSQL(voluntariadoRealizado.getData())
                + "," + toSQL(voluntariadoRealizado.getDurationMinutos())
                + "," + toSQL(((Voluntario) voluntariadoRealizado.getVoluntariado()).getIdIndiv())
                + "," + toSQL(voluntariadoRealizado.getTarefa().getIdProj())
                + "," + toSQL(voluntariadoRealizado.getTarefa().getIdTar())
                + ")"
        );
        newStatement();
    }
    
    @Override
    public ArrayList<Voluntario> getAll()throws SQLException {
        newStatement();
        ArrayList<Voluntario> r = new ArrayList<>();
       
        ResultSet rs = executeSelect("Select * from Individuo where isVoluntario=true");
        while(rs.next()) {
            Voluntario d = newObject(rs);
            
            r.add(d);
        }
        
        closeStatemnet();
        
        return r;
    }


    @Override
    public int insert(Voluntario d) throws SQLException {
        newStatement();
        
        int i = executeSQLWithId("INSERT INTO Individuo(idFunc, nome, dataNascimento, profissao, morada, codigoPostal, localidade," +
                    "email, telefone, telemovel, habilitacoes, conhecimentosLing, formacaoComp, experienciaVolunt, conhecmentosConstr," +
                    "trabalharJuntoVolunt, disponibilidade, comoConheceu, receberInfo, isParceiro, nif, isColectivo, isDoador," +
                    "isVoluntario, nacionalidadeIndev, dataCriaIndiv)" + "VALUES (" + 
                    toSQL(d.getIdFunc()) + "," + toSQL(d.getNome()) + "," + toSQL(d.getDataNascimento()) +
                    "," + toSQL(d.getProfissao()) + "," + toSQL(d.getMorada()) + "," + toSQL(d.getCodigoPostal()) + "," + toSQL(d.getLocalidade()) + 
                    "," + toSQL(d.getEmail()) + "," + toSQL(d.getTelefone()) + "," + toSQL(d.getTelemovel()) + 
                    "," + toSQL(d.getHabilitacoes()) + "," + toSQL(d.getConhecimentosLing()) + "," + toSQL(d.getFormacaoComp()) + 
                    "," + toSQL(d.getExperienciaVolunt()) + "," + toSQL(d.getConhecimentosConstr()) + "," + toSQL(d.getTrabalharJuntoVolunt()) + "," + 
                    toSQL(d.getDisponibilidade()) + "," + toSQL(d.getComoConheceu()) + "," + toSQL(d.getReceberInfo()) + "," + toSQL(d.isParceiro()) + 
                    "," + toSQL(d.getNif()) + "," + toSQL(d.isColetivo()) + "," + toSQL(d.isDoador()) + "," + toSQL(d.isVoluntario()) + "," + 
                    toSQL(d.getNacionalidadeIndiv()) + "," + toSQL(d.getDataCriaIndiv()) +")");
        closeStatemnet();
        
        return i;
    }
        
    @Override
    public int update(Voluntario d)throws SQLException{
        newStatement();
        executeSQL("UPDATE Individuo SET " +
                "idFunc=" + toSQL(d.getIdFunc()) + 
                ", nome=" + toSQL(d.getNome()) + 
                ", dataNascimento=" + toSQL(d.getDataNascimento()) + 
                ", profissao=" + toSQL(d.getProfissao()) + 
                ", morada=" + toSQL(d.getMorada()) + 
                ", codigoPostal=" + toSQL(d.getCodigoPostal()) + 
                ", localidade=" + toSQL(d.getLocalidade()) + 
                ", email=" + toSQL(d.getEmail()) + 
                ", telefone=" + toSQL(d.getTelefone()) +  
                ", telemovel=" + toSQL(d.getTelemovel()) +
                ", habilitacoes=" + toSQL(d.getHabilitacoes()) + 
                ", conhecimentosLing=" + toSQL(d.getConhecimentosLing()) + 
                ", formacaoComp=" + toSQL(d.getFormacaoComp()) + 
                ", experienciaVolunt=" + toSQL(d.getExperienciaVolunt()) + 
                ", conhecmentosConstr=" + toSQL(d.getConhecimentosConstr()) + 
                ", trabalharJuntoVolunt=" + toSQL(d.getTrabalharJuntoVolunt()) + 
                ", disponibilidade=" + toSQL(d.getDisponibilidade()) + 
                ", comoConheceu=" + toSQL(d.getComoConheceu()) + 
                ", receberInfo=" + toSQL(d.getReceberInfo()) + 
                ", isParceiro=" + toSQL(d.isParceiro()) + 
                ", nif=" + toSQL(d.getNif()) + 
                ", isColectivo=" + toSQL(d.isColetivo()) + 
                ", isDoador=" + toSQL(d.isDoador()) + 
                ", isVoluntario=" + toSQL(d.isVoluntario()) + 
                ", nacionalidadeIndev=" + toSQL(d.getNacionalidadeIndiv()) + 
                ", dataCriaIndiv=" + toSQL(d.getDataCriaIndiv()) + 
                " Where idIndiv=" + toSQL(d.getIdIndiv())
        );
        closeStatemnet();
                return 0;
    }

    @Override
    public void remove(Voluntario d) throws SQLException{
        newStatement();
        executeSQL("DELETE FROM Individuo WHERE idIndiv = " +  d.getIdIndiv());
        closeStatemnet();
    }
            
    //@Override
    public Voluntario newObject(ResultSet rs) throws SQLException{
        return new Voluntario(
            rs.getInt("idIndiv"),
            rs.getInt("idFunc"),
            rs.getNString("nome"),
            fromSQL(rs.getDate("dataNascimento")),
            rs.getNString("profissao"),
            rs.getNString("morada"),
            rs.getNString("codigoPostal"),
            rs.getNString("localidade"),
            rs.getNString("telefone"),
            rs.getNString("telemovel"),
            rs.getNString("email"),
            rs.getNString("habilitacoes"),
            rs.getNString("conhecimentosLing"),
            rs.getNString("formacaoComp"),
            rs.getNString("experienciaVolunt"),
            rs.getNString("conhecmentosConstr"),
            rs.getBoolean("trabalharJuntoVolunt"),
            rs.getNString("disponibilidade"),
            rs.getNString("comoConheceu"),
            rs.getBoolean("receberInfo"),
            rs.getBoolean("isParceiro"),
            rs.getInt("nif"),
            rs.getBoolean("isColectivo"),
            rs.getBoolean("isDoador"),
            rs.getBoolean("isVoluntario"),
            rs.getNString("nacionalidadeIndev"),
            fromSQL(rs.getDate("dataCriaIndiv"))
        );
    }


}