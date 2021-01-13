/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package envio_correo;

import entidades.envio_correo;
import java.util.ArrayList;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;


/**
 *
 * @author USER
 */
public class envio_de_correo {
    
int i;
    
    
    /////// CODIFICACION  ///////
    
    public static void main(String[] args) throws Exception {
 /* ArrayList<envio_correo>  lista_correo= new ArrayList<>();
  lista_correo=modelos.m_envio_correo.obtenerTodosCorreo();
   for(int i=0; i<lista_correo.size();i++)
   { 
   String destinatario =  lista_correo.get(i).getCorreo();
       System.out.println(destinatario);
       String asunto = "Programa NIIF Riobamba";
       String cuerpo = "INVITACIÓN AL PROGRAMA NIIF RIOBAMBA ";
       System.out.println(asunto);
       System.out.println(cuerpo);
       
       //enviarConGMail(destinatario, asunto, cuerpo);
   }*/
  // System.out.println("la lista tiene "+lista_correo.size()+"elementos");
   // String destinatario =  "charigbyron@hotmail.com"; //A quien le quieres escribir.
   // String asunto = "Programa NIIF Riobamba";
    //String cuerpo = "INVITACIÓN AL PROGRAMA NIIF RIOBAMBA ";

   // enviarConGMail(destinatario, asunto, cuerpo);
        String destinatario= "charigbyron@hotmail.com";
        String asunto="Hola";
        String cuerpo="asas";
        enviarConGMail(destinatario, asunto, cuerpo);
}
    
    
    
    
    private static void enviarConGMail(String destinatario, String asunto, String cuerpo) {
    // Esto es lo que va delante de @gmail.com en tu cuenta de correo. Es el remitente también.
    String remitente = "charigbyron";  //Para la dirección nomcuenta@gmail.com

    Properties props = System.getProperties();
    props.put("mail.smtp.host", "smtp.gmail.com");  //El servidor SMTP de Google
    props.put("mail.smtp.user", remitente);
    props.put("mail.smtp.clave", "0604076449");// de la cuenta
    props.put("mail.smtp.auth", "true");    //Usar autenticación mediante usuario y clave
    props.put("mail.smtp.starttls.enable", "true"); //Para conectar de manera segura al servidor SMTP
    props.put("mail.smtp.port", "587"); //El puerto SMTP seguro de Google

    Session session = Session.getDefaultInstance(props);
    MimeMessage message = new MimeMessage(session);

    try {
        message.setFrom(new InternetAddress(remitente));
        message.addRecipient(Message.RecipientType.TO,new InternetAddress( destinatario));   //Se podrían añadir varios de la misma manera
        message.setSubject(asunto);
       
        BodyPart adjunto = new MimeBodyPart();
        adjunto.setContent("<HTML>\n" +
"\n" +
"<HEAD>\n" +
"\n" +
"<TITLE>Un Titulo para el Browser de turno </TITLE>\n" +
"\n" +
"</HEAD>\n" +
"\n" +
"<BODY>\n" +
"\n" +
"<!-- Aqui va todo lo chachi -->\n" +
"\n" +
"<H1>Otro t&iacute;tulo, esta vez m&aacute;s largo. </H1>\n" +
"\n" +
"<P> <IMG SRC= \"./felix.gif \"ALIGN= \"MIDDLE \" ALT= \"EL Gato Felix \">Hoola.\n" +
"\n" +
"<P>Esto es un parrafo con informacion\n" +
"\n" +
"super importante. Notese que las lineas salen pegadas aun dejando\n" +
"\n" +
"espacios, saltos de linea, etc. <BR> &#161 Si pongo esto\n" +
"\n" +
"si <STRONG>cambia </STRONG> de linea!\n" +
"\n" +
"<P>Otro parrafo, esto ya es un poco rollo.\n" +
"\n" +
"<H3>Pongamos un subtítulo<H3>\n" +
"\n" +
"<P>Por cierto, &#191 que paso con las <A HREF= \"#pepe \">anclas</A>?\n" +
"\n" +
"<HR>\n" +
"\n" +
"<UL>\n" +
"\n" +
"<LI> Esto es una lista no ordenada.\n" +
"\n" +
"<LI> Las listas quedan mejor si tienen varios elementos.\n" +
"\n" +
"</UL>\n" +
"\n" +
"Me voy al <A HREF= \"http://www.iac.es/home.html \">IAC</A>.\n" +
"\n" +
"<P>Vamos a crear un <EM>ancla </EM>, o lo que es lo mismo, un <A NAME=\"pepe\">anchor.</A>\n" +
"\n" +
".....................................................\n" +
"\n" +
".....................................................\n" +
"\n" +
"</BODY>\n" +
"\n" +
"</HTML>","text/html");
        
        
        
        
        MimeMultipart multiParte = new MimeMultipart();
        multiParte.addBodyPart(adjunto);
       // message.setContent(multiParte);
        message.setContent(multiParte);
        Transport transport = session.getTransport("smtp");
        //transport.connect("smtp.gmail.com", remitente, clave);
        transport.connect("smtp.gmail.com", remitente, "0604076449");
        
        transport.sendMessage(message, message.getAllRecipients());
        transport.close();
    }
    catch (MessagingException me) {
        me.printStackTrace();   //Si se produce un error
    }
}
    
    
    
    
    
}
