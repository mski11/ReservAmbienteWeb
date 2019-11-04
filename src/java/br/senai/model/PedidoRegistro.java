package br.senai.model;

public class PedidoRegistro {
    
    private int idPedido;
    private String nome;
    private String telefone;
    private String email;
    private String matricula;
    private String descricao;

    public PedidoRegistro(){}
    public PedidoRegistro(int idPedido, String nome, String telefone, String email, String matricula, String descricao) {
        this.idPedido = idPedido;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.matricula = matricula;
        this.descricao = descricao;
    }
    
    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    
}
