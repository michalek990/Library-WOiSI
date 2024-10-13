package com.wp.library.Notification.infrastructure;

import com.wp.library.Notification.domain.adapter.NotificationAdapter;
import com.wp.library.Notification.domain.contract.MailMessage;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

@Slf4j
@RequiredArgsConstructor
public abstract class NotificationService implements NotificationAdapter {
    private final JavaMailSender mailSender;

    @Value("${spring.mail.username")
    private String fromMail;

    @Override
    public void sendNotification(String subject, String body, String to) {
        MailMessage message = formatMessage(subject, body);
        sendEmail(to, message.subject(), message.content());
    }

    private void sendEmail(String toMail, String subject, String body) {
        if(!isEmailValid(toMail)) {
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

    protected abstract MailMessage formatMessage(String subject, String body);
}
