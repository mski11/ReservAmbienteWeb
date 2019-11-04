package br.senai.model;

public class Pedido {
    private String descricao, diaReserva, diaPedido,
            horaInicio, horaFim, diaResposta, respostaMestre;
    private int idPedido, idUsuario, idAmbiente;
    private Boolean statusResposta;

    public Pedido(){}
    
    public Pedido(int idAmbiente, int idUsuario, String diaPedido){
        this.idAmbiente = idAmbiente;
        this.idUsuario = idUsuario;
        this.diaPedido = diaPedido;
    }

    public Pedido(String descricao, String diaReserva, String horaInicio, String horaFim, int idUsuario, int idAmbiente, String diaPedido) {
        this.descricao = descricao;
        this.diaReserva = diaReserva;
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
        this.idUsuario = idUsuario;
        this.idAmbiente = idAmbiente;
        this.diaPedido = diaPedido;
    }

    public Pedido(String descricao, String diaReserva, String diaPedido, String horaInicio, String horaFim, int idPedido, int idUsuario, int idAmbiente, Boolean statusResposta) {
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

    public int getIdAmbiente() {
        return idAmbiente;
    }

    public void setIdAmbiente(int idAmbiente) {
        this.idAmbiente = idAmbiente;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDiaReserva() {
        return diaReserva;
    }

    public void setDiaReserva(String diaReserva) {
        this.diaReserva = diaReserva;
    }

    public String getDiaPedido() {
        return diaPedido;
    }

    public void setDiaPedido(String diaPedido) {
        this.diaPedido = diaPedido;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFim() {
        return horaFim;
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

    public String getDiaResposta() {
        return diaResposta;
    }

    public void setDiaResposta(String diaResposta) {
        this.diaResposta = diaResposta;
    }

    public String getRespostaMestre() {
        return respostaMestre;
    }

    public void setRespostaMestre(String respostaMestre) {
        this.respostaMestre = respostaMestre;
    }
}
