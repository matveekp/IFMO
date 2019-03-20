package lesson6.classWork.staticFinal;

public class Main {

    public static void main(String[] args) {

           String fileName = "file.json";

           Handler handler = Handler.getInstance(fileName);


           handler.read();
           handler.write();

        System.out.println(CalcUtils.summ(5, 4));

        System.out.println(CalcUtils.PI);


    }



}
