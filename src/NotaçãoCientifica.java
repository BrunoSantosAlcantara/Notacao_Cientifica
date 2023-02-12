
public class NotaçãoCientifica{

    String stringNum;
    double num;

    boolean maiorQueUm;

    public String getNotaçãoCientifica(String stringNum){

        this.stringNum = stringNum;
        this.num = Double.parseDouble(stringNum);
        maiorQueUm = this.num >= 1.0;

        return converter();

    }

    public String converter(){

        int expoenteDez = 0;
        long potenciaDez = 10;
        double base = 0.0;

        if(maiorQueUm){

            stringNum = stringNum.replace(".0","");

            expoenteDez = stringNum.length();
            if(stringNum.indexOf(".") == -1 && num >= 10){
                expoenteDez--;
            } else if(stringNum.indexOf(".") != -1){
                expoenteDez-=2;
            }

            for (int potencia = 1; potencia < expoenteDez; potencia++){
                potenciaDez *= 10;
            }
            System.out.println(potenciaDez);
            base = (double) num / (double) potenciaDez;

        }else{

            String zeros = "1";

            for(int contarZeros = 0; contarZeros < stringNum.length()-1; contarZeros++){
                System.out.println(contarZeros);
                if(stringNum.charAt(contarZeros) == '0'){
                    zeros = zeros+stringNum.charAt(contarZeros);
                    expoenteDez++;
                }else if(stringNum.charAt(contarZeros) != '.'){
                    break;
                }
            }

            potenciaDez = Long.parseLong(zeros);
            base = (double) num * (double) potenciaDez;
            expoenteDez = -expoenteDez;

        }

        return base + " x 10^" + expoenteDez;
    }

}