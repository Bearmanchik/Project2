package com.example.myapplication;

public class Gym {

    private float edtV;
    private float edtC;
    private String description;

    public Gym(String description, int edtV, int edtC) {

        this.description = description;
        this.edtV = edtV;
        this.edtC = edtC;

    }

    public String getDesc(){
        return this.description;
    }

    public float getEdtV(){
        return this.edtV;
    }

    public float getEdtC(){
        return this.edtC;
    }


}
