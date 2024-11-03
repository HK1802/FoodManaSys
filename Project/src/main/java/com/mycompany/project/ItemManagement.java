/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project;

/**
 *
 * @author OS
 */
public class ItemManagement {
    public static void main(String[] args) {
        ItemList_View ILV = new ItemList_View();
        String file = "D:\\NetBeansProjects\\Project\\src\\main\\java\\com\\mycompany\\project\\item.txt";
        ILV.loadFile(file);
        String[] option = {"Display list", 
            "Add item into menu", 
            "Search food by name", 
            "Search food by value you choose", 
            "Update food in menu by using Name or ID",
            "Deleted one food in menu",
            "Save file data under Binary",
            "Load file data under Binary",
            "sort and display"};
        Menu menu = new Menu("Management Menu", option){
            @Override
            public void execute(int n){
                switch(n){
                    case 1:
                        ILV.displayList();
                        break;
                    case 2:
                        ILV.add();
                        break;
                    case 3:
                        ILV.searchMenu();
                        break;
                    case 4:
                        ILV.showValuey();
                        break;
                    case 5:
                        ILV.update();
                        break;
                    case 6:
                        ILV.deleted();
                        break;
                    case 7:
                        ILV.saveFileStream(file);
                        break;
                    case 8:
                        ILV.loadFileStream();
                        break;
                    case 9:
                        ILV.sortAndDisplayByDescendingValue();
                        break;
                }
            }
        };
        menu.run();
    }
}
