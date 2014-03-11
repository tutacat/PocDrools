package org.drools.examples.drake.posicao.domain;

public class Trabalhador
{

    public Trabalhador(int matricula, String nome){
        this.matricula = matricula;
        this.nome = nome;
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    private String nome;

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    private int matricula;

    @Override
    public String toString() {
        return "Trabalhador[nome="+nome+", matricula="+matricula+"]";
    }

    @Override
    public int hashCode() {
        return matricula;
    }

    @Override
    public boolean equals(Object obj) {

        if (obj != null && obj instanceof Trabalhador)
        {
            return this.matricula == ((Trabalhador)obj).matricula;
        }

        return false;
    }
}