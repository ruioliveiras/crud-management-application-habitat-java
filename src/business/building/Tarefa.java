package business.building;


import business.funds.Equipa;
import business.funds.Voluntariado;
import business.funds.Voluntario;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Objects;
import persistence.ProjetoDAO;
import persistence.fundos.EquipaDAO;
import persistence.fundos.VoluntarioDAO;

public class Tarefa {
    private static EquipaDAO equipaDAO = new EquipaDAO();
    private static VoluntarioDAO  voluntarioDAO= new VoluntarioDAO();

    private int idProj;
    private int idTar;
    private GregorianCalendar dataInicio;
    private GregorianCalendar dataFim;
    private GregorianCalendar dataInicioPrevista;
    private GregorianCalendar dataFimPrevista;
    private String tipoTarefa;
    /*public TarefaDAO _unnamed_TarefaDAO_;
    public Vector<Materia> _usa = new Vector<Materia>();
    public Vector<Monetario> _gasta = new Vector<Monetario>();
    public VoluntariadoDAO _voluntarioDao;
    public Voluntario _usa_Horas;
    public Voluntariado _unnamed_Voluntariado_;*/
/**
 * Construtor Parametrizado
 * @param idProj Identificador do Projeto associado à tarefa
 * @param idTar Identificador da Tarefa
 * @param dataInicio Data de Início
 * @param dataFim Data de Fim
 * @param dataInicioPrevista Previsão de Data de Início 
 * @param dataFimPrevista Previsão de Data de Finalização
 * @param tipoTarefa Tipo de Tarefa
 */
    public Tarefa(int idProj, int idTar, GregorianCalendar dataInicio, 
            GregorianCalendar dataFim, GregorianCalendar dataInicioPrevista, 
            GregorianCalendar dataFimPrevista, String tipoTarefa) {
        this.idProj = idProj;
        this.idTar = idTar;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.dataInicioPrevista = dataInicioPrevista;
        this.dataFimPrevista = dataFimPrevista;
        this.tipoTarefa = tipoTarefa;
    }
/**
 * Construtor de Cópia
 * @param t Tarefa a ser Copiada
 */
    public Tarefa(Tarefa t) {
        this.idProj = t.idProj;
        this.idTar = t.idTar;
        this.dataInicio = t.getDataInicio();
        this.dataFim = t.getDataFim();
        this.dataInicioPrevista = t.getDataInicioPrevista();
        this.dataFimPrevista = t.getDataFimPrevista();
        this.tipoTarefa = t.getTipoTarefa();
    }
/**
 * Retorna o Identificador do Projeto associado à tarefa
 * @return ID de Projecto
 */
    public int getIdProj() {
        return idProj;
    }
/**
 * Retorna o Identificador da Tarefa
 * @return Id de Tarefa
 */
    public int getIdTar() {
        return idTar;
    }
/**
 * Retorna a data de Finalização da Tarefa
 * @return Data de Finalização
 */
    public GregorianCalendar getDataFim() {
        return dataFim;
    }
/**
 * Retorna a data prevista de Finalização
 * @return Data Prevista de Finalização
 */
    public GregorianCalendar getDataFimPrevista() {
        return dataFimPrevista;
    }
/**
 * Retorna a data de Início da Tarefa
 * @return Data de Início
 */
    public GregorianCalendar getDataInicio() {
        return dataInicio;
    }
/**
 * Retorna a data Prevista de Início da Tarefa
 * @return Data Prevista de Início
 */
    public GregorianCalendar getDataInicioPrevista() {
        return dataInicioPrevista;
    }
/**
 * Retorna o Tipo de Tarefa
 * @return Tipo de Tarefa
 */
    public String getTipoTarefa() {
        return tipoTarefa;
    }
/**
 * Modifica a data de Fim
 * @param dataFim Nova data de Fim
 */
    public void setDataFim(GregorianCalendar dataFim) {
        this.dataFim = dataFim;
    }
/**
 * Modifica a data Prevista de Fim
 * @param dataFimPrevista Nova data Prevista de Fim
 */
    public void setDataFimPrevista(GregorianCalendar dataFimPrevista) {
        this.dataFimPrevista = dataFimPrevista;
    }
/**
 * Modifica a data de Início
 * @param dataInicio Nova data de Início
 */
    public void setDataInicio(GregorianCalendar dataInicio) {
        this.dataInicio = dataInicio;
    }
/**
 * Modifica a data prevista de Início
 * @param dataInicioPrevista Nova data Prevista de Início
 */
    public void setDataInicioPrevista(GregorianCalendar dataInicioPrevista) {
        this.dataInicioPrevista = dataInicioPrevista;
    }
/**
 * Modifica o tipo de Tarefa
 * @param tipoTarefa Novo Tipo de Tarefa
 */
    public void setTipoTarefa(String tipoTarefa) {
        this.tipoTarefa = tipoTarefa;
    }
    /**
     * Retorna todos os voluntários que participaram da realização da tarefa
     * @return Lista com todo o Voluntariado Realizado nesta Tarefa
     * @throws SQLException Caso exista problemas na ligação à Base de Dados 
     */
    public List<VoluntariadoRealizado> getVoluntariado() throws SQLException{
        List<VoluntariadoRealizado> vo = new ArrayList<>();
        vo.addAll(voluntarioDAO.getByTarefa(this));
        vo.addAll(equipaDAO.getByTarefa(this));
        return vo;
    }
  
    /**
     * Insere o voluntario
     * @param v the VoluntariadoRealizado to insert
     * @throws SQLException Caso exista problemas na ligação à Base de Dados 
     */
    public void putVoluntariado(VoluntariadoRealizado v) throws SQLException{
        v.setTarefa(this);
        if (v.getVoluntariado() instanceof Equipa){
            equipaDAO.updateTarefaRealizada(v);
        } else {
            voluntarioDAO.updateTarefaRealizada(v);
        }
    }
    
    /**
     * Remove um voluntario do da tarefa
     * @param v tarefa a remover
     * @throws java.sql.SQLException Caso exista problemas na ligação à Base de Dados 
     */
    public void rmVoluntariado(VoluntariadoRealizado v) throws SQLException {
         v.setTarefa(this);
        if (v.getVoluntariado() instanceof Equipa){
            equipaDAO.removeTarefaRealizada(v);
        } else {
            voluntarioDAO.removeTarefaRealizada(v);
        }
    }

    /**
     * Actualiza o voluntario guardando
     * @param v
     * @throws SQLException Caso exista problemas na ligação à Base de Dados 
     */
    public void addVoluntariado(VoluntariadoRealizado v) throws SQLException{
        v.setTarefa(this);
        if (v.getVoluntariado() instanceof Equipa){
            equipaDAO.insertTarefaRealizada(v);
        } else {
            voluntarioDAO.insertTarefaRealizada(v);
        }
    }

    
/**
 * Verificação de Igualdade Semântica entre dois objectos
 * @param obj Objecto comparado a this
 * @return True se obj e this forem semanticamente iguais, <p> Caso Contrário False
 */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Tarefa other = (Tarefa) obj;
        if (!Objects.equals(this.dataInicio, other.dataInicio)) {
            return false;
        }
        if (!Objects.equals(this.dataFim, other.dataFim)) {
            return false;
        }
        if (!Objects.equals(this.dataInicioPrevista, other.dataInicioPrevista)) {
            return false;
        }
        if (!Objects.equals(this.dataFimPrevista, other.dataFimPrevista)) {
            return false;
        }
        if (!Objects.equals(this.tipoTarefa, other.tipoTarefa)) {
            return false;
        }
        return true;
    }
    
    
   /**
    * Retorna uma cópia da instância actual
    * @return Cópia profunda da Instância Actual
    */ 
    public Tarefa clone()
    {
        return new Tarefa(this);
    }
/**
 * Retorna a representação textual da tarefa usando o Identificador da tarefa, Tipo de Tarefa e Identificador de Projeto
 * @return Representação textual da Tarefa
 */
    @Override
    public String toString(){
        return new String(this.idTar+"."+this.tipoTarefa+"."+this.idProj);
    }


}