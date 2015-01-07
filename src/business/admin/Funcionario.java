package business.admin;

import business.Individuo;
import java.sql.Date;
import java.util.GregorianCalendar;

/**
 * 
 * @author ruioliveiras
 */
public class Funcionario extends Individuo {
    public enum Tipo{ADMIN,FAM,FUNDOS,OBRAS};
    
    private Tipo tipoFunc;
    private String username,password;

    public Funcionario() {
        super();
    }
    
    public Funcionario(int id, Tipo tipoFunc, String nome, int nif, String morada, 
            String telefone, String telemovel, String codigoPostal, String localidade,
            GregorianCalendar dataNascimento, String username, String password) {
        super(id, nome, nif, morada, telefone, telemovel, codigoPostal, localidade, dataNascimento);
        this.tipoFunc = tipoFunc;
        this.username = username;
        this.password = password;
    }

    public Funcionario(Funcionario f) {
        super( f);
        tipoFunc = f.getTipoFunc();
        username = f.getUsername();
        password = f.getPassword();
    }

    public String getTipoFuncStr() {
        switch(tipoFunc){
            case ADMIN: return "Administrador";
            case FAM: return "Com. Familias";
            case FUNDOS: return "Com. Fundos";
            case OBRAS:return "Com. Obras";
        }
        return "";
    }

    public Tipo getTipoFunc() {
        return tipoFunc;
    }

    public void setTipoFunc(Tipo tipoFunc) {
        this.tipoFunc = tipoFunc;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    
    
    public Funcionario clone()
    {
        return new Funcionario(this);
    }

    @Override
    public String toString(){
        return new String(this.getId()+"."+this.getNome()+"."+this.getTipoFuncStr());
    }
}