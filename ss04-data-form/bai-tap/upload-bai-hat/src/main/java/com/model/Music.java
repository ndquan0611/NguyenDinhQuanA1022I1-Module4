package com.model;

public class Music {
    private String name;
    private String artist;
    private String type;
    private String file;

    public Music() {
    }

    public Music(String name, String artist, String type, String file) {
        this.name = name;
        this.artist = artist;
        this.type = type;
        this.file = file;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }
}
