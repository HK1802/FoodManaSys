/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project;

import java.util.Scanner;

/**
 *
 * @author OS
 */
public class DataInput {
    public static String inputString(){ // Nhập hàm string không bỏ trống
        Scanner sc= new Scanner(System.in);
        while (true){
            String input = sc.nextLine();
            if(!input.isEmpty()){
                return input;
            }
            else{
                System.out.println("The line must not emtpy.");
                System.out.print("Input again: ");
            }
        }        
    }
    
    public static int inputInt(){ // Dùng để sửa lỗi integer mà nhập string
        Scanner sc = new Scanner(System.in);
        while(true){
            try{
                int input = Integer.parseInt(sc.nextLine());
                return input;
            } catch(NumberFormatException e){
                System.out.print("Only input number and not leave empty!\nInput again: ");
            }    
        }       
    }
}
