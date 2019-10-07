package com.LabMovix.Movix.client;

import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.*;
import lombok.experimental.Tolerate;



import java.util.ArrayList;
import java.util.Date;
@JacksonStdImpl
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Movie {

    private String id;
    @Getter
    private String title;
    private String description;
    private String duration;
    private Date publishDate;
    private Date publishLimit;
    private ArrayList<String> actors;
    private ArrayList<String> director;
    private Date releaseDate;



}
