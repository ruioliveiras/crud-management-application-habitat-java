package business.funds;

import java.sql.SQLException;
import java.util.GregorianCalendar;
import persistence.fundos.DoadorDAO;

public class Doador {

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

    public Doador() {
        dataCriaIndiv = new GregorianCalendar();
        dataNascimento = new GregorianCalendar();
    }

    public Doador(int idIndiv, int idFunc, String nome, GregorianCalendar dataNascimento, String profissao, String morada, String codigoPostal, String localidade, String telefone, String telemovel, String email, String habilitacoes, String conhecimentosLing, String formacaoComp, String experienciaVolunt, String conhecimentosConstr, boolean trabalharJuntoVolunt, String disponibilidade, String comoConheceu, boolean receberInfo, boolean isParceiro, int nif, boolean isColetivo, boolean isDoador, boolean isVoluntario, String nacionalidadeIndiv, GregorianCalendar dataCriaIndiv) {
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

    public Doador(Doador d) {
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

    public int getQuantDoada() throws SQLException {
        DoadorDAO d = new DoadorDAO();
        return d.getQuantDoada(this.idIndiv);
    }

    public boolean isParceiro() {
        return isParceiro;
    }

    public boolean isColetivo() {
        return isColetivo;
    }

    public boolean isDoador() {
        return isDoador;
    }

    public boolean isVoluntario() {
        return isVoluntario;
    }

    public boolean getReceberInfo() {
        return receberInfo;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public String getComoConheceu() {
        return comoConheceu;
    }

    public String getConhecimentosConstr() {
        return conhecimentosConstr;
    }

    public String getConhecimentosLing() {
        return conhecimentosLing;
    }

    public GregorianCalendar getDataCriaIndiv() {
        return dataCriaIndiv;
    }

    public GregorianCalendar getDataNascimento() {
        return dataNascimento;
    }

    public String getDisponibilidade() {
        return disponibilidade;
    }

    public String getEmail() {
        return email;
    }

    public String getExperienciaVolunt() {
        return experienciaVolunt;
    }

    public String getFormacaoComp() {
        return formacaoComp;
    }

    public String getHabilitacoes() {
        return habilitacoes;
    }

    public int getIdFunc() {
        return idFunc;
    }

    public int getIdIndiv() {
        return idIndiv;
    }

    public String getLocalidade() {
        return localidade;
    }

    public String getMorada() {
        return morada;
    }

    public String getNacionalidadeIndiv() {
        return nacionalidadeIndiv;
    }

    public int getNif() {
        return nif;
    }

    public String getNome() {
        return nome;
    }

    public String getProfissao() {
        return profissao;
    }

    public String getTelemovel() {
        return telemovel;
    }

    public String getTelefone() {
        return telefone;
    }

    public boolean getTrabalharJuntoVolunt() {
        return trabalharJuntoVolunt;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public void setComoConheceu(String comoConheceu) {
        this.comoConheceu = comoConheceu;
    }

    public void setConhecimentosConstr(String conhecimentosConstr) {
        this.conhecimentosConstr = conhecimentosConstr;
    }

    public void setConhecimentosLing(String conhecimentosLing) {
        this.conhecimentosLing = conhecimentosLing;
    }

    public void setDataCriaIndiv(GregorianCalendar dataCriaIndiv) {
        this.dataCriaIndiv = dataCriaIndiv;
    }

    public void setDataNascimento(GregorianCalendar dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setDisponibilidade(String disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setExperienciaVolunt(String experienciaVolunt) {
        this.experienciaVolunt = experienciaVolunt;
    }

    public void setFormacaoComp(String formacaoComp) {
        this.formacaoComp = formacaoComp;
    }

    public void setHabilitacoes(String habilitacoes) {
        this.habilitacoes = habilitacoes;
    }

    public void setIdFunc(int idFunc) {
        this.idFunc = idFunc;
    }

    public void setIdIndiv(int idIndiv) {
        this.idIndiv = idIndiv;
    }

    public void setIsColetivo(boolean isColetivo) {
        this.isColetivo = isColetivo;
    }

    public void setIsDoador(boolean isDoador) {
        this.isDoador = isDoador;
    }

    public void setIsParceiro(boolean isParceiro) {
        this.isParceiro = isParceiro;
    }

    public void setIsVoluntario(boolean isVoluntario) {
        this.isVoluntario = isVoluntario;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public void setNacionalidadeIndiv(String nacionalidadeIndiv) {
        this.nacionalidadeIndiv = nacionalidadeIndiv;
    }

    public void setNif(int nif) {
        this.nif = nif;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public void setReceberInfo(boolean receberInfo) {
        this.receberInfo = receberInfo;
    }

    public void setTelemovel(String telemovel) {
        this.telemovel = telemovel;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setTrabalharJuntoVolunt(boolean trabalharJuntoVolunt) {
        this.trabalharJuntoVolunt = trabalharJuntoVolunt;
    }

    public Doador clone() {
        return new Doador(this);
    }

    public String toString() {
        return new String(this.idIndiv + "." + this.nome + "." + this.profissao);
    }
}
