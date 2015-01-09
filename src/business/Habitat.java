/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import business.admin.Funcionario;
import business.admin.TipoActividade;
import business.admin.TipoDonativo;
import business.admin.TipoQuestao;
import business.admin.TipoTarefa;
import business.building.Projeto;
import business.familiy.Candidatura;
import business.familiy.Familia;
import business.familiy.Prestacao;
import business.funds.Doador;
import business.funds.Donativo;
import business.funds.Equipa;
import business.funds.Evento;
import business.funds.Voluntario;
import java.sql.SQLException;
import java.util.List;
import persistence.ProjetoDAO;
import persistence.admin.ActividadeDAO;
import persistence.admin.FuncionarioDAO;
import persistence.admin.QuestaoDAO;
import persistence.admin.TipoDonativoDAO;
import persistence.admin.TipoTarefaDAO;
import persistence.familia.CandidaturaDAO;
import persistence.familia.FamiliaDAO;
import persistence.fundos.DoadorDAO;
import persistence.fundos.DonativoDAO;
import persistence.fundos.EquipaDAO;
import persistence.fundos.EventoDAO;
import persistence.fundos.VoluntarioDAO;

/**
 * Classe que serve de Facade à UI 
 * @author ruioliveiras
 */
public class Habitat {
    private Funcionario funcionario = null;
    
    private final TipoTarefaDAO tipoTarefaDAO = new TipoTarefaDAO(); 
    private final ActividadeDAO actividadeDAO = new ActividadeDAO(); 
    private final TipoDonativoDAO tipoDonativoDAO = new TipoDonativoDAO(); 
    private final FuncionarioDAO funcionarioDAO = new FuncionarioDAO(); 
    private final QuestaoDAO questaoDAO = new QuestaoDAO(); 
    private final ProjetoDAO projetoDAO = new ProjetoDAO();
    private final FamiliaDAO familiaDAO = new FamiliaDAO();
    private final VoluntarioDAO voluntarioDAO = new VoluntarioDAO();
    private final EquipaDAO equipaDAO = new EquipaDAO();
    private final EventoDAO eventoDAO = new EventoDAO();
    private final DoadorDAO doadoresDAO = new DoadorDAO();
    private final DonativoDAO donativoDAO = new DonativoDAO();
    private final CandidaturaDAO candidaturaDAO = new CandidaturaDAO();
    
    public void candidaturaUpdateEstado(Candidatura cand) throws SQLException
    { candidaturaDAO.updateEstado(cand); }
    /**
     * Retorna todos os tipos de tarefa 
     * @return Lista com todos os tipos de tarefa
     * @throws SQLException Se existir algum problema de ligação à Base de Dados
     */
    public List<TipoTarefa> tipoTarefaGetAll() throws SQLException {return tipoTarefaDAO.getAll();}
    /**
     * Retorna o tipo de tarefa que tenha o id passado como parâmetro
     * @param id Identificador do tipo de tarefa 
     * @return Tipo de Tarefa identificado por id
     * @throws SQLException Se existir algum problema de ligação à Base de Dados
     */
    public TipoTarefa tipoTarefaGetById(int id) throws SQLException {return tipoTarefaDAO.getById(id);}
    /**
     * Insere na Base de Dados um novo Tipo de Tarefa
     * @param obj Tipo de Tarefa a ser inserido na Base de Dados
     * @throws SQLException Se existir algum problema de ligação à Base de Dados
     */
    public void tipoTarefaInsert(TipoTarefa obj) throws SQLException {tipoTarefaDAO.insert(obj);}
    /**
     * Remove da Base de Dados um Tipo de Tarefa
     * @param obj Tipo de Tarefa a ser removido da Base de Dados
     * @throws SQLException Se existir algum problema de ligação à Base de Dados
     */
    public void tipoTarefaRemove(TipoTarefa obj) throws SQLException {tipoTarefaDAO.remove(obj);}
    /**
     * Atualiza na Base de Dados um Tipo de Tarefa
     * @param obj Tipo de Tarefa a ser atualizado na Base de Dados
     * @throws SQLException Se existir algum problema de ligação à Base de Dados
     */
    public void tipoTarefaUpdate(TipoTarefa obj) throws SQLException {tipoTarefaDAO.update(obj);}
    /**
     * Retorna todas as actividades existentes
     * @return Lista com todas as actividades existentes na Base de Dados
     * @throws SQLException Se existir algum problema de ligação à Base de Dados
     */
    public List<TipoActividade> actividadeGetAll() throws SQLException {return actividadeDAO.getAll();}
    /**
     * Retorna a actividade identificada pelo id passado como parâmetro 
     * @param id Identificador de actividade
     * @return Atividade identificada por id
     * @throws SQLException Se existir algum problema de ligação à Base de Dados
     */
    public TipoActividade actividadeGetById(int id) throws SQLException {return actividadeDAO.getById(id);}
    /**
     * Insere na Base de Dados um novo Tipo de Actividade
     * @param obj Tipo de Actividade a ser adicionado
     * @throws SQLException Se existir algum problema de ligação à Base de Dados
     */
    public void actividadeInsert(TipoActividade obj) throws SQLException {actividadeDAO.insert(obj);}
    /**
     * Remove da Base de Dados um Tipo de Actividade
     * @param obj Tipo de Actividade a ser removido
     * @throws SQLException Se existir algum problema de ligação à Base de Dados
     */
    public void actividadeRemove(TipoActividade obj) throws SQLException {actividadeDAO.remove(obj);}
    /**
     * Actualiza na Base de Dados um Tipo de Actividade
     * @param obj Tipo de Actividade a ser actualizado
     * @throws SQLException Se existir algum problema de ligação à Base de Dados
     */
    public void actividadeUpdate(TipoActividade obj) throws SQLException {actividadeDAO.update(obj);}
    /**
     * Retorna todos os tipos de donativo existentes
     * @return Lista com todos os tipos de donativo existentes
     * @throws SQLException Se existir algum problema de ligação à Base de Dados
     */
    public List<TipoDonativo> tipoDonativoGetAll() throws SQLException {return tipoDonativoDAO.getAll();}
    /**
     * Retorna o Tipo de Donativo identificado por id passado como parâmetro
     * @param id Identificador do Tipo de Donativo 
     * @return Tipo de Donativo identificado por id
     * @throws SQLException Se existir algum problema de ligação à Base de Dados
     */
    public TipoDonativo tipoDonativoGetById(int id) throws SQLException {return tipoDonativoDAO.getById(id);}
    /**
     * Insere um novo Tipo de Donativo na Base de Dados 
     * @param obj Tipo de Donativo a ser inserido na Base de Dados
     * @throws SQLException Se existir algum problema de ligação à Base de Dados
     */
    public void tipoDonativoInsert(TipoDonativo obj) throws SQLException {tipoDonativoDAO.insert(obj);}
    /**
     * Remove um Tipo de Donativo da Base de Dados
     * @param obj Tipo de Donativo a ser Removido da Base de Dados
     * @throws SQLException Se existir algum problema de ligação à Base de Dados
     */
    public void tipoDonativoRemove(TipoDonativo obj) throws SQLException {tipoDonativoDAO.remove(obj);}
    /**
     * Atualiza um Tipo de Donativo da Base de Dados
     * @param obj Tipo de Donativo a ser Atualizado na Base de Dados
     * @throws SQLException Se existir algum problema de ligação à Base de Dados
     */
    public void tipoDonativoUpdate(TipoDonativo obj) throws SQLException {tipoDonativoDAO.update(obj);}
    /**
     * Retorna todos os Funcionários existentes 
     * @return Lista com todos os Funcionários existentes na Base de dados
     * @throws SQLException Se existir algum problema de ligação à Base de Dados
     */
    public List<Funcionario> funcionarioGetAll() throws SQLException {return funcionarioDAO.getAll();}
    /**
     * Retorna o Funcionário identificado por id, pasado como parâmetro
     * @param id Identificador do Funcionário
     * @return Funcionário identificado por id
     * @throws SQLException Se existir algum problema de ligação à Base de Dados
     */
    public Funcionario funcionarioGetById(int id) throws SQLException {return funcionarioDAO.getById(id);}
    /**
     * Insere um novo Funcionário na Base de Dados
     * @param obj Funcionário a ser adicionado na Base de Dados
     * @throws SQLException Se existir algum problema de ligação à Base de Dados
     */
    public void funcionarioInsert(Funcionario obj) throws SQLException {funcionarioDAO.insert(obj);}
    /**
     * Remove um Funcionário da Base de Dados
     * @param obj Funcionário a ser removido da Base de Dados
     * @throws SQLException Se existir algum problema de ligação à Base de Dados
     */
    public void funcionarioRemove(Funcionario obj) throws SQLException {funcionarioDAO.remove(obj);}
    /**
     * Actualiza um Funcionário existente na Base de Dados
     * @param obj Funcionário a ser actualizado na Base de Dados
     * @throws SQLException Se existir algum problema de ligação à Base de Dados
     */
    public void funcionarioUpdate(Funcionario obj) throws SQLException {funcionarioDAO.update(obj);}
    /**
     * Retorna todos os tipos de questão existentes
     * @return Lista com todos os tipos de questão existentes
     * @throws SQLException Se existir algum problema de ligação à Base de Dados
     */
    public List<TipoQuestao> questaoGetAll() throws SQLException {return questaoDAO.getAll();}
    /**
     * Retorna o tipo de questão identificado por id, passado como parâmetro
     * @param id Identificador do tipo de questão
     * @return Tipo de questão identificado por id
     * @throws SQLException Se existir algum problema de ligação à Base de Dados
     */
    public TipoQuestao questaoGetById(int id) throws SQLException {return questaoDAO.getById(id);}
    /**
     * Insere um novo tipo de Questão na Base de Dados
     * @param obj Tipo de Questão a ser adicionado à Base de Dados
     * @throws SQLException Se existir algum problema de ligação à Base de Dados
     */
    public void questaoInsert(TipoQuestao obj) throws SQLException {questaoDAO.insert(obj);}
    /**
     * Remove um tipo de Questão da Base de Dados
     * @param obj Tipo de Questão a ser removida da Base de Dados
     * @throws SQLException Se existir algum problema de ligação à Base de Dados
     */
    public void questaoRemove(TipoQuestao obj) throws SQLException {questaoDAO.remove(obj);}
    /**
     * Actualiza um tipo de Questão na Base de Dados
     * @param obj Tipo de Questão a ser atualizada na Base de Dados
     * @throws SQLException Se existir algum problema de ligação à Base de Dados
     */
    public void questaoUpdate(TipoQuestao obj) throws SQLException {questaoDAO.update(obj);}
    /**
     * Retorna todos os Projetos existentes
     * @return Lista com todos os Projectos existentes na Base de Dados
     * @throws SQLException Se existir algum problema de ligação à Base de Dados
     */
    public List<Projeto> projetoGetAll() throws SQLException {return projetoDAO.getAll();}
    /**
     * Retorna o Projeto identificado por id, passado como parâmetro
     * @param id Identificador do projeto 
     * @return Projeto identificado por id
     * @throws SQLException Se existir algum problema de ligação à Base de Dados
     */
    public Projeto projetoGetById(int id) throws SQLException {return projetoDAO.getById(id);}
    /**
     * Insere um novo projeto na Base de Dados
     * @param obj Projeto a ser adicionado à Base de Dados
     * @throws SQLException Se existir algum problema de ligação à Base de Dados
     */
    public void projetoInsert(Projeto obj) throws SQLException {projetoDAO.insert(obj);}
    /**
     * Remove um projeto da Base de Dados
     * @param obj Projeto a ser Removido da Base de Dados
     * @throws SQLException Se existir algum problema de ligação à Base de Dados
     */
    public void projetoRemove(Projeto obj) throws SQLException {projetoDAO.remove(obj);}
    /**
     * Atualiza um projeto existente na Base de Dados
     * @param obj Projeto a ser atualizado na Base de Dados
     * @throws SQLException Se existir algum problema de ligação à Base de Dados
     */
    public void projetoUpdate(Projeto obj) throws SQLException {projetoDAO.update(obj);}
    /**
     * Retorna todas as Familias existentes 
     * @return Lista com todas as Familias existentes na Base de Dados
     * @throws SQLException 
     */
    public List<Familia> familiaGetAll() throws SQLException {return familiaDAO.getAll();}
    /**
     * Retorna a Familia identificada por id, passado como parâmetro
     * @param id Identificador da Familia
     * @return Familia identificada por id
     * @throws SQLException Se existir algum problema de ligação à Base de Dados
     */
    public Familia familiaGetById(int id) throws SQLException {return familiaDAO.getById(id);}
    /**
     * Insere uma nova Familia na Base de Dados
     * @param obj Familia a ser adicionada à Base de Dados
     * @throws SQLException Se existir algum problema de ligação à Base de Dados
     */
    public void familiaInsert(Familia obj) throws SQLException {familiaDAO.insert(obj);}
    /**
     * Remove uma Familia da Base de Dados
     * @param obj Familia a ser removida da Base de Dados
     * @throws SQLException Se existir algum problema de ligação à Base de Dados
     */
    public void familiaRemove(Familia obj) throws SQLException {familiaDAO.remove(obj);}
    /**
     * Atualiza uma Familia existente na Base de Dados
     * @param obj Familia a ser atualizada na Base de Dados
     * @throws SQLException Se existir algum problema de ligação à Base de Dados
     */
    public void familiaUpdate(Familia obj) throws SQLException {}
    /**
     * Atualiza uma Familia existente na Base de Dados, adicionando-lhe uma Candidatura
     * @param f Familia que vai receber a candidatura
     * @param c Candidatura que será associada à família
     * @throws SQLException Se existir algum problema de ligação à Base de Dados
     */
    public void familiaUpdate(Familia f, Candidatura c) throws SQLException { familiaDAO.update(f, c); }
//    public List<Candidatura> candidaturaGetAll() throws SQLException {return familiaDAO.getAll();}
//    public Candidatura candidaturaGetById(int id) throws SQLException {return familiaDAO.getC;}
//    public void candidaturaInsert(Candidatura obj) throws SQLException {familiaDAO.insertCand(obj);}
//    public void candidaturaRemove(Candidatura obj) throws SQLException {familiaDAO. obj);}
//    public void candidaturaUpdate(Candidatura obj) throws SQLException {familiaDAO.up;}
    /**
    * Retorna todas as prestações relativas a uma família
    * @param idFam Identificador da Familia à qual pertencem as prestações
    * @return Lista com todas as prestações relativas à família identificada por idFam
    * @throws SQLException Se existir algum problema de ligação à Base de Dados
    */
    public List<Prestacao> PrestacaoGet(int idFam)throws SQLException { return familiaDAO.getPrestacoes(idFam); }
    /**
     * Insere uma nova Prestação na Base de Dados
     * @param p Prestação a ser adicionada à Base de Dados
     * @throws SQLException Se existir algum problema de ligação à Base de Dados
     */
    public void PrestacaoInsert(Prestacao p)throws SQLException { familiaDAO.insertPrestacao(p);}
    /**
     * Atualiza uma Prestação existente na Base de Dados
     * @param p Prestação a ser atualizada na Base de Dados
     * @throws SQLException Se existir algum problema de ligação à Base de Dados
     */
    public void PrestacaoUpdate(Prestacao p)throws SQLException { familiaDAO.updatePrestacao(p);}
    /**
     * Remove uma Prestação da Base de Dados
     * @param p Prestação a ser removida da Base de Dados
     * @throws SQLException Se existir algum problema de ligação à Base de Dados
     */
    public void PrestacaoRemove(Prestacao p)throws SQLException { familiaDAO.removePrestacao(p); }
    
     /**
     * Retorna todos os Voluntários existentes 
     * @return Lista com todos os Voluntários existentes na Base de Dados
     * @throws SQLException Se existir algum problema de ligação à Base de Dados
     */
    public List<Voluntario> voluntarioGetAll() throws SQLException {return voluntarioDAO.getAll();}
     /**
     * Retorna o Voluntário identificado por id, passado como parâmetro
     * @param id Identificador do Voluntário 
     * @return Projeto identificado por id
     * @throws SQLException Se existir algum problema de ligação à Base de Dados
     */
    public Voluntario voluntarioGetById(int id) throws SQLException {return voluntarioDAO.getById(id);}
     /**
     * Insere um novo Voluntário na Base de Dados
     * @param obj Voluntário a ser adicionado à Base de Dados
     * @throws SQLException Se existir algum problema de ligação à Base de Dados
     */
    public void voluntarioInsert(Voluntario obj) throws SQLException {voluntarioDAO.insert(obj);}
     /**
     * Remove um Voluntário da Base de Dados
     * @param obj Voluntário a ser removido da Base de Dados
     * @throws SQLException Se existir algum problema de ligação à Base de Dados
     */
    public void voluntarioRemove(Voluntario obj) throws SQLException {voluntarioDAO.remove(obj);}
         /**
     * Atualiza um Voluntário existente na Base de Dados
     * @param obj Voluntário a ser atualizado na Base de Dados
     * @throws SQLException Se existir algum problema de ligação à Base de Dados
     */
    public void voluntarioUpdate(Voluntario obj) throws SQLException {voluntarioDAO.update(obj);}
    /**
     * Retorna todos as Equipas existentes 
     * @return Lista com todas as Equipas existentes na Base de Dados
     * @throws SQLException Se existir algum problema de ligação à Base de Dados
     */
    public List<Equipa> equipaGetAll() throws SQLException {return equipaDAO.getAll();}
    /**
     * Retorna a Equipa identificada por id, passado como parâmetro
     * @param id Identificador da Equipa 
     * @return Equipa identificado por id
     * @throws SQLException Se existir algum problema de ligação à Base de Dados
     */    
    public Equipa equipaGetById(int id) throws SQLException {return equipaDAO.getById(id);}
    /**
    * Insere uma nova Equipa na Base de Dados
    * @param obj Equipa a ser adicionada à Base de Dados
     * @throws SQLException Se existir algum problema de ligação à Base de Dados
     */
    public void equipaInsert(Equipa obj) throws SQLException {equipaDAO.insert(obj);}
    /**
     * Remove uma Equipa da Base de Dados
     * @param obj Equipa a ser removida da Base de Dados
     * @throws SQLException Se existir algum problema de ligação à Base de Dados
    */
    public void equipaRemove(Equipa obj) throws SQLException {equipaDAO.remove(obj);}
    /**
     * Atualiza uma Equipa existente na Base de Dados
     * @param obj Equipa a ser atualizada na Base de Dados
     * @throws SQLException Se existir algum problema de ligação à Base de Dados
     */
    public void equipaUpdate(Equipa obj) throws SQLException {equipaDAO.update(obj);}
     /**
     * Retorna todos os Eventos existentes 
     * @return Lista com todos os Eventos existentes na Base de Dados
     * @throws SQLException Se existir algum problema de ligação à Base de Dados
     */
    public List<Evento> eventoGetAll() throws SQLException {return eventoDAO.getAll();}
    /**
     * Retorna o Evento identificado por id, passado como parâmetro
     * @param id Identificador do Evento 
     * @return Evento identificado por id
     * @throws SQLException Se existir algum problema de ligação à Base de Dados
     */
    public Evento eventoGetById(int id) throws SQLException {return eventoDAO.getById(id);}
    /**
     * Insere um novo Evento na Base de Dados
     * @param obj Evento a ser adicionado à Base de Dados
     * @throws SQLException Se existir algum problema de ligação à Base de Dados
     */
    public void eventoInsert(Evento obj) throws SQLException {eventoDAO.insert(obj);}
    /**
     * Remove um Evento da Base de Dados
     * @param obj Evento a ser removido da Base de Dados
     * @throws SQLException Se existir algum problema de ligação à Base de Dados
     */
    public void eventoRemove(Evento obj) throws SQLException {eventoDAO.remove(obj);}
    /**
     * Atualiza um Evento existente na Base de Dados
     * @param obj Evento a ser atualizado na Base de Dados
     * @throws SQLException Se existir algum problema de ligação à Base de Dados
     */
    public void eventoUpdate(Evento obj) throws SQLException {eventoDAO.update(obj);}
    /**
     * Retorna todos os Doadores existentes 
     * @return Lista com todos os Doadores existentes na Base de Dados
     * @throws SQLException Se existir algum problema de ligação à Base de Dados
     */
    public List<Doador> doadoresGetAll() throws SQLException {return doadoresDAO.getAll();}
     /**
     * Retorna o Doador identificado por id, passado como parâmetro
     * @param id Identificador do Doador 
     * @return Doadro identificado por id
     * @throws SQLException Se existir algum problema de ligação à Base de Dados
     */
    public Doador doadoresGetById(int id) throws SQLException {return doadoresDAO.getById(id);}
    /**
     * Insere um novo Doador na Base de Dados
     * @param obj Doador a ser adicionado à Base de Dados
     * @throws SQLException Se existir algum problema de ligação à Base de Dados
     */
    public void doadoresInsert(Doador obj) throws SQLException {doadoresDAO.insert(obj);}
    /**
     * Remove um Doador da Base de Dados
     * @param obj Doador a ser removido da Base de Dados
     * @throws SQLException Se existir algum problema de ligação à Base de Dados
     */    
    public void doadoresRemove(Doador obj) throws SQLException {doadoresDAO.remove(obj);}
    /**
     * Atualiza um Doador existente na Base de Dados
     * @param obj Doador a ser atualizado na Base de Dados
     * @throws SQLException Se existir algum problema de ligação à Base de Dados
     */    
    public void doadoresUpdate(Doador obj) throws SQLException {doadoresDAO.update(obj);}
     /**
     * Retorna todos os Donativos existentes 
     * @return Lista com todos os Donativos existentes na Base de Dados
     * @throws SQLException Se existir algum problema de ligação à Base de Dados
     */    
    public List<Donativo> donativoGetAll() throws SQLException {return donativoDAO.getAll();}
    /**
     * Retorna o Donativo identificado por id, passado como parâmetro
     * @param id Identificador do Donativo 
     * @return Donativo identificado por id
     * @throws SQLException Se existir algum problema de ligação à Base de Dados
     */
    public Donativo donativoGetById(int id) throws SQLException {return donativoDAO.getById(id);}
    /**
     * Insere um novo Donativo na Base de Dados
     * @param obj Donativo a ser adicionado à Base de Dados
     * @throws SQLException Se existir algum problema de ligação à Base de Dados
     */
    public void donativoInsert(Donativo obj) throws SQLException {donativoDAO.insert(obj);}
    /**
     * Atualiza um Doador existente na Base de Dados
     * @param obj Doador a ser atualizado na Base de Dados
     * @throws SQLException Se existir algum problema de ligação à Base de Dados
     */    
    public void donativoRemove(Donativo obj) throws SQLException {donativoDAO.remove(obj);}
    /**
     * Atualiza um Donativo existente na Base de Dados
     * @param obj Donativo a ser atualizado na Base de Dados
     * @throws SQLException Se existir algum problema de ligação à Base de Dados
     */    
    public void donativoUpdate(Donativo obj) throws SQLException {donativoDAO.update(obj);}


    /**
     * Método de validação de credenciais de entrada
     * <p>
     * Se a palavra passe guardada em Base de Dados coincidir com a password passada como parâmetro, o funcionario será carregado 
     * com o utilizador carregado da Base de Dados.
     * @param username Nome de utilizador
     * @param password Palavra passe
     * @return True, se a palavra passe em Base de Dados coincidir com password.<p>Caso contrário False.
     * @throws SQLException 
     */
    public boolean login(String username, String password) throws SQLException {
        this.funcionario = funcionarioDAO.getByUsername(username);
        if(funcionario == null) return false;
        if (funcionario.getPassword().equals(password)){
            return true;
        } else {
            this.funcionario = null;
            return false;
        }
    }
    /**
     * Retorna o Funcionário associado a esta sessão 
     * @return Funcionário associado à sessão
     */
    public Funcionario getFuncionario() {
        return funcionario;
    }
/**
 * Associa um funcionário à sessão
 * @param funcionario Funcionário a ser associado à sessão
 */
    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }   

}
