public class Lettore{
    String[] tabel;
    public String getFile(String file) throws java.io.FileNotFoundException {
        java.io.BufferedReader reader = null;
        String line;
        tabel = new String[0];
        try{
            reader = new java.io.BufferedReader(new java.io.FileReader(file));
            while((line = reader.readLine()) != null){
                // vado ad aggiungere ogni riga del file letto in un'elenco di stringe
                aggiungiRiga(line);
            }
        }
        catch (java.io.FileNotFoundException e){
            // catturo e rilancio un errore nel caso il file specificato non esista
            throw new java.io.FileNotFoundException();
        }
        catch (Exception e){
            // catturo e stampo a schermo un qualsiasi altro errore inatteso
            e.printStackTrace();
        }
        finally {
            try {
                // chiudo il lettore liberando il file
                reader.close();
            } catch (java.io.IOException | NullPointerException ignored) {}
        }

        String row = "";
        for(String stringa:tabel){
            row = row.concat(stringa + "\n");
        }
        return row;
    }

    public void aggiungiRiga(String row){
        // genero un nuovo elenco di righe dato che la dimensione di un array non è modificabile e io devo aggiungere una riga
        String[] newTabel = new String[tabel.length+1];
        // copio il vecchio array in quello nuovo di dimensione maggiore
        for(int i=0;i<tabel.length;i++){
            newTabel[i] = tabel[i];
        }
        // inserisco nell'ultima cella (quella "nuova" che quindi so essere vuota la riga da aggiungere all'array
        newTabel[tabel.length] = row;
        // assegno il nuovo array che ho creato al campo di questa classe in modo da sovrascrivere il vecchio elenco
        tabel = newTabel;
    }
}