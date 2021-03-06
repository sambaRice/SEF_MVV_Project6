package model;

import enumerations.Status;
import enumerations.availability;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.time.LocalDate;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.UUID;

public class Activity implements Serializable {
    private String activityID;
    private String activityName;
    private String activityDescription;
    private ArrayList<String> actStaff = new ArrayList<String>();
    private ArrayList<Activity> dependencies = new ArrayList<Activity>();
    private double estimatedTimeInWeek;
    private LocalDate startDate;
    private LocalDate endDate;
    private double earlyStart = -1;
    private double earlyFinish = -1;
    private double lateStart = -1;
    private double lateFinish = -1;
    private double totalSlack = -1;
    private Status activityStatus;
    private availability dayPerWeek;
    private ArrayList<Skill> listOfSkillsNeeded = new ArrayList<Skill>();

    public Activity(String name, String description, double duration, ArrayList<String> staffs_id, LocalDate startDate, LocalDate endDate, availability dayPerWeek, ArrayList<Activity> dependencies, ArrayList<Skill> skillRequired) {
        this.activityID = UUID.randomUUID().toString();
        this.actStaff = staffs_id;
        this.activityStatus = Status.OPEN;
        this.startDate = startDate;
        this.endDate = endDate;
        this.dayPerWeek = dayPerWeek;
        this.listOfSkillsNeeded = skillRequired;
        this.activityName = name;
        this.activityDescription = description;
        this.estimatedTimeInWeek = duration;
        this.dependencies = dependencies;
        if (this.dependencies == null) {
            this.earlyStart = 0;
            this.earlyFinish = this.earlyStart+this.estimatedTimeInWeek;
        }
    }

    public Activity(String name, String description, Skill skill, Status status, availability dayPerWeek, LocalDate startDate, LocalDate endDate) {
        this.activityID = UUID.randomUUID().toString();
        this.activityStatus = status;
        this.listOfSkillsNeeded.add(skill);
        this.startDate = startDate;
        this.endDate = endDate;
        this.dayPerWeek = dayPerWeek;
        this.activityName = name;
        this.activityDescription = description;
    }

    //Getter methods
    public double getEstimatedTimeInWeek() {
        return estimatedTimeInWeek;
    }

    public String getActivityID() {
        return this.activityID;
    }
    
    public String getActivityName(){
        return this.activityName;
    }

    public String getActivityDescription() { return this.activityDescription; }

    public ArrayList<Activity> getDependencies(){
        return this.dependencies;
    }

    public double getLateStart() {
        return lateStart;
    }

    public double getEarlyStart() {
        return earlyStart;
    }

    public double getEarlyFinish() {
        return earlyFinish;
    }

    public ArrayList<Skill> getSkillRequired() {
        return this.listOfSkillsNeeded;
    }

    public void setSkillRequired(ArrayList<Skill> skillRequired) {
        this.listOfSkillsNeeded = skillRequired;
    }

    public void setSkillRequired(Skill skillRequired) {
        this.listOfSkillsNeeded.add(skillRequired);
    }

    public void setActStaff(String employeeId) {
        this.actStaff.add(employeeId);
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public double getLateFinish() {
        return lateFinish;
    }

    public double getTotalSlack() {
        return totalSlack;
    }

    public Status getActivityStatus() {
        return activityStatus;
    }

    //Setter methods
    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public void setActivityDescription(String activityDescription) {
        this.activityDescription = activityDescription;
    }

    public void setEstimatedTimeInWeek(double estimatedTimeInWeek) {
        this.estimatedTimeInWeek = estimatedTimeInWeek;
    }

    public void setEarlyStart(double value){
        this.earlyStart = value;
    }

    public void setEarlyFinish(double value){
        this.earlyFinish = value;
    }

    public void setLateStart(double value) {
        this.lateStart = value;
    }

    public void setLateFinish(double value){
        this.lateFinish = value;
    }

    public ArrayList<String> getActStaff() {
        return this.actStaff;
    }

    public void setActStatus(Status activityStatus) {
        this.activityStatus = activityStatus;
    }

    public ArrayList<String> getStaffs_id() {
        return this.actStaff;
    }

    public void setStaffs_id(ArrayList<String> staffs_id) {
        this.actStaff = staffs_id;
    }

    public availability getDayPerWeek() {
        return this.dayPerWeek;
    }

    public void setDayPerWeek(availability dayPerWeek) {
        this.dayPerWeek = dayPerWeek;
    }

    public void setActivityStatus(Status activityStatus) {
        this.activityStatus = activityStatus;
    }

    public Boolean assignStaff(String staffID){
        if (getStaffs_id().contains(staffID)) {
            return false;
        }
        getActStaff().add(staffID);
    
        return true;
    }

    public void setTotalSlack(double value){
        this.totalSlack = value;
    }

    public void progressCheck(LocalDate date) {
        if (date.compareTo(this.endDate) > 0) {
            setActStatus(Status.OVER_DUE);
        }
    }

    @Override
    public String toString() {
        return "\n[name: " + this.activityName + "]\n";
    }
}