/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project;

import java.io.BufferedReader;
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
                String[] part = line.split("\\|");
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
                    } else {
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
                        value = Integer.parseInt(part[3]);
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

    public void add() {

    }

    public void displayList() {
        System.out.println("----------Display list----------");
        System.out.println("| ID |   Name   |   Type   | Quantity | Release | Value |");
        for (Item i : list.getList()) {
            System.out.println(i);
        }
    }

    public void deleted() {
        System.out.println("Input name to deleted one item in menu(Must fully name and correct): ");
        String check = DataInput.inputString();
        for (Item i : list.getList()) {
            if (check.equals(i.getName())) {
                list.getList().remove(i);
            }
        }
    }

    public void searchMenu() {
        System.out.println("Input name to show up item in menu: ");
        String check = DataInput.inputString();
        for (Item i : list.getList()) {
            if (check.contains(i.getName())) {
                System.out.println(i);
            }
        }
    }

    public void showValuey() {
        System.out.println("Input value you want to show up item in menu: ");
        int check = DataInput.inputInt();
        for (Item i : list.getList()) {
            if (i.getValue() < check && i.getValue() > 0) {
                System.out.println(i);
            }
        }
    } // Hiện thị giá món ăn do người tự chọn

    public void sortValue() {
        Collections.sort(list.getList());
    }

}
