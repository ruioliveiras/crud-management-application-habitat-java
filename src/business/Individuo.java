package business;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

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

    public Individuo() {
    }

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

    public int getId() {
        return id;
    }
    
    public String getLocalidade() {
        return localidade;
    }

    public String getMorada() {
        return morada;
    }

    public int getNif() {
        return nif;
    }

    public String getNome() {
        return nome;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getTelemovel() {
        return telemovel;
    }

    public GregorianCalendar getDataNascimento() {
        return dataNascimento;
    }
    public String getDataNascimentoStr(String format) {
        DateFormat df = new SimpleDateFormat(format);
        return df.format(dataNascimento.getTime());
    }
    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public void setNif(int nif) {
        this.nif = nif;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setTelemovel(String telemovel) {
        this.telemovel = telemovel;
    }

    public void setDataNascimento(GregorianCalendar dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @Override
    public String toString() {
       return new String(this.id+"."+this.nome+"."+this.morada);
    }
    
    
}