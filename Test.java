import java.io.FileNotFoundException;

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

    }
}