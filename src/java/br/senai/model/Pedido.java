package br.senai.model;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Pedido {
    private String descricao, respostaMestre, idAmbiente;
    private Date diaReserva, diaPedido;
    private Date horaInicio, horaFim;
    private int idPedido, idUsuario;
    private Boolean statusResposta;

    public Pedido(){}
    
    public Pedido(String idAmbiente, int idUsuario, Date diaPedido){
        this.idAmbiente = idAmbiente;
        this.idUsuario = idUsuario;
        this.diaPedido = diaPedido;
    }

    public Pedido(String descricao, Date diaReserva, Date horaInicio, Date horaFim, int idUsuario, String idAmbiente, Date diaPedido) {
        this.descricao = descricao;
        this.diaReserva = diaReserva;
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
        this.idUsuario = idUsuario;
        this.idAmbiente = idAmbiente;
        this.diaPedido = diaPedido;
    }

    public Pedido(String descricao, Date diaReserva, Date diaPedido, Date horaInicio, Date horaFim, int idPedido, int idUsuario, String idAmbiente, Boolean statusResposta) {
        this.descricao = descricao;
        this.diaReserva = diaReserva;
        this.diaPedido = diaPedido;
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
        this.idPedido = idPedido;
        this.idUsuario = idUsuario;
        this.idAmbiente = idAmbiente;
        this.statusResposta = statusResposta;
    }
    
    

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getIdAmbiente() {
        return idAmbiente;
    }

    public void setIdAmbiente(String idAmbiente) {
        this.idAmbiente = idAmbiente;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDiaReserva() {
        return diaReserva;
    }

    public void setDiaReserva(Date diaReserva){
       this.diaReserva = diaReserva;
    }
    
   // public void setDiaReserva(String diaReserva) {
   //     this.diaReserva = diaReserva;
   // }

    public Date getDiaPedido() {
        return diaPedido;
    }
    
    public void setDiaPedido(Date diaPedido){
        this.diaPedido = diaPedido;
    }

    public Date getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Date horaInicio){
        this.horaInicio = horaInicio;
    }

    public Date getHoraFim() {
        return horaFim;
    }
    
    public void setHoraFim(Date horaFim){
        this.horaFim = horaFim;
    }

    public Boolean getStatusResposta() {
        return statusResposta;
    }

    public void setStatusResposta(Boolean statusResposta) {
        this.statusResposta = statusResposta;
    }

    public String getRespostaMestre() {
        return respostaMestre;
    }

    public void setRespostaMestre(String respostaMestre) {
        this.respostaMestre = respostaMestre;
    }
}
