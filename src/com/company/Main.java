package com.company;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        if(args.length==0){
            System.out.println("enter filename as command line argument");
        }else{
            wordCount(args[0]);
        }
    }
    static void wordCount(String filePath){
        try {
            HashMap<Character ,Integer> map=new HashMap<>();
            File file=new File(filePath);
            Scanner reader=new Scanner(new FileInputStream(file));
            ArrayList<String> words=new ArrayList<>();

            while(reader.hasNext())
                words.add(reader.next());
            for(String word: words){
                for(int i=0;i<word.length();i++){
                    Integer count=map.get(word.charAt(i));
                    if(count==null){
                        map.put(word.charAt(i),1);
                    }else{
                        map.put(word.charAt(i),count+1);
                    }
                }
            }
            for(Character character: map.keySet()) {
                String value=map.get(character).toString();
                System.out.println(character+" : "+ value );
            }

        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
