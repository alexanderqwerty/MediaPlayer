package com.example.mediaplayer;

import java.io.Serializable;

public class Audio implements Serializable {
    private Integer namber,
            RAudio,
    image;
    private String nameAudio;

    public Audio(Integer namber, Integer RAudio, String nameAudio,Integer image) {
        this.namber = namber;
        this.RAudio = RAudio;
        this.nameAudio = nameAudio;
        this.image = image;
    }

    public Integer getNamber() {
        return namber;
    }

    public Integer getRAudio() {
        return RAudio;
    }

    public String getNameAudio() {
        return nameAudio;
    }

    public Integer getImage(){return image;}

}
