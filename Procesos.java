public class Procesos implements Comparable<Procesos>{

    private String valor;  
    private String nombre; 
    private String proceso; 

    public Procesos(String v, String n, String p){
        valor=v;
        nombre=n;
        proceso=p;
    }

    public String getproceso() {
        return proceso;
    }

    public String getvalor() {
        return valor;
    }

    @Override
    public int compareTo(Procesos o) {
        return valor.compareTo(o.getvalor());
    }

    @Override
    public String toString() {
        return proceso + ", "+ nombre + ", " + valor;
    }
}
