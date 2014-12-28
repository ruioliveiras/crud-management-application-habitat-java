package business.funds;

import java.util.GregorianCalendar;
import java.util.Map;

public class Doador 
{
    private String nome, profissao, morada, localidade, codPostal, email, habilitacoes;
    private String conhecimentosLing, formacaoComp, experienciaVolunt, conhecimentoConstr;
    private String disponibilidade, comoConheceu, nacionalidadeIndev, atividade;
    private Boolean trabalharJuntoVolunt, receberInfo, isParceiro, isColectivo;
    private Boolean isDoador, isVoluntario;
    private int id, telefone, telemovel, nif;
    private GregorianCalendar dataNascimento, dataCriaIdiv;
    /*public Doador unnamed_Doador_;
    public Doador unnamed_Doador_2;
    public DoadorDAO unnamed_DoadorDAO_;
    public DonativoDAO _donativoDAO;*/

   
    public Doador(String nome, String profissao, String morada, String localidade, 
            String codPostal, String email, String habilitacoes, String conhecimentosLing, 
            String formacaoComp, String experienciaVolunt, String conhecimentoConstr, 
            String disponibilidade, String comoConheceu, String nacionalidadeIndev, 
            String atividade, Boolean trabalharJuntoVolunt, Boolean receberInfo, Boolean isParceiro, 
            Boolean isColectivo, Boolean isDoador, Boolean isVoluntario, int totalDonativo, 
            int id, int telefone, int telemovel, int nif, GregorianCalendar dataNascimento, 
            GregorianCalendar dataCriaIdiv) {
        this.nome = nome;
        this.profissao = profissao;
        this.morada = morada;
        this.localidade = localidade;
        this.codPostal = codPostal;
        this.email = email;
        this.habilitacoes = habilitacoes;
        this.conhecimentosLing = conhecimentosLing;
        this.formacaoComp = formacaoComp;
        this.experienciaVolunt = experienciaVolunt;
        this.conhecimentoConstr = conhecimentoConstr;
        this.disponibilidade = disponibilidade;
        this.comoConheceu = comoConheceu;
        this.nacionalidadeIndev = nacionalidadeIndev;
        this.atividade = atividade;
        this.trabalharJuntoVolunt = trabalharJuntoVolunt;
        this.receberInfo = receberInfo;
        this.isParceiro = isParceiro;
        this.isColectivo = isColectivo;
        this.isDoador = isDoador;
        this.isVoluntario = isVoluntario;
        this.id = id;
        this.telefone = telefone;
        this.telemovel = telemovel;
        this.nif = nif;
        this.dataNascimento = dataNascimento;
        this.dataCriaIdiv = dataCriaIdiv;
    }

    public Doador(Doador d) {
        this.nome = d.getNome();
        this.profissao = d.getProfissao();
        this.morada = d.getMorada();
        this.localidade = d.getLocalidade();
        this.codPostal = d.getCodPostal();
        this.email = d.getEmail();
        this.habilitacoes = d.getHabilitacoes();
        this.conhecimentosLing = d.getConhecimentosLing();
        this.formacaoComp = d.getFormacaoComp();
        this.experienciaVolunt = d.getExperienciaVolunt();
        this.conhecimentoConstr = d.getConhecimentoConstr();
        this.disponibilidade = d.getDisponibilidade();
        this.comoConheceu = d.getComoConheceu();
        this.nacionalidadeIndev = d.getNacionalidadeIndev();
        this.atividade = d.getAtividade();
        this.trabalharJuntoVolunt = d.isTrabalharJuntoVolunt();
        this.receberInfo = d.isReceberInfo();
        this.isParceiro = d.isIsParceiro();
        this.isColectivo = d.isIsColectivo();
        this.isDoador = d.isIsDoador();
        this.isVoluntario = d.isIsVoluntario();
        this.id = d.getId();
        this.telefone = d.getTelefone();
        this.telemovel = d.getTelemovel();
        this.nif = d.getNif();
        this.dataNascimento = d.getDataNascimento();
        this.dataCriaIdiv = d.getDataCriaIdiv();
    }
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public String getCodPostal() {
        return codPostal;
    }

    public void setCodPostal(String codPostal) {
        this.codPostal = codPostal;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHabilitacoes() {
        return habilitacoes;
    }

    public void setHabilitacoes(String habilitacoes) {
        this.habilitacoes = habilitacoes;
    }

    public String getConhecimentosLing() {
        return conhecimentosLing;
    }

    public void setConhecimentosLing(String conhecimentosLing) {
        this.conhecimentosLing = conhecimentosLing;
    }

    public String getFormacaoComp() {
        return formacaoComp;
    }

    public void setFormacaoComp(String formacaoComp) {
        this.formacaoComp = formacaoComp;
    }

    public String getExperienciaVolunt() {
        return experienciaVolunt;
    }

    public void setExperienciaVolunt(String experienciaVolunt) {
        this.experienciaVolunt = experienciaVolunt;
    }

    public String getConhecimentoConstr() {
        return conhecimentoConstr;
    }

    public void setConhecimentoConstr(String conhecimentoConstr) {
        this.conhecimentoConstr = conhecimentoConstr;
    }

    public String getDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(String disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public String getComoConheceu() {
        return comoConheceu;
    }

    public void setComoConheceu(String comoConheceu) {
        this.comoConheceu = comoConheceu;
    }

    public String getNacionalidadeIndev() {
        return nacionalidadeIndev;
    }

    public void setNacionalidadeIndev(String nacionalidadeIndev) {
        this.nacionalidadeIndev = nacionalidadeIndev;
    }

    public String getAtividade() {
        return atividade;
    }

    public void setAtividade(String atividade) {
        this.atividade = atividade;
    }

    public Boolean isTrabalharJuntoVolunt() {
        return trabalharJuntoVolunt;
    }

    public void setTrabalharJuntoVolunt(Boolean trabalharJuntoVolunt) {
        this.trabalharJuntoVolunt = trabalharJuntoVolunt;
    }

    public Boolean isReceberInfo() {
        return receberInfo;
    }

    public void setReceberInfo(Boolean receberInfo) {
        this.receberInfo = receberInfo;
    }

    public Boolean isIsParceiro() {
        return isParceiro;
    }

    public void setIsParceiro(Boolean isParceiro) {
        this.isParceiro = isParceiro;
    }

    public Boolean isIsColectivo() {
        return isColectivo;
    }

    public void setIsColectivo(Boolean isColectivo) {
        this.isColectivo = isColectivo;
    }

    public Boolean isIsDoador() {
        return isDoador;
    }

    public void setIsDoador(Boolean isDoador) {
        this.isDoador = isDoador;
    }

    public Boolean isIsVoluntario() {
        return isVoluntario;
    }

    public void setIsVoluntario(Boolean isVoluntario) {
        this.isVoluntario = isVoluntario;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public int getTelemovel() {
        return telemovel;
    }

    public void setTelemovel(int telemovel) {
        this.telemovel = telemovel;
    }

    public int getNif() {
        return nif;
    }

    public void setNif(int nif) {
        this.nif = nif;
    }

    public GregorianCalendar getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(GregorianCalendar dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public GregorianCalendar getDataCriaIdiv() {
        return dataCriaIdiv;
    }

    public void setDataCriaIdiv(GregorianCalendar dataCriaIdiv) {
        this.dataCriaIdiv = dataCriaIdiv;
    }
        
    
    /**
     * 
     * @return 
     */
//    public Map<GregorianCalendar, Donativo> DonativosDoador()
//    {
//        return getDonativosByDoador(this.id);
//    }
}