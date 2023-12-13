package SistemaFitness;

import java.util.ArrayList;

public class Refeição {
    private String nome;
    private ArrayList<Alimento> alimentosAdicionados = new ArrayList<>();

    private double totalCalorias=0;
    private double totalCarboidratos=0;
    private double totalProteinas=0;
    private double totalGorduras=0;


    private String tipo;

    public Refeição(String nome, String tipo, ArrayList<Alimento> alimentos){
        this.nome=nome;
        this.tipo=tipo;
        this.alimentosAdicionados=alimentos;
        for(Alimento a:alimentos){
            this.totalCalorias+=a.getCalorias();
            this.totalCarboidratos+=a.getCarboidratos();
            this.totalProteinas+=a.getProteínas();
            this.totalGorduras+=a.getGordura();
        }
    }
    public String getNome(){
        return nome;
    }
    public double getTotalCalorias()
    {
        return totalCalorias;
    }

    public double getTotalCarboidratos() {
        return totalCarboidratos;
    }

    public double getTotalProteinas() {
        return totalProteinas;
    }
    public double getTotalGorduras(){
        return totalGorduras;
    }

    public void AdicionaAlimentoRefeição(Alimento alimento){
        this.totalCalorias+= alimento.getCalorias();
        this.totalCarboidratos+= alimento.getCarboidratos();
        this.totalGorduras+= alimento.getGordura();
        this.totalProteinas+= alimento.getProteínas();
        alimentosAdicionados.add(alimento);

    }

    public double Somatudo()
    {
        return this.totalProteinas+this.totalGorduras+this.totalCarboidratos;
    }

    public String toString(){
        String saida="";
        saida+="\n=========================== "+this.nome+" ============================\n";
        for(Alimento a: alimentosAdicionados)
        {
                saida+="\n- "+a.getNome();
        }
        saida+= "\n\n           | CALORIAS  | PROTEINAS | CARBOIDRATOS | GORDURAS |" +
                "\nQUANTIDADE: "+this.totalCalorias+" Kcal     "+ this.totalProteinas+"g         "+this.totalCarboidratos+"g         "+this.totalGorduras+"g\n" +
                "\nPERCENTUAL:      -           "+Math.round((totalProteinas*100)/Somatudo())+"%         "+Math.round((totalCarboidratos*100)/Somatudo())+"%           "+Math.round((totalGorduras*100)/Somatudo()-1)+"%";
        return saida;
    }

    public String getNomeEAlimentos(){
        String saida=nome+" -> (";
        for(Alimento a: alimentosAdicionados)
        {
            saida+= " ,"+a.getNome();

        }
        saida+=").";
        return saida;
    }

}
