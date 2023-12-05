public class Agencia {
    String nome;
    Integer numero;

    public Agencia() {

    }

    public Agencia(String nome, Integer numero) {
        this.nome = nome;
        this.numero = numero;
    }

    public String obterNome() {
        return nome;
    }

    public Integer obterNumero() {
        return numero;
    }
}