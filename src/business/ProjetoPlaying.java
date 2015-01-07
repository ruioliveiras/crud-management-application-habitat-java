package business;

import business.building.Tarefa;
import java.util.GregorianCalendar;
import java.util.List;

public class ProjetoPlaying {
    private final IdProjeto id = new IdProjeto(); public IdProjeto idProjeto(){return id;}
    private int idFunc;
    private int idCand;
    private double orcamento;
    private double prestacao;
    private String designacao, descricao;
    private GregorianCalendar dataInicio;
    private GregorianCalendar dataFim;
    private GregorianCalendar dataCriaProj;
    private GregorianCalendar prazo;
    private List<Tarefa> tarefas;
    
    
    
    
    public static class IdProjeto extends SimpleGetter<Integer>{}
    
    //util
    public static class SimpleGetter<A> implements Database{
        private A a;

        public A get() {
            return a;
        }

        public void set(A a) {
            this.a = a;
        }

        @Override
        public String getCollum() {
            return this.getClass().getSimpleName();
        }
    }
   
    public static interface Database{
        public String getCollum();
    }
}