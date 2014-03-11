package org.drools.examples.drake.posicao.domain;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Escala
{
    public static final int TRABALHO = 0;
    public static final int FOLGA = 1;

    private int tipo;
    private Date inicio;

    public Escala(int dia, int mes, int ano, int diaTermino, int mesTermino, int anoTermino, int tipo, Trabalhador trabalhador)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.set(ano, mes-1, dia);
        setInicio(calendar.getTime());

        Calendar calendarTermino = Calendar.getInstance();
        calendarTermino.set(anoTermino, mesTermino-1, diaTermino);
        setTermino(calendarTermino.getTime());

        this.tipo = tipo;
        this.trabalhador = trabalhador;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(inicio);
        cal.set(Calendar.HOUR_OF_DAY,0);
        cal.set(Calendar.MINUTE,0);
        cal.set(Calendar.SECOND,0);
        cal.set(Calendar.MILLISECOND,0);
        this.inicio = cal.getTime();
    }

    public Date getTermino() {
        return termino;
    }

    public void setTermino(Date termino) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(termino);
        cal.set(Calendar.HOUR_OF_DAY,23);
        cal.set(Calendar.MINUTE,59);
        cal.set(Calendar.SECOND,59);
        cal.set(Calendar.MILLISECOND,999);
        this.termino = cal.getTime();
    }

    public Trabalhador getTrabalhador() {
        return trabalhador;
    }

    public void setTrabalhador(Trabalhador trabalhador) {
        this.trabalhador = trabalhador;
    }

    private Date termino;
    private Trabalhador trabalhador;

    public String getTipoTexto()
    {
        switch (tipo)
        {
            case Escala.TRABALHO:
                return "TRABALHO";
            default:
                return "FOLGA";
        }
    }

    @Override
    public String toString() {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String inicioTexto = df.format(inicio);
        String terminoTexto = df.format(termino);
        return "Escala[inicio="+inicioTexto+", termino="+terminoTexto+", tipo="+getTipoTexto()+", trabalhador="+trabalhador+"]";
    }
}
