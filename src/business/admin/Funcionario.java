package business.admin;

import business.Individuo;
import java.sql.Date;
import java.util.GregorianCalendar;

/**
 * Classe que representa um Funcionário da Organização  
 * @author ruioliveiras
 */
public class Funcionario extends Individuo {
    public enum Tipo{ADMIN,FAM,FUNDOS,OBRAS};
    
    private Tipo tipoFunc;
    private String username,password;
/**
 * Construtor Vazio
 */
    public Funcionario() {
        super();
    }
/**
 * Construtor Parametrizado
 * @param id Código Identificativo
 * @param tipoFunc Tipo de Funcionário (ADMIN, FAM, FUNDOS, OBRAS)
 * @param nome Nome do Funcionário
 * @param nif Número de Identificação Fiscal do Funcionário
 * @param morada Morada do Funcionário
 * @param telefone Nº de Telefone do Funcionário
 * @param telemovel Nº de Telemóvel do Funcionário
 * @param codigoPostal Código Postal do Funcionário
 * @param localidade Localidade do Funcionário
 * @param dataNascimento Data de Nascimento do Funcionário
 * @param username Nome de Utilizador do Funcionário
 * @param password Palavra passe do Funcionário
 */    
    public Funcionario(int id, Tipo tipoFunc, String nome, int nif, String morada, 
            String telefone, String telemovel, String codigoPostal, String localidade,
            GregorianCalendar dataNascimento, String username, String password) {
        super(id, nome, nif, morada, telefone, telemovel, codigoPostal, localidade, dataNascimento);
        this.tipoFunc = tipoFunc;
        this.username = username;
        this.password = password;
    }
/**
 * Construtor de Cópia 
 * @param f Funcionário a ser copiado
 */
    public Funcionario(Funcionario f) {
        super( f);
        tipoFunc = f.getTipoFunc();
        username = f.getUsername();
        password = f.getPassword();
    }
/**
 * Retorna a Representação textual do tipo de Funcionario
 * @return Representação Textual de Tipo de Funcionário
 */
    public String getTipoFuncStr() {
        switch(tipoFunc){
            case ADMIN: return "Administrador";
            case FAM: return "Com. Familias";
            case FUNDOS: return "Com. Fundos";
            case OBRAS:return "Com. Obras";
        }
        return "";
    }
/**
 * Retorna o tipo de Funcionário
 * @return Tipo de Funcionário
 */
    public Tipo getTipoFunc() {
        return tipoFunc;
    }
/**
 * Modifica o tipo de Funcionário
 * @param tipoFunc Novo tipo de Funcionário 
 */
    public void setTipoFunc(Tipo tipoFunc) {
        this.tipoFunc = tipoFunc;
    }
/**
 * Retorna a palavra passe de acesso ao sistema
 * @return Palavra Passe
 */
    public String getPassword() {
        return password;
    }
/**
 * Retorna o nome de utilizador
 * @return Nome de Utilizador
 */
    public String getUsername() {
        return username;
    }
/**
 * Modifica a palavra passe do Funcionário
 * @param password Nova Palavra Passe 
 */
    public void setPassword(String password) {
        this.password = password;
    }
/**
 * Modifica o nome de utilizador do Funcionário
 * @param username Novo nome de Utilizador
 */
    public void setUsername(String username) {
        this.username = username;
    }
    
    
/**
 * Método clone, retorna uma cópia da instância actual
 * @return Cópia da instância actual
 */    
    public Funcionario clone()
    {
        return new Funcionario(this);
    }
/**
 * Retorna a representação textual do Funcionário usando o Identificador, Nome e Tipo de Funcionário
 * @return Representação textual da informação do Funcionário 
 */
    @Override
    public String toString(){
        return new String(this.getId()+"."+this.getNome()+"."+this.getTipoFuncStr());
    }
}