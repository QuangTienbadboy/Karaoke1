package com.example.tien;

public class Song {
    private int songNumber;
    private String songInfo;

    public Song(int songNumber, String songInfo) {
        this.songNumber = songNumber;
        this.songInfo = songInfo;
    }

    public int getSongNumber() {
        return songNumber;
    }

    public String getSongInfo() {
        return songInfo;
    }
}