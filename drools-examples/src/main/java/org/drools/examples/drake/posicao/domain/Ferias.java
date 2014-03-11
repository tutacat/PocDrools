package org.drools.examples.drake.posicao.domain;

import java.util.Date;

public class Ferias
{
    public static final int GOZADA  = 0;
    public static final int VENDIDA = 1;

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

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    private Date inicio;
    private Date termino;
    private int tipo;
}
