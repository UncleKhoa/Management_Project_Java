/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.userDAO;
import DTO.userDTO;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author khoan
 */
public class userBUS {
    private userDAO userDAO;
    
    private ArrayList<userDTO> dsUS;
    
    public userBUS(){
       list();
    }
    
    public void userBUS(){
        this.userDAO = new userDAO();
    }
    
    public void list() {
        userDAO usDAO = new userDAO();
        dsUS = new ArrayList<>();
        dsUS = usDAO.list();
    }
    
    public void add(){
        userDAO usDao = new userDAO();
        
    }
    
    public userDTO Check(String username, String password){
        for(userDTO us:dsUS){
            if(us.getUsername().equals(username) && us.getPassword().equals(password)){
                return us;
            }
        }
        return null;
    }
    
    public userDTO CheckMail(String mail){
        for(userDTO us:dsUS){
            if(us.getGmail().equals(mail)){
                return us;
            }
        }
        return null;
    }
    
    public ArrayList<userDTO> getList() {
        return dsUS;
    }
    
    public boolean isValidGmailFormat(String email) {
        // Biểu thức chính quy để kiểm tra định dạng email Gmail
        String gmailPattern = "\\b[A-Za-z0-9._%+-]+@gmail\\.com\\b";

        // Tạo Pattern object từ biểu thức chính quy
        Pattern pattern = Pattern.compile(gmailPattern);

        // Tạo Matcher object để so khớp biểu thức chính quy với email
        Matcher matcher = pattern.matcher(email);

        // Trả về true nếu có sự khớp hoàn toàn
        return matcher.matches();
    }
    
        public static String generateRandomNumber(int length) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder(length);
        
        // Sinh ra từng chữ số ngẫu nhiên và thêm vào StringBuilder
        for (int i = 0; i < length; i++) {
            // Sinh một chữ số ngẫu nhiên từ 0 đến 9
            int digit = random.nextInt(10);
            // Chuyển chữ số này thành ký tự và thêm vào StringBuilder
            sb.append(digit);
        }
        
        // Trả về chuỗi số ngẫu nhiên
        return sb.toString();
    }

    public void Mail(String t, String mail) throws MessagingException, UnsupportedEncodingException {
        //Gửi email
        final String accountName = "khoanguyen052096@gmail.com";
        final String accountPassword = "kouk sduc mewa phtq";
        String subject = "Lấy lại mật khẩu";

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
        props.put("mail.smtp.port", "587"); //TLS Port
        props.put("mail.smtp.auth", "true"); //enable authentication
        props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS

        Authenticator auth = new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(accountName, accountPassword);
            }
        };
        Session session = Session.getInstance(props, auth);

        MimeMessage msg = new MimeMessage(session);
        //set message headers
        msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
        msg.addHeader("format", "flowed");
        msg.addHeader("Content-Transfer-Encoding", "8bit");
        msg.setFrom(new InternetAddress(accountName, "NoReply-JD"));
        msg.setReplyTo(InternetAddress.parse(accountName, false));
        msg.setSubject(subject, "UTF-8");

        // Nội dung email được xây dựng bằng HTML
        String htmlContent = "<h1>Thông báo!</h1>"
                + "<p>Xin chào, </p>"
                + "<p>Hiện tại đang có người đăng nhập vào tài khoản của bạn.</p>"
                + "<p>Để chắc chắn rằng đó thực sự là bạn, Vui lòng nhập mã xác minh sau: </p>"
                + "<h1><strong>" + t + "</strong></h1>";
        msg.setContent(htmlContent, "text/html; charset=UTF-8");

        msg.setSentDate(new Date());
        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(mail, false));

        Transport.send(msg);
    }
    
    public void updatePass(String pass, String mail){
        userDAO usDAO = new userDAO();
        usDAO.UpdatePassword(pass, mail);
        System.out.print(mail+" "+pass);
        return;
    }
    
}
