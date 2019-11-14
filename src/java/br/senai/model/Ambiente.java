package br.senai.model;

import java.util.List;

public class Ambiente {
    
    private String idAmbiente;
    private boolean status;
    private List<Item> itensAmbiente;

    public String getIdAmbiente() {
        return idAmbiente;
    }

    public void setIdAmbiente(String idAmbiente) {
        this.idAmbiente = idAmbiente;
    }

    public Ambiente(){}
    public Ambiente(String idAmbiente,  boolean status, List<Item> itensAmbiente) {
        this.idAmbiente = idAmbiente;
        this.status = status;
        this.itensAmbiente = itensAmbiente;
    }

    public boolean isStatus() {
        return status;
    }

    public List<Item> getItensAmbiente() {
        return itensAmbiente;
    }

    public void setItensAmbiente(List<Item> itensAmbiente) {
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
