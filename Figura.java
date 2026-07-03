package Estrutura_de_dados.TrabalhoFigurinhas;

public class Figura {
   private String nomeSelecao;
    private int numeroFigura;
    private String descricao;
    private int quantidade;
    private boolean rara;

    public Figura(String nomeSelecao, int numeroFigura, String descricao, int quantidade, boolean rara) {
        this.nomeSelecao = nomeSelecao;
        this.numeroFigura = numeroFigura;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.rara = rara;
    }


    public Figura(String linhaCSV) {
        String[] partes = linhaCSV.split(";");
        this.nomeSelecao = partes[0];
        this.numeroFigura = Integer.parseInt(partes[1]);
        this.descricao = partes[2];
        this.quantidade = Integer.parseInt(partes[3]);
        this.rara = Boolean.parseBoolean(partes[4]);
    }

    public String toCSV() {
        return nomeSelecao + ";" + numeroFigura + ";" + descricao + ";" + quantidade + ";" + rara;
    }

    public String getNomeSelecao() { 
        return nomeSelecao; 
    }
    
    public int getNumeroFigura() { 
        return numeroFigura; 
    }
    
    public String getDescricao() { 
        return descricao; 
    }
    
    public int getQuantidade() { 
        return quantidade; 
    }
    
    public void setQuantidade(int quantidade) { 
        this.quantidade = quantidade; 
    }
    
    public boolean isRara() { 
        return rara; 
    }

    @Override
    public String toString() {
        return String.format("[%s #%d] %s (Qtd: %d) %s", 
                nomeSelecao, numeroFigura, descricao, quantidade, (rara ? " RARA* " : ""));
    }
}