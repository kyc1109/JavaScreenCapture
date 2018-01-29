    private static void screencapture() throws IOException, AWTException {
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
                    //Save file at %userprofile%\Documents\NetBeansProjects\JavaSikuli
                }  
            }
        } catch (AWTException ex) {
            Logger.getLogger(JavaSnapshot.class.getName()).log(Level.SEVERE, null, ex);          
        }
    } 
