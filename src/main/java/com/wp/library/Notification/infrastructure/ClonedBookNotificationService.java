package com.wp.library.Notification.infrastructure;

import com.wp.library.Notification.domain.constants.EmailTemplates;
import com.wp.library.Notification.domain.contract.MailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class ClonedBookNotificationService extends NotificationService {

    public ClonedBookNotificationService(JavaMailSender mailSender) {
        super(mailSender);
    }

    @Override
    protected MailMessage formatMessage(String subject, String body) {
        subject = String.format(EmailTemplates.CLONE_BOOK_SUBJECT, subject);
        body = String.format(EmailTemplates.CLONE_BOOK_BODY, body);

        return new MailMessage(subject, body);
    }
}
