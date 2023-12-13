package SistemaFitness;

import java.util.ArrayList;

public class MenuSF {
    private ArrayList<Alimento> alimentos = new ArrayList<>();

    private ArrayList<Refeição> refeiçoes = new ArrayList<>();
    private DiaSemana[] dias=new DiaSemana[5];



    public MenuSF(){
        alimentos.add(new Alimento("Banana",89.0,1.1,23.0,0.3,"SIM"));
        alimentos.add(new Alimento("Aveia",68.0,2.4,12.0,1.4,"SIM"));
        alimentos.add(new Alimento("Leite",42.0,3.4,5.0,1.0,"SIM"));
        alimentos.add(new Alimento("Ovo",155.0,13.0,1.1,11.0,"NÃO"));
        alimentos.add(new Alimento("Feijão",150,6.0,22.0,5.0,"NÂO"));
        alimentos.add(new Alimento("Arroz",130.0,2.7,28.0,0.3,"NÃO"));
        alimentos.add(new Alimento("Carne Bovina",250,26.0,0.0,15.0,"NÃO"));
        alimentos.add(new Alimento("Peito De Frango",170.0,31.0,0.0,3.6,"NÃO"));
        alimentos.add(new Alimento("Macarrão",360.0,13.0,75.0,1.5,"NÃO"));
        alimentos.add(new Alimento("Mamão",43.0,0.5,11.0,0.3,"SIM"));
        alimentos.add(new Alimento("Maçã",52.0,0.3,14.0,0.2,"SIM"));
        alimentos.add(new Alimento("Purê De Batata",88.0,1.7,15.0,2.8,"NÃO"));
        alimentos.add(new Alimento("Pão Francês",150.0,5.0,25.4,3.0,"NÃO"));
        alimentos.add(new Alimento("Iogurte",110.0,5.0,7.1,0.8,"SIM"));

        dias[0]=new DiaSemana("SEGUNDA-FEIRA");
        dias[1]=new DiaSemana("TERÇA-FEIRA");
        dias[2]=new DiaSemana("QUARTA-FEIRA");
        dias[3]=new DiaSemana("QUINTA-FEIRA");
        dias[4]=new DiaSemana("SEXTA-FEIRA");

    }

    public String CriaRefeiçao(String nome,String tipo, int[] codigos)
    {
        ArrayList<Alimento> alimentosRefeiçao= new ArrayList<>();
        for(int i=0; i<codigos.length;i++){
            alimentosRefeiçao.add(alimentos.get(codigos[i]));
        }
        Refeição refeição= new Refeição(nome,tipo,alimentosRefeiçao);
        refeiçoes.add(refeição);
        return refeição.toString();
    }

    public boolean AdicionaAlimentoRefeiçao(int[] posiçoes,int pos)
    {
        for(int i=0;i<posiçoes.length;i++)
        {
            refeiçoes.get(pos).AdicionaAlimentoRefeição(alimentos.get(posiçoes[i]));
        }

        return true;
    }

    public String getRefeiçao(String nomeRefeiçao){
        String saida= "";
        boolean refeiçaoEncontrada= false;
        for(Refeição r: refeiçoes){
            if(r.getNome().toUpperCase().equals(nomeRefeiçao.toUpperCase())){
                saida+= r.toString();
                refeiçaoEncontrada= true;
            }
        }
        if(!refeiçaoEncontrada){
            saida= "NENHUMA REFEIÇAO COM ESTE NOME FOI ENCONTRADA...";
        }
        return saida;
    }

    public String CadastraAlimento(String nome,double calorias,double carboidratos,double gorduras,double proteinas,String podeSerLiquido){

        alimentos.add(new Alimento(nome,calorias,proteinas,carboidratos,gorduras,podeSerLiquido));
        String saída="\n\t\t\t\tALIMENTO CADASTRADO COM SUCESSO!!";

        return saída;
    }

    public String ListaRefeiçoes()
    {
        String saida="-REFEIÇÕES CRIADAS: \n";
        for(int i=0;i<refeiçoes.size();i++)
        {
            if(refeiçoes.get(i)!=null)
            {
                saida+= i+1+ " - "+refeiçoes.get(i).getNome()+"\n";
            }
        }
        return saida;
    }

    public String ExibeRefeiçao(int posiçao){
        String saida="a ";
        if(refeiçoes.get(posiçao)!=null)
        {
            saida+=refeiçoes.get(posiçao).toString();
        }
        else{
            saida= "Refeição Inexistente!";
        }
        return saida;
    }

    public void ListaNomeAlimentos()
    {
        int k=1;
        String p=" ";
        System.out.println("\t\t\t ------- ALIMENTOS CADASTRADOS --------\n\n");
        for(int i=0;i< alimentos.size();i+=2)
        {
            System.out.format("   %15s - (%2d)" ,alimentos.get(i).getNome(),i);
            System.out.format(" %15s%2d) - %s","(",k,alimentos.get(k).getNome()+"\n");

            k+=2;
        }
    }

    public String ListaAlimentos()
    {
        int k=1;
        String saida="\n ";
        for(int i=0;i< alimentos.size();i++)
        {
            if(alimentos.get(i)!=null)
            {
                saida+= "\n\n\n"+i+". "+alimentos.get(i).toString();
            }


        }
        return saida;

    }

    public String CalendarioSemana()
    {
        String saida="\t\t------------------- CALENDÁRIO SEMANAL ------------------\n\n";

        for(int i=0;i<dias.length;i++)
        {
            if(dias[i]!=null)
            {
                saida+= dias[i].toString()+"\n\n\n";
            }
        }
        return saida;
    }
    public String AdicionaRefiçaoDia(int dia,int refeição){
        dias[dia].AdicionaRefeiçaoDia(refeiçoes.get(refeição));
        String saida = dias[dia].toString();
        return saida;
    }

}
