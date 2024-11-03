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
            }
            
            
        } catch (IOException ex) {
            Logger.getLogger(ItemList.class.getName()).log(Level.SEVERE, null, ex);
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
    public void updateItemById() {
    System.out.println("Input ID of the item you want to update: ");
    int idToUpdate = DataInput.inputInt();
    Item itemToUpdate = null;

    // Find the item by ID
    for (Item item : list.getList()) {
        if (item.getId() == idToUpdate) {
            itemToUpdate = item;
            break;
        }
    }

    if (itemToUpdate == null) {
        System.out.println("Item with ID " + idToUpdate + " not found.");
        return;
    }

    // Update item's information
    System.out.println("Current information: " + itemToUpdate);
    
    System.out.println("Enter new name (leave blank to keep current): ");
    String newName = DataInput.inputString();
    if (!newName.isEmpty()) {
        itemToUpdate.setName(newName);
    }

    System.out.println("Enter new type (leave blank to keep current): ");
    String newType = DataInput.inputString();
    if (!newType.isEmpty() && (newType.equals("Fast Food") || newType.equals("Special") || newType.equals("Drink") || newType.equals("Combo"))) {
        itemToUpdate.setType(newType);
    }

    System.out.println("Enter new quantity (leave blank to keep current): ");
    String newQuantityStr = DataInput.inputString();
    if (!newQuantityStr.isEmpty()) {
        try {
            int newQuantity = Integer.parseInt(newQuantityStr);
            itemToUpdate.setQuantity(newQuantity);
        } catch (NumberFormatException e) {
            System.out.println("Invalid quantity input. Keeping current value.");
        }
    }

    System.out.println("Enter new release date (dd-MM-yyyy) (leave blank to keep current): ");
    String newReleaseDateStr = DataInput.inputString();
    if (!newReleaseDateStr.isEmpty()) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        sdf.setLenient(false);
        try {
            Date newReleaseDate = sdf.parse(newReleaseDateStr);
            itemToUpdate.setRelease(newReleaseDate);
        } catch (ParseException e) {
            System.out.println("Invalid date format. Keeping current value.");
        }
    }

    System.out.println("Enter new value (leave blank to keep current): ");
    String newValueStr = DataInput.inputString();
    if (!newValueStr.isEmpty()) {
        try {
            int newValue = Integer.parseInt(newValueStr);
            itemToUpdate.setValue(newValue);
        } catch (NumberFormatException e) {
            System.out.println("Invalid value input. Keeping current value.");
        }
    }

    System.out.println("Item updated successfully: " + itemToUpdate);
}
}
    
