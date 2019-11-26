package br.senai.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Pedido {
    private String descricao, diaPedido,
            horaInicio, horaFim, respostaMestre, idAmbiente;
    private Date diaReserva;
    
    private int idPedido, idUsuario;
    private Boolean statusResposta;

    public Pedido(){}
    
    public Pedido(String idAmbiente, int idUsuario, String diaPedido){
        this.idAmbiente = idAmbiente;
        this.idUsuario = idUsuario;
        this.diaPedido = diaPedido;
    }

    public Pedido(String descricao, Date diaReserva, String horaInicio, String horaFim, int idUsuario, String idAmbiente, String diaPedido) {
        this.descricao = descricao;
        this.diaReserva = diaReserva;
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
        this.idUsuario = idUsuario;
        this.idAmbiente = idAmbiente;
        this.diaPedido = diaPedido;
    }

    public Pedido(String descricao, Date diaReserva, String diaPedido, String horaInicio, String horaFim, int idPedido, int idUsuario, String idAmbiente, Boolean statusResposta) {
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

    public String getDiaPedido() {
        return diaPedido;
    }
    
    public void setDiaPedido(Date diaPedido){
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
        this.diaPedido = formatador.format(diaPedido);
    }

    public void setDiaPedido(String diaPedido) {
        this.diaPedido = diaPedido;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Date horaInicio){
        SimpleDateFormat formatador = new SimpleDateFormat("HH:mm");
        this.horaInicio =  formatador.format(horaInicio);
    }
    
    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFim() {
        return horaFim;
    }
    
    public void setHoraFim(Date horaFim){
        SimpleDateFormat formatador = new SimpleDateFormat("HH:mm");
        this.horaFim =  formatador.format(horaFim);
    }

    public void setHoraFim(String horaFim) {
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
