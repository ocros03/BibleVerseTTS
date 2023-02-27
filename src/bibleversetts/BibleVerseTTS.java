/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bibleversetts;
import java.util.Locale;  
import javax.speech.Central;  
import javax.speech.synthesis.Synthesizer;  
import javax.speech.synthesis.SynthesizerModeDesc; 
/**
 *
 * @author ptsou
 */
public class BibleVerseTTS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {  
            //setting properties as Kevin Dictionary  
            System.setProperty("freetts.voices", 
                                  "com.sun.speech.freetts.en.us" 
                                  + ".cmu_us_kal.KevinVoiceDirectory");  
            
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
            synthesizer.speakPlainText("Hello my name is dumb", null);  
            synthesizer.waitEngineState(Synthesizer.QUEUE_EMPTY);  
            
            //deallocating the Synthesizer  
            synthesizer.deallocate();  
        }  
        catch (Exception e){  
            e.printStackTrace();  
        }  
    }  
}