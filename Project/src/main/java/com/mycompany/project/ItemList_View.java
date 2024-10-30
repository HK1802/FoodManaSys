/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author OS
 */
public class ItemList_View {
    ItemList list = new ItemList();
    
    public void loadFile(String file){
        SimpleDateFormat SDF = new SimpleDateFormat("dd-MM-yyyy");
        SDF.setLenient(false);
        
        try(BufferedReader br = new BufferedReader(new FileReader(file))){
            String line;
            while((line = br.readLine()) != null){
                String[] part = line.split(",");
                try {
                    Item item = new Item(
                    Integer.parseInt(part[0]),
                    part[1],
                    part[2],
                    Integer.parseInt(part[3]),
                    SDF.parse.(part[4]),
                    Integer.parseInt(part[5]));
                    list.add(item);
                } catch (NumberFormatException | ParseException e ) {
                    System.out.println("Error parsing item: "+e.getMessage());
                }
            }
            
        } catch (IOException ex) {
            Logger.getLogger(ItemList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 public  void addSpecialItem(String name, int quantity, String releaseDate, int value) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        try {
            Item specialItem = new Item(list.getNextID(),name,"Special",quantity,sdf.parse(releaseDate),value);
            list.add(sepcialItem);
            System.out.println("Special item added successfully!");
        } catch (ParseException e) {
            System.out.println("Date format is incorrect.");
        }
    }
    
    
    public void add(){
        
    }
    
    public void displayList(){
        for(Item i: list.getList()){
            System.out.println(i);
        }
    }
    
    public void deleted(){
        System.out.println("Input name to deleted one item in menu(Must fully name and correct): ");
        String check = DataInput.inputString();
        for(Item i:list.getList()){
            if(check.equals(i.getName())){
                list.getList().remove(i);
            }
        }        
    }
    
    public void searchMenu(){
        System.out.println("Input name to show up item in menu: ");
        String check = DataInput.inputString();
        for(Item i:list.getList()){
            if(check.contains(i.getName())){
                System.out.println(i);
            }
        }
    }
    
    public void showValuey(){
        System.out.println("Input value you want to show up item in menu: ");
        int check = DataInput.inputInt();
        for(Item i:list.getList()){
            if(i.getValue() < check && i.getValue() > 0){
                System.out.println(i);
            }
        }
    } // Hiện thị giá món ăn do người tự chọn
    
    public void sortValue(){
        
//        Collections.sort(list.getList());
    }
    
    
}
