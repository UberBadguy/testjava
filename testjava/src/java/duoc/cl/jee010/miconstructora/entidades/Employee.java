/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoc.cl.jee010.miconstructora.entidades;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Badguy
 */
public class Employee {
    private int id;
    private int rut;
    private String dv;
    private String name;
    private String building_site_name;
    private String last_name;
    private Date birth;
    private String gender;
    private int building_site_id;
    private String payment_method;
    private String account_number;
    private String bank;
    private int value_per_hour;
    private int status;

    public Employee() {
    }

    public Employee(int id, int rut, String dv, String name, String last_name, Date birth, String gender, int building_site_id, String payment_method, String account_number, String bank, int value_per_hour, int status) {
        this.id = id;
        this.rut = rut;
        this.dv = dv;
        this.name = name;
        this.last_name = last_name;
        this.birth = birth;
        this.gender = gender;
        this.building_site_id = building_site_id;
        this.payment_method = payment_method;
        this.account_number = account_number;
        this.bank = bank;
        this.value_per_hour = value_per_hour;
        this.status = status;
    }
    public Employee(int id, int rut, String dv, String name, String last_name, Date birth, String gender, int building_site_id, String payment_method, String account_number, String bank, int value_per_hour, int status, String building_site_name) {
        this.id = id;
        this.rut = rut;
        this.dv = dv;
        this.name = name;
        this.last_name = last_name;
        this.birth = birth;
        this.gender = gender;
        this.building_site_id = building_site_id;
        this.payment_method = payment_method;
        this.account_number = account_number;
        this.bank = bank;
        this.value_per_hour = value_per_hour;
        this.status = status;
        this.building_site_name = building_site_name;
    }

    public String getPayment_method() {
        return payment_method;
    }

    public void setPayment_method(String payment_method) {
        this.payment_method = payment_method;
    }

    public String getAccount_number() {
        return account_number;
    }

    public void setAccount_number(String account_number) {
        this.account_number = account_number;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public int getValue_per_hour() {
        return value_per_hour;
    }

    public void setValue_per_hour(int value_per_hour) {
        this.value_per_hour = value_per_hour;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRut() {
        return rut;
    }

    public void setRut(int rut) {
        this.rut = rut;
    }

    public String getDv() {
        return dv;
    }

    public void setDv(String dv) {
        this.dv = dv;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getBuilding_site_id() {
        return building_site_id;
    }

    public void setBuilding_site_id(int building_site_id) {
        this.building_site_id = building_site_id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getBuilding_site_name() {
        return building_site_name;
    }

    public void setBuilding_site_name(String building_site_name) {
        this.building_site_name = building_site_name;
    }
    
    
    @Override
    public String toString() {
        Format formatter = new SimpleDateFormat("yyyy-MM-dd");
        return "{\"data\":{" +
                "\"id\":" + id +
                ",\"rut\":\"" + rut + "-" + dv + "\"" +
                ",\"name\":\"" + name + "\"" +
                ",\"last_name\":\"" + last_name + "\"" +
                ",\"birth\":\"" + formatter.format(birth) + "\"" +
                ",\"gender\":\"" + gender + "\"" +
                ",\"building_site_id\":" + building_site_id +
                ",\"payment_method\":\"" + payment_method + "\"" +
                ",\"building_site_name\":\"" + building_site_name + "\"" +
                ",\"account_number\":\"" + account_number + "\"" + 
                ",\"bank\":\"" + bank + "\"" + 
                ",\"value_per_hour\":" + value_per_hour +
                ",\"status\":" + status +"}}";
    }
    
}
