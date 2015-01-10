package business.familiy;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import persistence.familia.FamiliaDAO;

public class Familia {

    private static FamiliaDAO familiaDAO = new FamiliaDAO();

    private String nomeRepresentante, moradaRepresentante;
    private int nif, idFunc, id, contactoRepresentate;
    private GregorianCalendar dataNascimento, dataCriaFam;
    private String apelido;
    private ArrayList<ElementoFamilia> elementosFamilia;
    private ArrayList<ElementoFamilia> elementosFamiliaRemoved = new ArrayList<>();
    private Candidatura candidatura;

    /**
     * Construtor vazio
     */
    public Familia() {
        elementosFamilia = new ArrayList<>();
        dataNascimento = new GregorianCalendar();
        dataCriaFam = new GregorianCalendar();
        candidatura = new Candidatura(this);
    }

    /**
     * Construtor Parametrizado
     *
     * @param nomeRepresentante Nome do Representante
     * @param contactoRepresentate Contacto do Representante
     * @param moradaRepresentante Morada do Representante
     * @param nif Número de Identificação Fiscal do Representante
     * @param idFunc Identificador do Funcionário Responsável
     * @param id Identificador da Família
     * @param dataNascimento Data de Nascimento do Representante
     * @param dataCriaFam Data de Criação da Família
     * @param apelido Apelido da Família
     * @param candidatura Candidatura Correspondente à família
     * @param acomp Todos os acompanhamentos que uma família teve
     * @param elem Lista com os elementos da Família
     * @param p Prestação a pagar
     */
    public Familia(String nomeRepresentante, int contactoRepresentate,
            String moradaRepresentante, int nif, int idFunc, int id, GregorianCalendar dataNascimento,
            GregorianCalendar dataCriaFam, String apelido, Candidatura candidatura,
            HashMap<GregorianCalendar, Acompanhamento> acomp, ArrayList<ElementoFamilia> elem,
            Prestacao p) {
        this.nomeRepresentante = nomeRepresentante;
        this.contactoRepresentate = contactoRepresentate;
        this.moradaRepresentante = moradaRepresentante;
        this.nif = nif;
        this.idFunc = idFunc;
        this.id = id;
        this.dataNascimento = dataNascimento;
        this.dataCriaFam = dataCriaFam;
        this.apelido = apelido;
        this.candidatura = candidatura;
        this.elementosFamilia = new ArrayList<ElementoFamilia>();
        for (ElementoFamilia e : elem) {
            this.elementosFamilia.add(e);
        }
    }

    /**
     * Construtor Parametrizado
     *
     * @param nomeRepresentante Nome do representante
     * @param contactoRepresentate Contacto do Representante
     * @param moradaRepresentante Morada do Representante
     * @param nif Número de Identificação Fiscal do Representante
     * @param idFunc Identificador do Funcionário responsável
     * @param id Identificador da Família
     * @param dataNascimento Data de Nascimento do Representante da Família
     * @param dataCriaFam Data de Criação da Família
     * @param apelido Apelido da Família
     */
    public Familia(String nomeRepresentante, int contactoRepresentate,
            String moradaRepresentante, int nif, int idFunc, int id, GregorianCalendar dataNascimento,
            GregorianCalendar dataCriaFam, String apelido) {
        this.nomeRepresentante = nomeRepresentante;
        this.contactoRepresentate = contactoRepresentate;
        this.moradaRepresentante = moradaRepresentante;
        this.nif = nif;
        this.idFunc = idFunc;
        this.id = id;
        this.dataNascimento = dataNascimento;
        this.dataCriaFam = dataCriaFam;
        this.apelido = apelido;
    }

    /**
     * Construtor de Cópia
     *
     * @param f Família a ser copiada
     */
    public Familia(Familia f) {
        this.nomeRepresentante = f.getNomeRepresentante();
        this.contactoRepresentate = f.getContactoRepresentate();
        this.moradaRepresentante = f.getMoradaRepresentante();
        this.nif = f.getNif();
        this.idFunc = f.getIdFunc();
        this.id = f.getId();
        this.dataNascimento = f.getDataNascimento();
        this.dataCriaFam = f.getDataCriaFam();
        this.apelido = f.getApelido();
        this.candidatura = f.getCandidaturaLast();
        this.elementosFamilia = f.getElementosFamilia();
    }

    /**
     * Retorna o Identificador da Família
     *
     * @return Identificador
     */
    public int getId() {
        return id;
    }

    /**
     * Modifica o Identificador da Família
     *
     * @param id Novo Identificador da Família
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Retorna o Identificador do Funcionário Responsável
     *
     * @return Identificador do Funcionário Responsável
     */
    public int getIdFunc() {
        return idFunc;
    }

    /**
     * Modifica o identificador do Funcionário Responsável
     *
     * @param idFunc Novo Identificador do Funcionário Responsável
     */
    public void setIdFunc(int idFunc) {
        this.idFunc = idFunc;
    }

    /**
     * Retorna o nome do Representante da Família
     *
     * @return Nome do Representante
     */
    public String getNomeRepresentante() {
        return nomeRepresentante;
    }

    /**
     * Modifica o Nome do Representante
     *
     * @param nomeRepresentante Novo nome do Representante
     */
    public void setNomeRepresentante(String nomeRepresentante) {
        this.nomeRepresentante = nomeRepresentante;
    }

    /**
     * Retorna o Contacto do Representante da Família
     *
     * @return Contacto do Representante
     */
    public int getContactoRepresentate() {
        return contactoRepresentate;
    }

    /**
     * Modifica o contacto do Representante
     *
     * @param contactoRepresentate Novo contacto do representante
     */
    public void setContactoRepresentate(int contactoRepresentate) {
        this.contactoRepresentate = contactoRepresentate;
    }

    /**
     * Retorna a morada do Representante
     *
     * @return Retorna a Morada do Representante
     */
    public String getMoradaRepresentante() {
        return moradaRepresentante;
    }

    /**
     * Modifica a Morada do Representante
     *
     * @param moradaRepresentante Nova Morada do Representante
     */
    public void setMoradaRepresentante(String moradaRepresentante) {
        this.moradaRepresentante = moradaRepresentante;
    }

    /**
     * Retorna o Número de Identificação Fiscal do Representante
     *
     * @return NIF
     */
    public int getNif() {
        return nif;
    }

    /**
     * Modifica o Número de Identificação Fiscal do Representante
     *
     * @param nif Novo NIF
     */
    public void setNif(int nif) {
        this.nif = nif;
    }

    /**
     * Retorna a data de nascimento do Representante
     *
     * @return Data de Nascimento
     */
    public GregorianCalendar getDataNascimento() {
        return dataNascimento;
    }

    /**
     * Modifica a data de Nascimento do Representante
     *
     * @param dataNascimento Nova data de Nascimento
     */
    public void setDataNascimento(GregorianCalendar dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    /**
     * Retorna a data de Criação da Família
     *
     * @return Data de Crição da Família
     */
    public GregorianCalendar getDataCriaFam() {
        return dataCriaFam;
    }

    /**
     * Modifica a data de Criação da Família
     *
     * @param dataCriaFam Nova data de Criação da Família
     */
    public void setDataCriaFam(GregorianCalendar dataCriaFam) {
        this.dataCriaFam = dataCriaFam;
    }

    /**
     * Retorna o Apelido
     *
     * @return Apelido
     */
    public String getApelido() {
        return apelido;
    }

    /**
     * Modifica o apelido
     *
     * @param apelido Novo Apelido
     */
    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    /**
     * Adiciona um novo elemento à família
     *
     * @param e Elemento a ser adicionado à Família
     */
    public void addElementoFamilia(ElementoFamilia e) {
        e.setIdFam(id);
        this.elementosFamilia.add(e.clone());
    }

    /**
     * Adiciona um elemento da Família numa posição, eliminando o que se
     * encontrava na mesma anteriormente
     *
     * @param e Elemento a ser adicionado
     * @param actualIndex Índice onde se colocará o Elemento
     */
    public void addElementoFamiliaAt(ElementoFamilia e, int actualIndex) {
        e.setIdFam(id);
        this.elementosFamilia.remove(actualIndex);
        this.elementosFamilia.add(actualIndex, e);
    }

    /**
     * Remove da Família um elemento
     *
     * @param selectedIndex Posição do Elemento da família na lista
     */
    public void rmElementoFamiliaAt(int selectedIndex) {
        elementosFamiliaRemoved.add(this.elementosFamilia.remove(selectedIndex));
    }

    /**
     * Retorna todos os elementos da Família
     *
     * @return Lista com todos os Elementos da Família
     */
    public ArrayList<ElementoFamilia> getElementosFamilia() {
        ArrayList<ElementoFamilia> ret = new ArrayList<ElementoFamilia>();

        for (ElementoFamilia e : this.elementosFamilia) {
            ret.add(e);
        }

        return ret;
    }

    /** faz get dos elementos da familia apagados e instancia de novo
     *  
     * @return lista com os elementos da familia apagados
     */
    public ArrayList<ElementoFamilia> getElementosFamiliaRemovedReset() {
        ArrayList<ElementoFamilia> ret = elementosFamiliaRemoved;
        elementosFamiliaRemoved = new ArrayList<>();
        return ret;
    }

    /**
     * Modifica os elementos da Família
     *
     * @param elem Lista com os novos elementos da Família
     */
    public void setElementosFamilia(ArrayList<ElementoFamilia> elem) {
        this.elementosFamilia = new ArrayList<ElementoFamilia>();
        for (ElementoFamilia e : elem) {
            this.elementosFamilia.add(e);
        }
    }

    /**
     * Retorna a última Candidatura da Família
     *
     * @return Candidatura
     */
    public Candidatura getCandidaturaLast() {
        return candidatura;
    }

    /**
     * Modifica a Candidatura
     *
     * @param candidatura Nova Candidatura
     */
    public void setCandidatura(Candidatura candidatura) {
        this.candidatura = candidatura;
    }

    /**
     * Retorna uma cópia da instância actual
     *
     * @return Cópia da Instância Actual
     */
    public Familia clone() {
        return new Familia(this);
    }

    /**
     * Retorna a representação textual da Família usando o Identificador, Nome
     * do Representante e Número de Identificação Fiscal
     *
     * @return Representação textual da Família
     */
    public String toString() {
        return this.id + "." + this.nomeRepresentante + "." + this.nif;
    }

    /**
     * Retorna a lista das candidaturas efectuadas pela família
     *
     * @return Lista com todas as candidaturas da família
     * @throws SQLException Caso haja algum problema de ligação à Base de Dados
     */
    public List<Candidatura> getCandidaturas() throws SQLException {
        return familiaDAO.getCandidaturas(this);
    }

    /**
     * Retorna a Lista de Prestações pagas pela família
     *
     * @return Lista com todas as Prestações pagas pela família
     * @throws SQLException Caso haja algum problema de ligação à Base de Dados
     */
    public List<Prestacao> getPrestacoes() throws SQLException {
        return familiaDAO.getPrestacoes(id);
    }

    /**
     * Retorna a lista de Acompanhamentos realizados pela organização
     *
     * @return Lista com todos os Acompanhamentos realizados pela Organização
     * @throws SQLException Caso haja algum problema de ligação à Base de Dados
     */
    public List<Acompanhamento> getAconpanhamento() throws SQLException {
        return familiaDAO.getAcompanhamento(id);
    }

}
