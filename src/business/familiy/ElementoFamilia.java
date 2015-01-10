package business.familiy;

import java.util.GregorianCalendar;

public class ElementoFamilia 
{
    private String nome;
    private String ocupacao;
    private String parentesco;
    private String escolaridade;
    private String estadoCivil;
    private int id;
    private int idFam;
    private GregorianCalendar dataNascimento;
/**
 * Construtor Vazio
 */
    public ElementoFamilia() {
        dataNascimento = new GregorianCalendar();
    }
/**
 * Construtor Parametrizado
 * @param id Identificador do membro de Família
 * @param idFam Identificador da Família
 * @param nome Nome do Elemento
 * @param ocupacao Actividade profissional exercida pelo elemento
 * @param parentesco Grau de Parentesco
 * @param escolaridade Grau mais alto de escolaridade atingido
 * @param estadoCivil Estado Civil do elemento
 * @param dataNascimento Data de Nascimento
 */
    public ElementoFamilia(int id,int idFam, String nome, String ocupacao, String parentesco, 
            String escolaridade, String estadoCivil, GregorianCalendar dataNascimento) {
        this.id = id;
        this.idFam = idFam;
        this.nome = nome;
        this.ocupacao = ocupacao;
        this.parentesco = parentesco;
        this.escolaridade = escolaridade;
        this.estadoCivil = estadoCivil;
        this.dataNascimento = dataNascimento;
    }
    /**
     * Construtor de Cópia
     * @param e Elemento a ser copiado
     */
    public ElementoFamilia(ElementoFamilia e) 
    {
        this.idFam = e.getIdFam();
        this.id = e.getId();
        this.nome = e.getNome();
        this.ocupacao = e.getOcupacao();
        this.parentesco = e.getParentesco();
        this.escolaridade = e.getEscolaridade();
        this.estadoCivil = e.getEstadoCivil();
        this.dataNascimento = e.getDataNascimento();
    }
    
/**
 * Retorna o Identificador do Elemento da Família
 * @return Identificador
 */
    public int getId() {
        return id;
    }
/**
 * Modifica o Identificador do Elemento da Família
 * @param id Novo Identificador de Elemento
 */
    public void setId(int id) {
        this.id = id;
    }   
/**
 * Retorna o Identificador da Família
 * @return Identificador da Família
 */
    public int getIdFam() {
        return idFam;
    }
/**
 * Modifica o Identificador da Família
 * @param idFam Novo Identificador da Família
 */
    public void setIdFam(int idFam) {
        this.idFam = idFam;
    }
/**
 * Retorna o Nome
 * @return Nome
 */
    public String getNome() {
        return nome;
    }
/**
 * Modifica o Nome
 * @param nome Novo Nome
 */
    public void setNome(String nome) {
        this.nome = nome;
    }
/**
 * Retorna a Ocupação
 * @return Ocupação
 */
    public String getOcupacao() {
        return ocupacao;
    }
/**
 * Modifica a ocupação
 * @param ocupacao Nova Ocupação
 */
    public void setOcupacao(String ocupacao) {
        this.ocupacao = ocupacao;
    }
/**
 * Retorna o grau de Parentesco
 * @return Grau de Parentesco
 */
    public String getParentesco() {
        return parentesco;
    }
/**
 * Modifica o grau de Parentesco
 * @param parentesco Novo Grau de Parentesco
 */
    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }
/**
 * Retorna a Escolaridade obtida
 * @return Escolaridade
 */
    public String getEscolaridade() {
        return escolaridade;
    }
/**
 * Modifica a Escolaridade 
 * @param escolaridade Nova Escolaridade
 */
    public void setEscolaridade(String escolaridade) {
        this.escolaridade = escolaridade;
    }
/**
 * Retorna o Estado Civil 
 * @return Estado Civil
 */
    public String getEstadoCivil() {
        return estadoCivil;
    }
/**
 * Modifica o Estado Civil
 * @param estadoCivil Novo Estado Civil
 */
    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }
/**
 * Retorna a Data de Nascimento
 * @return Data de Nascimento
 */
    public GregorianCalendar getDataNascimento() {
        return dataNascimento;
    }
/**
 * Modifica a Data de Nascimento
 * @param dataNascimento Nova Data de Nascimento
 */
    public void setDataNascimento(GregorianCalendar dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
/**
 * Retorna uma cópia da Instância actual
 * @return Cópia da Instância actual
 */        
    public ElementoFamilia clone()
    {
        return new ElementoFamilia(this);
    }
/**
 * Retorna a Representação textual do Elemento da Família usanod o Nome, Ocupação e Grau de Parentesco
 * @return Representação textual dum elemento da Família
 */    
    @Override
    public String toString(){
        return this.nome+"."+this.ocupacao+"."+this.parentesco;
    }
}