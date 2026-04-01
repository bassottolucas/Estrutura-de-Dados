package Estrutura_de_dados.Trabalho1;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Mclima {
    public static void main(String[] args) {

        // Lista dinâmica para armazenar todos os objetos Clima na memória
        ArrayList<Clima> lista = new ArrayList<>();
        String caminho = "base.csv";

        // Bloco para leitura do arquivo e fechamento automático
        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
            String linha;
            while ((linha = br.readLine()) != null) {

                // Divide a linha pela vírgula para separar as colunas
                String[] dados = linha.split(",");
                if (dados.length == 4) {

                    // Cria o objeto e adiciona na lista
                    lista.add(new Clima(dados[0], dados[1], dados[2], dados[3]));
                }
            }
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }

        System.out.println("--- CONTEÚDO DO ARQUIVO BASE.CSV ---");
        for (Clima c : lista) {
            System.out.println(c); // Aqui o Java usa o seu toString()
        }
        System.out.println("-------------------------------------\n");

        // Mapas para contar a frequência de ocorrências por ano
        Map<String, Integer> contagemCalor = new HashMap<>();
        Map<String, Integer> contagemChuva = new HashMap<>();

        // Percorre a lista e incrementa os contadores nos mapas
        for (Clima c : lista) {
            if (c.temperatura.equalsIgnoreCase("Quente")) {
                contagemCalor.put(c.ano, contagemCalor.getOrDefault(c.ano, 0) + 1);
            }
            if (c.precipitacao.equalsIgnoreCase("muita")) {
                contagemChuva.put(c.ano, contagemChuva.getOrDefault(c.ano, 0) + 1);
            }
        }

        // Exibe os resultados finais chamando a lógica de comparação
        System.out.println("Ano mais quente: " + buscarMaior(contagemCalor));
        System.out.println("Ano que mais choveu: " + buscarMaior(contagemChuva));
    }

    // Método que identifica o ano com o maior valor (meses) no mapa
    private static String buscarMaior(Map<String, Integer> mapa) {
        String melhorAno = "Nenhum";
        int max = -1;

        // Itera sobre as entradas do mapa para encontrar o recordista
        for (Map.Entry<String, Integer> entry : mapa.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                melhorAno = entry.getKey();
            }
        }
        return melhorAno + " (" + max + " meses)";
    }
    
}
