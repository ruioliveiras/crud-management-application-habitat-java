package business.funds;

import business.funds.Voluntariado;
import java.util.Objects;
import java.util.Objects;

public class Voluntario implements Voluntariado {
	private String ocupacao;
	private String disponivilidade;
	private String experienciaVolun;
	private String comoConheceu;
	private String profissao;
	private String atividade;
	/*public Horas_Volut�riado _usa;
	public Tarefa usa_Horas;
	public Equipa_Voluntario pertence;
	public Nome tem;*/

    public Voluntario(String ocupacao, String disponivilidade, String experienciaVolun, 
            String comoConheceu, String profissao, String atividade) {
        this.ocupacao = ocupacao;
        this.disponivilidade = disponivilidade;
        this.experienciaVolun = experienciaVolun;
        this.comoConheceu = comoConheceu;
        this.profissao = profissao;
        this.atividade = atividade;
    }

    public Voluntario(Voluntario v) {
        this.ocupacao = v.getOcupacao();
        this.disponivilidade = v.getDisponivilidade();
        this.experienciaVolun = v.getExperienciaVolun();
        this.comoConheceu = v.getComoConheceu();
        this.profissao = v.getProfissao();
        this.atividade = v.getAtividade();
    }

    public String getAtividade() {
        return atividade;
    }

    public void setAtividade(String atividade) {
        this.atividade = atividade;
    }

    public String getComoConheceu() {
        return comoConheceu;
    }

    public void setComoConheceu(String comoConheceu) {
        this.comoConheceu = comoConheceu;
    }

    public String getExperienciaVolun() {
        return experienciaVolun;
    }

    public void setExperienciaVolun(String experienciaVolun) {
        this.experienciaVolun = experienciaVolun;
    }

    public String getDisponivilidade() {
        return this.disponivilidade;
    }

    public void setDisponivilidade(String isponivilidade) {
        this.disponivilidade = isponivilidade;
    }

    public String getOcupacao() {
        return ocupacao;
    }

    public void setOcupacao(String ocupacao) {
        this.ocupacao = ocupacao;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }  

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Voluntario other = (Voluntario) obj;
        if (!Objects.equals(this.ocupacao, other.ocupacao)) {
            return false;
        }
        if (!Objects.equals(this.disponivilidade, other.disponivilidade)) {
            return false;
        }
        if (!Objects.equals(this.experienciaVolun, other.experienciaVolun)) {
            return false;
        }
        if (!Objects.equals(this.comoConheceu, other.comoConheceu)) {
            return false;
        }
        if (!Objects.equals(this.profissao, other.profissao)) {
            return false;
        }
        if (!Objects.equals(this.atividade, other.atividade)) {
            return false;
        }
        return true;
    }

    
    
    
    public Voluntario clone()
    {
        return new Voluntario(this);
    }       
         
}