package codetranspiler;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

import java.io.File;
import java.io.IOException;

public class CodeTranspiler {
    //1. create a function that will load the keyword translator data from a certain type of keyword
    //2. It is on csv format
    //3. The headder would be origin, translate
    String foldername;
    Table keywords;
    String[] input;
    String[] output;
    public CodeTranspiler(String foldername1) throws IOException {
        foldername=foldername1;
        keywords=new Table(new File(foldername+"/keywords.csv"),"header");
        loadInput();
        PApplet.println("Input was loaded.");
        translate();
    }

    void translate(){
        //1. Use the loop to translate every line
        //2. In each line, split in space for keyword to translate
        //3. Use the for loop again using keyword to translate each word
        //4. Save it for each index counterpart of output
        for (int i=0;i< input.length;i++){
            String[] line=PApplet.split(input[i]," ");
            String[] lineoutput=new String[line.length];
            for (int j=0;j< line.length;j++){
                lineoutput[j]=translateKeyword(line[j]);
            }
            output[i]=PApplet.join(lineoutput,' ');
        }
        saveOutput();
        PApplet.println("Finished translation.");
    }
    void loadInput(){
       input= PApplet.loadStrings(new File(foldername+"/input.txt"));
       output=new String[input.length];

    }
    void saveOutput(){
        PApplet.saveStrings(new File(foldername+"/output.txt"),output);
    }
    public String translateKeyword(String keyword){
        String ans=keyword;
        int index= keywords.findRowIndex(keyword,0);
        if (index>-1){
            TableRow tableRow=keywords.getRow(index);
            ans=tableRow.getString(1);
        }
        return ans;
    }
}
