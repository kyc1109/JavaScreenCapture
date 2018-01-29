/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package screencapture;

import java.awt.AWTException;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author user
 * Reference from Java official doc  
 */
public class Screencapture {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     * @throws java.awt.AWTException
     */
    public static void main(String[] args) throws IOException, AWTException{
        // TODO code application logic here
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        try{
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            GraphicsDevice[] gs = ge.getScreenDevices();
            for (int j = 0; j < gs.length; j++) {   //get each monitor
                GraphicsDevice gd = gs[j];
                GraphicsConfiguration[] gc = gd.getConfigurations();          
                for (int i=0; i < gc.length; i++) {
                    Rectangle rec = gc[i].getBounds();  //get each screen resolution
                    BufferedImage image = new Robot().createScreenCapture(rec);
                 
                    String timeStamp = new SimpleDateFormat("MMdd_HHmm_ss").format(Calendar.getInstance().getTime());    //yyyyMMdd_HHmmss
                    ImageIO.write(image, "png", new File("Screen_"+j+"_"+ rec.width +"x"+rec.height +"_"+timeStamp +".png"));
                    System.out.println("Screen:"+j+"_"+ rec.width +"x"+rec.height +"_"+timeStamp +".png");
                    //Save file at %userprofile%\Documents\NetBeansProjects\
                }  
            }
        } catch (AWTException ex) {
            Logger.getLogger(Screencapture.class.getName()).log(Level.SEVERE, null, ex);          
        }
        
        
    }
    
}
