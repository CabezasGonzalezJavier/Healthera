package com.example.javier.healthera.model;

/**
 * Created by Javier on 21/12/2017.
 */

public class Generic {

    String actionAndDose;
    String time;
    String adherenceId;
    String patientId;
    String remedyId;

    public Generic(String actionAndDose, String time, String adherenceId, String patienId, String remedyId) {
        this.actionAndDose = actionAndDose;
        this.time = time;
        this.adherenceId = adherenceId;
        this.patientId = patienId;
        this.remedyId = remedyId;
    }

    public String getActionAndDose() {
        return actionAndDose;
    }

    public String getTime() {
        return time;
    }

    public String getAdherenceId() {
        return adherenceId;
    }

    public String getPatientId() {
        return patientId;
    }

    public String getRemedyId() {
        return remedyId;
    }
}
