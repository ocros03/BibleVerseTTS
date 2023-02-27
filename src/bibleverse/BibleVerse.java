/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bibleverse;

import java.util.Scanner;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Files;
import java.util.Locale;  
import javax.speech.Central;  
import javax.speech.synthesis.Synthesizer;  
import javax.speech.synthesis.SynthesizerModeDesc; 
/**
 *
 * @author Orion Crosby
 */
public class BibleVerse {
    // Private member fields
    private String book;                               
    private int chapter;
    private int verse;
    
    // Default Constructor
    public BibleVerse() {
        book = "none";
        chapter = 0;
        verse = 0;
    }

    // Parameterized constructor
    public BibleVerse(String bk, int ch, int vrs) {  
        book = bk;
        chapter = ch;
        verse = vrs;
    }

    // Book accessor
    public String getBook() {                       
        return book;
    }

    // Chapter accessor
    public int getChapter() {                      
        return chapter;
    }

    // Verse accessor
    public int getVerse() {                        
        return verse;
    }

    // Book mutator
    public void setBook(String bk) {              
        book = bk;
    }

    // Chapter mutator
    public void setChapter(int ch) {              
        chapter = ch;
    }

    // Verse mutator
    public void setVerse(int vrs) {              
        verse = vrs;
    }

    // Get the verse text
    public String getVerseText() {
        Path filePath = Path.of("kjbible.txt");
        String bible = null;
      
        try {
            bible = Files.readString(filePath);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
      
        // Find the start of the verse
        int startIndex = bible.indexOf(book + chapter + ":" + verse);

        // Find the next colon after the start of the verse
        int endIndex = bible.indexOf("\n", startIndex);

        // Get the verse's text
        String text = bible.substring(startIndex, endIndex);
        
        return text;
    }
    
    public void BibleVerseTTS(String verse, boolean quit) {
    try {  
            //setting properties as Kevin Dictionary  
            /*
            System.setProperty("freetts.voices",
                                   "com.sun.speech.freetts.en.us"
                                   + ".cmu_us_kal.KevinVoiceDirectory");
            */
            
            // setting properties as MBROLA
            System.setProperty("freetts.voices", 
                                  "de.dfki.lt.freetts.en.us" 
                                  + ".MbrolaVoiceDirectory");  
            
            //registering speech engine  
            Central.registerEngineCentral("com.sun.speech.freetts" 
                    + ".jsapi.FreeTTSEngineCentral");  
            
            //create a Synthesizer that generates voice  
            Synthesizer synthesizer = 
                Central.createSynthesizer(new SynthesizerModeDesc(Locale.US));  
            
            //allocates a synthesizer  
            synthesizer.allocate();
            
            //resume a Synthesizer  
            synthesizer.resume();  
            
            //speak the specified text until the QUEUE become empty  
            synthesizer.speakPlainText(verse, null);  
            synthesizer.waitEngineState(Synthesizer.QUEUE_EMPTY);  
            
            if (quit){
            //deallocating the Synthesizer  
            synthesizer.deallocate();  
            }
        }  
        catch (Exception e){  
            e.printStackTrace();  
        }  
    }

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scnr = new Scanner(System.in);
        boolean endLoop = false;

        do {
            // Get the book
            System.out.println("Enter the book:");
            String book = scnr.nextLine();

            // Get the chapter
            System.out.println("Enter the chapter:");
            int chapter = scnr.nextInt();

            // Get the verse
            System.out.println("Enter the verse:");
            int verse = scnr.nextInt();

            // Create bible verse object
            BibleVerse bvo = new BibleVerse(book, chapter, verse);
            
            // Get the bible verse string and pass it to TTS to read it
            bvo.BibleVerseTTS(bvo.getVerseText(), endLoop);
            
            // quit loop?
            System.out.println("Enter 'q' to quit or  any other key to continue:");
            String choice = scnr.next();

            if (choice.equals("q")) {
                endLoop = true;
                bvo.BibleVerseTTS("God bless you", endLoop);
                //System.out.println("God bless you");
            }

            scnr.nextLine();
            System.out.println("");

        } while (!endLoop); 
    }  
}