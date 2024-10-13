package com.wp.library.Notification.domain.adapter;

public interface NotificationAdapter {
    void sendNotification(String subject, String body, String to);
}
