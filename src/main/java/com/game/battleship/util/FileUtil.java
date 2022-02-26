package com.game.battleship.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class FileUtil {

    public static List<String> readDataFromFile() throws FileNotFoundException {
        FileInputStream fis=new FileInputStream("/Users/ma/Manju/battleship/src/main/resources/data.txt");       
        Scanner sc=new Scanner(fis);    //file to be scanned  
        //returns true if there is another line to read  
        List<String> inputData = new ArrayList<>();
        while(sc.hasNextLine())  
        {  
            inputData.add(sc.nextLine());
            System.out.println();      //returns the line that was skipped  
        }  
        sc.close();
        return inputData;
    }
}
