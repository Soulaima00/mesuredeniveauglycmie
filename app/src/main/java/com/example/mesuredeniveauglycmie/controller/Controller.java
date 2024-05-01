package com.example.mesuredeniveauglycmie.controller;

import android.content.Context;

import com.example.mesuredeniveauglycmie.model.AccessLocal;
import com.example.mesuredeniveauglycmie.model.Patient;

import java.util.Date;

public class Controller {
    private static Controller instance = null;
    private static Patient patient;

    //private static AccessDistant accessDistant;
    private static AccessLocal accessLocal;
    private Controller(){
        super();
    }
    public static final Controller getInstance( Context context){
        if(Controller.instance ==null){
            Controller.instance = new Controller();
            accessLocal=new AccessLocal(context);
            //récuper
            patient = accessLocal.getPatient();

            //accessDistant = new AccessDistant();
            //accessDistant.envoi("dernier", new JSONArray());
        }
        return Controller.instance;
    }
    public void createPatient(int age, float valeurMesuree, boolean isFasting){
        patient = new Patient(new Date(), age, valeurMesuree, isFasting);

        accessLocal.insertPatient(patient);

        //accessDistant.envoi("enreg", patient.convertToJSONArray());
    }

    public String getResult() {
        return patient.getReponse();
    }

    public static Patient getPatient() {
        return patient;
    }


}