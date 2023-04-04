import java.io.File;
import java.io.FileNotFoundException;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MainPQ {
    public static void main(String[] args) {

        PriorityQueue<Procesos> prique = new PriorityQueue<>();

        try {
            File objeto = new File("procesos.txt");
            Scanner myReader = new Scanner(objeto);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] splited = data.split(", ");
                Procesos p = new Procesos(splited[0],splited[1],splited[2]);
                prique.add(p);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Ocurrio un error");
            e.printStackTrace();
        }


        print(prique);

    }

    
    public static void print(PriorityQueue<Procesos> prique){
        int initialSize = prique.size();
        for (int i = 0; i<initialSize;i++){
            System.out.println(prique.peek().toString());
            prique.remove();
        }
    }


}
