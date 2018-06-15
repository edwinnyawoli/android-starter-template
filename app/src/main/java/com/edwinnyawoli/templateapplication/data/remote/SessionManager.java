package com.edwinnyawoli.templateapplication.data.remote;

import com.edwinnyawoli.templateapplication.data.model.User;

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