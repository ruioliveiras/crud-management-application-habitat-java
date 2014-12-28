/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence.admin;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.naming.NamingException;
import persistence.util.GenericDAO;
import business.admin.Funcionario;
import business.admin.TipoTarefa;

/**
 *
 * @author ruioliveiras
 */
public class FuncionarioDAO extends GenericDAO<Funcionario>{
  public enum Attr{
       idFunc,tipoFunc,nome,nif,morada,telefone,telemovel,codigoPostal,dataNascimento,localidade
    }
    
    public FuncionarioDAO() {
        super(Attr.values(), 1 , "Funcionario");
    }

    
    
    @Override
    protected String getToBD(Funcionario p, Enum<?> en) {
        Attr a = (Attr) en;
        switch(a){
          case idFunc: return toSQL(p.getId());
          case tipoFunc: return toSQL(p.getTipoFunc().name());
          case nome:return toSQL(p.getNome());
          case nif:return toSQL(p.getNif());
          case morada:return toSQL(p.getMorada());
          case telefone:return toSQL(p.getTelefone());
          case telemovel:return toSQL(p.getTelemovel());
          case codigoPostal:return toSQL(p.getCodigoPostal());
          case dataNascimento:return toSQL(p.getDataNascimento());
          case localidade:return toSQL(p.getLocalidade());
          default:
              throw new AssertionError(a.name());
        }
    }

    @Override
    public Funcionario newObject(ResultSet rs) throws SQLException {
        GregorianCalendar g = new GregorianCalendar();
        java.sql.Date d  = rs.getDate("dataNascimento");
        g.setTime(new Date(d.getTime()));
        return new Funcionario(
                rs.getInt("idFunc"),
                Funcionario.Tipo.valueOf(rs.getNString("tipoFunc")),
                rs.getNString("nome"),
                rs.getInt("nif"),
                rs.getNString("morada"),
                rs.getNString("telefone"),
                rs.getString("telemovel"),
                rs.getNString("codigoPostal"),
                rs.getNString("localidade"),
                g
        );    
    }
    
    
//    
//    protected Class<Funcionario> classFunc;
//    protected String[] attrs = {"idFunc","tipoFunc","nome","nif","morada","telefone","telemovel","codigoPostal","dataNascimento","localidade"};
//    protected int notKeyIndex = 1;
    //function para contruir apartir de rs
    //function to generic get;

    public static void main(String[] args) throws SQLException, NamingException {
        GenericDAO.initConnection();
        FuncionarioDAO f = new FuncionarioDAO();
        f.insert(new Funcionario(-1,Funcionario.Tipo.FAM, "Rui Pedro",932324, "rua da luz", "915 015 377", null, "4765-343","Oliveira st maria", new GregorianCalendar(1994, 11, 10)));
        Funcionario  f1 = f.getById(3);
        Funcionario  f2 = f.getAll().get(2);
        f1.setNome("olha ele");
        f.update(f1);
        f.remove(f2);
    }
}


/**
 * 
 * 
 * @Override
    public Funcionario getById(int id) throws SQLException{
        newStatement();
        ResultSet rs = executeSelect("Select idFunc,tipoFunc,nome,nif,morada,telefone,telemovel,codigoPostal,dataNascimento,localidade "
                + " from Funcionario where idFunc = "+ id);
        Funcionario f = null;
        if (rs.next()){
            f = newFuncionario(rs);
        }
        closeStatemnet();
        return f;
    }
    

    @Override
    public ArrayList<Funcionario> getAll()throws SQLException {
        ArrayList<Funcionario> list = new ArrayList<>();
        newStatement();
        ResultSet rs = executeSelect("Select * from Funcionario");
        while(rs.next()) {
            Funcionario f = newFuncionario(rs);
            list.add(f);
        }
        closeStatemnet();
        return list;
    }

    @Override
    public void insert(Funcionario obj)throws SQLException{
        newStatement();
        
        executeSQL("INSERT INTO Funcionario"
                + " (tipoFunc,nome,nif,morada,telefone,telemovel,codigoPostal,dataNascimento,localidade) VALUES "
                + " (" + obj.getTipoFunc().ordinal() +  ","
                + " '"+ obj.getNome() +"', "
                + " '"+ obj.getNif()+"', "
                + " '"+ obj.getMorada()+"', "
                + " '"+ obj.getTelefone()+"', "
                + " '"+ obj.getTelemovel()+"', "
                + " '"+ obj.getCodigoPostal()+"', "
                + " '"+ obj.getDataNascimentoStr("yyyy-MM-dd")+"', "
                + " '"+ obj.getLocalidade()+"'"
                + ")");
        closeStatemnet();
    }

    @Override
    public void remove(Funcionario obj) throws SQLException{
        newStatement();
        executeSQL("DELETE FROM Funcionario WHERE idFunc = "+ obj.getId() );
        closeStatemnet();
    }

    @Override
    public void update(Funcionario obj)throws SQLException{
        newStatement();
        executeSQL("UPDATE Funcionario SET "
                + "tipoFunc = " + toSQL(obj.getTipoFunc().name()) +  ","
                + "nome = "+ toSQL(obj.getNome() )+", "
                + "nif =  "+ toSQL(obj.getNif())+", "
                + "morada = "+ toSQL(obj.getMorada())+", "
                + "telefone = "+ toSQL(obj.getTelefone())+", "
                + "telemovel = "+ toSQL(obj.getTelemovel())+", "
                + "codigoPostal = "+ toSQL(obj.getCodigoPostal())+", "
                + "dataNascimento = "+ toSQL(obj.getDataNascimentoStr("yyyy-MM-dd"))+", "
                + "localidade = "+ toSQL(obj.getLocalidade())+" "
                + "where idFunc = " + obj.getId());

        closeStatemnet();
        
    }
    
 * 
 */