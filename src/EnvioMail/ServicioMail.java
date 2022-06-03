/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EnvioMail;

import java.util.Properties;

public class ServicioMail {

    final String username = "ejemplo@gmail.com";
    final String password = "password";

    public ServicioMail() {
    }

    public void EnvioCorreo() {
        /*this.txtDni.setInputVerifier(
          new InputVerifier() {
            @Override
            public boolean verify(JComponent input) {
              boolean isValid = false;

              String text = ((JTextField) input).getText();
              if (text != null && text.matches("[0-9]{7,8}[A-Z]")) {
                isValid = true;
                ((JTextField) input).setBackground(null);
              }
              if (!isValid) {
               ((JTextField) input).setBackground(Color.red);
              }
              return isValid;
            }
          });
        this.txtCorreo.setInputVerifier(
          new InputVerifier() {
            @Override
            public boolean verify(JComponent input) {
              boolean isValid = false;

              String text = ((JTextField) input).getText();
              if (text != null && text.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
                isValid = true;
                ((JTextField) input).setBackground(null);
              }
              if (!isValid) {
               ((JTextField) input).setBackground(Color.red);
              }
              return isValid;
            }
          });*/
       /* Properties props = new Properties();

        props.put(
                "mail.smtp.auth", "true");
        props.put(
                "mail.smtp.starttls.enable", "true");
        props.put(
                "mail.smtp.host", "smtp.gmail.com");
        props.put(
                "mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {

            // Define message
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setSubject("asunto");
            message.addRecipient(Message.RecipientType.TO, new InternetAddress("cmedina@imptec.com.pe"));
            message.setText("gracias Chuidiang");
            // Envia el mensaje
            Transport.send(message);
        } catch (Exception e) {
        }*/
    }

}
