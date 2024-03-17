package lk.ijse.bookworm.Controller;

import javafx.scene.control.Alert;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailServiceController {

    public static void sendEmail(String toEmail, String subject, String body) {
        final String fromEmail = "ahkpw0330@gmail.com";
        final String password = "gwpw voqz apdz xkss"; /*"Msi@GF63M20"*/

        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(fromEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            message.setSubject(subject);
            message.setText(body);

            Transport.send(message);
            new Alert(Alert.AlertType.CONFIRMATION).show();

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}


