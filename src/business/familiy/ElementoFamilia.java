package business.familiy;

import java.util.GregorianCalendar;

public class ElementoFamilia 
{
    private String nome;
    private String ocupacao;
    private String parentesco;
    private String escolaridade;
    private String estadoCivil;
    private GregorianCalendar dataNascimento;

    public ElementoFamilia(String nome, String ocupacao, String parentesco, 
            String escolaridade, String estadoCivil, GregorianCalendar dataNascimento) {
        this.nome = nome;
        this.ocupacao = ocupacao;
        this.parentesco = parentesco;
        this.escolaridade = escolaridade;
        this.estadoCivil = estadoCivil;
        this.dataNascimento = dataNascimento;
    }
    
    public ElementoFamilia(ElementoFamilia e) 
    {
        this.nome = e.getNome();
        this.ocupacao = e.getOcupacao();
        this.parentesco = e.getParentesco();
        this.escolaridade = e.getEscolaridade();
        this.estadoCivil = e.getEstadoCivil();
        this.dataNascimento = e.getDataNascimento();
    }
    
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getOcupacao() {
        return ocupacao;
    }

    public void setOcupacao(String ocupacao) {
        this.ocupacao = ocupacao;
    }

    public String getParentesco() {
        return parentesco;
    }

    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }

    public String getEscolaridade() {
        return escolaridade;
    }

    public void setEscolaridade(String escolaridade) {
        this.escolaridade = escolaridade;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public GregorianCalendar getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(GregorianCalendar dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
        
    public ElementoFamilia clone()
    {
        return new ElementoFamilia(this);
    }
        
}