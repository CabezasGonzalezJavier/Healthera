package com.example.javier.healthera.model.remedy;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

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
    @SerializedName("course_quantity")
    @Expose
    private Integer courseQuantity;
    @SerializedName("date_created")
    @Expose
    private Integer dateCreated;
    @SerializedName("date_modified")
    @Expose
    private Integer dateModified;
    @SerializedName("dispense_id")
    @Expose
    private String dispenseId;
    @SerializedName("dose_continuous")
    @Expose
    private Object doseContinuous;
    @SerializedName("dose_discrete")
    @Expose
    private String doseDiscrete;
    @SerializedName("medicine_type")
    @Expose
    private String medicineType;
    @SerializedName("instruction")
    @Expose
    private String instruction;
    @SerializedName("medicine_name")
    @Expose
    private String medicineName;
    @SerializedName("oba")
    @Expose
    private String oba;
    @SerializedName("pharmacy_id")
    @Expose
    private String pharmacyId;
    @SerializedName("reorder_timestamp")
    @Expose
    private Integer reorderTimestamp;
    @SerializedName("restrictions")
    @Expose
    private String restrictions;
    @SerializedName("schedule")
    @Expose
    private List<Schedule> schedule = null;
    @SerializedName("special_instruction")
    @Expose
    private String specialInstruction;
    @SerializedName("strictness")
    @Expose
    private Integer strictness;
    @SerializedName("taker_num")
    @Expose
    private Integer takerNum;


    public Datum(String patientId) {
        this.patientId = patientId;
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

    public Integer getCourseQuantity() {
        return courseQuantity;
    }

    public void setCourseQuantity(Integer courseQuantity) {
        this.courseQuantity = courseQuantity;
    }

    public Integer getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Integer dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Integer getDateModified() {
        return dateModified;
    }

    public void setDateModified(Integer dateModified) {
        this.dateModified = dateModified;
    }

    public String getDispenseId() {
        return dispenseId;
    }

    public void setDispenseId(String dispenseId) {
        this.dispenseId = dispenseId;
    }

    public Object getDoseContinuous() {
        return doseContinuous;
    }

    public void setDoseContinuous(Object doseContinuous) {
        this.doseContinuous = doseContinuous;
    }

    public String getDoseDiscrete() {
        return doseDiscrete;
    }

    public void setDoseDiscrete(String doseDiscrete) {
        this.doseDiscrete = doseDiscrete;
    }

    public String getMedicineType() {
        return medicineType;
    }

    public void setMedicineType(String medicineType) {
        this.medicineType = medicineType;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public String getOba() {
        return oba;
    }

    public void setOba(String oba) {
        this.oba = oba;
    }

    public String getPharmacyId() {
        return pharmacyId;
    }

    public void setPharmacyId(String pharmacyId) {
        this.pharmacyId = pharmacyId;
    }

    public Integer getReorderTimestamp() {
        return reorderTimestamp;
    }

    public void setReorderTimestamp(Integer reorderTimestamp) {
        this.reorderTimestamp = reorderTimestamp;
    }

    public String getRestrictions() {
        return restrictions;
    }

    public void setRestrictions(String restrictions) {
        this.restrictions = restrictions;
    }

    public List<Schedule> getSchedule() {
        return schedule;
    }

    public void setSchedule(List<Schedule> schedule) {
        this.schedule = schedule;
    }

    public String getSpecialInstruction() {
        return specialInstruction;
    }

    public void setSpecialInstruction(String specialInstruction) {
        this.specialInstruction = specialInstruction;
    }

    public Integer getStrictness() {
        return strictness;
    }

    public void setStrictness(Integer strictness) {
        this.strictness = strictness;
    }

    public Integer getTakerNum() {
        return takerNum;
    }

    public void setTakerNum(Integer takerNum) {
        this.takerNum = takerNum;
    }

}
