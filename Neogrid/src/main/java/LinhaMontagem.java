import java.util.Date;
import java.util.GregorianCalendar;

public class LinhaMontagem {
    private int numLinha;
    private Date horario;
    private GregorianCalendar horaDiaAtividade;

    public GregorianCalendar getHoraDiaAtividade() {
        return horaDiaAtividade;
    }

    public void setHoraDiaAtividade(GregorianCalendar horaDiaAtividade) {
        this.horaDiaAtividade = horaDiaAtividade;
    }

    public Date getHorario() {
        return horario;
    }

    public void setHorario(Date horario) {
        this.horario = horario;
    }

    public int getNumLinha() {
        return numLinha;
    }

    public void setNumLinha(int numLinha) {
        this.numLinha = numLinha;
    }

}
