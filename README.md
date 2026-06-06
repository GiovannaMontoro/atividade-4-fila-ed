# Atividade - Filas em Java

## Como utilizar

Implemente e execute o arquivo [App.java](src/App.java). O programa possui um menu principal com os 6 exercicios:

1. Fila com valores fixos
2. Fila de nomes
3. Remover 10 numeros da fila
4. Menu interativo de fila
5. Fila de atendimento
6. Fila de impressao

Para compilar e executar:

```bash
javac -d bin src/App.java
java -cp bin App
```

## Exercicios

### Exercicio 01

Crie um programa em Java que implemente uma fila utilizando a interface `Queue` e a classe `LinkedList`.

O programa deve:

- inserir os valores 10, 20, 30, 40 e 50;
- exibir a fila completa;
- remover o primeiro elemento da fila;
- exibir a fila novamente.

Metodo esperado pelo autograder:

```java
public static Queue<Integer> criarFilaValoresFixos()
```

### Exercicio 02

Crie um programa em Java que armazene nomes em uma fila.

Insira:

- Ana
- Carlos
- Pedro
- Juliana

Exiba:

- primeiro elemento da fila;
- quantidade de elementos armazenados.

Metodo esperado pelo autograder:

```java
public static Queue<String> criarFilaNomes()
```

### Exercicio 03

Crie um programa em Java que insira 10 numeros inteiros em uma fila.

Utilizando estrutura de repeticao, remova todos os elementos e exiba cada elemento removido. A ordem de remocao deve seguir o comportamento FIFO: o primeiro valor inserido deve ser o primeiro removido.

Metodo esperado pelo autograder:

```java
public static List<Integer> removerTodosElementos(Queue<Integer> fila)
```

### Exercicio 04

Crie um programa em Java com menu interativo contendo:

```text
1 - Enfileirar
2 - Desenfileirar
3 - Mostrar inicio
4 - Mostrar fila
5 - Sair
```

O usuario devera manipular a fila dinamicamente.

### Exercicio 05

Crie uma simulacao de fila de atendimento.

O sistema deve permitir:

- cadastrar clientes na fila;
- atender o primeiro cliente da fila;
- mostrar o proximo cliente;
- exibir a fila completa.

Metodo esperado pelo autograder:

```java
public static List<String> atenderClientes(Queue<String> fila)
```

### Exercicio 06

Crie uma simulacao de fila de impressao.

O sistema deve permitir:

- adicionar documentos na fila;
- imprimir o primeiro documento da fila;
- mostrar o proximo documento;
- exibir documentos pendentes.

Metodos esperados pelo autograder:

```java
public static void adicionarDocumento(Queue<String> fila, String documento)
public static String imprimirDocumento(Queue<String> fila)
public static String proximoDocumento(Queue<String> fila)
```

## Teste local do autograder

O autograder local valida os exercicios de fila.

```bash
javac -d bin src/App.java autograde/Autograder.java
java -cp bin autograde.Autograder ex1
```

Modos disponiveis: `ex1`, `ex2`, `ex3`, `ex4`, `ex5`, `ex6`.
