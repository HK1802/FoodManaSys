/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author OS
 */
public class ItemList_View {

    ItemList list = new ItemList();

    // Dùng để load file item.txt 
    public void loadFile(String file) {
        SimpleDateFormat SDF = new SimpleDateFormat("dd-MM-yyyy");
        SDF.setLenient(false);

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] part = line.split(",");
                if (part.length == 6) {
                    int id;
                    try {
                        id = Integer.parseInt(part[0]);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid number!");
                        continue;
                    }
                    String name = part[1];
                    String type;
                    if (part[2].equals("Fast Food")) {
                        type = part[2];
                    } else if (part[2].equals("Special")) {
                        type = part[2];
                    } else if (part[2].equals("Drink")) {
                        type = part[2];
                    }else {
                        System.out.println("Invalid type!");
                        continue;
                    }
                    

                    int quan;
                    try {
                        quan = Integer.parseInt(part[3]);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid number!");
                        continue;
                    }
                    Date Release;
                    try {
                        Release = SDF.parse(part[4]);
                    } catch (ParseException ex) {
                        Logger.getLogger(ItemList_View.class.getName()).log(Level.SEVERE, null, ex);
                        System.out.println("Invalid date");
                        continue;
                    }
                    int value;
                    try {
                        value = Integer.parseInt(part[5]);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid number!");
                        continue;
                    }
                    Item item = new Item(id, name, type, quan, Release, value);
                    list.getList().add(item);
                }
            }

        } catch (IOException ex) {
            Logger.getLogger(ItemList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void add() { // thêm món mới vô menu + DataInput sẽ khắc phục lỗi nhập string và int
        SimpleDateFormat SDF = new SimpleDateFormat("dd-MM-yyyy");
        SDF.setLenient(false);
        System.out.print("Input new ID: ");
        int ID = 0;
        
        while(true){
            boolean foundID = false;
            ID = DataInput.inputInt(); //ID sẽ input vô đây
            for(Item i: list.getList()){    // Tìm xem có bị trùng ID ko       
                if(ID == i.getIDItem()){
                    foundID = true;
                    break;
                }
            }
            
            if(foundID){    // Nếu có, nhập lại
                System.out.println("There same ID, input another!");
                continue;   // Dòng lệnh ngăn không thực hiện dòng lệnh dưới
            }
                      
            break; // phá vòng lặp while
        }
        
        
        System.out.print("Input new Name food: ");
        String name = DataInput.inputString();
        
        System.out.print("Input type(Fast Food,Drink,Special) and must correct input: ");
        String type;
        while(true){
            type = DataInput.inputString();
            if(type.equals("Fast Food") || type.equals("Drink") || type.equals("Special")){
                break;
            }
            else{
                System.out.print("Input wrong, please input again!\nInput: ");
            }
        }
        
        System.out.print("Input new quanity: ");
        int quan = DataInput.inputInt();
        
        System.out.print("Input Release date: ");
        
        Date release;
        while(true){
            try{
                String temp = DataInput.inputString();
                release = SDF.parse(temp);
                break;
            } catch(ParseException e){
                System.out.print("Input wrong, please try again!\nInput: ");
            }
        }
        
        System.out.print("Input new value: ");
        int value = DataInput.inputInt();
        
        Item item = new Item(ID,name,type,quan,release,value);
        list.getList().add(item);
        
    }

    public void displayList() {// Hiện thị danh sách món ăn
        System.out.println("----------Display list----------");
        System.out.println("| ID |   Name   |   Type   | Quantity | Release | Value |");
        for (Item i : list.getList()) {
            System.out.println(i);
        }
    }

    public void deleted() {// Xoá món ăn theo tên
        boolean found = false;
        System.out.println("Input name to deleted one item in menu(Must fully name and correct): ");
        String check = DataInput.inputString();
        for (Item i : list.getList()) {
            if (i.getName().equals(check)) {
                found = true;
                list.getList().remove(i);
                System.out.println("Deleted completed");
                break;
            }
        }
        
        if(!found){
            System.out.println("Can't found to deleted");
        }
    }

    public void searchMenu() {// Tìm món ăn theo tên 
        boolean found = false;
        System.out.println("Input name to show up item in menu: ");
        String check = DataInput.inputString();
        for (Item i : list.getList()) {
            if (i.getName().contains(check)) {
                found = true;
                System.out.println(i);
            }
        }
        
        if(!found){
            System.out.println("Can't found!");
        }
    }

        public void showValuey() {// Hiện thị giá món ăn do người tự chọn
        boolean found = false;
        System.out.println("Input value you want to show up under value you input in menu: ");
        int check = DataInput.inputInt();
        for (Item i : list.getList()) {
            if (i.getValue() < check && i.getValue() > 0) {
                found = true;
                System.out.println(i);
            }
        }
        if(!found){
            System.out.println("Can't found");
        }
    } 

    public void update(){
        
    }
        
    public void sortValue() {
        Collections.sort(list.getList());
    }
    
    public void saveFileStream(String file){ // lưu file dưới dạng Binary
        SimpleDateFormat SDF = new SimpleDateFormat("dd-MM-yyyy");
        try(DataOutputStream dataOut = new DataOutputStream(new FileOutputStream("item.dat"))){
            for(Item i:list.getList()){
                dataOut.writeUTF(String.valueOf(i.getIDItem())+","+i.getName()+","+i.getType()+","+String.valueOf(i.getQuantity())+","+String.valueOf(SDF.format(i.getRelease()))+","+String.valueOf(i.getValue()));      
            }
            System.out.println("Save completed!");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ItemList_View.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ItemList_View.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void loadFileStream(){ // mở file dưới dạng Binary
        SimpleDateFormat SDF = new SimpleDateFormat("dd-MM-yyyy");
        try(DataInputStream dataIn = new DataInputStream(new FileInputStream("item.dat"))){
            String line;
            list.getList().clear();
            int count = 0;
            try{
                while((line = dataIn.readUTF()) != null){
                    String[] part = line.split(",");

                    if(part.length == 6){
                        int ID = Integer.parseInt(part[0]);
                        String name = part[1];
                        String type = part[2];
                        int Quan = Integer.parseInt(part[3]);
                        Date date;
                        try{
                            date = SDF.parse(part[4]);
                        } catch(ParseException e){
                            continue;
                        }
                        int value = Integer.parseInt(part[5]);
                        Item i = new Item(ID,name,type,Quan,date,value);
                        list.getList().add(i);
                        count += 1;
                    }


                }
            } catch (EOFException ex){}
            
            System.out.println("Load "+count+" thing completed!");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ItemList_View.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ItemList_View.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
