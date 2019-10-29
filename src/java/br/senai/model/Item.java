package br.senai.model;

public class Item {
    private String nome;
    private String descricao;
    private int quantidade;
    private int idItem;

    public Item(){}
    public Item(String nome, String descricao, int quantidade){
        this.nome = nome;
        this.descricao = descricao;
        this.quantidade = quantidade;
    }

    public int getIdItem() {
        return idItem;
    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

    
    
    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public String getQuantidadeString() {
        return Integer.toString(quantidade);
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
