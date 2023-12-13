package SistemaFitness;

public class DiaSemana {
    private String nome;
    private Refeição[] refeiçoesDia= new Refeição[3];
    private double proteinasDia;
    private double carboidratosDia;
    private double caloriasDia;
    private double gordurasDia;
    private int contRefeiçoes=0;

    public DiaSemana(String nome)
    {
        this.nome=nome;
    }

    public boolean AdicionaRefeiçaoDia(Refeição refeição)
    {
        refeiçoesDia[contRefeiçoes]=refeição;
        this.proteinasDia+=refeição.getTotalProteinas();
        this.caloriasDia+=refeição.getTotalCalorias();
        this.carboidratosDia+=refeição.getTotalCarboidratos();
        this.gordurasDia+=refeição.getTotalGorduras();
        contRefeiçoes++;
        return true;

    }

    public String toString()
    {
        String saída= "========= "+this.nome+" ==========";
        for(int i=0;i< refeiçoesDia.length;i++)
        {
            if(refeiçoesDia[i]!=null)
            {
                saída+=  "\n- "+refeiçoesDia[i].getNomeEAlimentos();
            }
        }
        saída+= "\n\n Calorias Diarias : "+caloriasDia+"kcal\n Carboidratos Diarios : "+carboidratosDia+"g\n Proteínas Diárias : "+proteinasDia+"g\n Gorduras Diárias : "+gordurasDia+"g";
        return saída;
    }

}
