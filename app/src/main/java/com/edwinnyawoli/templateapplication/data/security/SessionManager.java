package com.edwinnyawoli.templateapplication.data.security;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 *
 */

@Singleton
public class SessionManager {
    private User loggedInUser;

    @Inject
    public SessionManager() {
    }

    public User getLoggedInUser() {
        return loggedInUser;
    }

    public void setLoggedInUser(User agent) {
        loggedInUser = agent;
    }
}
