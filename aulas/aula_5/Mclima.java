package Estrutura_de_dados.Trabalho1;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Mclima {
    public static void main(String[] args) {
        ArrayList<Clima> lista = new ArrayList<>();
        String caminho = "base.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(",");
                if (dados.length == 4) {
                    lista.add(new Clima(dados[0], dados[1], dados[2], dados[3]));
                }
            }
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }

        Map<String, Integer> contagemCalor = new HashMap<>();
        Map<String, Integer> contagemChuva = new HashMap<>();

        for (Clima c : lista) {
            if (c.temperatura.equalsIgnoreCase("Quente")) {
                contagemCalor.put(c.ano, contagemCalor.getOrDefault(c.ano, 0) + 1);
            }
            if (c.precipitacao.equalsIgnoreCase("muita")) {
                contagemChuva.put(c.ano, contagemChuva.getOrDefault(c.ano, 0) + 1);
            }
        }

        System.out.println("Ano mais quente: " + buscarMaior(contagemCalor));
        System.out.println("Ano que mais choveu: " + buscarMaior(contagemChuva));
    }

    private static String buscarMaior(Map<String, Integer> mapa) {
        String melhorAno = "Nenhum";
        int max = -1;
        for (Map.Entry<String, Integer> entry : mapa.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                melhorAno = entry.getKey();
            }
        }
        return melhorAno + " (" + max + " meses)";
    }
    
}
