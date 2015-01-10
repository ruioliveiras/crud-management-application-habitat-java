/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import persistence.util.GenericDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.GregorianCalendar;
import javax.naming.NamingException;
import business.building.Projeto;
import business.building.Tarefa;
import java.util.List;

/**
 *
 * @author ruioliveiras
 */
public class ProjetoDAO extends GenericDAO<Projeto> {

    protected enum Attr {

        idProj, orcamento, prazo, dataInicio, dataFim, idFunc, idCand, designacao, descricao, dataCriaProj
    };

    private TarefasDAO tarefasDAO = new TarefasDAO();
    
    public ProjetoDAO() {
        super(Attr.values(), 1, "Projeto");
    }

    @Override
    protected String getToBD(Projeto p, Enum<?> en) {
        Attr a = (Attr) en;
        switch (a) {
            case idProj:
                return toSQL(p.getId());
            case orcamento:
                return toSQL(p.getOrcamento());
            case prazo:
                return toSQL(p.getPrazo());
            case dataInicio:
                return toSQL(p.getDataInicio());
            case dataFim:
                return toSQL(p.getDataFim());
            case idFunc:
                return toSQL(p.getFuncionarioId());
            case idCand:
                return toSQL(p.getCandidaturaId());
            case designacao:
                return toSQL(p.getDesignacao());
            case descricao:
                return toSQL(p.getDescricao());
            case dataCriaProj:
                return toSQL(p.getDataCriaProj());
            default:
                return toSQL((String) null);
        }
    }

    //preciso da lista dos attrs,
    //contruir por rs
    //aceder dinamicamente;
    @Override
    public Projeto newObject(ResultSet rs) throws SQLException {
        return new Projeto(
                rs.getInt(Attr.idProj.name()),
                rs.getInt(Attr.idFunc.name()),
                rs.getInt(Attr.idCand.name()),
                rs.getInt(Attr.orcamento.name()),
                0.0,//shit
                rs.getNString(Attr.designacao.name()),
                rs.getNString(Attr.descricao.name()),
                fromSQL(rs.getDate(Attr.dataInicio.name())),
                fromSQL(rs.getDate(Attr.dataFim.name())),
                fromSQL(rs.getDate(Attr.dataCriaProj.name())),
                fromSQL(rs.getDate(Attr.prazo.name()))
        );
    }

    public List<Tarefa> getTarefasAllByIdProg(int idtar) throws SQLException{
        return tarefasDAO.getByIdAll(idtar);
    }
    public void insertTarefa(Tarefa idtar) throws SQLException{
        tarefasDAO.insertNoAuto(idtar);
    }
    public void removeTarefa(Tarefa t) throws SQLException{
       tarefasDAO.remove(t);
    }
    public void updateTarefa(Tarefa t) throws SQLException{
       tarefasDAO.update(t);
    }
    
    private static class TarefasDAO extends GenericDAO<Tarefa> {

        protected enum Attr {

            idProj, idTar, dataPlInicio, dataPlFim, DataExInicio, dataExFim
        };
        //extra

        public TarefasDAO() {
            super(TarefasDAO.Attr.values(), 2, "TarefaProjeto", "ViewTarefaProjeto");
        }

        @Override
        protected String getToBD(Tarefa p, Enum<?> en) {
            Attr a = (Attr) en;
            switch (a){
                case idProj: return toSQL(p.getIdProj());
                case idTar:return toSQL(p.getIdTar());
                case dataPlInicio: return toSQL(p.getDataInicioPrevista());
                case dataPlFim: return toSQL(p.getDataFimPrevista());
                case DataExInicio: return toSQL(p.getDataInicio());
                case dataExFim: return toSQL(p.getDataFim());
            }
            return "";
        }

        @Override
        public Tarefa newObject(ResultSet rs) throws SQLException {
            return new Tarefa(
                    rs.getInt("idProj"),
                    rs.getInt("idTar"),
                    fromSQL(rs.getDate("dataPlInicio")),
                    fromSQL(rs.getDate("dataPlFim")),
                    fromSQL(rs.getDate("DataExInicio")),
                    fromSQL(rs.getDate("dataExFim")),
                    rs.getNString("designacaoTar")
            );
        }

    }

    public static void main(String[] args) throws SQLException, NamingException {
        GenericDAO.initConnection();
        ProjetoDAO f = new ProjetoDAO();
        /*
         public Projeto(int id,int idFunc,int idCant, Double orcamento, Double prestacao, String designacao, 
         String descricao, GregorianCalendar dataInicio, GregorianCalendar dataFim, 
         GregorianCalendar dataCriaProj, GregorianCalendar prazo) {
         */
        f.insert(new Projeto(-1, 1, 12, 100, 11d, "Quinta do bill", " Muita coisa para fazer",
                new GregorianCalendar(), new GregorianCalendar(), new GregorianCalendar(), new GregorianCalendar()));
        Projeto f1 = f.getById(53);
        Projeto f2 = f.getById(104);

        f1.setDesignacao("olha ele");
        f.update(f1);
        f.remove(f2);
    }
}

//    @Override
//    public Projeto getById(int id) throws SQLException {
//        newStatement();
//        ResultSet rs = executeSelect("Select " + join(Attr.values())
//                + " from Projeto where idFunc = " + id);
//        Projeto f = null;
//        if (rs.next()) {
//            f = newProjeto(rs);
//        }
//        closeStatemnet();
//        return f;
//    }
//
//    @Override
//    public ArrayList<Projeto> getAll() throws SQLException {
//        ArrayList<Projeto> list = new ArrayList<>();
//        newStatement();
//        ResultSet rs = executeSelect("Select "+ join(Attr.values()) +" from Projeto");
//        while (rs.next()) {
//            Projeto f = newProjeto(rs);
//            list.add(f);
//        }
//        closeStatemnet();
//        return list;
//    }
//
//    @Override
//    public void insert(Projeto obj) throws SQLException {
//        newStatement();
//        String query = "INSERT INTO Projeto "
//                + " (" + join(Attr.values())  + ")";
//        
//        
//        executeSQL( " (" + obj.getTipoFunc().ordinal() + ","
//                + " '" + obj.getNome() + "', "
//                + " '" + obj.getNif() + "', "
//                + " '" + obj.getMorada() + "', "
//                + " '" + obj.getTelefone() + "', "
//                + " '" + obj.getTelemovel() + "', "
//                + " '" + obj.getCodigoPostal() + "', "
//                + " '" + obj.getDataNascimentoStr("yyyy-MM-dd") + "', "
//                + " '" + obj.getLocalidade() + "'"
//                + ")");
//        closeStatemnet();
//    }
//
//    @Override
//    public void remove(Projeto obj) throws SQLException {
//        newStatement();
//        executeSQL("DELETE FROM Projeto WHERE idFunc = " + obj.getId());
//        closeStatemnet();
//    }
//
//    @Override
//    public void update(Projeto obj) throws SQLException {
//        newStatement();
//        executeSQL("UPDATE Projeto SET "
//                + "tipoFunc = " + toSQL(obj.getTipoFunc().name()) + ","
//                + "nome = " + toSQL(obj.getNome()) + ", "
//                + "nif =  " + toSQL(obj.getNif()) + ", "
//                + "morada = " + toSQL(obj.getMorada()) + ", "
//                + "telefone = " + toSQL(obj.getTelefone()) + ", "
//                + "telemovel = " + toSQL(obj.getTelemovel()) + ", "
//                + "codigoPostal = " + toSQL(obj.getCodigoPostal()) + ", "
//                + "dataNascimento = " + toSQL(obj.getDataNascimentoStr("yyyy-MM-dd")) + ", "
//                + "localidade = " + toSQL(obj.getLocalidade()) + " "
//                + "where idFunc = " + obj.getId());
//
//        closeStatemnet();
//
//    }
