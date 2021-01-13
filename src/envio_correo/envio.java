/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package envio_correo;

import java.net.MalformedURLException;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

/**
 *
 * @author USER
 */
public class envio {
    public static void main(String[] args) throws EmailException, MalformedURLException {
    
// Create the email message
  HtmlEmail email = new HtmlEmail();
 email.setHostName("SMTP");//servidor de correos
  email.addTo("charigbyron@hotmail.com", "060407644");//Para quien se envia
  email.setFrom("charigbyron@gmail.com", "0604076449");//quien  envia
  email.setSubject("PRUEBA ");
  
  // set the html message
  email.setHtmlMsg("<html><b>No usen Windows 7 </b> logo - <img src=\"http://media.techeblog.com/images/errormessage.jpg\"></html>");

  // set the alternative message
  email.setTextMsg("Tu Cliente de mail no Soporta HTML mensajes");

  // send the email
  email.send();
  }
}
