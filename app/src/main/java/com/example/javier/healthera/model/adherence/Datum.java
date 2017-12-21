package com.example.javier.healthera.model.adherence;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Javier on 21/12/2017.
 */

public class Datum {

    @SerializedName("patient_id")
    @Expose
    private String patientId;
    @SerializedName("remedy_id")
    @Expose
    private String remedyId;
    @SerializedName("alarm_time")
    @Expose
    private Integer alarmTime;
    @SerializedName("adherence_id")
    @Expose
    private String adherenceId;
    @SerializedName("action")
    @Expose
    private String action;
    @SerializedName("action_time")
    @Expose
    private Integer actionTime;
    @SerializedName("dose_discrete")
    @Expose
    private Object doseDiscrete;
    @SerializedName("dose_quantity")
    @Expose
    private Integer doseQuantity;
    @SerializedName("note")
    @Expose
    private Object note;
    @SerializedName("date_modified")
    @Expose
    private Integer dateModified;

    public Datum(String patientId, String remedyId) {
        this.patientId = patientId;
        this.remedyId = remedyId;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getRemedyId() {
        return remedyId;
    }

    public void setRemedyId(String remedyId) {
        this.remedyId = remedyId;
    }

    public Integer getAlarmTime() {
        return alarmTime;
    }

    public void setAlarmTime(Integer alarmTime) {
        this.alarmTime = alarmTime;
    }

    public String getAdherenceId() {
        return adherenceId;
    }

    public void setAdherenceId(String adherenceId) {
        this.adherenceId = adherenceId;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Integer getActionTime() {
        return actionTime;
    }

    public void setActionTime(Integer actionTime) {
        this.actionTime = actionTime;
    }

    public Object getDoseDiscrete() {
        return doseDiscrete;
    }

    public void setDoseDiscrete(Object doseDiscrete) {
        this.doseDiscrete = doseDiscrete;
    }

    public Integer getDoseQuantity() {
        return doseQuantity;
    }

    public void setDoseQuantity(Integer doseQuantity) {
        this.doseQuantity = doseQuantity;
    }

    public Object getNote() {
        return note;
    }

    public void setNote(Object note) {
        this.note = note;
    }

    public Integer getDateModified() {
        return dateModified;
    }

    public void setDateModified(Integer dateModified) {
        this.dateModified = dateModified;
    }

}
