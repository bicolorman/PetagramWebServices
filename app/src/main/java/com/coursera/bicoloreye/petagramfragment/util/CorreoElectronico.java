package com.coursera.bicoloreye.petagramfragment.util;

import android.util.Log;

import com.coursera.bicoloreye.petagramfragment.R;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class CorreoElectronico {

  private String host;
  private String mailServer;



    public boolean enviarCorreoElectronico(String fromEmail, String toEmail,String subjectEmail, String messageBody){

        final String username = "android@bicoloreye.com";
        final String password = "Passw0rd4ndr01d";

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "p3plcpnl0771.prod.phx3.secureserver.net");
        //prop.put("mail.smtp.port", "465");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.timeout", 45000);
        prop.put("mail.smtp.starttls.enable", "true"); //TLS

        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(fromEmail));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(toEmail+","+username)
            );

            message.setSubject(subjectEmail);
            message.setText(messageBody);

            Transport.send(message);

            Log.i("OK", R.string.mensaje_correo_satisfactorio+"");


        } catch (AddressException mex) {
            mex.printStackTrace();
            Log.i("NO-OK",R.string.mensaje_correo_insatisfactorio+"");

            return false;
        } catch (MessagingException mex) {
            mex.printStackTrace();
            Log.i("NO-OK",R.string.mensaje_correo_insatisfactorio+"");
            return false;
        } catch (Exception ex){
            ex.printStackTrace();
            Log.i("NO-OK",R.string.mensaje_correo_insatisfactorio+"");
            return false;
        }
        return true;
    }
}
