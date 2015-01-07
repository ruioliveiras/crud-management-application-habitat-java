package business.familiy;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class Familia {
	private String nomeRepresentante, contactoRepresentate, moradaRepresentante;
	private int nif, idFunc, id;
	private GregorianCalendar dataNascimento, dataCriaFam;
	private String apelido;
	private ArrayList<ElementoFamilia> elementosFamilia;
	private Candidatura candidatura;
        private HashMap<GregorianCalendar, Acompanhamento> acomp;
        private Prestacao prestacao;

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
            for(Map.Entry<GregorianCalendar, Acompanhamento> e : acomp.entrySet())
                this.acomp.put(e.getKey(), e.getValue());
        this.elementosFamilia = new ArrayList<ElementoFamilia>();
            for(ElementoFamilia e : elem)
                this.elementosFamilia.add(e);
        this.prestacao = p.clone();
    }
    
    public Familia(String nomeRepresentante, String contactoRepresentate, 
            String moradaRepresentante, int nif, int idFunc, int id, GregorianCalendar dataNascimento, 
            GregorianCalendar dataCriaFam, String apelido)
    {
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
        this.candidatura = f.getCandidatura();
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
    
    public void addElementoFamilia(ElementoFamilia e)
    { this.elementosFamilia.add(e.clone()); }
    
    public ArrayList<ElementoFamilia> getElementosFamilia() 
    {        
        ArrayList<ElementoFamilia> ret = new ArrayList<ElementoFamilia>();
        
        for(ElementoFamilia e : this.elementosFamilia)
            ret.add(e);
        
        return ret;
    }

    public void setElementosFamilia(ArrayList<ElementoFamilia> elem) 
    {
        this.elementosFamilia = new ArrayList<ElementoFamilia>();
        for(ElementoFamilia e : elem)
            this.elementosFamilia.add(e);
    }

    public Candidatura getCandidatura() {
        return candidatura.clone();
    }

    public void setCandidatura(Candidatura candidatura) {
        this.candidatura = candidatura;
    }

    public void addAcomp(Acompanhamento a)
    { this.acomp.put(a.getData(), a.clone()); }            
    
    public HashMap<GregorianCalendar, Acompanhamento> getAcomp() 
    {
        HashMap<GregorianCalendar, Acompanhamento> ret = new HashMap<GregorianCalendar, Acompanhamento>();
        
        for(Map.Entry<GregorianCalendar, Acompanhamento> e : this.acomp.entrySet())
            ret.put(e.getKey(), e.getValue());
        
        return ret;
    }

    public void setAcomp(HashMap<GregorianCalendar, Acompanhamento> comp) 
    {
        this.acomp = new HashMap<GregorianCalendar, Acompanhamento>();
        for(Map.Entry<GregorianCalendar, Acompanhamento> e : comp.entrySet())
            this.acomp.put(e.getKey(), e.getValue()); 
    }
    
    public Familia clone()
    {
        return new Familia(this);
    }
    
    public String toString(){
        return new String(this.id+"."+this.nomeRepresentante+"."+this.nif);
    }
        
}