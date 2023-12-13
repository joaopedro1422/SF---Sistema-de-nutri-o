package SistemaFitness;

public class Alimento {
    private String Nome;
    private double Calorias;
    private double Proteínas;
    private double carboidratos;
    private double Gordura;

    private boolean PodeSerLiquido;

    public Alimento(String nome,double calorias, double Proteinas,double carboidratos, double Gordura, String podeSerLiquido)
    {
        this.Calorias=calorias;
        this.Nome=nome;
        this.Gordura=Gordura;
        this.carboidratos=carboidratos;
        this.Proteínas=Proteinas;
        if(podeSerLiquido.equals("SIM"))
        {
            this.PodeSerLiquido=true;
        }
        else{
            this.PodeSerLiquido=false;
        }

    }

    public double getCalorias(){
        return Calorias;
    }
    public double getProteínas(){
        return Proteínas;
    }

    public double getCarboidratos(){
        return carboidratos;
    }

    public double getGordura(){
        return Gordura;
    }

    public String getNome()
    {
        return Nome;
    }

    public String toString(){
        String saída="";
        saída="======== "+Nome+" ========\nCarboidratos: "+carboidratos+"g\nProteínas: "+Proteínas+"g\nGorduras: "+Gordura+"g\nCalorias: "+Calorias+"Kcal.";
        if(this.PodeSerLiquido==true)
        {
            saída+="\nPode ser Liquído: SIM";
        }
        else {
            saída+="\nPode ser Liquído: NÃO";
        }
        return saída;
    }
}
