import java.io.*;
import java.net.*;
import java.util.*;
import javax.swing.*;

public class Cliente {
    public static void main(String[] args) {
        try {

            //Inicializa el socket y los lectores
            String host = "127.0.0.1";
            Socket servidor = new Socket(host, Servidor.puertoclientes);
            InputStreamReader isr = new InputStreamReader(servidor.getInputStream());
            BufferedReader in = new BufferedReader(isr);
            BufferedReader tec = new BufferedReader(new InputStreamReader(System.in));

            PrintWriter out = new PrintWriter(servidor.getOutputStream(), true);

            String[] IPs = new String[5];
            IPs[0] = "galileo";
            IPs[1] = "hogwarts";
            // IPs[3] = "slytherin";
            // IPs[5] = "quidditch";

           //while(true){

              String ingresouser, ingresopass;
              System.out.println("Servidor: " + in.readLine());
              System.out.println("Servidor conectado");
              System.out.println();


              System.out.print("Username: ");
              ingresouser = JOptionPane.showInputDialog("Ingrese Usuario");
              System.out.print(ingresouser);
              System.out.println();
              //ingresouser = tec.readLine();
              System.out.print("Password: ");
              ingresopass = JOptionPane.showInputDialog("Ingrese Contrasena");
              System.out.print(ingresopass);
              System.out.println();
              //ingresopass = tec.readLine();
              String[] datosusername = ingresouser.split("@");
              String usuario = datosusername[0];
              String serv = datosusername[1];

              //Se manda la solicitud de entreda "LOGIN"
              if (Arrays.asList(datosusername).contains(serv)){
                out.println("LOGIN " + usuario + " " + ingresopass);
              }
              System.out.println("Servidor: " + in.readLine());
              JOptionPane.showMessageDialog(null, "BIENVENIDO " + usuario);


              System.out.print("Comando: ");
              //String recibo = JOptionPane.showInputDialog("Escriba un Comando...\n 1.Lista de Contactos (CLIST)\n 2.Mensajes Recibidos(GETNEWMAILS)\n 3.Enviar mensaje(SEND MAIL)\n 4.Agregar Conatacto(NEWCONT)\n 5.Salir(LOGOUT)");
              String clist = JOptionPane.showInputDialog("Comando: ");
              System.out.print(clist);
              System.out.println();

              String[] datosclist = clist.split(" ");
              String comando = datosclist[0];
              //comando = "CLIST";
              String dato1 = datosclist[1];
              // String dato2 = datosclist[2];
              // String dato3 = datosclist[3];
              // String dato4 = datosclist[4];
              // String dato5 = datosclist[5];

              if (Arrays.asList(datosclist).contains("CLIST")){
                  out.println(comando + " " + usuario);
              }else{
                JOptionPane.showMessageDialog(null, "Comando equivocado", "Error!", JOptionPane.ERROR_MESSAGE);
                System.out.println("Comando equivocado...");
              }

              //Set para imprimir la lista de contactos
              String us = in.readLine();
              String numC = in.readLine();
              int numContactos = Integer.parseInt(numC);

              if (us.equals("jorge.v")){
                for (int i=0; i<numContactos; i++){
                  System.out.println("Servidor: " + in.readLine());
                  //JOptionPane.showMessageDialog(null, in.readLine());
                }
                System.out.print("Comando: ");
                String popo= JOptionPane.showInputDialog("Comando: ");
                System.out.print(popo);
                System.out.println();
              }else if (us.equals("melissa08")){
                for (int i=0; i<numContactos; i++){
                  System.out.println("Servidor: " + in.readLine());
                  //JOptionPane.showMessageDialog(null, in.readLine());
                }
              }else if(us.equals("nick08")){
                for (int i=0; i<numContactos; i++){
                  System.out.println("Servidor: " + in.readLine());
                  //JOptionPane.showMessageDialog(null, in.readLine());
                }
              }


              //Solicitud para ver los correos
              System.out.print("Comando: ");
              String solicitudemails = JOptionPane.showInputDialog("Comando: ");
              System.out.print(solicitudemails);
              System.out.println();

              String[] ingemails = solicitudemails.split(" ");
              String comando2 = ingemails[0];
              String useremails = ingemails[1];
              if ((Arrays.asList(ingemails).contains("GETNEWMAILS")) && (Arrays.asList(ingemails).contains(usuario))){
                out.println(comando2 + " " + useremails);
              }else{
                JOptionPane.showMessageDialog(null, "Comando equivocado", "Error!", JOptionPane.ERROR_MESSAGE);
                System.out.println("Comando equivocado...");
              }

              //Set de instrucciones para imprimir los correos recibidos
              String uss = in.readLine();
              String numE = in.readLine();
              int numEmails = Integer.parseInt(numE);

              if (uss.equals("jorge.v")){
                for (int i=0; i<numEmails; i++){
                  System.out.println("Servidor: " + in.readLine());
                  //JOptionPane.showMessageDialog(null, in.readLine());
                }
              }else if (uss.equals("melissa08")){
                for (int i=0; i<numEmails; i++){
                  System.out.println("Servidor: " + in.readLine());
                  //JOptionPane.showMessageDialog(null, in.readLine());
                }
              }else if(uss.equals("nick08")){
                for (int i=0; i<numEmails; i++){
                  System.out.println("Servidor: " + in.readLine());
                  //JOptionPane.showMessageDialog(null, in.readLine());
                }
              }



              //Set de instrucciones para enviar un correo
              System.out.print("Comando: ");
              String  envio = JOptionPane.showInputDialog("Comando: ");
              System.out.print(envio);
              System.out.println();
              out.println(envio);

              System.out.print("Comando: ");
              String  solenvioemails = JOptionPane.showInputDialog("Comando Correo para: ");
              System.out.print(solenvioemails);
              System.out.println();
              // String  = tec.readLine();
              String[] ingemails2 = solenvioemails.split(" ");
              String mail = ingemails2[0];
              String to = ingemails2[1];
              String contacto = ingemails2[2];
              if ((Arrays.asList(ingemails2).contains("MAIL")) && (Arrays.asList(ingemails2).contains("TO"))){
                out.println(mail + " " + to + " " + contacto);
              }

              System.out.print("Comando: ");
              String  datosemail = JOptionPane.showInputDialog("Comando Asunto: ");
              System.out.print(datosemail);
              System.out.println();
              //tec.readLine();
              String[] datosmail = datosemail.split(" ");
              String instruccion = datosmail[0];
              String subject = datosmail[1];
              String text = datosmail[2];
              if (Arrays.asList(datosmail).contains("MAIL")){
                out.println(instruccion + " " + subject + " " + text);
              }

              System.out.print("Comando: ");
              String  cuerpo = JOptionPane.showInputDialog("Comando Cuerpo del Correo: ");
              System.out.print(cuerpo);
              System.out.println();
              //tec.readLine();
              String[] datoscuerpo = cuerpo.split(" ");
              String instruccion2 = datoscuerpo[0];
              String body = datoscuerpo[1];
              String txt = datoscuerpo[2];
              if (Arrays.asList(datoscuerpo).contains("MAIL")){
                out.println(instruccion2 + " " + body + " " + txt);
              }

              System.out.print("Comando: ");
              String  finale = JOptionPane.showInputDialog("Comando Final del Correo: ");
              System.out.print(finale);
              System.out.println();
              //tec.readLine();
              String[] finalmail = finale.split(" ");
              String instruccion3 = finalmail[0];
              String send = finalmail[1];
              String m = finalmail[2];
              if (Arrays.asList(finalmail).contains("END")){
                out.println(instruccion3 + " " + send + " " + m);
                System.out.println("Servidor: " + in.readLine());
                JOptionPane.showMessageDialog(null, "Correo Enviado");
              }

              //Set de instrucciones para ingresar un nuevo contacto
              System.out.print("Comando: ");
              String  nuevo = JOptionPane.showInputDialog("Comando para Ingresar Nuevo Conatacto: ");
              System.out.print(nuevo);
              System.out.println();
              //tec.readLine();
              String[] newcontacto = nuevo.split(" ");
              String instruccion4 = newcontacto[0];
              String contactoo = newcontacto[1];
              if (Arrays.asList(newcontacto).contains("NEWCONT")){
                out.println(instruccion4 + " " + contactoo);
                System.out.println("Servidor: " + in.readLine());
                JOptionPane.showMessageDialog(null, "Contacto Agregado");
              }

              //Verifica que el comando sea LOGOUT y manda la solicitud
              System.out.print("Comando: ");
              String  salida = JOptionPane.showInputDialog("Comando para Salir: ");
              System.out.print(salida);
              System.out.println();
              //tec.readLine();
              if (salida.equals("LOGOUT")){
                out.println(salida);
                JOptionPane.showMessageDialog(null, "ADIOS!", "Saliendo...", JOptionPane.INFORMATION_MESSAGE);
                System.out.println("Servidor: " + in.readLine());
              }


              //Cierra el socket y la entra y salida de datos.
              in.close();
              out.close();
              servidor.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Comando equivocado", "Error!", JOptionPane.ERROR_MESSAGE);
            System.out.println("INVALID COMMAND ERROR");
        }
    }
}
