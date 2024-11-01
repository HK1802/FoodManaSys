/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author OS
 */
public class Item implements Comparable<Item> {
    private int IDItem; // ID của món ăn
    private String Name; // Tên món ăn
    private String type; // kiểu món ăn: Fast Food, Special, Drink
    private int Quantity; // số lượng
    private Date Release; // Ngày ra mắt(dd-MM-yyyy)
    private int value; // Giá thành

    public Item() {
    }

    public Item(int IDItem, String Name, String type, int Quantity, Date Release, int value) {
        this.IDItem = IDItem;
        this.Name = Name;
        this.type = type;
        this.Quantity = Quantity;
        this.Release = Release;
        this.value = value;
    }

    

    @Override
    public int compareTo(Item other){
        return Integer.compare(this.value, other.value);
    }

    @Override
    public String toString() {
        SimpleDateFormat SDF = new SimpleDateFormat("dd-MM-yyyy");
        return "| " + IDItem + " | " + Name + " | " + type + " |  " + Quantity + "  | " + SDF.format(Release) + " |  " + value + "  |";
    }

    
    
    public int getIDItem() {
        return IDItem;
    }

    public void setIDItem(int IDItem) {
        this.IDItem = IDItem;
    }
    
    

    

    
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

    public Date getRelease() {
        return Release;
    }

    public void setRelease(Date Release) {
        this.Release = Release;
    }

}
