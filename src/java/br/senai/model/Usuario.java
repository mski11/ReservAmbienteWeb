package br.senai.model;

public class Usuario {
    private int idUsuario;
    private String nome, matricula, email, telefone, pass;
    private boolean mestre;

    public Usuario(){

    }
    
    public Usuario(int idUsuario, String nome, String matricula){
        this.idUsuario = idUsuario;
        this.nome = nome;
        this.matricula = matricula;
    }

    public Usuario(int idUsuario, String nome, String matricula, String email, String telefone, String pass, boolean mestre) {
        this.idUsuario = idUsuario;
        this.nome = nome;
        this.matricula = matricula;
        this.email = email;
        this.telefone = telefone;
        this.pass = pass;
        this.mestre = mestre;
    }

    /*
    public void setAll(String nome, String matricula, boolean mestre, String email, String telefone, String pass){
        this.nome = nome;
        this.matricula = matricula;
        this.mestre = mestre;
        this.email = email;
        this.telefone = telefone;
        this.pass = pass;
    }
    */

    public String getPass() { return pass; }

    public void setPass(String pass) { this.pass = pass; }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isMestre() {
        return mestre;
    }

    public void setMestre(boolean mestre) {
        this.mestre = mestre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefone(String telefone) { this.telefone = telefone; }

    public String getTelefone() {
        return telefone;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    
}
