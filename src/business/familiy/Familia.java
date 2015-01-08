package business.familiy;

import com.sun.istack.internal.FinalArrayList;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import persistence.familia.FamiliaDAO;

public class Familia {

    private static FamiliaDAO familiaDAO = new FamiliaDAO();

    private String nomeRepresentante, contactoRepresentate, moradaRepresentante;
    private int nif, idFunc, id;
    private GregorianCalendar dataNascimento, dataCriaFam;
    private String apelido;
    private ArrayList<ElementoFamilia> elementosFamilia;
    private ArrayList<ElementoFamilia> elementosFamiliaRemoved = new ArrayList<>();
    private Candidatura candidatura;
    private HashMap<GregorianCalendar, Acompanhamento> acomp;
    private Prestacao prestacao;

    public Familia() {
       acomp = new HashMap<>();
        prestacao = new Prestacao();
        elementosFamilia = new ArrayList<>();
        dataNascimento = new GregorianCalendar();
        dataCriaFam = new GregorianCalendar();
        candidatura = new Candidatura(this);
    }

    public Familia(String nomeRepresentante, String contactoRepresentate,
            String moradaRepresentante, int nif, int idFunc, int id, GregorianCalendar dataNascimento,
            GregorianCalendar dataCriaFam, String apelido, Candidatura candidatura,
            HashMap<GregorianCalendar, Acompanhamento> acomp, ArrayList<ElementoFamilia> elem,
            Prestacao p) {
        this.nomeRepresentante = nomeRepresentante;
        this.contactoRepresentate = contactoRepresentate;
        this.moradaRepresentante = moradaRepresentante;
        this.nif = nif;
        this.idFunc = idFunc;
        this.id = id;
        this.dataNascimento = dataNascimento;
        this.dataCriaFam = dataCriaFam;
        this.apelido = apelido;
        this.candidatura = candidatura;
        this.acomp = new HashMap<GregorianCalendar, Acompanhamento>();
        for (Map.Entry<GregorianCalendar, Acompanhamento> e : acomp.entrySet()) {
            this.acomp.put(e.getKey(), e.getValue());
        }
        this.elementosFamilia = new ArrayList<ElementoFamilia>();
        for (ElementoFamilia e : elem) {
            this.elementosFamilia.add(e);
        }
        this.prestacao = p.clone();
    }

    public Familia(String nomeRepresentante, String contactoRepresentate,
            String moradaRepresentante, int nif, int idFunc, int id, GregorianCalendar dataNascimento,
            GregorianCalendar dataCriaFam, String apelido) {
        this.nomeRepresentante = nomeRepresentante;
        this.contactoRepresentate = contactoRepresentate;
        this.moradaRepresentante = moradaRepresentante;
        this.nif = nif;
        this.idFunc = idFunc;
        this.id = id;
        this.dataNascimento = dataNascimento;
        this.dataCriaFam = dataCriaFam;
        this.apelido = apelido;
    }

    public Familia(Familia f) {
        this.nomeRepresentante = f.getNomeRepresentante();
        this.contactoRepresentate = f.getContactoRepresentate();
        this.moradaRepresentante = f.getMoradaRepresentante();
        this.nif = f.getNif();
        this.idFunc = f.getIdFunc();
        this.id = f.getId();
        this.dataNascimento = f.getDataNascimento();
        this.dataCriaFam = f.getDataCriaFam();
        this.apelido = f.getApelido();
        this.candidatura = f.getCandidaturaLast();
        this.elementosFamilia = f.getElementosFamilia();
        this.acomp = f.getAcomp();
        this.prestacao = f.getPrestacao();
    }

    public Prestacao getPrestacao() {
        return prestacao.clone();
    }

    public void setPrestacao(Prestacao prestacao) {
        this.prestacao = prestacao.clone();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdFunc() {
        return idFunc;
    }

    public void setIdFunc(int idFunc) {
        this.idFunc = idFunc;
    }

    public String getNomeRepresentante() {
        return nomeRepresentante;
    }

    public void setNomeRepresentante(String nomeRepresentante) {
        this.nomeRepresentante = nomeRepresentante;
    }

    public String getContactoRepresentate() {
        return contactoRepresentate;
    }

    public void setContactoRepresentate(String contactoRepresentate) {
        this.contactoRepresentate = contactoRepresentate;
    }

    public String getMoradaRepresentante() {
        return moradaRepresentante;
    }

    public void setMoradaRepresentante(String moradaRepresentante) {
        this.moradaRepresentante = moradaRepresentante;
    }

    public int getNif() {
        return nif;
    }

    public void setNif(int nif) {
        this.nif = nif;
    }

    public GregorianCalendar getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(GregorianCalendar dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public GregorianCalendar getDataCriaFam() {
        return dataCriaFam;
    }

    public void setDataCriaFam(GregorianCalendar dataCriaFam) {
        this.dataCriaFam = dataCriaFam;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public void addElementoFamilia(ElementoFamilia e) {
        this.elementosFamilia.add(e.clone());
    }

    public void addElementoFamiliaAt(ElementoFamilia e, int actualIndex) {
        this.elementosFamilia.remove(actualIndex);
        this.elementosFamilia.add(actualIndex, e);
    }

    public void rmElementoFamiliaAt(int selectedIndex) {
        elementosFamiliaRemoved.add(this.elementosFamilia.remove(selectedIndex));
    }

    public ArrayList<ElementoFamilia> getElementosFamilia() {
        ArrayList<ElementoFamilia> ret = new ArrayList<>();
        for (ElementoFamilia e : this.elementosFamilia) {
            ret.add(e);
        }
        return ret;
    }
    
    public ArrayList<ElementoFamilia> getElementosFamiliaRemovedReset() {
        ArrayList<ElementoFamilia> ret = elementosFamiliaRemoved;
        elementosFamiliaRemoved = new FinalArrayList<>();
        return ret;
    }
    
    public void setElementosFamilia(ArrayList<ElementoFamilia> elem) {
        this.elementosFamilia = new ArrayList<>();
        for (ElementoFamilia e : elem) {
            this.elementosFamilia.add(e);
        }
    }

    public Candidatura getCandidaturaLast() {
        return candidatura;
    }

    public void setCandidatura(Candidatura candidatura) {
        this.candidatura = candidatura;
    }

    public void addAcomp(Acompanhamento a) {
        this.acomp.put(a.getData(), a.clone());
    }

    public HashMap<GregorianCalendar, Acompanhamento> getAcomp() {
        HashMap<GregorianCalendar, Acompanhamento> ret = new HashMap<GregorianCalendar, Acompanhamento>();

        for (Map.Entry<GregorianCalendar, Acompanhamento> e : this.acomp.entrySet()) {
            ret.put(e.getKey(), e.getValue());
        }

        return ret;
    }

    public void setAcomp(HashMap<GregorianCalendar, Acompanhamento> comp) {
        this.acomp = new HashMap<GregorianCalendar, Acompanhamento>();
        for (Map.Entry<GregorianCalendar, Acompanhamento> e : comp.entrySet()) {
            this.acomp.put(e.getKey(), e.getValue());
        }
    }

    public Familia clone() {
        return new Familia(this);
    }

    public String toString() {
        return this.id + "." + this.nomeRepresentante + "." + this.nif;
    }

    public List<Candidatura> getCandidaturas() throws SQLException {
        return familiaDAO.getCandidaturas(this);
    }

    public List<Prestacao> getPrestacoes() throws SQLException {
        return familiaDAO.getPrestacoes(id);
    }

    public List<Acompanhamento> getAconpanhamento() throws SQLException {
        return familiaDAO.getAcompanhamento(id);
    }

}
