package SistemaFitness;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Menutests {

    private MenuSF menutest;
    private Alimento[] alimentos = new Alimento[100];
    private Refeição refeicaoTest;
    private DiaSemana dia;

    @BeforeEach
//    void prepara()
//    {
//        menutest= new MenuSF();
//        dia=new DiaSemana("SEGUNDA-FEIRA");
//
//
//
//        refeicaoTest=new Refeição("Janta","Solida");
//
//
//        menutest.CriaRefeiçao("Almoço","liq");
//        menutest.CriaRefeiçao("Janta","liq");
//        int[] posiçoes= new int[]{0,3,4,7,9};
//        int[] posiçoesJanta= new int[]{11,5,2,4,6};
//        menutest.AdicionaAlimentoRefeiçao(posiçoes,1);
//        menutest.AdicionaAlimentoRefeiçao(posiçoesJanta,2);
//        menutest.AdicionaRefiçaoDia(1,2);
//        menutest.AdicionaRefiçaoDia(1,1);
//        menutest.AdicionaRefiçaoDia(0,1);
//        menutest.AdicionaRefiçaoDia(2,1);
//
//    }

    @Test
    void testaSaída(){
        String msg="  oi";
        assertEquals("ola",alimentos[1].toString(),msg);
    }

    @Test
    void testaSaidaRefeicao()
    {
        String msg="oi";
        menutest.ListaAlimentos();
        assertEquals("ola",menutest.ExibeRefeiçao(1),msg);
    }
    @Test
    void TestaDia()
    {
        String msg="oi";

        System.out.println(menutest.CalendarioSemana());
    }



}
