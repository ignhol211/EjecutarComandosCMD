import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args){

        System.out.println(hacerDirDoble());

    }

    public static String hacerDirDoble() {
        String impresion="";

        try {
            ProcessBuilder builder = new ProcessBuilder(
                    "cmd.exe", "/c", "cd C:\\ && dir");
            builder.redirectErrorStream(true);
            Process p = builder.start();
            BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            while ((line = r.readLine()) != null) {
                System.out.println(line);
                if(line.contains("<DIR>"))
                    repetirDir(line.substring(36),impresion);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return impresion;
    }

    public static void repetirDir(String nombre,String impresion) throws IOException {
        String cadena;
        //StringBuilder devolucion= new StringBuilder();
        ProcessBuilder builder1 = new ProcessBuilder(
                "cmd.exe", "/c", "cd C:\\"+nombre+" && dir");
        builder1.redirectErrorStream(true);
        Process p1 = builder1.start();
        BufferedReader r = new BufferedReader(new InputStreamReader(p1.getInputStream()));
        while ((cadena = r.readLine()) != null) {
            impresion+=cadena+"\n";
        }
    }
}
