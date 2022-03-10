
package projetodealgoritimos;

import javax.swing.JOptionPane;


public class ProjetoDeAlgoritimos {
        
        //Variaveis de Escopo global para integraÃ§Ã£o em todo programa
        public static String[] nomeProduto = new String[10];
        public static String[] nomeFornecedor = new String[nomeProduto.length];
        public static int[] quantEstoque = new int[nomeProduto.length];
        public static float[] valorVenda = new float[nomeProduto.length];
        public static float[] valorCusto = new float[nomeProduto.length];
        public static float lucro[] = new float[nomeProduto.length];
        public static int quantidadeCompra = 0;
        public static float valorPagar;

        //Metodo para reduzir a sintax do JOptionPane saida
        public static void escreva(String x) 
        {	
            JOptionPane.showMessageDialog(null,x);
        }
        
        //Metodo para reduzir a sintax do JOptionPane entrada
        public static String leia(String x) 
        {
            String y = JOptionPane.showInputDialog(null,x);
            return y;
        }
        
        //Metodo para cadastrar a produto
        public static void cadastro() 
        {
            	int repitirFuncao, i = 0;
                
                do//LaÃ§o para percorrer o vetor
                {
                    nomeProduto[i] = leia("Produto:");
                    nomeFornecedor[i] = leia("Fornecedor:");
                    quantEstoque[i] = Integer.parseInt(leia("Quantidade:"));
                    valorCusto[i] = Float.parseFloat(leia("Valor de Custo:"));
                    valorVenda[i] = Float.parseFloat(leia("Valor de Venda:"));
                    i++;//Contador para adicÃ£o de produtos
                    
                //ConfirmaÃ§Ã£o para adiÃ§Ã£o de outro produto
                repitirFuncao = JOptionPane.showConfirmDialog(null,
                                "Adicionar Novo Produto?",
                                "Lanchonete",JOptionPane.YES_NO_OPTION);
                
                }
                while(repitirFuncao == JOptionPane.YES_OPTION);
        }
        
        //Metodo para venda de produtos
        public static void vender()
        {
            String busca;
            int menuBusca;
            //Varivel receberÃ¡ numero equivalente a alguma funÃ§Ã£o de busca
            menuBusca = Integer.parseInt(leia(
                                    "Qual Metodo de Busca:\n1-Nome Produto"+
                                    "\n2-Valor R$\n3-Fornecedor"));
            
            switch (menuBusca)//Teste da variavel 
            {
                case 1://Busca por produto
                    busca = leia("Busca Produto:");  // Variavel para armazenar o nome que serÃ¡ Buscado   
                    
                    for(int i = 0; i < nomeProduto.length; i++)//LaÃ§o para percorrer o vetor
                    {

                        if (busca.equalsIgnoreCase(nomeProduto[i]))//Teste para nome do produto
                        {
                        escreva("Produto Econtrado");
                        escreva("Produto: "+nomeProduto[i]+"\n"+
                                "Valor: R$ "+valorVenda[i]+"\n"+
                                "Estoque: "+quantEstoque[i]);
                        
                                quantidadeCompra = Integer.parseInt(
                                        leia("Quanidade a comprar?"));//Quantidade de produtos que serÃ¡ adquirido

                        quantEstoque[i]-= quantidadeCompra;//Calculo de quantidade subtraida no estoque
                        lucro[i] = (valorVenda[i]-valorCusto[i]) * quantidadeCompra;//Calculo do lucro individual
                        valorPagar = quantidadeCompra*valorVenda[i];//Calculo do preÃ§o a pagar pela compra
                        
                        escreva("Compra concluida\nProduto: "+nomeProduto[i]+"\n"+
                                        +quantidadeCompra+" Unidades"+"\n"+"Valor: R$"+valorPagar);
                        } 
                    }
                    break;
                    
                case 2://Busca por Valor
                    float buscar = Float.parseFloat(leia("Valor do Produto:"));  // Variavel para armazenar o valor que serÃ¡ Buscado   
                    for(int i = 0; i < nomeProduto.length; i++)
                    {
                        if (buscar >= valorVenda[i])
                        {
                        escreva("Produto Econtrado");
                        escreva("Produto: "+nomeProduto[i]+"\n"+
                                "Valor: R$ "+valorVenda[i]+"\n"+
                                "Estoque: "+quantEstoque[i]);
                        
                                quantidadeCompra = Integer.parseInt(
                                        leia("Quanidade a comprar?"));//Quantidade de produtos que serÃ¡ adquirido

                        quantEstoque[i]-= quantidadeCompra;//Calculo de quantidade subtraida no estoque
                        lucro[i] = (valorVenda[i]-valorCusto[i]) * quantidadeCompra;//Calculo do lucro individual
                        valorPagar = quantidadeCompra*valorVenda[i];//Calculo do preÃ§o da compra
                        
                        escreva("Compra concluida\nProduto: "+nomeProduto[i]+"\n"+
                                        quantidadeCompra+" Unidades"+"\n"+"Valor: R$"+valorPagar);
                        }
                    }
                    break;
                case 3://Busca por nome de fornecedor
                    busca = leia("Nome do Fornecedor:");  // Variavel para armazenar o nome que serÃ¡ Buscado   
                    
                    for(int i = 0; i < nomeProduto.length; i++)//LaÃ§o para percorrer o vetor
                    {

                        if (busca.equalsIgnoreCase(nomeFornecedor[i]))//Teste de valores para encontrar o fornecedor
                        {
                        escreva("Produto Econtrado");
                        escreva("Produto: "+nomeProduto[i]+"\n"+
                                "Valor: R$ "+valorVenda[i]+"\n"+"Estoque: "+quantEstoque[i]);

                        quantidadeCompra = Integer.parseInt(
                                        leia("Quanidade a comprar?"));//Quantidade de produtos que serÃ¡ adquirido

                        quantEstoque[i]-= quantidadeCompra;//Calculo de quantidade subtraida no estoque
                        valorPagar = quantidadeCompra*valorVenda[i];//Calculo do preÃ§o da compra
                        lucro[i] = (valorVenda[i]-valorCusto[i]) * quantidadeCompra;//Calculo do lucro individual
                        
                        escreva("Compra concluida\nProduto: "+nomeProduto[i]+"\n"+
                                        quantidadeCompra+" Unidades"+"\n"+
                                        "Valor: R$ "+valorPagar);
                        }                 
                    }
                default://Caso o numero seja diferente dos listados, retornarÃ¡ ao menu principal
                    break;
            }
        }
        
        //Metodo para consultar produtos
        public static void consultar()
        {
            String busca;
            
            busca = leia("Busca Produto:");  // Variavel para armazenar o nome que serÃ¡ Buscado   
            
            for(int i = 0; i < nomeProduto.length; i++)//LaÃ§o para percorrer o vetor
            {
               if (busca.equalsIgnoreCase(nomeProduto[i]))//Teste para encontrar o produto
               {
                   escreva("Produto Econtrado");
                   escreva("Produto: "+nomeProduto[i]+
                           "\nValor: R$ "+valorVenda[i]+"\nEstoque: "+quantEstoque[i]);
               }
            }
        }
        
        //Metodo para averiguÃ§Ã£o de finanÃ§as
        public static void lucro()
        {   
            String buscaLocal;
            float lucroTotal = 0;

            //LaÃ§o para somar o lucro total
            for(int i = 0; i < nomeProduto.length; i++){
                lucroTotal+= lucro[i];
            }

            //Variavel para recebimento do nome que serÃ¡ buscado
            buscaLocal = leia("Produto Para Buscar Lucro?");
            
            for(int i = 0; i < nomeProduto.length; i ++)//LaÃ§o para percorrer o vetor
            {
                if(buscaLocal.equalsIgnoreCase(nomeProduto[i]))//Teste do nome de produto
                {
                    escreva("Lucro com o Produto "+nomeProduto[i]+
                            " atualmente gira por volta dos R$"+lucro[i]+
                            "\nLucro Total R$"+lucroTotal);
                }
            }
        }
       
        //Metodo de controle do programa/ Menu
        public static int menu()
        {   
            int menu;
            String cabecario = "---------------------------------";//Variavel para estilizar o cabeÃ§ario do menu
            String[] button = {"Cadastrar","Vender","Consultar","Lucro","Sair"};//Array de caracterizaÃ§Ã£o dos botÃµes
            
            //JoptionPane de OpÃ§Ãµes para caracterazar os botÃµes
            menu = JOptionPane.showOptionDialog(null, cabecario+"|MENU|"+cabecario, "Lanchonete",
                            JOptionPane.DEFAULT_OPTION, 
                            JOptionPane.INFORMATION_MESSAGE,
                            null,button, button[0]);
            return menu;
        }
        
        //Metodo para integraÃ§Ã£o das funÃµes do menu
        public static void integraMenu()
        {
            switch (menu()){
                case 0:
                    cadastro();
                    break;
                case 1:
                    vender();
                    break;
                case 2:
                    consultar();
                    break;
                case 3:
                    lucro();
                    break;
                case 4:
                    //Dessa forma qualquer numero diferendo dos citados irÃ¡ retornar ao menu
                    break;
            }
        }
        
        //Metodo principal do programa
        public static void main(String[] args) {
            int repetir;//Variavel para laÃ§o de repetiÃ§Ã£o do menu
            
            do
            {
                integraMenu();//Chamada e teste do metodo integra menu
                repetir = JOptionPane.showConfirmDialog(null,
                                "Continuar no Programa?",
                                "Loja",JOptionPane.YES_NO_OPTION);
            }
            
            while(repetir==JOptionPane.YES_OPTION); 
        }      
}