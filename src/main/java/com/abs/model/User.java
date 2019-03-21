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

    private int userId;
    private boolean member;
    private String sessionId;

    public User(int userId, boolean member, String sessionId) {
        this.userId = userId;
        this.member = member;
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

    public boolean isMember() {
        return member;
    }

    public void setMember(boolean member) {
        this.member = member;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
