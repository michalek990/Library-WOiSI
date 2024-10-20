package com.wp.library.Notification.infrastructure;

import com.wp.library.Notification.domain.constants.EmailTemplates;
import com.wp.library.Notification.domain.contract.MailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class ExportedBookNotificationService extends NotificationService {
    public ExportedBookNotificationService(JavaMailSender mailSender) {
        super(mailSender);
    }

    @Override
    protected MailMessage formatMessage(String subject, String body) {
        subject = String.format(EmailTemplates.EXPORT_BOOKS_SUBJECT);
        body = String.format(EmailTemplates.EXPORT_BOOKS_BODY);

        return new MailMessage(subject, body);
    }
}
