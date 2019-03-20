/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abs.model;

/**
 *
 * @author ghani
 */
public class User {

    private String sessionId;

    public User(String sessionId) {
        this.sessionId = sessionId;
    }

    public User() {
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
}
