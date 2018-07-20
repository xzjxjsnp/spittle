package spittrtest.model;


import lombok.Data;

import java.util.Date;

@Data
public class Spittle {
    private Integer id;
    private String message;
    private Date time;
    private String latitude;
    private String longitude;

    public Spittle(){}

    public Spittle(String message, Date time){
        this(message, time, "0.0", "0.0");
    }

    public Spittle(String message, Date time, String latitude, String longitude){
        this.id = null;
        this.message = message;
        this.time = time;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Spittle(int id, String message, Date time, String latitude, String longitude){
        this.id = id;
        this.message = message;
        this.time = time;
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
