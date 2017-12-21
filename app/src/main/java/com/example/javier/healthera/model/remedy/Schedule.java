package com.example.javier.healthera.model.remedy;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Javier on 21/12/2017.
 */

public class Schedule {

    @SerializedName("day_offset")
    @Expose
    private Integer dayOffset;
    @SerializedName("day_iterator")
    @Expose
    private Integer dayIterator;
    @SerializedName("dose_min")
    @Expose
    private Integer doseMin;
    @SerializedName("dose_max")
    @Expose
    private Integer doseMax;
    @SerializedName("alarm_window")
    @Expose
    private String alarmWindow;
    @SerializedName("number_of_alarms")
    @Expose
    private Integer numberOfAlarms;
    @SerializedName("dose_string")
    @Expose
    private String doseString;
    @SerializedName("number_of_loops")
    @Expose
    private Integer numberOfLoops;

    public Integer getDayOffset() {
        return dayOffset;
    }

    public void setDayOffset(Integer dayOffset) {
        this.dayOffset = dayOffset;
    }

    public Integer getDayIterator() {
        return dayIterator;
    }

    public void setDayIterator(Integer dayIterator) {
        this.dayIterator = dayIterator;
    }

    public Integer getDoseMin() {
        return doseMin;
    }

    public void setDoseMin(Integer doseMin) {
        this.doseMin = doseMin;
    }

    public Integer getDoseMax() {
        return doseMax;
    }

    public void setDoseMax(Integer doseMax) {
        this.doseMax = doseMax;
    }

    public String getAlarmWindow() {
        return alarmWindow;
    }

    public void setAlarmWindow(String alarmWindow) {
        this.alarmWindow = alarmWindow;
    }

    public Integer getNumberOfAlarms() {
        return numberOfAlarms;
    }

    public void setNumberOfAlarms(Integer numberOfAlarms) {
        this.numberOfAlarms = numberOfAlarms;
    }

    public String getDoseString() {
        return doseString;
    }

    public void setDoseString(String doseString) {
        this.doseString = doseString;
    }

    public Integer getNumberOfLoops() {
        return numberOfLoops;
    }

    public void setNumberOfLoops(Integer numberOfLoops) {
        this.numberOfLoops = numberOfLoops;
    }

}
