package Estrutura_de_dados.TrabalhoFigurinhas;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class GerenciadorFigurinhas {
    private static final String FILE_REPETIDAS = "figuras_repetidas_pessoais.csv";
    private static final String FILE_DESEJADAS = "figuras_desejadas_pessoais.csv";

    private static ArrayList<Figura> listaRepetidasPessoais = new ArrayList<>();
    private static ArrayList<Figura> listaDesejadasPessoais = new ArrayList<>();
    
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        carregarArquivoPessoal(FILE_REPETIDAS, listaRepetidasPessoais);
        carregarArquivoPessoal(FILE_DESEJADAS, listaDesejadasPessoais);

        int opcao = 0;
        do {
            exibirMenu();
            try {
                opcao = Integer.parseInt(scanner.nextLine());
                processarOpcao(opcao);
            } catch (NumberFormatException e) {
                System.out.println("Por favor, digite um número válido.");
            }
            System.out.println("\nPressione ENTER para continuar...");
            scanner.nextLine();
        } while (opcao != 7);
    }

    private static void exibirMenu() {
        System.out.println("\n=== GERENCIADOR DE FIGURINHAS COPA 2026 ===");
        System.out.println("1 - Cadastrar figuras repetidas pessoais");
        System.out.println("2 - Listar figuras repetidas pessoais");
        System.out.println("3 - Cadastrar figuras desejadas pessoais");
        System.out.println("4 - Listar figuras desejadas pessoais");
        System.out.println("5 - Carregar figuras repetidas OUTRO (Ver Matches)");
        System.out.println("6 - Carregar figuras desejadas OUTRO (Ver Matches)");
        System.out.println("7 - Sair");
        System.out.print("Opção: ");
    }

    private static void processarOpcao(int opcao) {
        switch (opcao) {
            case 1:
                System.out.println("\n--- Cadastrar Repetida Pessoal ---");
                cadastrarFigura(FILE_REPETIDAS, listaRepetidasPessoais);
                break;
            case 2:
                System.out.println("\n--- Suas Figuras Repetidas ---");
                listarFiguras(listaRepetidasPessoais);
                break;
            case 3:
                System.out.println("\n--- Cadastrar Desejada Pessoal ---");
                cadastrarFigura(FILE_DESEJADAS, listaDesejadasPessoais);
                break;
            case 4:
                System.out.println("\n--- Suas Figuras Desejadas ---");
                listarFiguras(listaDesejadasPessoais);
                break;
            case 5:
                System.out.println("\n--- Carregar Repetidas do OUTRO ---");
                verificarMatchesOutro(listaDesejadasPessoais, "Ele tem o que você quer!");
                break;
            case 6:
                System.out.println("\n--- Carregar Desejadas do OUTRO ---");
                verificarMatchesOutro(listaRepetidasPessoais, "Você tem o que ele quer!");
                break;
            case 7:
                System.out.println("Encerrando o programa ");
                break;
            default:
                System.out.println("Opção inválida!");
        }
    }

    private static void cadastrarFigura(String nomeArquivo, ArrayList<Figura> lista) {
        try {
            System.out.print("Nome da Seleção: ");
            String selecao = scanner.nextLine();
            System.out.print("Número da Figura: ");
            int numero = Integer.parseInt(scanner.nextLine());
            System.out.print("Descrição (Jogador/Brasão): ");
            String desc = scanner.nextLine();
            System.out.print("Quantidade: ");
            int qtd = Integer.parseInt(scanner.nextLine());
            System.out.print("É rara? (true/false): ");
            boolean rara = Boolean.parseBoolean(scanner.nextLine());

            Figura nova = new Figura(selecao, numero, desc, qtd, rara);
            lista.add(nova);
            
            salvarNoArquivo(nomeArquivo, nova);
            System.out.println("Figura cadastrada e salva com sucesso!");
        } catch (NumberFormatException e) {
            System.out.println("Erro no cadastro: Digite números válidos para o Número e Quantidade.");
        }
    }

    private static void listarFiguras(ArrayList<Figura> lista) {
        if (lista.isEmpty()) {
            System.out.println("Nenhuma figura cadastrada nesta lista.");
            return;
        }
        for (Figura f : lista) {
            System.out.println(f);
        }
    }

    private static void verificarMatchesOutro(ArrayList<Figura> listaPessoalComparacao, String mensagemMatch) {
        System.out.print("Digite o nome do arquivo CSV do outro usuário (ex: alexandre.csv): ");
        String nomeArquivoOutro = scanner.nextLine();
        
        ArrayList<Figura> listaOutro = new ArrayList<>();
        
        if (!carregarArquivoPessoal(nomeArquivoOutro, listaOutro)) {
            System.out.println("Arquivo '" + nomeArquivoOutro + "' não foi encontrado. Certifique-se de que ele existe.");
            return; 
        }

        System.out.println("\n--- Figuras do Arquivo Carregado ---");
        listarFiguras(listaOutro);

        System.out.println("\n--- MATCHES ENCONTRADOS (" + mensagemMatch + ") ---");
        boolean teveMatch = false;

        for (Figura figOutro : listaOutro) {
            for (Figura figPessoal : listaPessoalComparacao) {
                if (figOutro.getNomeSelecao().equalsIgnoreCase(figPessoal.getNomeSelecao()) 
                        && figOutro.getNumeroFigura() == figPessoal.getNumeroFigura()) {
                    System.out.println("  MATCH: " + figOutro);
                    teveMatch = true;
                }
            }
        }

        if (!teveMatch) {
            System.out.println("Nenhum match encontrado para troca.");
        }
    }

    
    private static void salvarNoArquivo(String nomeArquivo, Figura figura) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nomeArquivo, true))) {
            bw.write(figura.toCSV());
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Erro ao salvar no arquivo: " + e.getMessage());
        }
    }

   
    private static boolean carregarArquivoPessoal(String nomeArquivo, ArrayList<Figura> lista) {
        File arquivo = new File(nomeArquivo);
        if (!arquivo.exists()) {
            return false;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                if (!linha.trim().isEmpty()) {
                    lista.add(new Figura(linha));
                }
            }
            return true;
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo " + nomeArquivo + ": " + e.getMessage());
            return false;
        }
    }
}