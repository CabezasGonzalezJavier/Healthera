package com.example.javier.healthera.model;

import com.example.javier.healthera.model.adherence.Datum;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Javier on 21/12/2017.
 */

public class CreateGenericList {

    public static List<Generic> getGenericList(List<Datum> list, String tablet, String tablets, String noFound) {
        List<Generic> listReturn = new ArrayList<>();

        String actionAndDose = noFound;
        String date = noFound;
        String adherenceId = noFound;
        String patientId = noFound;
        String remedyId = noFound;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getAction() != null || list.get(i).getDoseQuantity() != null) {
                StringBuilder stringBuilder = new StringBuilder();
                if (list.get(i).getAction() != null) {
                    stringBuilder.append(list.get(i).getAction());
                    stringBuilder.append(", ");
                }
                if (list.get(i).getDoseQuantity() != null) {
                    stringBuilder.append(String.valueOf(list.get(i).getDoseQuantity()));
                    if (list.get(i).getDoseQuantity() == 1) {
                        stringBuilder.append(tablet);
                    } else {
                        stringBuilder.append(tablets);
                    }
                }

                actionAndDose = stringBuilder.toString();

            }

            if (list.get(i).getAlarmTime()!=null) {
                Date time=new java.util.Date((long)list.get(i).getAlarmTime()*1000);
                SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm");
                date = dateFormat.format(time);
            }

            if (list.get(i).getAdherenceId()!=null) {
                adherenceId =list.get(i).getAdherenceId();
            }

            if (list.get(i).getPatientId()!=null) {
                patientId = list.get(i).getPatientId();
            }

            if (list.get(i).getRemedyId()!=null) {
                remedyId = list.get(i).getRemedyId();
            }

            listReturn.add(new Generic(actionAndDose, date,adherenceId, patientId, remedyId));

        }

        return listReturn;
    }
}
