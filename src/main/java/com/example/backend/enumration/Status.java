package com.example.backend.enumration;

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
