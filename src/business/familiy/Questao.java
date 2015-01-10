package business.familiy;

import java.util.Objects;

public class Questao {
    private int perguntaId;
    private String pergunta;
    private String resposta;
/**
 * Construtor Parametrizado
 * @param perguntaid Identificador da Pergunta
 * @param pergunta Enunciado da Pergunta
 * @param resposta Resposta à pergunta
 */
    public Questao(int perguntaid, String pergunta, String resposta) {
        this.perguntaId = perguntaid;
        this.pergunta = pergunta;
        this.resposta = resposta;
    }
/**
 * Construtor por cópia
 * @param q Questão a ser copiada
 */
    public Questao(Questao q) {
        this.perguntaId = q.getPerguntaId();
        this.pergunta = q.getPergunta();
        this.resposta = q.getResposta();
    }
/**
 * Retorna o Identificador da Pergunta
 * @return Identificador da Pergunta
 */
    public int getPerguntaId() {
        return perguntaId;
    }
/**
 * Modifica o Identificador da Pergunta
 * @param perguntaId Novo identificador da Pergunta
 */
    public void setPerguntaId(int perguntaId) {
        this.perguntaId = perguntaId;
    }
    /**
     * Retorna o enunciado da Questão
     * @return Pergunta
     */
    public String getPergunta() {
        return pergunta;
    }
/**
 * Retorna a resposta dada à pergunta 
 * @return Resposta
 */
    public String getResposta() {
        return resposta;
    }
/**
 * Modifica o enunciado da pergunta
 * @param pergunta Novo Enunciado da pergunta
 */
    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }
/**
 * Modifica a resposta
 * @param resposta Nova Resposta
 */
    public void setResposta(String resposta) {
        this.resposta = resposta;
    }
/**
 * Método de verificação de igualdade semântica entre dois objectos
 * @param obj Objecto a ser comparado a this
 * @return True se obj e this forem semanticamente iguais <p> Caso contrário False
 */
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
    
    
    /**
     * Retorna uma instância como cópia da instância actual
     * @return Cópia da instância Actual
     */
    public Questao clone()
    {
        return new Questao(this);
    }
    /**
     * Retorna a Representação textual da questão Utilizando o enunciado da questão e a sua resposta
     * @return Representação textual da Questão
     */
    public String toString(){
        return new String(this.pergunta+"."+this.resposta);
    }
}