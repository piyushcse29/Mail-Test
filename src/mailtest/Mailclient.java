package mailtest;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

public class Mailclient
{


public void sendMail(String from, String to,
String subject, String messageBody) throws MessagingException, AddressException
{
// Setup mail server
String host = "smtp.gmail.com";
String username = "piyush.cse29@gmail.com";
String password = "Yourpassword";
Properties props = new Properties();
props.put("mail.smtps.auth", "true");

// Get a mail session
Session session = Session.getDefaultInstance(props, null);

// Define a new mail message
MimeMessage message = new MimeMessage(session);
message.setFrom(new InternetAddress(from));
message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
message.setSubject(subject);

message.setText(messageBody);

// Send the message
Transport t = session.getTransport("smtps");
try {
t.connect(host, username, password);
t.sendMessage(message, message.getAllRecipients());
} finally {
t.close();
}

}

public static void main(String[] args)
{
try
{
Mailclient client = new Mailclient();
String from="piyush.cse29@gmail.com";
String to = "piyush.cse29@gmail.com";
String subject="Hiiii";
String message="This mail is from mail implementation program";

client.sendMail(from,to,subject,message);
}
catch(Exception e)
{
e.printStackTrace(System.out);
}

}
}
