package com.turkcell.libraryapplication.dto.response;

import java.util.UUID;

public class OgrenciResponse {

    private UUID ogrenciID;
    private String ogrenciAd;
    private String email;

    public OgrenciResponse() {}

    public UUID getOgrenciID() { return ogrenciID; }
    public void setOgrenciID(UUID ogrenciID) { this.ogrenciID = ogrenciID; }
    public String getOgrenciAd() { return ogrenciAd; }
    public void setOgrenciAd(String ogrenciAd) { this.ogrenciAd = ogrenciAd; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}
