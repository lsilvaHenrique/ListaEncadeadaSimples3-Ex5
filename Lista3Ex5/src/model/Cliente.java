package model;

public class Cliente {
    private String cpf;
    private String nome;
    private int idade;
    private double limiteCredito;

    public Cliente(String cpf, String nome, int idade, double limiteCredito) {
        this.cpf = cpf;
        this.nome = nome;
        this.idade = idade;
        this.limiteCredito = limiteCredito;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public double getLimiteCredito() {
        return limiteCredito;
    }
}
