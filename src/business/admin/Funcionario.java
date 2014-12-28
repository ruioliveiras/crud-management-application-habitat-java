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
    /**/

    public Funcionario() {
        super();
    }
    
    public Funcionario(int id, Tipo tipoFunc, String nome, int nif, String morada, 
            String telefone, String telemovel, String codigoPostal, String localidade,
            GregorianCalendar dataNascimento) {
        super(id, nome, nif, morada, telefone, telemovel, codigoPostal, localidade, dataNascimento);
        this.tipoFunc = tipoFunc;
    }

    public Funcionario(Funcionario f) {
        super( f);
        tipoFunc = f.getTipoFunc();
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
    
    public Funcionario clone()
    {
        return new Funcionario(this);
    }
}