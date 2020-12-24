package pubSub.p2p;

public class RegNotificationObserver implements RegObserver{
    private NotificationService notificationService;
    @Override
    public void handleRegSuccess(long userId) {
        notificationService.sendInboxMessage(userId, "Welcome...");
    }
}
