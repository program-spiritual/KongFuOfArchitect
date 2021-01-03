package pubSub.eventBus;

import pubSub.p2p.PromotionService;
import pubSub.p2p.RegObserver;

public class RegPromotionObserver implements RegObserver {
    private PromotionService promotionService; // 依赖注入
    @Override
    public void handleRegSuccess(long userId) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                promotionService.issueNewUserExperienceCash(userId);
            }
        });
        thread.start();
    }
}
