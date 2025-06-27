//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


    // Classe que representa um Livro
    class Livro {
        private String titulo;
        private String autor;
        private String isbn;

        public Livro(String titulo, String autor, String isbn) {
            this.titulo = titulo;
            this.autor = autor;
            this.isbn = isbn;
        }

        public String getTitulo() {
            return titulo;
        }

        public String getAutor() {
            return autor;
        }

        public String getIsbn() {
            return isbn;
        }

        @Override
        public String toString() {
            return "Título: " + titulo + ", Autor: " + autor + ", ISBN: " + isbn;
        }
    }

    // Classe principal do programa
    public class Livraria {
        private static List<Livro> estoque = new ArrayList<>();
        private static Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) {
            int opcao;

            do {
                System.out.println("\n=== Sistema de Livraria ===");
                System.out.println("1. Adicionar Livro");
                System.out.println("2. Listar Livros");
                System.out.println("3. Procurar Livro por Título");
                System.out.println("0. Sair");
                System.out.print("Escolha uma opção: ");

                opcao = scanner.nextInt();
                scanner.nextLine(); // Consumir a nova linha

                switch (opcao) {
                    case 1:
                        adicionarLivro();
                        break;
                    case 2:
                        listarLivros();
                        break;
                    case 3:
                        procurarLivro();
                        break;
                    case 0:
                        System.out.println("Encerrando o programa...");
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
            } while (opcao != 0);
        }

        private static void adicionarLivro() {
            System.out.print("Digite o título do livro: ");
            String titulo = scanner.nextLine();

            System.out.print("Digite o autor do livro: ");
            String autor = scanner.nextLine();

            System.out.print("Digite o ISBN do livro: ");
            String isbn = scanner.nextLine();

            Livro novoLivro = new Livro(titulo, autor, isbn);
            estoque.add(novoLivro);
            System.out.println("Livro adicionado com sucesso!");
        }

        private static void listarLivros() {
            if (estoque.isEmpty()) {
                System.out.println("Nenhum livro cadastrado.");
            } else {
                System.out.println("\nLivros disponíveis:");
                for (Livro livro : estoque) {
                    System.out.println(livro);
                }
            }
        }

        private static void procurarLivro() {
            System.out.print("Digite o título do livro que deseja procurar: ");
            String tituloBusca = scanner.nextLine();

            boolean encontrado = false;
            for (Livro livro : estoque) {
                if (livro.getTitulo().equalsIgnoreCase(tituloBusca)) {
                    System.out.println("Livro encontrado: " + livro);
                    encontrado = true;
                    break;
                }
            }
            if (!encontrado) {
                System.out.println("Livro não encontrado.");
            }
        }
    }