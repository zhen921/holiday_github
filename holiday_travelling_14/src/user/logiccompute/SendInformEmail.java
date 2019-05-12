package user.logiccompute;
import java.util.Date;
import java.util.Properties;
import javax.mail.Message.RecipientType;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class SendInformEmail {

    public static final String SMTPSERVER = "smtp.163.com";
    public static final String SMTPPORT = "587";
    public static final String ACCOUT = "wangyuwei116@163.com";
    public static final String PWD = "WEI7295099?";
public  void sendEmai(String email,boolean flag,String code){
        Properties props = new Properties();
        props.setProperty("mail.transport.protocol", "smtp"); // 
        props.setProperty("mail.smtp.host", SMTPSERVER);
        props.setProperty("mail.smtp.port", SMTPPORT); 
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.setProperty("mail.smtp.auth", "true"); 
        props.setProperty("mail.smtp.ssl.enable", "true");


        Session session = Session.getDefaultInstance(props);
      //  session.setDebug(true);
        MimeMessage message;
		try {
				message = createEmail(session,email,flag,code);
				message.addHeader("X-Mailer","Microsoft Outlook Express 6.00.2900.2869");
		        Transport transport = session.getTransport();
		        transport.connect(SMTPSERVER,ACCOUT, PWD);
		        transport.sendMessage(message, message.getAllRecipients());
		        transport.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
      

    }
 

    public static MimeMessage createEmail(Session session, String email,boolean flag,String code) throws Exception {
        MimeMessage msg = new MimeMessage(session);
        InternetAddress fromAddress = new InternetAddress(ACCOUT,
                "Travelling Network", "utf-8");
        msg.setFrom(fromAddress);
        InternetAddress receiveAddress = new InternetAddress(
                email,email, "utf-8");
        msg.setRecipient(RecipientType.TO, receiveAddress);
        msg.setSubject("来自校园驴友网", "utf-8");
        //true 获取邮箱验证码
        if(flag)
        	msg.setText("来自旅游网注册的验证信息，验证码为"+code);
        else
        	msg.setText("系统为您挑选出了合适的旅游伙伴，请注意登录网站查收哦");
        msg.setSentDate(new Date());
        msg.saveChanges();
        return msg;
    }
}

