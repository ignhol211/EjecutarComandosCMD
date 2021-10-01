import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args){

        System.out.println(hacerDirDoble());

    }
    //Opción A: la función hacerDirDoble no imprime nada por pantalla. Obliga a devolver dos String concatenados.
    //Opción B: la función hacerDirDoble imprime la primera parte por pantalla y llama a la función repetirDir
    public static String hacerDirDoble() {
        //String impresionA="";
        StringBuilder impresionB1= new StringBuilder();
        StringBuilder impresionB2= new StringBuilder();

        try {
            ProcessBuilder builder = new ProcessBuilder(
                    "cmd.exe", "/c", "cd C:\\ && dir");
            builder.redirectErrorStream(true);
            Process p = builder.start();
            BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            while ((line = r.readLine()) != null) {

                //System.out.println(line);

                impresionB1.append(line).append("\n");

                if(line.contains("<DIR>"))
                    //impresionA+=repetirDir(line.substring(36));
                    impresionB2.append(repetirDir(line.substring(36)));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //return impresionA;
        return impresionB1 + impresionB2.toString();
    }

    public static String repetirDir(String nombre) throws IOException {
        String cadena;
        StringBuilder impresion2= new StringBuilder();
        ProcessBuilder builder2 = new ProcessBuilder(
                "cmd.exe", "/c", "cd C:\\"+nombre+" && dir");
        builder2.redirectErrorStream(true);
        Process p2 = builder2.start();
        BufferedReader r = new BufferedReader(new InputStreamReader(p2.getInputStream()));
        while ((cadena = r.readLine()) != null)
            impresion2.append(cadena).append("\n");
        return impresion2.toString();
    }
}
