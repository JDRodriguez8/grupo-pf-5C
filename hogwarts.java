import java.io.*;
import java.util.*;
import java.net.*;

public class hogwarts{
  static int puertoservidor = 1500;

  public static void main(String[] args){
    try{
      String host = "127.0.0.1";
      Socket servidor = new Socket(host, Servidor.puertoservidores);

      InputStreamReader isr = new InputStreamReader(servidor.getInputStream());
      BufferedReader in = new BufferedReader(isr);

      // esta es la instruccion para la salidas del servidor hacia el otro servidor
      PrintWriter out = new PrintWriter(servidor.getOutputStream(), true);


      ArrayList<String> contactos = new ArrayList<String>();

      contactos.add("julia@hogwarts");
      contactos.add("hatshepshut8@hogwarts");
      contactos.add("papitochulo@hogwarts");
      contactos.add("olga.la@hogwarts");
      contactos.add("pancha@hogwarts");

      String recibo1 = in.readLine();
      System.out.println("Servidor: " + recibo1);
      String[] ingresomail = recibo1.split(" ");
      String comandosend = ingresomail[0];
      String comandomail = ingresomail[1];
      String contacto = ingresomail[2];

      if (Arrays.asList(comandosend).contains("SEND")){
        String recibo2 = in.readLine();
        System.out.println("Servidor: " + recibo2);
        String[] ingresodestino = recibo2.split(" ");
        String comandom = ingresodestino[0];
        String comandofrom = ingresodestino[1];
        String destinatario = ingresodestino[2];

        String recibo3 = in.readLine();
        System.out.println("Servidor: " + recibo3);
        String[] ingresosub = recibo3.split(" ");
        String comandomm = ingresosub[0];
        String comandosub = ingresosub[1];
        String txt = ingresosub[2];

        String recibo4 = in.readLine();
        System.out.println("Servidor: " + recibo4);
        String[] ingresobody = recibo4.split(" ");
        String comandommm = ingresobody[0];
        String comandobody = ingresobody[1];
        String texto = ingresobody[2];

        String recibo5 = in.readLine();
        System.out.println("Servidor: " + recibo5);
        String[] ingresoend = recibo5.split(" ");
        String comandoend = ingresoend[0];
        String comandos = ingresoend[1];
        String m = ingresoend[2];

        if ((Arrays.asList(destinatario).contains(null)) || (Arrays.asList(txt).contains(null)) || (Arrays.asList(texto).contains(null))){
          if (contactos.contains(contacto)){
            out.println("OK SEND MAIL");
          }else{
            out.println("SEND ERROR 201 " + contacto);
          }
        }else{
          out.println("SEND ERROR 202");
          out.println("SEND ERROR 203");
          out.println("SEND ERROR 204");
        }
      }else if(Arrays.asList(comandosend).contains("CHECK")){
        if (contactos.contains(contacto)){
          out.println("OK NEWCONT " + contacto);
        }else{
          out.println("CHECK ERROR 205");
        }
      }




    }catch (Exception e){
      System.out.println("INVALID COMMAND ERROR");
    }
  }
}
