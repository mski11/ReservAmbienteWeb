package br.senai.model;

import java.util.ArrayList;

public class Ambiente {
    
    private String idAmbiente;
    private boolean status;
    private ArrayList<Item> itensAmbiente;

    public String getIdAmbiente() {
        return idAmbiente;
    }

    public void setIdAmbiente(String idAmbiente) {
        this.idAmbiente = idAmbiente;
    }

    public Ambiente(){}
    public Ambiente(String idAmbiente,  boolean status, ArrayList<Item> itensAmbiente) {
        this.idAmbiente = idAmbiente;
        this.status = status;
        this.itensAmbiente = itensAmbiente;
    }

    public boolean isStatus() {
        return status;
    }

    public ArrayList<Item> getItensAmbiente() {
        return itensAmbiente;
    }

    public void setItensAmbiente(ArrayList<Item> itensAmbiente) {
        this.itensAmbiente = itensAmbiente;
    }

    public void setStatus(String a){
        if(a.equals("0")){
            this.status = false;
        } else{
            this.status = true;
        }
    }
}
