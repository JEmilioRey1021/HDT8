import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        VectorHeap<Procesos> abc = new VectorHeap<>();

        try {
            File objeto = new File("procesos.txt");
            Scanner myReader = new Scanner(objeto);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] splited = data.split(", ");
                Procesos p = new Procesos(splited[0],splited[1],splited[2]);
                abc.add(p);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Ocurrio un error.");
            e.printStackTrace();
        }
        abc.print();

    }

}