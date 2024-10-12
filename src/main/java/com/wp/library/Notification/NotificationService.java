package com.wp.library.Notification;

import com.wp.library.Book.domain.contract.BookRequest;
import com.wp.library.Book.domain.contract.ExportBookRequest;
import com.wp.library.Notification.adapter.NotificationAdapter;
import com.wp.library.Notification.constants.EmailTemplates;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class NotificationService implements NotificationAdapter {


    private final JavaMailSender mailSender;

    @Value("${spring.mail.username")
    private String fromMail;

    @Override
    public void sendCreatedBookEmailNotification(BookRequest request) {
        String subject = String.format(EmailTemplates.CREATE_BOOK_SUBJECT, request.getTitle());
        String body = String.format(EmailTemplates.CREATE_BOOK_BODY, request.getTitle(), request.getDescription());
        sendEmail(subject, body, request.getToMail());
    }

    @Override
    public void sendCloningBookNotification(BookRequest request) {
        String subject = String.format(EmailTemplates.CLONE_BOOK_SUBJECT,request.getTitle());
        String body = String.format(EmailTemplates.CLONE_BOOK_BODY,request.getTitle());
        sendEmail(subject,body, request.getToMail());
    }

    @Override
    public void sendExportBookNotification(ExportBookRequest request) {
        String subject = String.format(EmailTemplates.EXPORT_BOOKS_SUBJECT);
        String body = String.format(EmailTemplates.EXPORT_BOOKS_BODY);
        sendEmail(subject,body, request.getToMail());
    }

    private void sendEmail(String toMail, String subject, String body) {
        if(!isEmailValid(toMail)){
            return;
        }
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message,true);
            helper.setSubject(subject);
            helper.setTo(toMail);
            helper.setText(body);
            helper.setFrom(fromMail);
            mailSender.send(message);
        } catch (MessagingException e) {
            log.error("Error occurred creating mail message");
        }
    }

    private boolean isEmailValid(String email) {
        return StringUtils.isNoneBlank(email);
    }
}
