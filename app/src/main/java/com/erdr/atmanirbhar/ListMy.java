package com.erdr.atmanirbhar;

import com.google.firebase.firestore.QueryDocumentSnapshot;

public class ListMy {
    
    String AreaOfWork;
    QueryDocumentSnapshot document;


    public ListMy(String AreaOfWork,QueryDocumentSnapshot document){
        this.AreaOfWork = AreaOfWork;
        this.document = document;

    }

    public String getAreaOfWork() {
        return AreaOfWork;
    }

    public void setAreaOfWork(String areaOfWork) {
        this.AreaOfWork = areaOfWork;
    }

    public QueryDocumentSnapshot getDocument() {
        return document;
    }

    public void setDocument(QueryDocumentSnapshot document) {
        this.document = document;
    }
}