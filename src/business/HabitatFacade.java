/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import business.admin.Actividade;
import business.admin.Funcionario;
import business.admin.Questao;
import business.admin.TipoDonativo;
import business.admin.TipoTarefa;
import business.building.Projeto;
import java.sql.SQLException;
import java.util.List;
import persistence.ProjetoDAO;
import persistence.admin.ActividadeDAO;
import persistence.admin.FuncionarioDAO;
import persistence.admin.QuestaoDAO;
import persistence.admin.TipoDonativoDAO;
import persistence.admin.TipoTarefaDAO;

/**
 *
 * @author ruioliveiras
 */
public class HabitatFacade {
    private Funcionario funcionario;
    
    private final TipoTarefaDAO tipoTarefaDAO = new TipoTarefaDAO(); 
    private final ActividadeDAO actividadeDAO = new ActividadeDAO(); 
    private final TipoDonativoDAO tipoDonativoDAO = new TipoDonativoDAO(); 
    private final FuncionarioDAO funcionarioDAO = new FuncionarioDAO(); 
    private final QuestaoDAO questaoDAO = new QuestaoDAO(); 
    private final ProjetoDAO projetoDAO = new ProjetoDAO();

    public List<TipoTarefa> tipoTarefaGetAll() throws SQLException {return tipoTarefaDAO.getAll();}
    public TipoTarefa tipoTarefaGetById(int id) throws SQLException {return tipoTarefaDAO.getById(id);}
    public void tipoTarefaInsert(TipoTarefa obj) throws SQLException {tipoTarefaDAO.insert(obj);}
    public void tipoTarefaRemove(TipoTarefa obj) throws SQLException {tipoTarefaDAO.remove(obj);}
    public void tipoTarefaUpdate(TipoTarefa obj) throws SQLException {tipoTarefaDAO.update(obj);}
    public List<Actividade> actividadeGetAll() throws SQLException {return actividadeDAO.getAll();}
    public Actividade actividadeGetById(int id) throws SQLException {return actividadeDAO.getById(id);}
    public void actividadeInsert(Actividade obj) throws SQLException {actividadeDAO.insert(obj);}
    public void actividadeRemove(Actividade obj) throws SQLException {actividadeDAO.remove(obj);}
    public void actividadeUpdate(Actividade obj) throws SQLException {actividadeDAO.update(obj);}
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
    public List<Questao> questaoGetAll() throws SQLException {return questaoDAO.getAll();}
    public Questao questaoGetById(int id) throws SQLException {return questaoDAO.getById(id);}
    public void questaoInsert(Questao obj) throws SQLException {questaoDAO.insert(obj);}
    public void questaoRemove(Questao obj) throws SQLException {questaoDAO.remove(obj);}
    public void questaoUpdate(Questao obj) throws SQLException {questaoDAO.update(obj);}
    public List<Projeto> projetoGetAll() throws SQLException {return projetoDAO.getAll();}
    public Projeto projetoGetById(int id) throws SQLException {return projetoDAO.getById(id);}
    public void projetoInsert(Projeto obj) throws SQLException {projetoDAO.insert(obj);}
    public void projetoRemove(Projeto obj) throws SQLException {projetoDAO.remove(obj);}
    public void projetoUpdate(Projeto obj) throws SQLException {projetoDAO.update(obj);}

    public boolean login(String username, String password) throws SQLException {
        this.funcionario = funcionarioDAO.getByUsername(username);
        if (funcionario.getPassword().equals(password)){
            return true;
        } else {
            this.funcionario = null;
            return false;
        }
    }


}
