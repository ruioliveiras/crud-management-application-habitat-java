package business.building;


import java.util.GregorianCalendar;
import java.util.Objects;

public class Tarefa {
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

    public Tarefa(GregorianCalendar dataInicio, GregorianCalendar dataFim, 
            GregorianCalendar dataInicioPrevista, GregorianCalendar dataFimPrevista, String tipoTarefa) {
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.dataInicioPrevista = dataInicioPrevista;
        this.dataFimPrevista = dataFimPrevista;
        this.tipoTarefa = tipoTarefa;
    }
    
    public Tarefa(Tarefa t) {
        this.dataInicio = t.getDataInicio();
        this.dataFim = t.getDataFim();
        this.dataInicioPrevista = t.getDataInicioPrevista();
        this.dataFimPrevista = t.getDataFimPrevista();
        this.tipoTarefa = t.getTipoTarefa();
    }

    public GregorianCalendar getDataFim() {
        return dataFim;
    }

    public GregorianCalendar getDataFimPrevista() {
        return dataFimPrevista;
    }

    public GregorianCalendar getDataInicio() {
        return dataInicio;
    }

    public GregorianCalendar getDataInicioPrevista() {
        return dataInicioPrevista;
    }

    public String getTipoTarefa() {
        return tipoTarefa;
    }

    public void setDataFim(GregorianCalendar dataFim) {
        this.dataFim = dataFim;
    }

    public void setDataFimPrevista(GregorianCalendar dataFimPrevista) {
        this.dataFimPrevista = dataFimPrevista;
    }

    public void setDataInicio(GregorianCalendar dataInicio) {
        this.dataInicio = dataInicio;
    }

    public void setDataInicioPrevista(GregorianCalendar dataInicioPrevista) {
        this.dataInicioPrevista = dataInicioPrevista;
    }

    public void setTipoTarefa(String tipoTarefa) {
        this.tipoTarefa = tipoTarefa;
    }

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
    
    
    
    public Tarefa clone()
    {
        return new Tarefa(this);
    }
}