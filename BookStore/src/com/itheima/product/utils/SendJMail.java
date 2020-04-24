package com.itheima.product.utils;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendJMail {
	
		public static boolean sendMail(String email, String emailMsg) {
		
		String from = "qiu_wenxin@163.com"; 				// �ʼ������˵��ʼ���ַ
		String to = email; 										// �ʼ������˵��ʼ���ַ
		final String username = "qiu_wenxin@163.com";  	//�����˵��ʼ��ʻ�
		final String password = "qiuwenxin66";   		 //注意：此处需要的是授权码，并不是密码			//�����˵��ʼ�����


		//����Properties����,���û�����Ϣ
		Properties props = new Properties();

		//�����ʼ��������ĵ�ַ
		props.setProperty("mail.smtp.host", "smtp.163.com"); // ָ����smtp������
		props.setProperty("mail.smtp.auth", "true");
		props.setProperty("mail.transport.protocol", "smtp");//���÷����ʼ�ʹ�õ�Э��
		//����Session����,session�����ʾ�����ʼ��Ļ�����Ϣ
		Session session = Session.getInstance(props);
		//�������������Ϣ
		session.setDebug(true);
		try {
			//Message��ʵ�������ʾһ������ʼ�
			MimeMessage message = new MimeMessage(session);
			//���÷����˵ĵ�ַ
			message.setFrom(new InternetAddress(from));
			//��������
			message.setSubject("用户激活");
			//�����ʼ����ı�����
			//message.setText("Welcome to JavaMail World!");
			message.setContent(emailMsg,"text/html;charset=utf-8");
			//��session�Ļ����л�ȡ�����ʼ��Ķ���
			Transport transport=session.getTransport();
			//�����ʼ�������
			transport.connect("smtp.163.com",25, username, password);
			//�����ռ��˵�ַ,��������Ϣ
			transport.sendMessage(message,new Address[]{new InternetAddress(to)});
			transport.close();
			return true;
		} catch (MessagingException e) {
			e.printStackTrace();
			return false;
		}
	}
	
}
