package io.decid.emailservicesendgrid;

import com.sendgrid.*;
//import io.decid.emailservicesendgrid.service.UserService;
import io.decid.emailservicesendgrid.model.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.io.IOException;

@SpringBootApplication
public class EmailServiceSendgridApplication {

	private static User user;

	public static void main(String[] args) throws IOException {
		SpringApplication.run(EmailServiceSendgridApplication.class, args);
		Email from = new Email("riyad.miles@outlook.com");
		String subject = "Decidio Email Sending Assessment";
		Email to = new Email("assessment@decid.io");

//		String name = user.getName();
//		Email to = new Email(user.getEmail().toString());

		Content content = new Content("text/plain",
				"Dear User, you have received an email as a part of the Decidio Email sending Assessment development");
		Mail mail = new Mail(from, subject, to, content);

		String key = System.getenv("SENDGRID_API_KEY");
		System.out.println("key is " + key);
        SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
//		SendGrid sg = new SendGrid("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");


		Request request = new Request();
		try {
			request.setMethod(Method.POST);
			request.setEndpoint("mail/send");
			request.setBody(mail.build());
			Response response = sg.api(request);
			System.out.println(response.getStatusCode());
			System.out.println(response.getBody());
			System.out.println(response.getHeaders());
		} catch (IOException ex) {
			throw ex;
		}
	}
}


