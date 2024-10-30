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
    public void updatePriceById() {
    int itemId = -1;
    boolean validInput = false;

    // Loop until a valid integer is provided
    while (!validInput) {
        System.out.println("Input the ID of the item to update its price: ");
        try {
            itemId = DataInput.inputInt(); // Assume this method reads an int input
            validInput = true; // If we reach here, input was valid
        } catch (NumberFormatException e) {
            System.out.println("Invalid input! Please enter a valid integer for the item ID.");
        }
    }

    // Now we have a valid itemId, we can search for the item
    boolean found = false;
    for (Item item : list.getList()) {
        if (item.getId() == itemId) {
            found = true; // Item found
            System.out.println("Current price of " + item.getName() + " is: " + item.getValue());
            System.out.println("Enter new price: ");
            int newPrice = -1;
            validInput = false;

            // Loop until a valid integer is provided for the new price
            while (!validInput) {
                try {
                    newPrice = DataInput.inputInt(); // Assume this method reads an int input
                    validInput = true; // If we reach here, input was valid
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input! Please enter a valid integer for the new price.");
                }
            }

            // Update the price
            item.setValue(newPrice);
            System.out.println("Price updated successfully!");
            break; // Exit the loop after updating
        }
    }

    if (!found) {
        System.out.println("Item with ID " + itemId + " not found.");
    }
}
    
