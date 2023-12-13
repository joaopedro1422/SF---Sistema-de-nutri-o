package SistemaFitness;

import java.util.Scanner;
import java.io.IOException;

import static java.lang.System.exit;


public class MainSF {
    public static void main(String[] args) throws IOException, InterruptedException {
        MenuSF menu = new MenuSF();
        Scanner scanner = new Scanner(System.in);


        String escolha = "";
            Apresentação(scanner);



        while (true) {
            scanner.nextLine();
            escolha = Menu(scanner);


              comandos(escolha, menu, scanner);
        }

    }
    private static void Apresentação(Scanner scanner) throws IOException, InterruptedException {
        System.out.println("\n\n\t\t\t\t\t\t=========== SF-Sistema Fitness ==========");
        System.out.println("\n\n- Seja Bem vindo ao SF, me chamo João Pedro e preparei esse Programa para darmos uma organizada na sua rotina alimentar!\n\n" +
                                "- O SF funciona como um simulador, que irá criar refeições e uma rotina semanal com base em suas escolhas.\n\n" +
                                "- Possuímos um catálogo com os alimentos mais consumidos, mas você poderá registrar algum de seu gosto, caso não haja no Catálogo.\n\n" +
                                "- Você poderá formar refeições com até 6 alimentos, e inseri-las em dias da semana, assim como consultar seu calendário semanal.\n\n" +
                                "- Meu intuíto é Mostrar os nutrientes consumidos a partir de cada refeição que você realizará.\n\n" +
                                "- Os dados dos alimentos Foram Obtidos a partir da USDA (DEPARTAMENTO DE AGRICULTURA DOS ESTADOS UNIDOS).\n\n" +
                                "- Todos os nutrientes de cada almento são dados para uma amostra de 100g do alimento em questão.\n\n"+
                                "- O calculo da quantidade ideal de agua por dia se dá pela medida de 35ml por kg, segundo fornecido por especialistas.");
        System.out.println("\n\n\n\t\t\t\t\t\t\t----- ENTER PARA CONTINUAR ------\n");

        scanner.nextLine();
    }
    private static String Menu(Scanner scanner){

        System.out.println("\n\n\n======================= SF- Sistema Fitness ====================");
        System.out.println("\n\n\n\n" +
                " (1) CATALOGO DE ALIMENTOS.\n" +
                " (2) CADASTRAR NOVO ALIMENTO.\n" +
                " (3) CRIAR REFEIÇÃO.\n" +
                " (4) CONSULTAR REFEIÇÕES.\n" +
                " (5) VIZUALIZAR REFEIÇÃO.\n" +
                " (6) ADC REFEIÇAO AO DIA.\n"+
                " (7) ROTEIRO SEMANAL.\n" +
                " (8) CALC. QUANTIDADE DE AGUA IDEAL.\n"+
                " (9) SAIR.");
        System.out.println("\n\n\n -> OPÇÃO: ");

        String opçao = scanner.next().toUpperCase();


        return opçao;
    }

    public static void comandos(String escolha, MenuSF menu,Scanner scanner){
        switch (escolha){
            case "1":
                CatalogoDeAlimentos(menu,scanner);
                break;
            case "2":
                CadastraAlimento(menu,scanner);
                break;
            case "3":
                criaRefeicao(menu,scanner);
                break;
            case "4":
                listaRefeiçoes(menu,scanner);
                break;
            case "5":
                vizualizaRefeiçao(menu,scanner);
                break;

            case "6":
                adcRefeiçaoAoDia(menu,scanner);
                break;
            case "7":
                roteiroSemanal(menu,scanner);
                break;
            case "8":
                calculaQntAgua(menu,scanner);
                break;



        }
    }


    public static void calculaQntAgua(MenuSF menuSF,Scanner scanner){
        System.out.println("\n\n\n\t\t ======================= AGUA ======================");
        System.out.println("\n\n -> Informe o seu peso: ");
        Double peso= scanner.nextDouble();
        Double qntAgua= peso*35;
        System.out.println("\n Voce deve tomar aproximadamente "+ qntAgua+"ml ("+qntAgua/1000+" Litros) de Agua por dia!!");
        System.out.println("\n\n-> Pressione ENTER para sair.");
        scanner.nextLine();
    }
    public static void vizualizaRefeiçao(MenuSF menu, Scanner scanner){
        System.out.println("\n\n\n  =========== REFEIÇAO ===========");
        System.out.println("\n\n-> Nome da refeiçao a ser consultada:");
        String nome= scanner.next();
        System.out.println(menu.getRefeiçao(nome));
        System.out.println("\n-> Pressione ENTER para sair.");
        scanner.nextLine();
    }
    public static void adcRefeiçaoAoDia(MenuSF menu, Scanner scanner){
        System.out.println("\n\n\n ========= ORGANIZANDO A SEMANA =========");
        System.out.println("\n\n-> Dia (segunda-feira = 0): ");
        int dia= scanner.nextInt();
        System.out.println("\n\n-> Refeiçao: ");
        int refeiçao= scanner.nextInt();
        System.out.println(menu.AdicionaRefiçaoDia(dia,refeiçao));
        System.out.println("\n-> Pressione ENTER para sair.");
        scanner.nextLine();
    }

    public static void roteiroSemanal(MenuSF menu, Scanner scanner){
        System.out.println(menu.CalendarioSemana());
        System.out.println("\n-> Pressione ENTER para sair.");
        scanner.nextLine();
    }
    public static void CatalogoDeAlimentos(MenuSF menu,Scanner scanner){
        System.out.println("\n\n\n\n============ CATALOGO DE ALIMENTOS ===========");
        System.out.println(menu.ListaAlimentos());
        System.out.println("\n-> Pressione ENTER para sair.");
        scanner.nextLine();



    }

    public static void listaRefeiçoes(MenuSF menuSF, Scanner scanner){
        System.out.println("\n\n\n=========== REFEIÇOES ============");
        System.out.println(menuSF.ListaRefeiçoes());
        System.out.println("\n-> Pressione ENTER para sair.");
        scanner.nextLine();
    }

    public static void criaRefeicao(MenuSF menu, Scanner scanner){
        System.out.println("\n\n\n ========= REFEIÇOES ==========");
        System.out.println("\n\n-> Nome da Refeiçao :");
        String nome= scanner.next();
        System.out.println("\n\n-> Tipo da Refeiçao :");
        String tipo= scanner.next();

        System.out.println(menu.ListaAlimentos());
        System.out.println("\n\n-> Informe os codigos dos alimentos que deseja adicionar na refeição\n" +
                "    (Separados por virgula):");
        String codigos= scanner.next();
        String[] codigosArray= codigos.split(",");
        int[] codigosConvertidos= new int[codigosArray.length];
        for(int i=0;i<codigosArray.length;i++){
            codigosConvertidos[i]= Integer.parseInt(codigosArray[i]);
        }
        System.out.println("\n\t\t\t\t  *REFEIÇAO CRIADA COM SUCESSO*\n"+menu.CriaRefeiçao(nome,tipo,codigosConvertidos));
        System.out.println("\n-> Pressione ENTER para sair.");
        scanner.nextLine();
    }

    public static void CadastraAlimento(MenuSF menu,Scanner scanner){

        System.out.println("\n\n\n\n========= CADASTRO DE ALIMENTOS =========");
        System.out.println("\n\n-> Informe o nome do alimento: ");
        String nome= scanner.next();
        System.out.println("\n\n-> Informe a quantidade de Calorias:");
        Double Calorias= scanner.nextDouble();
        System.out.println("\n\n-> Carboidratos:");
        Double carbo= scanner.nextDouble();
        System.out.println("\n\n-> Proteínas:");
        Double proteinas= scanner.nextDouble();
        System.out.println("\n\n-> Gorduras:");
        Double gorduras=scanner.nextDouble();
        System.out.println("\n\n-> O alimento pode ser inserido em uma refeição líquida ? (SIM ou NÃO)");
        String podeSerLiquido=scanner.next();
        System.out.println(menu.CadastraAlimento(nome,Calorias,carbo,gorduras,proteinas,podeSerLiquido));
        System.out.println("\n\t\t\t\t\tENTER para sair.");
        scanner.nextLine();



    }




}
