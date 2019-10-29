package br.senai.model;

import java.util.ArrayList;

public class Ambiente {
    private int idAmbiente;
    private String nome;
    private boolean status;
    private ArrayList<Item> itensAmbiente;

    public int getIdAmbiente() {
        return idAmbiente;
    }

    public void setIdAmbiente(int idAmbiente) {
        this.idAmbiente = idAmbiente;
    }
    
    public Ambiente(int idAmbiente, String nome){
        this.idAmbiente = idAmbiente;
        this.nome = nome;
    }

    public Ambiente(String nome, ArrayList<Item> itensAmbiente) {
        this.nome = nome;
        this.itensAmbiente = itensAmbiente;
    }

    public Ambiente(int idAmbiente, String nome, boolean status, ArrayList<Item> itensAmbiente) {
        this.idAmbiente = idAmbiente;
        this.nome = nome;
        this.status = status;
        this.itensAmbiente = itensAmbiente;
    }

    public String getNome() {
        return nome;
    }

    public boolean isStatus() {
        return status;
    }

    public ArrayList<Item> getItensAmbiente() {
        return itensAmbiente;
    }

    public void setStatus(String a){
        if(a.equals("0")){
            this.status = false;
        } else{
            this.status = true;
        }
    }
}
