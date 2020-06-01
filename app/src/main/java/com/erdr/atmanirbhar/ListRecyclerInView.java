package com.erdr.atmanirbhar;

public class ListRecyclerInView {

    public String NameOfCompany, LogoOfCompany, ChinaName, IndiaName, DataAbout;

    public ListRecyclerInView(){
    }
    public ListRecyclerInView(String NameOfCompany, String LogoOfCompany, String ChinaName, String IndiaName, String DataAbout) {
        this.NameOfCompany = NameOfCompany;
        this.LogoOfCompany = LogoOfCompany;
        this.ChinaName = ChinaName;
        this.IndiaName = IndiaName;
        this.DataAbout = DataAbout;
    }

    public String getIndiaName() {
        return IndiaName;
    }

    public void setIndiaName(String indiaName) {
        IndiaName = indiaName;
    }

    public String getDataAbout() {
        return DataAbout;
    }

    public void setDataAbout(String dataAbout) {
        DataAbout = dataAbout;
    }

    public String getNameOfCompany() {
        return NameOfCompany;
    }

    public void setNameOfCompany(String nameOfCompany) {
        NameOfCompany = nameOfCompany;
    }

    public String getLogoOfCompany() {
        return LogoOfCompany;
    }

    public void setLogoOfCompany(String logoOfCompany) {
        LogoOfCompany = logoOfCompany;
    }

    public String getChinaName() {
        return ChinaName;
    }

    public void setChinaName(String chinaName) {
        ChinaName = chinaName;
    }
}
