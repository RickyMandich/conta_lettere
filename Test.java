import java.io.FileNotFoundException;
import java.io.IOException;

public class Test{
    public static void main(String[] args) throws FileNotFoundException{
        Lettore reader = new Lettore();
        String file = reader.getFile("divinacommedia.txt");
        Lettera[] conteggio = new Lettera[0];
        for(char c:file.toCharArray()){
            conteggio = conta(c, conteggio);
        }
        order(conteggio);
        print(conteggio);
        write(conteggio);
    }

    public static Lettera[] conta(char c, Lettera[] conteggio){
        boolean add = false;
        for(Lettera l:conteggio){
            if(c == l.lettera){
                l.volte++;
                add = true;
            }
        }
        if(!add) return addLettera(conteggio, c);
        else return conteggio;
    }

    public static Lettera[] addLettera(Lettera[] oldConteggio, char c){
        Lettera[] newConteggio = new Lettera[oldConteggio.length+1];
        for(int i = 0;i<oldConteggio.length;i++){
            newConteggio[i] = oldConteggio[i];
        }
        newConteggio[oldConteggio.length]= new Lettera(c);
        return newConteggio;
    }

    public static void print(Lettera[] conteggio){
        for(Lettera l:conteggio){
            System.out.println(l.lettera + "\t" + l.volte);
        }
    }

    public static void order(Lettera[] conteggio){
        boolean scambio = true;
        while(scambio){
            scambio = false;
            for(int i=0;i<conteggio.length-1;i++){
                if(conteggio[i].lettera>conteggio[i+1].lettera){
                    scambia(conteggio, i, i+1);
                    scambio = true;
                }
            }
        }
    }

    public static void scambia(Lettera[] conteggio, int i, int j){
        Lettera temp = conteggio[i];
        conteggio[i] = conteggio[j];
        conteggio[j] = temp;
    }

    public static void write(Lettera[] conteggio){
        java.io.FileWriter writer = null;
        try {
            writer = new java.io.FileWriter("conteggioLettere");
            for(Lettera l:conteggio){
                if(l.lettera == '\n') writer.append("a capo");
                else if(l.lettera == ' ') writer.append("spazio");
                else writer.append(l.lettera);
                writer.append("," + l.volte + "\n");
            }
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }finally {
            try {
                writer.close();
            } catch (IOException ignore){}
        }
    }
}