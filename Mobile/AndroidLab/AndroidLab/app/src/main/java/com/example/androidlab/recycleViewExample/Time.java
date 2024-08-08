package com.example.androidlab.recycleViewExample;

public class Time {
    private String nome;
    private String emblema;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmblema(String emblema) {
        this.emblema = emblema;
    }

    public String getEmblema() {
        return emblema;
    }

    public Time(String nome, String emblema) {
        this.nome = nome;
        this.emblema = emblema;
    }
}
