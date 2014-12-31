package persistence;

public class DoadorDAO {/* extends DAO<Doador> {

    @Override
    public Doador getById(int id) throws SQLException{
        newStatement();
        ResultSet rs = executeSelect("Select * from Individuo where idIndiv = "+ id);
        
        Doador d = newObject(rs);
        
        closeStatemnet();
        
        return d;
    }

    @Override
    public ArrayList<Doador> getAll()throws SQLException {
        newStatement();
        ArrayList<Doador> r = new ArrayList<>();
       
        ResultSet rs = executeSelect("Select * from Doador");
        while(rs.next()) {
            Doador d = newObject(rs);
            
            r.add(d);
        }
        closeStatemnet();
        
        return r;
    }

    @Override
    public int insert(Doador d) {
        newStatement();
        
        ResultSet rs = executeSQL("INSERT INTO Individuo(idIndiv, idFunc, nome, dataNascimento, profissao, morada, codPostal, localidade," +
                                    "email, telefone, telemovel, habilitacoes, conhecimentosLing, formacaoComp, experienciaVolunt, conhecimentoConstr," +
                                    "trabalharJuntoVolunt, disponibilidade, comoConheceu, receberInfo, isParceiro, nif, isColetivo, isDoador," +
                                    "isVoluntario, nacionalidadeIndiv, dataCriaIndiv)" + "VALUES (" + 
                                    toSQL(d.getIdIndiv()) + "," + toSQL(d.getidFunc()) + "," + toSQL(d.getNome()) + "," + toSQL(d.getDataNascimento()) +
                                    "," + toSQL(d.getProfissao()) + "," + toSQL(d.getMorada()) + "," + toSQL(d.getCodPostal()) + "," + toSQL(d.getLocalidade()) + 
                                    "," + toSQL(d.getEmail()) + "," + toSQL(d.getTelefone()) + "," + toSQL(d.getTelemovel()) + 
                                    "," + toSQL(d.getHabilitacoes()) + "," + toSQL(d.getConhecimentosLing()) + "," + toSQL(d.getFormacaoComp()) + 
                                    "," + toSQL(d.getExperienciaVolunt()) + "," + toSQL(d.getConhecimentoContr()) + "," + toSQL(d.getTrabalharJuntoVolunt()) + "," + 
                                    toSQL(d.getDisponibilidade()) + "," + toSQL(d.getComoConheceu()) + "," + toSQL(d.getReceberInfo()) + "," + toSQL(d.getIsParceiro()) + 
                                    "," + toSQL(d.getNif()) + "," + toSQL(d.getIsColetivo()) + "," + toSQL(d.getIsDoador()) + "," + toSQL(d.getIsVoluntario()) + "," + 
                                    toSQL(d.getNacionalidadeIndiv()) + "," + toSQL(d.getDataCriaIdiv()) +")");
        closeStatemnet();
    }
    
 
    @Override
    public void update(Doador d)throws SQLException{
        newStatement();
        executeSQL("UPDATE Individuo SET idFunc=" + toSQL(d.getidFunc()) + ", nome=" + toSQL(d.getNome()) + ", dataNascimento=" + toSQL(d.getDataNascimento()) + 
                     ", profissao=" + toSQL(d.getProfissao()) + ", morada=" + toSQL(d.getMorada()) + ", codPostal=" + toSQL(d.getCodPostal()) + ", localidade=" + 
                     toSQL(d.getLocalidade()) + ", email=" + toSQL(d.getEmail()) + ", telefone=" toSQL(d.getTelefone()) +  ", telemovel=" + toSQL(d.getTelemovel()) + 
                     ", habilitacoes=" + toSQL(d.getHabilitacoes()) + ", conhecimentosLing=" + toSQL(d.getConhecimentosLing()) + ", formacaoComp=" + toSQL(d.getFormacaoComp()) + 
                     ", experienciaVolunt=" + toSQL(d.getExperienciaVolunt()) + ", conhecimentoConstr=" + toSQL(d.getConhecimentoContr()) + "trabalharJuntoVolunt=" +
                     toSQL(d.getTrabalharJuntoVolunt()) + ", disponibilidade=" + toSQL(d.getDisponibilidade()) + ", comoConheceu=" + toSQL(d.getComoConheceu()) + 
                     ", receberInfo=" + toSQL(d.getReceberInfo()) + ", isParceiro=" + toSQL(d.getIsParceiro()) + ", nif=" + toSQL(d.getNif()) + ", isColetivo=" +
                     toSQL(d.getIsColetivo()) + ", isDoador," + toSQL(d.getIsDoador()) + ", isVoluntario=" + toSQL(d.getIsVoluntario()) + ", nacionalidadeIndiv=" +
                     toSQL(d.getNacionalidadeIndiv()) + ", dataCriaIndiv=" + toSQL(d.getDataCriaIdiv()) + " Where idIndiv=" + toSQL(d.getIdIndiv()));
        closeStatemnet();
    }
    

    @Override
    public void remove(Doador d) throws SQLException{
        newStatement();
        executeSQL("DELETE FROM INDIVIDUO WHERE idIndiv = " +  d.getId());
        closeStatemnet();
    }
    

    public Doador newObject(ResultSet rs){
        return new Doador(
            rs.getInt("idIndiv");
            rs.getInt("idFunc");
            rs.getNString("nome");
            fromSQL(rs.getDate("dataNascimento"));
            rs.getNString("profissao");
            rs.getNString("morada");
            rs.getNString("codPostal");
            rs.getNString("localidade");
            rs.getNString("email");
            rs.getInt("telefone");
            rs.getInt("telemovel");
            rs.getNString("habilitacoes");
            rs.getNString("conhecimentosLing");
            rs.getNString("formacaoComp");
            rs.getNString("experienciaVolunt");
            rs.getNString("conhecimentoConstr");
            rs.getBoolean("trabalharJuntoVolunt");
            rs.getNString("disponibilidade");
            rs.getNString("comoConheceu");
            rs.getBoolean("receberInfo");
            rs.getBoolean("isParceiro");
            rs.getInt("nif");
            rs.getBoolean("isColetivo");
            rs.getBoolean("isDoador");
            rs.getBoolean("isVoluntario");
            rs.getNString("nacionalidadeIndiv");
            fromSQL(rs.getDate("dataCriaIndiv"));
        );
    }*/
}