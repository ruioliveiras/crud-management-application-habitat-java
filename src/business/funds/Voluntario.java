package business.funds;

import java.util.GregorianCalendar;

public class Voluntario implements Voluntariado {
   private int idIndiv, idFunc;
    private String nome;
    private GregorianCalendar dataNascimento;
    private String profissao, morada, codigoPostal, localidade, telefone;
    private String telemovel, email, habilitacoes, conhecimentosLing, formacaoComp;
    private String experienciaVolunt, conhecimentosConstr;
    private boolean trabalharJuntoVolunt;
    private String disponibilidade, comoConheceu;
    private boolean receberInfo, isParceiro;
    private int nif;
    private boolean isColetivo, isDoador, isVoluntario;
    private String nacionalidadeIndiv;
    private GregorianCalendar dataCriaIndiv;

/**
 * Construtor Vazio
 */
      public Voluntario() {
        dataCriaIndiv = new GregorianCalendar();
        dataNascimento = new GregorianCalendar();
        isVoluntario = true;
    }
    /**
     * Construtor Parametrizado
     * @param idIndiv Identificador de Indivíduo
     * @param idFunc Identificador de Funcionário Responsável
     * @param nome Nome
     * @param dataNascimento Data de Nascimento
     * @param profissao Profissão do Voluntário
     * @param morada Morada
     * @param codigoPostal Código Postal
     * @param localidade Localidade de Residência
     * @param telefone nº de Telefone 
     * @param telemovel Nºde Telemóvel
     * @param email Email
     * @param habilitacoes Habilitações Literárias
     * @param conhecimentosLing Conhecimentos Linguísticos
     * @param formacaoComp Formação Complementar
     * @param experienciaVolunt Experiência como Voluntário
     * @param conhecimentosConstr Conhecimentos de Construção 
     * @param trabalharJuntoVolunt Se quer trabalhar junto de um Voluntário
     * @param disponibilidade Disponibilidade 
     * @param comoConheceu Como Conheceu a organização
     * @param receberInfo Se pretende receber informações 
     * @param isParceiro Se é parceiro da Organização
     * @param nif Número de Identificação Fiscal
     * @param isColetivo Se é Coletivo
     * @param isDoador Se é Doador
     * @param isVoluntario Se é Voluntário
     * @param nacionalidadeIndiv Nacionalidade
     * @param dataCriaIndiv Data de Criação 
     */
    public Voluntario(int idIndiv, int idFunc, String nome, GregorianCalendar dataNascimento, String profissao, String morada, String codigoPostal, String localidade, String telefone, String telemovel, String email, String habilitacoes, String conhecimentosLing, String formacaoComp, String experienciaVolunt, String conhecimentosConstr, boolean trabalharJuntoVolunt, String disponibilidade, String comoConheceu, boolean receberInfo, boolean isParceiro, int nif, boolean isColetivo, boolean isDoador, boolean isVoluntario, String nacionalidadeIndiv, GregorianCalendar dataCriaIndiv) {
        this.idIndiv = idIndiv;
        this.idFunc = idFunc;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.profissao = profissao;
        this.morada = morada;
        this.codigoPostal = codigoPostal;
        this.localidade = localidade;
        this.telefone = telefone;
        this.telemovel = telemovel;
        this.email = email;
        this.habilitacoes = habilitacoes;
        this.conhecimentosLing = conhecimentosLing;
        this.formacaoComp = formacaoComp;
        this.experienciaVolunt = experienciaVolunt;
        this.conhecimentosConstr = conhecimentosConstr;
        this.trabalharJuntoVolunt = trabalharJuntoVolunt;
        this.disponibilidade = disponibilidade;
        this.comoConheceu = comoConheceu;
        this.receberInfo = receberInfo;
        this.isParceiro = isParceiro;
        this.nif = nif;
        this.isColetivo = isColetivo;
        this.isDoador = isDoador;
        this.isVoluntario = isVoluntario;
        this.nacionalidadeIndiv = nacionalidadeIndiv;
        this.dataCriaIndiv = dataCriaIndiv;
    }

 /**
  * Construtor de Cópia
  * @param d Voluntário a ser Copiado
  */   
    public Voluntario(Voluntario d) {
        this.idIndiv = d.getIdIndiv();
        this.idFunc = d.getIdFunc();
        this.nome = d.getNome();
        this.dataNascimento = d.getDataNascimento();
        this.profissao = d.getProfissao();
        this.morada = d.getMorada();
        this.codigoPostal = d.getCodigoPostal();
        this.localidade = d.getLocalidade();
        this.telefone = d.getTelefone();
        this.telemovel = d.getTelemovel();
        this.email = d.getEmail();
        this.habilitacoes = d.getHabilitacoes();
        this.conhecimentosLing = d.getConhecimentosLing();
        this.formacaoComp = d.getFormacaoComp();
        this.experienciaVolunt = d.getExperienciaVolunt();
        this.conhecimentosConstr = d.getConhecimentosConstr();
        this.trabalharJuntoVolunt = d.getTrabalharJuntoVolunt();
        this.disponibilidade = d.getDisponibilidade();
        this.comoConheceu = d.getComoConheceu();
        this.receberInfo = d.getReceberInfo();
        this.isParceiro = d.isParceiro();
        this.nif = d.getNif();
        this.isColetivo = d.isColetivo();
        this.isDoador = d.isDoador();
        this.isVoluntario = d.isVoluntario();
        this.nacionalidadeIndiv = d.getNacionalidadeIndiv();
        this.dataCriaIndiv = d.getDataCriaIndiv();
    }
    
   /**
    * 
    * @return Se é parceiro da organização 
    */ 
    public boolean isParceiro() {
        return isParceiro;
    }
    /**
     * 
     * @return Se é Coletivo 
     */
    public boolean isColetivo() {
        return isColetivo;
    }
    /**
     * 
     * @return Se é doador 
     */
    public boolean isDoador() {
        return isDoador;
    }
    /**
     * 
     * @return se é Voluntário 
     */
    public boolean isVoluntario() {
        return isVoluntario;
    }
    /**
     * 
     * @return Se pretende Receber Informações
     */
    public boolean getReceberInfo() {
        return receberInfo;
    }
/**
 * Código Postal
 * @return 
 */
    public String getCodigoPostal() {
        return codigoPostal;
    }
/**
 * 
 * @return Como Conheceu A Organização 
 */
    public String getComoConheceu() {
        return comoConheceu;
    }
/**
 * 
 * @return Conhecimentos de Construção
 */
    public String getConhecimentosConstr() {
        return conhecimentosConstr;
    }
/**
 * 
 * @return Conhecimentos Linguísticos
 */
    public String getConhecimentosLing() {
        return conhecimentosLing;
    }
/**
 * 
 * @return Data de Criação
 */
    public GregorianCalendar getDataCriaIndiv() {
        return dataCriaIndiv;
    }
/**
 * 
 * @return Data de Nascimento
 */
    public GregorianCalendar getDataNascimento() {
        return dataNascimento;
    }
/**
 * 
 * @return Disponibilidade
 */
    public String getDisponibilidade() {
        return disponibilidade;
    }
/**
 * 
 * @return E-Mail
 */
    public String getEmail() {
        return email;
    }
/**
 * 
 * @return Experiência como Voluntário
 */
    public String getExperienciaVolunt() {
        return experienciaVolunt;
    }
/**
 * 
 * @return Formação Complementar
 */
    public String getFormacaoComp() {
        return formacaoComp;
    }
/**
 * 
 * @return Habilitações Literárias
 */
    public String getHabilitacoes() {
        return habilitacoes;
    }
/**
 * 
 * @return Identificador do Funcionário Responsável
 */
    public int getIdFunc() {
        return idFunc;
    }
/**
 * 
 * @return Identificador de Indivíduo
 */
    public int getIdIndiv() {
        return idIndiv;
    }
/**
 * 
 * @return Localidade
 */
    public String getLocalidade() {
        return localidade;
    }
/**
 * 
 * @return Morada
 */
    public String getMorada() {
        return morada;
    }
/**
 * 
 * @return Nacionalidade
 */
    public String getNacionalidadeIndiv() {
        return nacionalidadeIndiv;
    }
/**
 * 
 * @return Número de Identificação Fiscal
 */
    public int getNif() {
        return nif;
    }
/**
 * 
 * @return Nome
 */
    public String getNome() {
        return nome;
    }
/**
 * 
 * @return Profissão
 */
    public String getProfissao() {
        return profissao;
    }
/**
 * 
 * @return Telemóvel
 */
    public String getTelemovel() {
        return telemovel;
    }
/**
 * 
 * @return Telefone
 */
    public String getTelefone() {
        return telefone;
    }
/**
 * 
 * @return Se pretende trabalhar junto de outro Voluntário
 */    
    public boolean getTrabalharJuntoVolunt() {
        return trabalharJuntoVolunt;
    }
    
    
/**
 * Modifica o Código Postal
 * @param codigoPostal Novo Código Postal
 */
    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }
/**
 * Modifica como conheceu a Organização
 * @param comoConheceu Nova forma de conhecer a Organização
 */
    public void setComoConheceu(String comoConheceu) {
        this.comoConheceu = comoConheceu;
    }
/**
 * Modifica os Conhecimentos de Construção
 * @param conhecimentosConstr Novos Conhecimentos de Construção
 */
    public void setConhecimentosConstr(String conhecimentosConstr) {
        this.conhecimentosConstr = conhecimentosConstr;
    }
/**
 * Modifica os Conhecimentos Linguísticos
 * @param conhecimentosLing Novos Conhecimentos Linguísticos
 */
    public void setConhecimentosLing(String conhecimentosLing) {
        this.conhecimentosLing = conhecimentosLing;
    }
/**
 * Modifica a data de Criação 
 * @param dataCriaIndiv Nova data de Criação
 */
    public void setDataCriaIndiv(GregorianCalendar dataCriaIndiv) {
        this.dataCriaIndiv = dataCriaIndiv;
    }
/**
 * Modifica a data de Nascimento
 * @param dataNascimento Nova data de Nasciento
 */
    public void setDataNascimento(GregorianCalendar dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
/**
 * Modifica a Disponibilidade
 * @param disponibilidade Nova Disponibilidade
 */
    public void setDisponibilidade(String disponibilidade) {
        this.disponibilidade = disponibilidade;
    }
/**
 * Modifica o E-Mail
 * @param email Novo E-Mail
 */
    public void setEmail(String email) {
        this.email = email;
    }
/**
 * Modifica a experiência como Voluntario
 * @param experienciaVolunt Nova Experiência
 */
    public void setExperienciaVolunt(String experienciaVolunt) {
        this.experienciaVolunt = experienciaVolunt;
    }
/**
 * Modifica a Formação Complementar
 * @param formacaoComp Nova Formação Complementar
 */
    public void setFormacaoComp(String formacaoComp) {
        this.formacaoComp = formacaoComp;
    }
/**
 * Modifica as Habilitações Literárias 
 * @param habilitacoes Novas Habilitações Literárias
 */
    public void setHabilitacoes(String habilitacoes) {
        this.habilitacoes = habilitacoes;
    }
/**
 * Modifica o Identificador do Funcionário Responsável
 * @param idFunc Novo Identificador de Funcionário Responsável
 */
    public void setIdFunc(int idFunc) {
        this.idFunc = idFunc;
    }
/**
 * Muda o Identificador
 * @param idIndiv Novo Identificador
 */
    public void setIdIndiv(int idIndiv) {
        this.idIndiv = idIndiv;
    }
/**
 * Modifica Multiplicidade do Voluntario
 * @param isColetivo Nova Multiplicidade
 */
    public void setIsColetivo(boolean isColetivo) {
        this.isColetivo = isColetivo;
    }
/**
 * Modifica Estado relativo a Doador
 * @param isDoador Novo Estado de Doador
 */
    public void setIsDoador(boolean isDoador) {
        this.isDoador = isDoador;
    }
/**
 * Modifica o estado de Parceiro
 * @param isParceiro Novo estado de Parceiro
 */
    public void setIsParceiro(boolean isParceiro) {
        this.isParceiro = isParceiro;
    }
/**
 * Modifica o estado de Voluntário
 * @param isVoluntario Novo estado de Voluntário
 */
    public void setIsVoluntario(boolean isVoluntario) {
        this.isVoluntario = isVoluntario;
    }
/**
 * Modifica a Localidade
 * @param localidade Nova Localidade
 */
    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }
/**
 * Modifica a Morada
 * @param morada Nova Morada
 */
    public void setMorada(String morada) {
        this.morada = morada;
    }
/**
 * Modifica a Nacionalidade
 * @param nacionalidadeIndiv Nova Nacionalidade 
 */
    public void setNacionalidadeIndiv(String nacionalidadeIndiv) {
        this.nacionalidadeIndiv = nacionalidadeIndiv;
    }
/**
 * Modifica o NIF 
 * @param nif Novo NIF
 */
    public void setNif(int nif) {
        this.nif = nif;
    }
/**
 * Modifica o Nome
 * @param nome Novo Nome
 */
    public void setNome(String nome) {
        this.nome = nome;
    }
/**
 * Modifica a profissão 
 * @param profissao Nova Profissão
 */
    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }
/**
 * Modifica vontade de receber Informação 
 * @param receberInfo Nova vontade de Receber Informação
 */
    public void setReceberInfo(boolean receberInfo) {
        this.receberInfo = receberInfo;
    }
/**
 * Modifica o Telemóvel
 * @param telemovel Novo Telemóvel
 */
    public void setTelemovel(String telemovel) {
        this.telemovel = telemovel;
    }
/**
 * Modifica o Telefone
 * @param telefone Novo Telefone
 */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * 
     * @param obj
     * @return 
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Voluntario){
            return ((Voluntario) obj).getIdIndiv() == this.getIdIndiv();
        }
        return false;
    }
    
    
/**
 * Modifica vontade de trabalhar junto de outro voluntário
 * @param trabalharJuntoVolunt Nova vontade de trabalhar junto de outro voluntário
 */
    public void setTrabalharJuntoVolunt(boolean trabalharJuntoVolunt) {
        this.trabalharJuntoVolunt = trabalharJuntoVolunt;
    } 
    /**
     * Representação textual do Voluntário usando o ID, Nome e Profissão
     * @return Representação textual do Voluntário
     */
    public String toString(){
        return new String(this.idIndiv+"."+this.nome+"."+this.profissao);
    }
}