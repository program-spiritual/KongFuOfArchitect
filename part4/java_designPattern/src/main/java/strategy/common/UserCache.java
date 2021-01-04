package strategy.common;

import template.jdbc.User;

import java.util.HashMap;
import java.util.Map;

public class UserCache {
    private Map<String, User> cacheData = new HashMap<>();
    private EvictionStrategy eviction;

    public UserCache(EvictionStrategy eviction) {
        this.eviction = eviction;
    }
}
