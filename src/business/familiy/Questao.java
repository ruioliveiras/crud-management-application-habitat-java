package business.familiy;

import java.util.Objects;

public class Questao {
    private int perguntaId;
    private String pergunta;
    private String resposta;

    public Questao(int perguntaid, String pergunta, String resposta) {
        this.perguntaId = perguntaid;
        this.pergunta = pergunta;
        this.resposta = resposta;
    }

    public Questao(Questao q) {
        this.perguntaId = q.getPerguntaId();
        this.pergunta = q.getPergunta();
        this.resposta = q.getResposta();
    }

    public int getPerguntaId() {
        return perguntaId;
    }

    public void setPerguntaId(int perguntaId) {
        this.perguntaId = perguntaId;
    }
    
    public String getPergunta() {
        return pergunta;
    }

    public String getResposta() {
        return resposta;
    }

    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Questao other = (Questao) obj;
        if (!Objects.equals(this.pergunta, other.pergunta)) {
            return false;
        }
        if (!Objects.equals(this.resposta, other.resposta)) {
            return false;
        }
        return true;
    }
    
    
    
    public Questao clone()
    {
        return new Questao(this);
    }
    
    public String toString(){
        return new String(this.pergunta+"."+this.resposta);
    }
}