package com.remote.mocked;

public class WaterBill
{
    public String username;
    public WaterBill(String username)
    {
        this.username = username;
    }
    public int fetchBill() {
        return 123;
    }
}