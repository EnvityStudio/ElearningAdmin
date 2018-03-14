/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;



/**
 *
 * @author thuanenvity
 */
public class Course {

    private int idcourse;
    private String name;
    private String description;
    private long subcribers;
    private String image;
    private int totalTime;
    private int progress;

    public Course() {
    }

    public Course(int idcourse, String name, String description, long subcribers, String image, int totalTime) {
        this.idcourse = idcourse;
        this.name = name;
        this.description = description;
        this.subcribers = subcribers;
        this.image = image;
        this.totalTime = totalTime;
    }
     public Course(int idcourse, String name, String description, long subcribers, String image ) {
        this.idcourse = idcourse;
        this.name = name;
        this.description = description;
        this.subcribers = subcribers;
        this.image = image;
    
    }

    public int getIdcourse() {
        return idcourse;
    }

    public void setIdcourse(int idcourse) {
        this.idcourse = idcourse;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getSubcribers() {
        return subcribers;
    }

    public void setSubcribers(long subcribers) {
        this.subcribers = subcribers;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(int totalTime) {
        this.totalTime = totalTime;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

}
