package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.logging.Logger;

public class CharCounter {

    private static final Logger logger = Logger.getLogger(CharCounter.class.getName());
    private static final File outputFile=new File("/home/rahulalishetty/output.txt");

    public static void main(String[] args) {
        if(args.length==0){
            logger.info("enter filename as command line argument");
        }else{
            wordCount(args[0]);
        }
    }

    static void wordCount(String filePath){
        try {
            wordCountHandler(filePath);
        }catch (Exception e) {
            logger.info("error ocuured"+ e);
        }
    }

    static void wordCountHandler(String filePath) throws IOException {
        HashMap<Character ,Integer> map=new HashMap<>();
        File file=new File(filePath);
        Scanner reader=new Scanner(new FileInputStream(file));
        ArrayList<String> words=new ArrayList<>();

        while(reader.hasNext()){
            words.add(reader.next());
        }

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
        writeToFile(map);
    }

    static void writeToFile(HashMap<Character ,Integer> map) throws IOException {
        outputFile.createNewFile();
        PrintWriter writer=new PrintWriter("/home/rahulalishetty/output.txt","UTF-8");

        for(Character character: map.keySet()) {
            String value=map.get(character).toString();
            StringBuilder charWithCount=new StringBuilder("");
            charWithCount.append(character);
            charWithCount.append(" : ");
            charWithCount.append(value);
            writer.println(charWithCount);
        }
        logger.info("finished writing output to file named output.txt in home directory");
        writer.close();
    }
}
