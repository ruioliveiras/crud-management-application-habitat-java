/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import business.admin.TipoActividade;
import business.admin.Funcionario;
import business.admin.TipoQuestao;
import business.admin.TipoDonativo;
import business.admin.TipoTarefa;
import business.building.Projeto;
import business.familiy.Candidatura;
import business.familiy.Familia;
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
import persistence.familia.FamiliaDAO;
import persistence.fundos.DoadorDAO;
import persistence.fundos.DonativoDAO;
import persistence.fundos.EquipaDAO;
import persistence.fundos.EventoDAO;
import persistence.fundos.VoluntarioDAO;

/**
 *
 * @author ruioliveiras
 */
public class Habitat {
    private Funcionario funcionario;
    
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

    public List<TipoTarefa> tipoTarefaGetAll() throws SQLException {return tipoTarefaDAO.getAll();}
    public TipoTarefa tipoTarefaGetById(int id) throws SQLException {return tipoTarefaDAO.getById(id);}
    public void tipoTarefaInsert(TipoTarefa obj) throws SQLException {tipoTarefaDAO.insert(obj);}
    public void tipoTarefaRemove(TipoTarefa obj) throws SQLException {tipoTarefaDAO.remove(obj);}
    public void tipoTarefaUpdate(TipoTarefa obj) throws SQLException {tipoTarefaDAO.update(obj);}
    public List<TipoActividade> actividadeGetAll() throws SQLException {return actividadeDAO.getAll();}
    public TipoActividade actividadeGetById(int id) throws SQLException {return actividadeDAO.getById(id);}
    public void actividadeInsert(TipoActividade obj) throws SQLException {actividadeDAO.insert(obj);}
    public void actividadeRemove(TipoActividade obj) throws SQLException {actividadeDAO.remove(obj);}
    public void actividadeUpdate(TipoActividade obj) throws SQLException {actividadeDAO.update(obj);}
    public List<TipoDonativo> tipoDonativoGetAll() throws SQLException {return tipoDonativoDAO.getAll();}
    public TipoDonativo tipoDonativoGetById(int id) throws SQLException {return tipoDonativoDAO.getById(id);}
    public void tipoDonativoInsert(TipoDonativo obj) throws SQLException {tipoDonativoDAO.insert(obj);}
    public void tipoDonativoRemove(TipoDonativo obj) throws SQLException {tipoDonativoDAO.remove(obj);}
    public void tipoDonativoUpdate(TipoDonativo obj) throws SQLException {tipoDonativoDAO.update(obj);}
    public List<Funcionario> funcionarioGetAll() throws SQLException {return funcionarioDAO.getAll();}
    public Funcionario funcionarioGetById(int id) throws SQLException {return funcionarioDAO.getById(id);}
    public void funcionarioInsert(Funcionario obj) throws SQLException {funcionarioDAO.insert(obj);}
    public void funcionarioRemove(Funcionario obj) throws SQLException {funcionarioDAO.remove(obj);}
    public void funcionarioUpdate(Funcionario obj) throws SQLException {funcionarioDAO.update(obj);}
    public List<TipoQuestao> questaoGetAll() throws SQLException {return questaoDAO.getAll();}
    public TipoQuestao questaoGetById(int id) throws SQLException {return questaoDAO.getById(id);}
    public void questaoInsert(TipoQuestao obj) throws SQLException {questaoDAO.insert(obj);}
    public void questaoRemove(TipoQuestao obj) throws SQLException {questaoDAO.remove(obj);}
    public void questaoUpdate(TipoQuestao obj) throws SQLException {questaoDAO.update(obj);}
    public List<Projeto> projetoGetAll() throws SQLException {return projetoDAO.getAll();}
    public Projeto projetoGetById(int id) throws SQLException {return projetoDAO.getById(id);}
    public void projetoInsert(Projeto obj) throws SQLException {projetoDAO.insert(obj);}
    public void projetoRemove(Projeto obj) throws SQLException {projetoDAO.remove(obj);}
    public void projetoUpdate(Projeto obj) throws SQLException {projetoDAO.update(obj);}
    public List<Familia> familiaGetAll() throws SQLException {return familiaDAO.getAll();}
    public Familia familiaGetById(int id) throws SQLException {return familiaDAO.getById(id);}
    public void familiaInsert(Familia obj) throws SQLException {familiaDAO.insert(obj);}
    public void familiaRemove(Familia obj) throws SQLException {familiaDAO.remove(obj);}
    public void familiaUpdate(Familia obj) throws SQLException {}
    public void familiaUpdate(Familia f, Candidatura c) throws SQLException { familiaDAO.update(f, c); }
//    public List<Candidatura> candidaturaGetAll() throws SQLException {return familiaDAO.getAll();}
//    public Candidatura candidaturaGetById(int id) throws SQLException {return familiaDAO.getC;}
//    public void candidaturaInsert(Candidatura obj) throws SQLException {familiaDAO.insertCand(obj);}
//    public void candidaturaRemove(Candidatura obj) throws SQLException {familiaDAO. obj);}
//    public void candidaturaUpdate(Candidatura obj) throws SQLException {familiaDAO.up;}
    
    
    public List<Voluntario> voluntarioGetAll() throws SQLException {return voluntarioDAO.getAll();}
    public Voluntario voluntarioGetById(int id) throws SQLException {return voluntarioDAO.getById(id);}
    public void voluntarioInsert(Voluntario obj) throws SQLException {voluntarioDAO.insert(obj);}
    public void voluntarioRemove(Voluntario obj) throws SQLException {voluntarioDAO.remove(obj);}
    public void voluntarioUpdate(Voluntario obj) throws SQLException {voluntarioDAO.update(obj);}
    public List<Equipa> equipaGetAll() throws SQLException {return equipaDAO.getAll();}
    public Equipa equipaGetById(int id) throws SQLException {return equipaDAO.getById(id);}
    public void equipaInsert(Equipa obj) throws SQLException {equipaDAO.insert(obj);}
    public void equipaRemove(Equipa obj) throws SQLException {equipaDAO.remove(obj);}
    public void equipaUpdate(Equipa obj) throws SQLException {equipaDAO.update(obj);}
    public List<Evento> eventoGetAll() throws SQLException {return eventoDAO.getAll();}
    public Evento eventoGetById(int id) throws SQLException {return eventoDAO.getById(id);}
    public void eventoInsert(Evento obj) throws SQLException {eventoDAO.insert(obj);}
    public void eventoRemove(Evento obj) throws SQLException {eventoDAO.remove(obj);}
    public void eventoUpdate(Evento obj) throws SQLException {eventoDAO.update(obj);}
    public List<Doador> doadoresGetAll() throws SQLException {return doadoresDAO.getAll();}
    public Doador doadoresGetById(int id) throws SQLException {return doadoresDAO.getById(id);}
    public void doadoresInsert(Doador obj) throws SQLException {doadoresDAO.insert(obj);}
    public void doadoresRemove(Doador obj) throws SQLException {doadoresDAO.remove(obj);}
    public void doadoresUpdate(Doador obj) throws SQLException {doadoresDAO.update(obj);}
    public List<Donativo> donativoGetAll() throws SQLException {return donativoDAO.getAll();}
    public Donativo donativoGetById(int id) throws SQLException {return donativoDAO.getById(id);}
    public void donativoInsert(Donativo obj) throws SQLException {donativoDAO.insert(obj);}
    public void donativoRemove(Donativo obj) throws SQLException {donativoDAO.remove(obj);}
    public void donativoUpdate(Donativo obj) throws SQLException {donativoDAO.update(obj);}


    
    public boolean login(String username, String password) throws SQLException {
        this.funcionario = funcionarioDAO.getByUsername(username);
        if (funcionario.getPassword().equals(password)){
            return true;
        } else {
            this.funcionario = null;
            return false;
        }
    }
    
        public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }   

}
