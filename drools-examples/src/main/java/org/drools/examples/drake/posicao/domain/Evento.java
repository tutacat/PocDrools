package org.drools.examples.drake.posicao.domain;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Evento
{
    public static final int NAO_INFORMADO = 0;
    public static final int EMBARQUE = 1;
    public static final int DESEMBARQUE = 2;
    public static final int FALTA = 3;
    public static final int FOLGA = 4;
    public static final int TRABALHO = 5;

    private int tipo;
    private Date data;


    public Trabalhador getTrabalhador() {
        return trabalhador;
    }

    public void setTrabalhador(Trabalhador trabalhador) {
        this.trabalhador = trabalhador;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    private Trabalhador trabalhador;

    private boolean derivado;

    public boolean isDerivado()
    {
        return derivado;
    }

    public Evento(int dia, int mes, int ano, int tipo, Trabalhador trabalhador)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.set(ano, mes-1, dia);
        data = calendar.getTime();

        this.trabalhador = trabalhador;
        this.tipo = tipo;
    }

    public Evento(Date data, int tipo, Trabalhador trabalhador)
    {
        this.data = data;
        this.tipo = tipo;
        this.trabalhador = trabalhador;
    }

    public Evento(Date data, int tipo, Trabalhador trabalhador, boolean derivado)
    {
        this.data = data;
        this.tipo = tipo;
        this.trabalhador = trabalhador;
        this.derivado = derivado;
    }

    public String getTipoTexto()
    {
        switch (tipo)
        {
            case EMBARQUE:
                return "EMBARQUE";
            case DESEMBARQUE:
                return "DESEMBARQUE";
            case FOLGA:
                return "FOLGA";
            case FALTA:
                return "FALTA";
            case TRABALHO:
                return "TRABALHO";
            case NAO_INFORMADO:
                return "NÃO INFORMADO";
            default:
                return "NÃO SEI!!!";
        }
    }

    public Date getDataAnterior()
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(data);
        cal.add(Calendar.DATE, -1);
        return cal.getTime();
    }

    public Date getProximaData()
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(data);
        cal.add(Calendar.DATE, 1);
        return cal.getTime();
    }

    @Override
    public String toString() {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String reportDate = df.format(data);
        return "Evento[data="+reportDate+", trabalhador="+trabalhador.toString()+", tipo="+getTipoTexto()+"]";
    }

    @Override
    public int hashCode() {
        return data.hashCode() * trabalhador.hashCode() * 7;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null)
        {
            if (obj instanceof Evento)
            {
                return ((Evento)obj).data == this.data &&  ((Evento)obj).trabalhador == this.trabalhador && ((Evento)obj).derivado == this.derivado;
            }
        }

        return false;
    }
}
