package persistence;

import business.funds.Equipa;
import business.funds.Voluntario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import persistence.util.DAO;

public class VoluntariadoDAO  extends DAO<Voluntariado> {
    

    @Override
    public Voluntario getById(int id) throws SQLException{
        newStatement();
       
        ResultSet rs = executeSelect("Select * from Individuo where idIndiv = "+ id);
        Voluntario r = newObject(rs);
       
        closeStatemnet();
        
        return r;
    }
    
    
    public Equipa getByIdEq(int id) throws SQLException{
        newStatement();
        ResultSet rs = executeSelect("Select * from Equipa where idEq = "+ id);
        Equipa r = newEq(rs);
       
        closeStatemnet();
        
        return r;
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
    
    
    public ArrayList<Equipa> getAllEq()throws SQLException {
        newStatement();
        ArrayList<Equipa> r = new ArrayList<>();
       
        ResultSet rs = executeSelect("Select * from Equipa");
        while(rs.next()) {
            Equipa e = newEq(rs);
            
            r.add(e);
        }
        closeStatemnet();
        
        return r;
    }
    
    
    

    //@Override
    public int insert(Voluntario d) throws SQLException {
        newStatement();
        
        executeSQL("INSERT INTO Individuo(idIndiv, idFunc, nome, dataNascimento, profissao, morada, codPostal, localidade," +
                    "email, telefone, telemovel, habilitacoes, conhecimentosLing, formacaoComp, experienciaVolunt, conhecimentoConstr," +
                    "trabalharJuntoVolunt, disponibilidade, comoConheceu, receberInfo, isParceiro, nif, isColetivo, isDoador," +
                    "isVoluntario, nacionalidadeIndiv, dataCriaIndiv)" + "VALUES (" + 
                    toSQL(d.getIdIndiv()) + "," + toSQL(d.getIdFunc()) + "," + toSQL(d.getNome()) + "," + toSQL(d.getDataNascimento()) +
                    "," + toSQL(d.getProfissao()) + "," + toSQL(d.getMorada()) + "," + toSQL(d.getCodigoPostal()) + "," + toSQL(d.getLocalidade()) + 
                    "," + toSQL(d.getEmail()) + "," + toSQL(d.getTelefone()) + "," + toSQL(d.getTelemovel()) + 
                    "," + toSQL(d.getHabilitacoes()) + "," + toSQL(d.getConhecimentosLing()) + "," + toSQL(d.getFormacaoComp()) + 
                    "," + toSQL(d.getExperienciaVolunt()) + "," + toSQL(d.getConhecimentosConstr()) + "," + toSQL(d.getTrabalharJuntoVolunt()) + "," + 
                    toSQL(d.getDisponibilidade()) + "," + toSQL(d.getComoConheceu()) + "," + toSQL(d.getReceberInfo()) + "," + toSQL(d.isParceiro()) + 
                    "," + toSQL(d.getNif()) + "," + toSQL(d.isColetivo()) + "," + toSQL(d.isDoador()) + "," + toSQL(d.isVoluntario()) + "," + 
                    toSQL(d.getNacionalidadeIndiv()) + "," + toSQL(d.getDataCriaIndiv()) +")");
        closeStatemnet();
        
        return 0;
    }
    
    
    //@Override 
    void insert(Equipa e) throws SQLException{
        newStatement();
        
        executeSQL("INSERT INTO Equipa(idEq, nacionalidadeEq, designacao, dataCriaEq, idfunc) VALUES (" +
                                    toSQL(e.getIdEq()) + "," + toSQL(e.getNacionalidadeEq()) + "," + toSQL(e.getDesignacao()) + 
                                    "," + toSQL(e.getDataCriaEq()) + "," + toSQL(e.getIdFunc()));
        closeStatemnet();
    }
    
    
    @Override
    public void update(Voluntario d)throws SQLException{
        newStatement();
        executeSQL("UPDATE Individuo SET " +
                "idFunc=" + toSQL(d.getIdFunc()) + 
                ", nome=" + toSQL(d.getNome()) + 
                ", dataNascimento=" + toSQL(d.getDataNascimento()) + 
                ", profissao=" + toSQL(d.getProfissao()) + 
                ", morada=" + toSQL(d.getMorada()) + 
                ", codPostal=" + toSQL(d.getCodigoPostal()) + 
                ", localidade=" + toSQL(d.getLocalidade()) + 
                ", email=" + toSQL(d.getEmail()) + 
                ", telefone=" + toSQL(d.getTelefone()) +  
                ", telemovel=" + toSQL(d.getTelemovel()) +
                ", habilitacoes=" + toSQL(d.getHabilitacoes()) + 
                ", conhecimentosLing=" + toSQL(d.getConhecimentosLing()) + 
                ", formacaoComp=" + toSQL(d.getFormacaoComp()) + 
                ", experienciaVolunt=" + toSQL(d.getExperienciaVolunt()) + 
                ", conhecimentoConstr=" + toSQL(d.getConhecimentosConstr()) + 
                ", trabalharJuntoVolunt=" + toSQL(d.getTrabalharJuntoVolunt()) + 
                ", disponibilidade=" + toSQL(d.getDisponibilidade()) + 
                ", comoConheceu=" + toSQL(d.getComoConheceu()) + 
                ", receberInfo=" + toSQL(d.getReceberInfo()) + 
                ", isParceiro=" + toSQL(d.isParceiro()) + 
                ", nif=" + toSQL(d.getNif()) + 
                ", isColetivo=" + toSQL(d.isColetivo()) + 
                ", isDoador," + toSQL(d.isDoador()) + 
                ", isVoluntario=" + toSQL(d.isVoluntario()) + 
                ", nacionalidadeIndiv=" + toSQL(d.getNacionalidadeIndiv()) + 
                ", dataCriaIndiv=" + toSQL(d.getDataCriaIndiv()) + 
                " Where idIndiv=" + toSQL(d.getIdIndiv())
        );
        closeStatemnet();
    }
    
    

    public void update(Equipa e)throws SQLException{
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
    

    //@Override
    public void remove(Voluntario d) throws SQLException{
        newStatement();
        executeSQL("DELETE FROM INDIVIDUO WHERE idIndiv = " +  d.getIdIndiv());
        closeStatemnet();
    }
    
    
    //@Override
    public void remove(Equipa d) throws SQLException{
        newStatement();
        executeSQL("DELETE FROM Equipa WHERE idEq = " +  d.getIdEq());
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
            rs.getNString("codPostal"),
            rs.getNString("localidade"),
            rs.getNString("email"),
            rs.getNString("telefone"),
            rs.getNString("telemovel"),
            rs.getNString("habilitacoes"),
            rs.getNString("conhecimentosLing"),
            rs.getNString("formacaoComp"),
            rs.getNString("experienciaVolunt"),
            rs.getNString("conhecimentoConstr"),
            rs.getBoolean("trabalharJuntoVolunt"),
            rs.getNString("disponibilidade"),
            rs.getNString("comoConheceu"),
            rs.getBoolean("receberInfo"),
            rs.getBoolean("isParceiro"),
            rs.getInt("nif"),
            rs.getBoolean("isColetivo"),
            rs.getBoolean("isDoador"),
            rs.getBoolean("isVoluntario"),
            rs.getNString("nacionalidadeIndiv"),
            fromSQL(rs.getDate("dataCriaIndiv"))
        );
    }
    
    public Equipa newEq(ResultSet rs) throws SQLException{
        return new Equipa(
            rs.getInt("idEq"),
            rs.getNString("nacionalidadeEq"),
            rs.getNString("designacao"),
            fromSQL(rs.getDate("dataCriaEq")),
            rs.getInt("idFunc")
        );
    }
}