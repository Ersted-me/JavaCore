package main.java.com.ersted_me.javacore.chapter10;

public class SuperSubCatch {
    public static void main(String[] args) {
        try {
            int a = 0;
            int b = 42 / a;
        }catch (Exception e){
            System.out.println(
                    "Перехват исключений общего класса Exception.");
        /* Этот оператор catch не будет достигнут, т.к.
        подкласс ArithmeticException является производным
        от класса Exception
         */

        }/*catch (ArithmeticException e){ // ОШИБКА: недостижимый код
            System.out.println("Этот код вообще не достижим.");
        }*/
    }
}
