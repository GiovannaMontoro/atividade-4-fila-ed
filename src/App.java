import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            exibirMenuPrincipal();
            opcao = lerInteiro(scanner, "Escolha uma opcao: ");

            switch (opcao) {
                //para não confundir
                //exercicio 1
                case 1:
                  Queue<Integer> f1 = criarFilaValoresFixos();
                  String filaCompleta = f1.toString();
                  int removido1 = f1.poll();
                  System.out.printf("Fila completa: %s\n Elemento removido: %d\n Fila após a remoção: %s\n", filaCompleta, removido1, f1);
                    break;

                //exercicio 2
                case 2:
                     Queue<String> f2 = criarFilaNomes();
                  System.out.printf("Primeiro elemento: %s\n Quantidade de elementos: %d\n", f2.peek(), f2.size());
                    break;

                //exercicio 3
                case 3:
                    Queue<Integer> filaEx3 = new LinkedList<>();
                    for (int i = 1; i <= 10; i++){
                        filaEx3.add(i);
                    }
                    String filaOriginal = filaEx3.toString();
                    List<Integer> removidos = removerTodosElementos(filaEx3);
                    System.out.printf("Fila original: %s\n Elementos removidos na ordem: %s|n", filaOriginal, removidos);
                    break;
                //exercicio 4
                case 4:
                    executarExercicio04(scanner);
                    break;

                 //exercicio 5
                case 5:
                    executarExercicio05(scanner);
                    break;
                case 0:
                    System.out.println("Encerrando o programa.");
                    break;
                default:
                    System.out.println("Opcao invalida.");
                    break;
            }

            System.out.println();
        } while (opcao != 0);

        scanner.close();
    }

    private static void exibirMenuPrincipal() {
        System.out.println("=== Exercicios com Fila ===");
        System.out.println("1 - Fila com valores fixos");
        System.out.println("2 - Fila de nomes");
        System.out.println("3 - Remover 10 numeros da fila");
        System.out.println("4 - Fila de atendimento");
        System.out.println("5 - Fila de impressao");
        System.out.println("0 - Sair");
    }

    private static int lerInteiro(Scanner scanner, String mensagem) {
        while (true) {
            System.out.print(mensagem);

            if (scanner.hasNextInt()) {
                int valor = scanner.nextInt();
                scanner.nextLine();
                return valor;
            }

            System.out.println("Entrada invalida. Digite um numero inteiro.");
            scanner.nextLine();
        }
    }

//exercicio 1

    public static Queue<Integer> criarFilaValoresFixos(){
        Queue<Integer> fila = new LinkedList<>();
        fila.add(10);
        fila.add(20);
        fila.add(30);
        fila.add(40);
        fila.add(50);
        return fila;
    }

//exercicio 2

    public static Queue<String> criarFilaNomes() {
        Queue<String> fila = new LinkedList<>();
        fila.add("Ana");
        fila.add("Carlos");
        fila.add("Pedro");
        fila.add("Juliana");
      return fila;
    }

//exercicio 3

    public static List<Integer> removerTodosElementos(Queue<Integer> fila) {
        List<Integer> removidos = new ArrayList<>();
        while (!fila.isEmpty()){
            removidos.add(fila.poll());
        }
        return removidos;
    }

//exercicio 4

    public static List<String> atenderClientes(Queue<String> fila){
        List<String> atendidos = new ArrayList<>();
        while (!fila.isEmpty()){
            atendidos.add(fila.poll());
        }
        return atendidos;
    }
    private static void executarExercicio04(Scanner scanner){
        Queue<String> fila = new LinkedList<>();
        int opt;
        do {
            System.out.println("\n---Fila de Atendimento---");
            System.out.println("1- Cadastrar cliente\n 2- Atender próximo cliente\n 3- Mostrar próximo cliente\n 4- Exibir fila completa");
            opt = lerInteiro(scanner, "Escolha: ");
            switch (opt){
                case 1:
                    System.out.println("Nome do cliente: ");
                    String cliente = scanner.nextLine();
                    fila.add(cliente);
                    System.out.println("Cliente " + cliente + "adicionado a fila");
                    break;
                case 2:
                    if(fila.isEmpty()){
                        System.out.println("Fila vazia");
                    }else{
                        System.out.println("Atendendo: "+ fila.poll());
                    }
                    break;
                case 3:
                    if (fila.isEmpty()){
                        System.out.println("Fila vazia");
                    }else{
                        System.out.println("Próximo cliente: "+fila.peek());
                    }
                    break;
                case 4:
                    System.out.println("Fila completa: "+ fila);
                    break;
            }
        } while (opt != 0);
    }


//exercicio 5

    public static void adicionarDocumento(Queue<String> fila, String documento){
        fila.add(documento);
    }
    public static String imprimirDocumento(Queue<String> fila) {
        if (!fila.isEmpty()){
            return fila.poll();
        }
        return null;
    }
    public static String proximoDocumento(Queue<String> fila){
        if (!fila.isEmpty()){
            return fila.peek();
        }
        return null;
    }

    private static void executarExercicio05(Scanner scanner) {
        Queue<String> fila = new LinkedList<>();
        int opt;
        do {
            System.out.println("\n---Fila de impressão---");
            System.out.println("1- Adicionar documento\n 2- Imprimir próximo documento\n 3- Mostrar próximo documento\n 4- Exibir documentos pendentes");
            opt = lerInteiro(scanner, "Escolha: ");
            switch (opt){
                case 1:
                    System.out.println("Nome do documento: ");
                    String documento = scanner.nextLine();
                    adicionarDocumento(fila, documento);
                    System.out.println("Documento " + documento + "adicionado");
                    break;
                case 2:
                    String impresso = imprimirDocumento(fila);
                    System.out.println(impresso != null ? "Imprimindo: " + impresso : "Fila vazia");
                    break;
                case 3:
                    String proximo = proximoDocumento(fila);
                    System.out.println(proximo != null ? "Próximo: " + proximo : "Fila vazia");
                    break;
                case 4:
                    System.out.println("Documentos pendentes: "+ fila);
                    break;
            }
        } while (opt != 0);

    }

}