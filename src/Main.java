import java.util.Scanner;

public class Main {
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=============");
        System.out.println("  Sistema Bancário");
        System.out.println("=============");

        System.out.println("\n> Por favor, cadastre um novo banco.");

        System.out.print("\nNome do banco: ");
        String nome = sc.next();
        sc.nextLine();
        System.out.print("Digite o endereço do banco: ");
        String endereco = sc.next();

        Banco banco = new Banco(nome, endereco);
        sc.nextLine();

        boolean menuAtivo = true;

        while (menuAtivo) {
            exibirMenu();

            int opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    adicionarAgencia(banco, sc);
                    break;
                case 2:
                    listarAgencias(banco);
                    break;
                case 3:
                    selecionarAgencia(banco, sc);
                    break;
                case 4:
                    removerAgencia(banco, sc);
                    break;
                case 5:
                    System.out.println("\n> Saindo do programa. Obrigado!");
                    menuAtivo = false;
                    break;
                default:
                    System.out.println("\n> Opção inválida. Tente novamente.");
                    break;
            }
        }

        sc.close();
    }

    static void exibirMenu() {
        System.out.println("\n============");
        System.out.println("  Menu Principal");
        System.out.println("============");
        System.out.println("1. Adicionar Agência");
        System.out.println("2. Listar Agências");
        System.out.println("3. Selecionar Agência");
        System.out.println("4. Remover Agência");
        System.out.println("5. Sair");
        System.out.println("\nDigite a opção: ");
    }

    static void adicionarAgencia(Banco banco, Scanner sc) {
        System.out.println("\n=============");
        System.out.println("  Cadastro Agência");
        System.out.println("=============");
        System.out.print("\nInforme o número da agência: ");

        int numeroAgencia = sc.nextInt();

        sc.nextLine();

        System.out.println("Informe o nome da agência: ");
        String nomeAgencia = sc.next();
        banco.criarAgencia(numeroAgencia, nomeAgencia);
    }

    static void listarAgencias(Banco banco) {

        banco.listarAgencias();
    }

    static void selecionarAgencia(Banco banco, Scanner sc) {
        System.out.println("\n==============");
        System.out.println("Seleção de Agência");
        System.out.println("==============");

        System.out.print("\nDigite o número da agência: ");
        int indice = sc.nextInt();
        sc.nextLine();

        Agencia agenciaSelecionada = banco.selecionarAgencia(indice);
        if (agenciaSelecionada != null) {
            System.out.println("Agência selecionada: " + agenciaSelecionada.obterNome());
        } else {
            System.out.println("Agência com o número " + indice + " não encontrada.");
        }
    }

    private static void removerAgencia(Banco banco, Scanner sc) {
        System.out.println("\n==============");
        System.out.println("Remoção da Agência");
        System.out.println("==============");

        System.out.print("\ninforme o número da agência a ser removida: ");
        int agNumero = sc.nextInt();
        sc.nextLine();

        Agencia agenciaSelecionada = banco.selecionarAgencia(agNumero);

        if (agenciaSelecionada != null) {
            banco.removerAgencia(agenciaSelecionada);
            System.out.println("Agência " +agNumero+ " removida com sucesso.");
        } else {
            System.out.println("Agência com o número " + agNumero + " não encontrada.");
        }
    }
}