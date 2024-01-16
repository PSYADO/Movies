package com.example.movie.movie.domain;

import jakarta.persistence.*;

@Entity(name = "movies")
public class Movie
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private float rating;
    private String author;
    private float totalTime;

    public Long getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getAuthor()
    {
        return author;
    }

    public void setAuthor(String author)
    {
        this.author = author;
    }

    public float getTotalTime()
    {
        return totalTime;
    }

    public void setTotalTime(float totalHours)
    {
        this.totalTime = totalHours;
    }

    public float getRating()
    {
        return rating;
    }

    public void setRating(float rating)
    {
        this.rating = rating;
    }

    public Movie(){}

    public Movie(Long id,String name, float rating, String author, float totalTime)
    {
        this.id = id;
        this.name = name;
        this.rating = rating;
        this.author = author;
        this.totalTime = totalTime;
    }

}
