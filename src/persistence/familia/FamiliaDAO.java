/*
 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence.familia;

import business.familiy.Acompanhamento;
import persistence.*;
import business.familiy.Prestacao;
import business.familiy.Candidatura;
import business.familiy.ElementoFamilia;
import business.familiy.Familia;
import business.familiy.Questao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import persistence.util.GenericDAO;
import persistence.util.KeyValue;

public class FamiliaDAO extends GenericDAO<Familia> {

    private ElementosFamiliaDAO elementosFamiliaDAO = new ElementosFamiliaDAO();
    private AcompanhamentoDAO acompanhamentoDAO = new AcompanhamentoDAO();
    private PrestacaoDAO prestacaoDAO = new PrestacaoDAO();
    private CandidaturaDAO candidaturaDAO = new CandidaturaDAO();
    
    protected enum Attr {

        idFam, nome, morada, telefone, nif, idFunc, dataNascimento, apelido, dataCriaFam
    };

    public FamiliaDAO() {
        super(Attr.values(), 1, "Familia");
    }

    protected String getToBD(Familia p, Enum<?> en) {
        Attr a = (Attr) en;
        switch (a) {
            case idFam:
                return toSQL(p.getId());
            case nome:
                return toSQL(p.getNomeRepresentante());
            case morada:
                return toSQL(p.getMoradaRepresentante());
            case telefone:
                return toSQL(p.getContactoRepresentate());
            case nif:
                return toSQL(p.getNif());
            case idFunc:
                return toSQL(p.getIdFunc());
            case dataNascimento:
                return toSQL(p.getDataNascimento());
            case apelido:
                return toSQL(p.getApelido());
            case dataCriaFam:
                return toSQL(p.getDataCriaFam());
            default:
                return toSQL((String) null);
        }
    }

    @Override
    public int insert(Familia obj) throws SQLException {
        //martelada -.-
        if (obj.getId() <= 0) {
            int ret = super.insert(obj);    
            obj.setId(ret);
            for (ElementoFamilia e : obj.getElementosFamilia()) {
                elementosFamiliaDAO.insert(e);
            }
        }
        candidaturaDAO.insert(obj.getCandidaturaLast());
        return obj.getId();
    }

    @Override
    public void update(Familia obj) throws SQLException {
        update(obj,obj.getCandidaturaLast());
    }
    public void update(Familia obj, Candidatura c) throws SQLException {
        super.update(obj); //To change body of generated methods, choose Tools | Templates.
        for (ElementoFamilia e : obj.getElementosFamilia()) {
            elementosFamiliaDAO.update(e);
        }
        for (ElementoFamilia e : obj.getElementosFamiliaRemovedReset()) {
            elementosFamiliaDAO.remove(e);
        }
        candidaturaDAO.update(c);
    }

    @Override
    public void remove(Familia obj) throws SQLException {
        remove(obj,obj.getCandidaturaLast());
    }
 
    public void remove(Familia obj, Candidatura c) throws SQLException {
        for (ElementoFamilia e : obj.getElementosFamilia()) {
            elementosFamiliaDAO.remove(e);
        }
        candidaturaDAO.remove(c);
        super.remove(obj);
    }

    @Override
    public Familia newObject(ResultSet rs) throws SQLException {
        return new Familia(
                rs.getNString(Attr.nome.name()),
                rs.getInt(Attr.telefone.name()),
                rs.getNString(Attr.morada.name()),
                rs.getInt(Attr.nif.name()),
                rs.getInt(Attr.idFunc.name()),
                rs.getInt(Attr.idFam.name()),
                fromSQL(rs.getDate(Attr.dataNascimento.name())),
                fromSQL(rs.getDate(Attr.dataCriaFam.name())),
                rs.getNString(Attr.apelido.name())
        );
    }

    @Override
    public void beforeReturn(List<Familia> a) throws SQLException{
        for (Familia familia : a) {
            familia.setCandidatura(candidaturaDAO.getByIdFam(familia.getId()));
            if (familia.getCandidaturaLast() != null){
                familia.getCandidaturaLast().setFamilia(familia);
            }
            
            ElementoFamilia elem = new ElementoFamilia();
            elem.setIdFam(familia.getId());
            familia.setElementosFamilia(elementosFamiliaDAO.getAllBy(elem, ElementosFamiliaDAO.Attr.idFam));            
        }
    }
    
    public List<Prestacao> getPrestacoes(int idFam) throws SQLException{
        Prestacao p = new Prestacao();
        p.setIdFam(idFam);
        return prestacaoDAO.getAllBy(p, PrestacaoDAO.Attr.idFam);
    }
    
    public void insertPrestacao(Prestacao p) throws SQLException{
        prestacaoDAO.insert(p);
    }
    
    public void updatePrestacao(Prestacao p) throws SQLException{
        prestacaoDAO.update(p);
    }
    
    public void removePrestacao(Prestacao p) throws SQLException{
        prestacaoDAO.remove(p);
    }
    
    public List<Acompanhamento> getAcompanhamento(int idFam) throws SQLException{
        Acompanhamento p = new Acompanhamento();
        p.setIdFam(idFam);
        return acompanhamentoDAO.getAllBy(p, AcompanhamentoDAO.Attr.idFam);
    }
    
    public List<Candidatura> getCandidaturas(Familia familia) throws SQLException{
        List<Candidatura> candidaturas = candidaturaDAO.getAllByIdFam(familia.getId());
        for (Candidatura candidatura : candidaturas) {
            candidatura.setFamilia(familia);
        }
        return candidaturas;
    }
    

    public static class ElementosFamiliaDAO extends GenericDAO<ElementoFamilia> {

        public enum Attr {

            idElemento, idFam, nome, parentesco, dataNascimento, estadoCivil, ocupacao, escolaridade
        }

        public ElementosFamiliaDAO() {
            super(Attr.values(), 1, "ElementoFamilia");
        }

        @Override
        protected String getToBD(ElementoFamilia p, Enum<?> a) {
            Attr b = (Attr) a;
            switch (b) {
                case idElemento:
                    return toSQL(p.getId());
                case idFam:
                    return toSQL(p.getIdFam());
                case nome:
                    return toSQL(p.getNome());
                case parentesco:
                    return toSQL(p.getParentesco());
                case dataNascimento:
                    return toSQL(p.getDataNascimento());
                case estadoCivil:
                    return toSQL(p.getEstadoCivil());
                case ocupacao:
                    return toSQL(p.getOcupacao());
                case escolaridade:
                    return toSQL(p.getEscolaridade());
            }
            return "";
        }

        @Override
        public ElementoFamilia newObject(ResultSet rs) throws SQLException {
            return
                    
                    new ElementoFamilia(
                            rs.getInt("idElemento"),
                            rs.getInt("idFam"),
                            rs.getString("nome"),
                            rs.getString("ocupacao"),
                            rs.getString("parentesco"),
                            rs.getString("escolaridade"),
                            rs.getString("estadoCivil"),
                            fromSQL(rs.getDate("dataNascimento"))
                    );
        }
    }

    public static class PrestacaoDAO extends GenericDAO<Prestacao> {

        public enum Attr {

            idPrestacao, idFam, valor, data, idFunc
        }

        public PrestacaoDAO() {
            super(Attr.values(), 1, "Prestacao");
        }

        @Override
        protected String getToBD(Prestacao p, Enum<?> a) {
            Attr b = (Attr) a;
            switch (b) {
                case idPrestacao:
                    return toSQL(p.getId());
                case idFam:
                    return toSQL(p.getIdFam());
                case valor:
                    return toSQL(p.getValor());
                case data:
                    return toSQL(p.getData());
                case idFunc:
                    return toSQL(p.getIdFunc());
            }
            return "";
        }

        @Override
        public Prestacao newObject(ResultSet rs) throws SQLException {
            return new Prestacao(
                    rs.getInt("idPrestacao"),
                    rs.getInt("valor"),
                    rs.getInt("idFunc"),
                    rs.getInt("idFam"),
                    fromSQL(rs.getDate("data"))
            );
        }
    }
    
    public static class AcompanhamentoDAO extends GenericDAO<Acompanhamento> {

        public enum Attr {

            idRel, obsRel, dataRel, idFam, idFunc
        }

        public AcompanhamentoDAO() {
            super(Attr.values(), 1, "Relatorio");
        }

        @Override
        protected String getToBD(Acompanhamento p, Enum<?> a) {
            Attr b = (Attr) a;
            switch (b) {
                case idRel: return toSQL(p.getId());
                case obsRel: return toSQL(p.getDescricao());
                case dataRel: return toSQL(p.getData());
                case idFam: return toSQL(p.getIdFam());
                case idFunc: return toSQL(p.getIdFunc());
            }
            return "";
        }

        @Override
        public Acompanhamento newObject(ResultSet rs) throws SQLException {
            return new Acompanhamento(
                    rs.getInt(Attr.idRel.name()),
                    rs.getInt(Attr.idFunc.name()),
                    rs.getInt(Attr.idFam.name()),
                    rs.getString(Attr.obsRel.name()),
                    fromSQL(rs.getDate(Attr.idFunc.name()))
            );
        }

    }
    

    public static void main(String[] args) {
        FamiliaDAO fd = new FamiliaDAO();
        //testar o DAO aqui
    }
}
