package business;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
/**
 * Classe que abstrai um Indivíduo
 * @author Jose
 */
public abstract class Individuo {
    private int id;
    private String nome;
    private int nif;
    private String morada;
    private String telefone;
    private String telemovel;
    private String codigoPostal;
    private String localidade;
    private GregorianCalendar dataNascimento;
/**
 * Construtor Vazio
 * Apenas instancia a data de nascimento, os restantes valores serão por omissão
 */
    public Individuo() {
        dataNascimento = new GregorianCalendar();
    }
/**
 * Construtor Parametrizado
 * @param id Código de Identificação do Indivíduo
 * @param nome Nome do Indivíduo
 * @param nif Número de Identificação Fiscal do Indivíduo
 * @param morada Morada do Indivíduo
 * @param telefone Telefone do Indivíduo
 * @param telemovel Telemóvel do Indivíduo
 * @param codigoPostal Código Postal do Indivíduo
 * @param localidade Localidade do Indivíduo
 * @param dataNascimento Data de Nascimento do Indivíduo
 */
    public Individuo(int id,String nome, int nif, String morada, String telefone, String telemovel, 
            String codigoPostal, String localidade, GregorianCalendar dataNascimento) {
        this.id = id;
        this.nome = nome;
        this.nif = nif;
        this.morada = morada;
        this.telefone = telefone;
        this.telemovel = telemovel;
        this.codigoPostal = codigoPostal;
        this.localidade = localidade;
        this.dataNascimento = dataNascimento;

    }

/**
 * Construtor de cópia
 * @param i Indivíduo a ser copiado 
 */   
    public Individuo(Individuo i) {
        this.id = i.getId();
        this.nome = i.getNome();
        this.nif = i.getNif();
        this.morada = i.getMorada();
        this.telefone = i.getTelefone();
        this.telemovel = i.getTelemovel();
        this.codigoPostal = i.getCodigoPostal();
        this.localidade = i.getLocalidade();
        this.dataNascimento = i.getDataNascimento();
    }
    /**
    * Retorna o Identificador do Indivíduo
    * @return Identificador 
    */
    public int getId() {
        return id;
    }
    /**
     * Retorna a Localidade do Indivíduo
     * @return Localidade
     */
    public String getLocalidade() {
        return localidade;
    }
    /**
     * Retorna a Morada do Indivíduo
     * @return Morada
     */
    public String getMorada() {
        return morada;
    }
    /**
     * Retorna o Número de Identificação Fiscal do Indivíduo
     * @return NIF
     */
    public int getNif() {
        return nif;
    }
    /**
     * Retorna o Nome do Indivíduo
     * @return Nome
     */
    public String getNome() {
        return nome;
    }
    /**
     * Retorna o Código Postal do Indivíduo
     * @return Código Postal
     */
    public String getCodigoPostal() {
        return codigoPostal;
    }
    /**
     * Retorna o nº de telefone do Indivíduo
     * @return Telefone
     */
    public String getTelefone() {
        return telefone;
    }
    /**
     * Retorna o nº de telemóvel do Indivíduo
     * @return Telemovel
     */
    public String getTelemovel() {
        return telemovel;
    }
    /**
     * Retorna a Data de Nascimento do Indivíduo
     * @return Data de Nascimento
     */
    public GregorianCalendar getDataNascimento() {
        return dataNascimento;
    }
    /**
     * Retorna a Data de Nascimento do Indivíduo em formato textual seguindo um formato
     * @param format Formato de data 
     * @return Representação textual da data seguindo o formato 'format'
     */
    public String getDataNascimentoStr(String format) {
        DateFormat df = new SimpleDateFormat(format);
        return df.format(dataNascimento.getTime());
    }
    /**
     * Modifica a Localidade do Indivíduo
     * @param localidade Nova Localidade do Indivíduo
     */
    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }
    /**
     * Modifica a Morada do Indivíduo
     * @param morada Nova Morada do Indivíduo
     */
    public void setMorada(String morada) {
        this.morada = morada;
    }
    /**
     * Modifica o NIF do Indivíduo
     * @param nif Novo NIF do Indivíduo
     */
    public void setNif(int nif) {
        this.nif = nif;
    }
    /**
     * Modifica o Nome do Indivíduo
     * @param nome Novo Nome do Indivíduo
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
    /**
     * Modifica o Código Postal do Indivíduo
     * @param codigoPostal Novo Código Postal do Indivíduo
     */
    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }
    /**
     * Modifica o Telefone do Indivíduo
     * @param telefone Novo Telefone do Indivíduo
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    /**
     * Modifica o Telemóvel do Indivíduo
     * @param telemovel Novo Telemóvel do Indivíduo
     */
    public void setTelemovel(String telemovel) {
        this.telemovel = telemovel;
    }
    /**
     * Modifica a Data de Nascimento do Indivíduo
     * @param dataNascimento Nova Data de Nascimento do Indivíduo
     */
    public void setDataNascimento(GregorianCalendar dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    /**
     * Retorna a Representação textual do Indivíduo utilizando o Identificador, Nome e Morada
     * @return Representação textual da Informação do Indivíduo
     */
    @Override
    public String toString() {
       return new String(this.id+"."+this.nome+"."+this.morada);
    }
    
    
}