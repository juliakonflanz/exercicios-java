public class Manipulacaotexto {

    public static void main(String[] args) {
        String texto1 = "É nas manhãs silenciosas\nQuando não tem ninguém perto que ele mostra o que ele é\nFaz nascer do zero, as mais belas criações\nEle corre os riscos\nEm cada curva tem um pouco dele\nLapidando cada traço ele eleva a arte, as linhas se encaixam, rimam, ele ilustra a vida, ele também é poeta.\nE por apreço poético, ele que desenha os seus poemas, agora está desenhado em palavras, porque poeta também pode ser poesia.\n- Bia Brandão";

        System.out.println("-----------------------\n-----------------------");
        System.out.println("------- TEXTO 1 -------\n"+texto1);

        System.out.println("-----------------------");
        System.out.println("Quantidade de caracteres: "+texto1.replace(" ", "").length());

        System.out.println("-----------------------");
        System.out.println("Quantidade de palavras: "+texto1.split(" ").length);

        System.out.println("-----------------------");
        String palavrasTexto1[] = texto1.replace(",","").split(" ");
        
        for (String palavra: palavrasTexto1) {
            int palavrasRepetidas = 0;
            for (String comparaPalavras: palavrasTexto1) {
                if (comparaPalavras.equals(palavra)) {
                    palavrasRepetidas++;
                }
            }
            System.out.println("A palavra '"+palavra+"' aparece: "+palavrasRepetidas+" vez(es)");
        }

        System.out.println("-----------------------");
        String inversaoTexto1 = new StringBuilder(texto1).reverse().toString();
        System.out.println("O texto invertido:\n"+ inversaoTexto1);

        System.out.println("-----------------------");
        System.out.println("O texto com a ordem das palavras invertida:");
        
        for(int i= palavrasTexto1.length-1; i >= 0; i--){
            System.out.println(palavrasTexto1[i]);
        }
        

        String texto2 = "socorram me subi no onibus em marrocos";
        
        System.out.println("-----------------------\n-----------------------");
        System.out.println("------- texto 2 -------\n"+texto2);

        System.out.println("-----------------------");
        System.out.println("Quantidade de caracteres: "+texto2.replace(" ", "").length());

        System.out.println("-----------------------");
        System.out.println("Quantidade de palavras: "+texto2.split(" ").length);

        System.out.println("-----------------------");
        String palavrasTexto2[] = texto2.replace(",","").split(" ");
        
        for (String palavra: palavrasTexto2) {
            int palavrasRepetidas = 0;
            for (String comparaPalavras: palavrasTexto2) {
                if (comparaPalavras.equals(palavra)) {
                    palavrasRepetidas++;
                }
            }
            System.out.println("A palavra '"+palavra+"' aparece: "+palavrasRepetidas+" vez(es)");
        }

        System.out.println("-----------------------");
        String inversaoTexto2 = new StringBuilder(texto2).reverse().toString();
        System.out.println("O texto invertido:\n"+ inversaoTexto2);

        System.out.println("-----------------------");
        System.out.println("O texto com a ordem das palavras invertida:");
        
        for(int i= palavrasTexto2.length-1; i >= 0; i--){
            System.out.println(palavrasTexto2[i]);
        }
    }

}