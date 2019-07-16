package com.kener.dell.vericekme;

import java.util.ArrayList;

public class cities {
    private ArrayList<list> citylist;

    public ArrayList<list> getData() {
        return citylist;
    }

    public void setData(ArrayList<list> citylist) {
        this.citylist = citylist;
    }
}

 class list{
     private String idn;
     private String city;
     private  String temp;


     public String getTemp() {
         return temp;
     }

     public void setTemp(String temp) {
         this.temp = temp;
     }




     public String getIdn() {
         return idn;
     }

     public void setIdn(String idn) {
         this.idn = idn;
     }

     public String getCity() {
         return city;
     }

     public void setCity(String city) {
         this.city = city;
     }
 }
