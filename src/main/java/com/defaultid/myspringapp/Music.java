package com.defaultid.myspringapp;



public interface Music {
    default String getMusicGenreName() {
        return this.getClass().getSimpleName();
    }
    default String getSong() {
        return "UNTITLED";
    }
}
