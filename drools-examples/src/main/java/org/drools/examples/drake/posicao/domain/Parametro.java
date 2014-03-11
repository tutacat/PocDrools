package org.drools.examples.drake.posicao.domain;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by pperboires on 10/03/14.
 */
public class Parametro {

    public Parametro(int diaInicio, int mesInicio, int anoInicio, int diaTermino, int mesTermino, int anoTermino)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.set(anoInicio, mesInicio-1, diaInicio);
        inicio = calendar.getTime();

        Calendar calendarTermino = Calendar.getInstance();
        calendarTermino.set(anoTermino, mesTermino-1, diaTermino);
        termino = calendarTermino.getTime();
    }

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Date getTermino() {
        return termino;
    }

    public void setTermino(Date termino) {
        this.termino = termino;
    }

    private Date inicio;
    private Date termino;
}
