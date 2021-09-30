import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args){

        System.out.println(hacerDirDoble());

    }

    public static String hacerDirDoble() {
        String impresion="";
        String impresion2="";

        try {
            ProcessBuilder builder = new ProcessBuilder(
                    "cmd.exe", "/c", "cd C:\\ && dir");
            builder.redirectErrorStream(true);
            Process p = builder.start();
            BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            while ((line = r.readLine()) != null) {

                impresion += line+"\n";

                if(line.contains("<DIR>"))
                    impresion2+=repetirDir(line.substring(36));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return impresion+impresion2;
    }

    public static String repetirDir(String nombre) throws IOException {
        String cadena;
        String impresion2="";
        ProcessBuilder builder2 = new ProcessBuilder(
                "cmd.exe", "/c", "cd C:\\"+nombre+" && dir");
        builder2.redirectErrorStream(true);
        Process p2 = builder2.start();
        BufferedReader r = new BufferedReader(new InputStreamReader(p2.getInputStream()));
        while ((cadena = r.readLine()) != null)
            impresion2+=cadena+"\n";
        return impresion2;
    }
}
