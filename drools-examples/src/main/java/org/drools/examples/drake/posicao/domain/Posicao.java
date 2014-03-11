package org.drools.examples.drake.posicao.domain;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Posicao
{
    public static final int NAO_CALCULADA = 0;
    public static final int REGULAR = 1;
    public static final int FOLGA = 2;
    public static final int DOBRA = 3;
    public static final int FOLGA_INDENIZADA = 4;

    public Posicao(int dia, int mes, int ano, Trabalhador trabalhador, int acumuladorDiasTrabalho, int acumuladorFolgasAdquiridas, int acumuladorFolgasIndenizadas)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.set(ano, mes, dia);
        data = calendar.getTime();

        this.trabalhador = trabalhador;
        this.acumuladorFolgasIndenizadas = acumuladorFolgasIndenizadas;
        this.acumuladorDiasTrabalho = acumuladorDiasTrabalho;
        this.acumuladorFolgasAdquiridas = acumuladorFolgasAdquiridas;
    }

    public Posicao(Date data, Trabalhador trabalhador, int acumuladorDiasTrabalho, int acumuladorFolgasAdquiridas, int acumuladorFolgasIndenizadas)
    {
        this.data = data;

        this.trabalhador = trabalhador;
        this.acumuladorFolgasIndenizadas = acumuladorFolgasIndenizadas;
        this.acumuladorDiasTrabalho = acumuladorDiasTrabalho;
        this.acumuladorFolgasAdquiridas = acumuladorFolgasAdquiridas;
    }

    public Posicao(Date data, Trabalhador trabalhador)
    {
        this.data = data;
        this.trabalhador = trabalhador;
    }

    public Posicao(Date data, Trabalhador trabalhador, int ocorrencia)
    {
        this.data = data;
        this.trabalhador = trabalhador;
        this.ocorrencia = ocorrencia;
    }

    public Posicao(int dia, int mes, int ano, Trabalhador trabalhador)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.set(ano, mes-1, dia);
        data = calendar.getTime();

        this.trabalhador = trabalhador;
    }

    private Date data;

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Posicao getPosicaoAnterior() {
        return posicaoAnterior;
    }

    public void setPosicaoAnterior(Posicao posicaoAnterior) {
        this.posicaoAnterior = posicaoAnterior;
    }

    public Posicao getProximaPosicao() {
        return proximaPosicao;
    }

    public void setProximaPosicao(Posicao proximaPosicao) {
        this.proximaPosicao = proximaPosicao;
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

    public int getOcorrencia() {
        return ocorrencia;
    }

    public String getOcorrenciaTexto()
    {
        switch (ocorrencia)
        {
            case NAO_CALCULADA:
                return "NÃO CALCULADA";
            case REGULAR:
                return "REGULAR";
            case FOLGA:
                return "FOLGA";
            case DOBRA:
                return "DOBRA";
            case FOLGA_INDENIZADA:
                return "FOLGA INDENIZADA";
            default:
                return "NÃO SEI!!!";
        }
    }

    public void setOcorrencia(int ocorrencia) {
        this.ocorrencia = ocorrencia;
    }

    public Trabalhador getTrabalhador() {
        return trabalhador;
    }

    public void setTrabalhador(Trabalhador trabalhador) {
        this.trabalhador = trabalhador;
    }

    public int getAcumuladorDiasTrabalho() {
        return acumuladorDiasTrabalho;
    }

    public void setAcumuladorDiasTrabalho(int acumuladorDiasTrabalho) {
        this.acumuladorDiasTrabalho = acumuladorDiasTrabalho;
    }

    public int getAcumuladorFolgasAdquiridas() {
        return acumuladorFolgasAdquiridas;
    }

    public void setAcumuladorFolgasAdquiridas(int acumuladorFolgasAdquiridas) {
        this.acumuladorFolgasAdquiridas = acumuladorFolgasAdquiridas;
    }

    public int getAcumuladorFolgasIndenizaveis() {
        return acumuladorFolgasIndenizadas;
    }

    public void setAcumuladorFolgasIndenizaveis(int acumuladorFolgasIndenizadas) {
        this.acumuladorFolgasIndenizadas = acumuladorFolgasIndenizadas;
    }

    private Posicao posicaoAnterior;
    private Posicao proximaPosicao;
    private int ocorrencia;
    private Trabalhador trabalhador;
    private Integer acumuladorDiasTrabalho;
    private Integer acumuladorFolgasAdquiridas;
    private Integer acumuladorFolgasIndenizadas;

    public boolean isAcumuladorDiasTrabalhoDefinido()
    {
        return acumuladorDiasTrabalho != null;
    }

    public boolean isAcumuladorFolgasAdquiridasDefinido()
    {
        return acumuladorFolgasAdquiridas != null;
    }

    public boolean isAcumuladorFolgasIndenizadasDefinido()
    {
        return acumuladorFolgasIndenizadas != null;
    }

    public boolean isNenhumAcumuladorDefinido()
    {
        return acumuladorDiasTrabalho == null && acumuladorFolgasAdquiridas == null && acumuladorFolgasIndenizadas == null;
    }

    public boolean isTodosAcumuladoresDefinidos()
    {
        return acumuladorDiasTrabalho != null && acumuladorFolgasAdquiridas != null && acumuladorFolgasIndenizadas != null;
    }

    @Override
    public String toString() {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String reportDate = df.format(data);

        return "Posicao[data="+reportDate+", trabalhador="+trabalhador+", ocorrencia="+getOcorrenciaTexto()+", DT="+acumuladorDiasTrabalho+", FA="+acumuladorFolgasAdquiridas+", FI="+acumuladorFolgasIndenizadas+"]";
    }
}
