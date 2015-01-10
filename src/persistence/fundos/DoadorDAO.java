package persistence.fundos;

import business.funds.Doador;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import persistence.util.DAO;

public class DoadorDAO  extends DAO<Doador> {    
    
    public int getQuantDoada(int id) throws SQLException{
        newStatement();
        ResultSet rs = executeSelect("SELECT SUM(quantInicial) as quantTotal FROM Donativo WHERE idIndiv = "+id+" AND idTipoDon="+1);
        if(rs.next()) {
            int r=rs.getInt("quantTotal");
            closeStatemnet();
            return r;
        }
        else {
            closeStatemnet();
            return 0;
        }
    }
    
    @Override
    public Doador getById(int id) throws SQLException{
        newStatement();
        ResultSet rs = executeSelect("Select * from Individuo where idIndiv = "+ id);
         Doador r = null;
        if(rs.next()) {
            r = newObject(rs);
        }
        closeStatemnet();
        
        return r;
    }

    @Override
    public ArrayList<Doador> getAll()throws SQLException {
        newStatement();
        ArrayList<Doador> r = new ArrayList<>();
       
        ResultSet rs = executeSelect("Select * from Individuo where isDoador=true");
        while(rs.next()) {
            Doador d = newObject(rs);
            
            r.add(d);
        }
        closeStatemnet();
        
        return r;
    }

    @Override
    public int insert(Doador d) throws SQLException {
        newStatement();
        
        int i = executeSQLWithId("INSERT INTO Individuo(idFunc, nome, dataNascimento, profissao, morada, codigoPostal, localidade," +
                                    "email, telefone, telemovel, habilitacoes, conhecimentosLing, formacaoComp, experienciaVolunt, conhecmentosConstr," +
                                    "trabalharJuntoVolunt, disponibilidade, comoConheceu, receberInfo, isParceiro, nif, isColectivo, isDoador," +
                                    "isVoluntario, nacionalidadeIndev, dataCriaIndiv) VALUES (" + 
                                    toSQL(d.getIdFunc()) + "," + 
                                    toSQL(d.getNome()) + "," + 
                                    toSQL(d.getDataNascimento()) + "," + 
                                    toSQL(d.getProfissao()) + "," + 
                                    toSQL(d.getMorada()) + "," + 
                                    toSQL(d.getCodigoPostal()) + "," + 
                                    toSQL(d.getLocalidade()) + "," + 
                                    toSQL(d.getEmail()) + "," + 
                                    toSQL(d.getTelefone()) + "," + 
                                    toSQL(d.getTelemovel()) + "," + 
                                    toSQL(d.getHabilitacoes()) + "," + 
                                    toSQL(d.getConhecimentosLing()) + "," + 
                                    toSQL(d.getFormacaoComp()) + "," + 
                                    toSQL(d.getExperienciaVolunt()) + "," + 
                                    toSQL(d.getConhecimentosConstr()) + "," + 
                                    toSQL(d.getTrabalharJuntoVolunt()) + "," + 
                                    toSQL(d.getDisponibilidade()) + "," + 
                                    toSQL(d.getComoConheceu()) + "," + 
                                    toSQL(d.getReceberInfo()) + "," + 
                                    toSQL(d.isParceiro()) + "," + 
                                    toSQL(d.getNif()) + "," + 
                                    toSQL(d.isColetivo()) + "," + 
                                    toSQL(d.isDoador()) + "," + 
                                    toSQL(d.isVoluntario()) + "," + 
                                    toSQL(d.getNacionalidadeIndiv()) + "," + 
                                    toSQL(d.getDataCriaIndiv()) +")");
        closeStatemnet();
        
        return i;
    }
    
 
   @Override
    public int update(Doador d)throws SQLException{
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
    public void remove(Doador d) throws SQLException{
        newStatement();
        executeSQL("DELETE FROM Individuo WHERE idIndiv = " +  d.getIdIndiv());
        closeStatemnet();
    }
    
    
    //public Doador(int idIndiv, int idFunc, String nome, GregorianCalendar dataNascimento, String profissao, String morada, String codigoPostal, S
    //tring localidade, String telefone, String telemovel, String email, String habilitacoes, String conhecimentosLing, String formacaoComp, String experienciaVolunt, String conhecimentosConstr, boolean trabalharJuntoVolunt, String disponibilidade, String comoConheceu, boolean receberInfo, boolean isParceiro, int nif, boolean isColetivo, boolean isDoador, boolean isVoluntario, String nacionalidadeIndiv, GregorianCalendar dataCriaIndiv) {
 
    public Doador newObject(ResultSet rs) throws SQLException{
        return new Doador(
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