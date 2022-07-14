package com.example.backend.user.enumration;

public enum Status {
    ONLINE("ONLINE"),
    OFFLINE("OFFLINE");
    private final String status;
    Status(String status){
        this.status=status;

    }
    public String getStatus(){
        return this.status;
    }
}
