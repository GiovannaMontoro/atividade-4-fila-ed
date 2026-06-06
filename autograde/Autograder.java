package autograde;

import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Autograder {

    public static void main(String[] args) {
        if (args.length == 0) {
            fail("Modo nao informado. Use: ex1 | ex2 | ex3 | ex4 | ex5 | ex6");
        }

        try {
            String mode = args[0].trim().toLowerCase();
            switch (mode) {
                case "ex1":
                    testEx1();
                    break;
                case "ex2":
                    testEx2();
                    break;
                case "ex3":
                    testEx3();
                    break;
                case "ex4":
                    testEx4();
                    break;
                case "ex5":
                    testEx5();
                    break;
                case "ex6":
                    testEx6();
                    break;
                default:
                    fail("Modo invalido: " + mode);
            }
            pass();
        } catch (AssertionError e) {
            fail(e.getMessage());
        } catch (Exception e) {
            fail("Erro ao executar avaliacao: " + e.getMessage());
        }
    }

    private static void testEx1() throws Exception {
        Class<?> clazz = Class.forName("App");
        Method method = clazz.getMethod("criarFilaValoresFixos");

        Object result = method.invoke(null);
        assertTrue(result instanceof Queue, "criarFilaValoresFixos deve retornar Queue");

        Queue<?> fila = (Queue<?>) result;
        assertTrue(fila.size() == 5, "A fila deve ter 5 elementos");
        assertTrue(fila.peek().equals(10), "O inicio da fila deve ser 10");
        assertTrue(fila.poll().equals(10), "O elemento removido deve ser 10");
        assertTrue(fila.peek().equals(20), "O novo inicio da fila deve ser 20");
        assertTrue(fila.size() == 4, "A fila deve ficar com 4 elementos apos poll");
    }

    private static void testEx2() throws Exception {
        Class<?> clazz = Class.forName("App");
        Method method = clazz.getMethod("criarFilaNomes");

        Object result = method.invoke(null);
        assertTrue(result instanceof Queue, "criarFilaNomes deve retornar Queue");

        Queue<?> fila = (Queue<?>) result;
        assertTrue(fila.size() == 4, "A fila deve ter 4 nomes");
        assertTrue(fila.peek().equals("Ana"), "O primeiro nome da fila deve ser Ana");
    }

    private static void testEx3() throws Exception {
        Class<?> clazz = Class.forName("App");
        Method method = clazz.getMethod("removerTodosElementos", Queue.class);

        Queue<Integer> fila = new LinkedList<>();
        for (int i = 1; i <= 10; i++) {
            fila.add(i);
        }

        Object result = method.invoke(null, fila);
        assertTrue(result instanceof List, "removerTodosElementos deve retornar List");

        List<?> removidos = (List<?>) result;
        assertTrue(fila.isEmpty(), "A fila deve ficar vazia");
        assertTrue(removidos.size() == 10, "Devem ser removidos 10 elementos");
        assertTrue(removidos.get(0).equals(1), "O primeiro removido deve ser o primeiro inserido");
        assertTrue(removidos.get(9).equals(10), "O ultimo removido deve ser o ultimo inserido");
    }

    private static void testEx4() throws Exception {
        Queue<Integer> fila = new LinkedList<>();
        fila.add(15);
        fila.add(30);

        assertTrue(fila.peek().equals(15), "Mostrar inicio deve apontar para o primeiro valor enfileirado");
        assertTrue(fila.poll().equals(15), "Desenfileirar deve remover o inicio da fila");
        assertTrue(fila.peek().equals(30), "O novo inicio deve ser o proximo valor da fila");
    }

    private static void testEx5() throws Exception {
        Class<?> clazz = Class.forName("App");
        Method method = clazz.getMethod("atenderClientes", Queue.class);

        Queue<String> fila = new LinkedList<>();
        fila.add("Ana");
        fila.add("Carlos");
        fila.add("Pedro");

        Object result = method.invoke(null, fila);
        assertTrue(result instanceof List, "atenderClientes deve retornar List");

        List<?> atendidos = (List<?>) result;
        assertTrue(fila.isEmpty(), "A fila de atendimento deve ficar vazia");
        assertTrue(atendidos.size() == 3, "Devem ser atendidos 3 clientes");
        assertTrue(atendidos.get(0).equals("Ana"), "Ana deve ser a primeira cliente atendida");
        assertTrue(atendidos.get(2).equals("Pedro"), "Pedro deve ser o ultimo cliente atendido");
    }

    private static void testEx6() throws Exception {
        Class<?> clazz = Class.forName("App");
        Method adicionar = clazz.getMethod("adicionarDocumento", Queue.class, String.class);
        Method imprimir = clazz.getMethod("imprimirDocumento", Queue.class);
        Method proximo = clazz.getMethod("proximoDocumento", Queue.class);

        Queue<String> fila = new LinkedList<>();
        adicionar.invoke(null, fila, "relatorio.pdf");
        adicionar.invoke(null, fila, "boleto.pdf");

        assertTrue(proximo.invoke(null, fila).equals("relatorio.pdf"), "Proximo documento deve ser relatorio.pdf");
        assertTrue(imprimir.invoke(null, fila).equals("relatorio.pdf"), "Imprimir deve remover relatorio.pdf");
        assertTrue(proximo.invoke(null, fila).equals("boleto.pdf"), "Proximo documento deve ser boleto.pdf");
    }

    private static void assertTrue(boolean condition, String message) {
        if (!condition) {
            throw new AssertionError(message);
        }
    }

    private static void pass() {
        System.out.println("OK!");
    }

    private static void fail(String message) {
        System.out.println("FAIL: " + message);
        System.exit(1);
    }
}
