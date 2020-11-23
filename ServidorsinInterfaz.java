import java.io.*;
import java.net.*;
import java.util.*;

public class ServidorsinInterfaz {
    static int puertoclientes = 1400;
    static int puertoservidores = 1500;
    static int Dns = 1200;

    public static void main(String[] args) {
        try {
            ServerSocket servidor = new ServerSocket(puertoclientes);
            //ServerSocket sDns = new ServerSocket(Dns);
            System.out.println("Servidor esperando conexion...");
            Socket socketCliente = servidor.accept();
            //Socket socketdns = sDns.accept();
            System.out.println("Cliente conectado");

            // esta es la instruccion para la salidas y entradas del servidor hacia el DNS
            // InputStreamReader iva = new InputStreamReader(socketdns.getInputStream());
            // BufferedReader inn = new BufferedReader(iva);
            // PrintWriter outt = new PrintWriter(socketdns.getOutputStream(), true);
            // BufferedReader tecc = new BufferedReader(new InputStreamReader(System.in));

            // esta es la instruccion para la salidas y entradas del servidor hacia el cliente
            InputStreamReader isr = new InputStreamReader(socketCliente.getInputStream());
            BufferedReader in = new BufferedReader(isr);

            PrintWriter out = new PrintWriter(socketCliente.getOutputStream(), true);
            BufferedReader tec = new BufferedReader(new InputStreamReader(System.in));

            HashMap<String,String> usuarios = new HashMap<String,String>();

            ArrayList<String> listacontactosjorge = new ArrayList<String>();
            ArrayList<String> listacontactosmelissa = new ArrayList<String>();
            ArrayList<String> listacontactosnick = new ArrayList<String>();
            ArrayList<String> emailsjorge = new ArrayList<String>(50);
            ArrayList<String> emailsmelissa = new ArrayList<String>();
            ArrayList<String> emailsnick = new ArrayList<String>();

            usuarios.put("jorge.v","123456");
            usuarios.put("melissa08","741852");
            usuarios.put("nick08","963258");

            listacontactosjorge.add("Maria@galileo");
            listacontactosjorge.add("Mario@galileo");
            listacontactosjorge.add("Fernando@galileo");

            listacontactosmelissa.add("Linda08@galileo");
            listacontactosmelissa.add("Deniss3@galileo");
            listacontactosmelissa.add("el.jose@galileo");

            listacontactosnick.add("Sabrina.S@galileo");

            emailsjorge.add("sophos@hogwarts " + "OFERTAS!" + " A partir del 1 de diciembre tendremos ofertas en toda la tienda...");
            emailsjorge.add("carme@yahoo " + "Consulta!" + " A ti te compilo el proyecto, porque a mi no y voy a perder la clase :(");
            emailsjorge.add("ross.l@hogwarts " + "Bienvenido!" + " Nos complace darte la bienvenida a nuestro elenco, nos vemos el martes");
            emailsjorge.add("jose00@galileo " + "Pago!" + " Su pago se realizp con exito :)");
            emailsjorge.add("avon@yahoo " + "Catalogo!" + " Ya esta disponible el catalogo de la nueva temporada!");

            emailsmelissa.add("el.jose@hogwarts" + "HOLA" + "Soy yo otra vez...no me ignores");
            emailsmelissa.add("avon@yahoo" + "Catalogo" + "Ya esta disponible el catalogo de la nueva temporada!");

            //Recibe el IP y manda el comando al DNS para estar ONLINE
             out.println("Bienvenido!");
            // System.out.print("IP: ");
            // String ingresoIP = tecc.readLine();
            // outt.println("ONLINE galileo " + ingresoIP);
            // System.out.println("DNS: " + inn.readLine());

            //Lee el ingreso del usuario de parte del cliente
            String recibo = in.readLine();
            System.out.println("Cliente: " + recibo);

            String[] ingresodelcliente = recibo.split(" ");
            String x = ingresodelcliente[0];
            String user = ingresodelcliente[1];
            String password = ingresodelcliente[2];

            //Se verifica que tanto el user como la contrasena sea valida
            if (usuarios.containsKey(user) == true){
              if (usuarios.containsValue(password) == true){
                out.println("OK LOGIN");
              }else{
                out.println("LOGIN ERROR 102");
              }
            }else{
              out.println("LOGIN ERROR 101");
            }

            //Recibe el comando CLIST
            String recibo2 = in.readLine();
            System.out.println("Cliente: " + recibo2);
            String[] ingreso2 = recibo2.split(" ");
            String comando = ingreso2[0];
            String userl = ingreso2[1];

            //String[] clientelist = new String[2];
            //clientelist = recibo2.split(" ");
            //String comando = clientelist[0];
            //String userlist = clientelist[1];
            // if (userl == "jorge.v"){
            //   for (String n: listacontactosjorge) {
            //     out.println("OK CLIST " + n);
            //     }
            //   }
          //  out.println("OK CLIST " + listacontactosjorge.get(0));

            //Recorre la lista de contactos para devolverla al cliente.
            if(userl.equals("jorge.v")){
              out.println("jorge.v");
              out.println(listacontactosjorge.size());
              for(int i=0; i < listacontactosjorge.size(); i++){
                out.println("OK CLIST " + listacontactosjorge.get(i).toString());
              }
            }else if(userl.equals("melissa08")){
              out.println("melissa08");
              out.println(listacontactosmelissa.size());
              for(int i=0; i < listacontactosmelissa.size(); i++){
                out.println("OK CLIST " + listacontactosmelissa.get(i).toString());
              }
            }else if(userl.equals("nick08")){
              out.println("nick08");
              out.println(listacontactosnick.size());
              for(int i=0; i < listacontactosnick.size(); i++){
                out.println("OK CLIST " + listacontactosnick.get(i).toString());
              }
            }else{
              out.println("ERROR 103");
            }


            String recibo3 = in.readLine();
            System.out.println("Cliente: " + recibo3);
            String[] ingreso3 = recibo3.split(" ");
            String comando2 = ingreso3[0];
            String useremails = ingreso3[1];

            //Recorre la lista de emails de los contactos para devolverla al cliente.
            if(userl.equals("jorge.v")){
              if (emailsjorge.equals(null)){
                out.println("OK GETNEWMAILS NOMAILS");
              }else{
                out.println("jorge.v");
                out.println(emailsjorge.size());
                for(int i=0; i<emailsjorge.size(); i++){
                  out.println("OK GETNEWMAILS " + emailsjorge.get(i).toString());
                }
              }
            }else if(userl.equals("melissa08")){
              if (emailsmelissa.equals(null)){
                out.println("OK GETNEWMAILS NOMAILS");
              }else{
                out.println("melissa08");
                out.println(emailsmelissa.size());
                for(int i=0; i<emailsmelissa.size(); i++){
                  out.println("OK GETNEWMAILS " + emailsmelissa.get(i));
                }
              }
            }else if(userl.equals("nick08")){
              if (emailsnick.equals(null)){
                out.println("OK GETNEWMAILS NOMAILS");
              }else{
                out.println("nick08");
                out.println(emailsnick.size());
                for(int i=0; i<emailsnick.size(); i++){
                  out.println("OK GETNEWMAILS " + emailsnick.get(i));
                }
              }
            }else{
              out.println("OK GETNEWMAILS NOMAILS");
            }

            // String reciboo = in.readLine();
            // System.out.println("Cliente: " + reciboo);

            //Recibe las instrucciones para enviar un email.
            String recibo4 = in.readLine();
            System.out.println("Cliente: " + recibo4);
            String recibo5 = in.readLine();
            System.out.println("Cliente: " + recibo5);
            String recibo6 = in.readLine();
            System.out.println("Cliente: " + recibo6);
            String recibo7 = in.readLine();
            System.out.println("Cliente: " + recibo7);
            String recibo8 = in.readLine();
            System.out.println("Cliente: " + recibo8);

            //Guarda cada comando recibido en partes
            String[] ingreso4 = recibo4.split(" ");
            String comando3 = ingreso4[0];
            String mail = ingreso4[1];

            String[] ingreso5 = recibo5.split(" ");
            String comando4 = ingreso5[0];
            String to = ingreso5[1];
            String contact = ingreso5[2];

            String[] otroservidor = contact.split("@");
            String userr = otroservidor[0];
            String ser = otroservidor[1];

            String[] ingreso6 = recibo6.split(" ");
            String comando5 = ingreso6[0];
            String subject = ingreso6[1];
            String text = ingreso6[2];

            String[] ingreso7 = recibo7.split(" ");
            String comando6 = ingreso7[0];
            String body = ingreso7[1];
            String txt = ingreso7[2];

            String[] ingreso8 = recibo8.split(" ");
            String comando7 = ingreso8[0];
            String send = ingreso8[1];
            String m = ingreso8[2];


            //Verifica que los ingresos para enviar el correo sean validos
            if (userl.equals("jorge.v")){
              if ((Arrays.asList(txt).contains(null)) || (Arrays.asList(text).contains(null)) || (Arrays.asList(contact).contains(null))){
                out.println("SEND ERROR 106");
                out.println("SEND ERROR 107");
              }else{
                if (listacontactosjorge.contains(contact)){
                  out.println("OK SEND MAIL");
                }else{
                  out.println("SEND ERROR 104 " + contact);
                }
              }
            }else if (userl.equals("melissa08")){
              if ((Arrays.asList(txt).contains(null)) || (Arrays.asList(text).contains(null)) || (Arrays.asList(contact).contains(null))){
                out.println("SEND ERROR 106");
                out.println("SEND ERROR 107");
                }else{
                  if (listacontactosmelissa.contains(contact)){
                    out.println("OK SEND MAIL");
                  }else{
                    out.println("SEND ERROR 104 " + contact);
                  }
                }
            }else if (userl.equals("nick08")){
              if ((Arrays.asList(txt).contains(" ")) || (Arrays.asList(text).contains(" ")) || (Arrays.asList(contact).contains(" "))){
                out.println("SEND ERROR 106");
                out.println("SEND ERROR 107");
                }else{
                  if (listacontactosnick.contains(contact)){
                    out.println("OK SEND MAIL");
                  }else{
                     out.println("SEND ERROR 104 " + contact);
                  }
                }
            }


            //Manda la informacion a el servidor correspondiente.
            // out.println("SEND MAIL " + contact);
            // out.println("MAIL " + "FROM " + contact);
            // out.println("MAIL " + "SUBJECT " + text);
            // out.println("MAIL " + "BODY" + txt);
            // out.println("END SEND MAIL");
            // System.out.println("Servidor: " + in.readLine());


            String recibo9 = in.readLine();
            System.out.println("Cliente: " + recibo9);
            String[] ingreso9 = recibo9.split(" ");
            String comando8 = ingreso9[0];
            String contacto = ingreso9[1];

            //Verifica la informacion para agregar un contacto "NEWCONT"
            if (contacto.equals("jorge.v")){
              if (Arrays.asList(listacontactosjorge).contains(contacto)){
                out.println("NEWCONT ERROR 109 " + contacto);
              }else{
                listacontactosjorge.add(contacto);
                out.println("OK NEWCONT " + contacto);
              }
            }else if (contacto.equals("melissa08")){
              if (Arrays.asList(listacontactosmelissa).contains(contacto)){
                out.println("NEWCONT ERROR 109 " + contacto);
              }else{
                listacontactosmelissa.add(contacto);
                out.println("OK NEWCONT " + contacto);
              }
            }else if (contacto.equals("nick08")){
              if (Arrays.asList(listacontactosnick).contains(contacto)){
                out.println("NEWCONT ERROR 109 " + contacto);
              }else{
                listacontactosnick.add(contacto);
                out.println("OK NEWCONT " + contacto);
              }
            }else{
               out.println("NEWCONT ERROR 110 " + contacto);
            }

            //Recibe y verifica que el comando de salida sea correcto
            String salida = in.readLine();
            System.out.println("Cliente: " + salida);
            if (salida.equals("LOGOUT")){
              out.println("OK LOGOUT");
            }

            //Le avisa al DNS que esta OFFLINE
            // outt.println("OFFLINE galileo");
            // System.out.println("DNS: " + inn.readLine());


            //Cierra los elementos de comunicacion.
            in.close();
            out.close();
            socketCliente.close();
            //socketdns.close();
        }catch (Exception e) {
            System.out.println("INVALID COMMAND ERROR");
        }
    }
}
