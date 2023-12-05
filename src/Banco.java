import java.util.ArrayList;
import java.util.List;

public class Banco {
    String nome;
    String endereco;
    ArrayList<Agencia> listaAgencia = new ArrayList<Agencia>(10);

    public Banco() {
    }

    public Banco(String nome, String endereço) {
        this.nome = nome;
        this.endereco = endereço;
    }

    public void criarAgencia(int numero, String nome) {

        if (listaAgencia.size() > 10) {
            System.out.println("\n> Limite de agências atingido.");
            return;
        }

        listaAgencia.add(new Agencia(nome, numero));
        System.out.println("\n> Operação concluída.");
    }

    public void listarAgencias() {
        System.out.println("\n=============");
        System.out.println("Lista de Agências");
        System.out.println("=============\n");

        for (int i = 0; i < 10; i++) {
            System.out.println(i + 1 + ". Nome: " + listaAgencia.get(i).obterNome() + " - Número: " + listaAgencia.get(i).obterNumero());
        }
    }

    public Agencia selecionarAgencia(int numero) {
        for (int i = 0; i < 10; i++){
            if (listaAgencia.get(i).obterNumero() == numero) {
                return listaAgencia.get(i);
            }
        }
        return null;
    }
}