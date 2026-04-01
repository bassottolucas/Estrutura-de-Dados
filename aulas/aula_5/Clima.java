package Estrutura_de_dados.Trabalho1;

public class Clima {
    public String ano;
    public String mes;
    public String temperatura;
    public String precipitacao;

    public Clima(String ano, String mes, String temperatura, String precipitacao) {
        this.ano = ano;
        this.mes = mes;
        this.temperatura = temperatura;
        this.precipitacao = precipitacao;
    }

    @Override
    public String toString() {
        return "Ano: " + ano + ", Mes: " + mes + ", Temp: " + temperatura + ", Chuva: " + precipitacao;
    }
    
}
