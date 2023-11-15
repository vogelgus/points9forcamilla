import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.sql.SQLOutput;
import java.util.Scanner;

/**
 * This is the Main class... Ms Lockwodd thinks she's funny.. like me
 * lol
 */
public class Main  {
    final int WIDTH = 1000; // this is the width of the window
    final int HEIGHT = 700; // this is the height of the window

    //Declare the variables needed for the graphics
    public JFrame frame;
    public Canvas canvas;
    public JPanel panel;
    public OrderedPair data[];;

    public boolean isEven = true;
    public boolean isOdd = false;
    public boolean areInverses = false;
    public int wonkypoint;


    public BufferStrategy bufferStrategy;




    public static void main(String[] args) {

        Main myApp;
        myApp= new Main();
        myApp.run();


    }
    public Main(){
        setUpGraphics();
        render();
        checker();
        wonky();
    }




    public double A(double x){
        return (2*x);
    }

    public double F(double x){
        return (.005*x*x);

    }
    public double G(double x){
        return (x+100);
    }
    public double H(double x){
        return (x-100);
    }

    public double J(double x){
        return (2*x);
    }
    public double K(double x){
        return (x/2);
    }
    public double L(double x){
        return ((G(x/H(x))));
    }
    public double M(double x){
        return (x/x);
    }


    public double Sin(double x){
        return (Math.sin(Math.toRadians(x)));
    }
    public double Cos(double x){
        return (Math.cos(Math.toRadians(x)));
    }

    public void wonky (){
        for(int x=-WIDTH/2;x<WIDTH/2; x++){
            if(H(x) == 0){
                wonkypoint = x;
            }
        }
        System.out.println("the wonky point is " + wonkypoint);
    }



    private void render() {
        Graphics2D g = (Graphics2D) bufferStrategy.getDrawGraphics();
        g.clearRect(0, 0, WIDTH, HEIGHT);
        g.drawLine(0,HEIGHT/2,WIDTH,HEIGHT/2);
        g.drawLine(WIDTH/2,0,WIDTH/2,HEIGHT);
        for(int x=-WIDTH/2;x<WIDTH/2;x=x+1) {


            g.setColor(Color.blue);
//            g.fillRect(x+WIDTH/2 ,-1*(int)(A(x))+HEIGHT/2, 2, 2);
//            g.fillRect(x+WIDTH/2 ,-1*(int)(H(x))+HEIGHT/2, 2, 2);


//            g.setColor(Color.red);
//            g.fillRect(x+WIDTH/2 ,-1*(int)F(x)+HEIGHT/2, 2, 2);
         //   g.setColor(Color.blue);
         //   g.fillRect(x+WIDTH/2 ,-1*(int)G(x)+HEIGHT/2, 2, 2);
         //   g.setColor(Color.green);
         //   g.fillRect(x+WIDTH/2 ,-1*(int)(100*Sin(x))+HEIGHT/2, 2, 2);
        //    g.setColor(Color.pink);
        //    g.fillRect(x+WIDTH/2 ,-1*(int)(100*Cos(x))+HEIGHT/2, 2, 2);
        //    g.fillRect(x+WIDTH/2 ,-1*(int)(G(x)+F(x))+HEIGHT/2, 2, 2);
        //    g.setColor(Color.yellow);
       //     g.fillRect(x+WIDTH/2 ,-1*(int)(G(F(x)))+HEIGHT/2, 2, 2);


       //     g.setColor(Color.red);
          //  g.fillRect(x+WIDTH/2 ,-1*(int)(root(x))+HEIGHT/2, 2, 2);
       //     g.setColor(Color.red);
       //     g.fillRect(x+WIDTH/2 ,-1*(int)(G(H(x)))+HEIGHT/2, 2, 2);

//            g.setColor(Color.gray);
//            g.fillRect(x+WIDTH/2 ,-1*(int)(J(x))+HEIGHT/2, 2, 2);

            g.setColor(Color.RED);
            g.fillRect(x+WIDTH/2 ,-1*(int)(M(x))+HEIGHT/2, 2, 2);
            g.setColor(Color.pink);
            g.fillRect(x+WIDTH/2 ,-1*(int)(L(x))+HEIGHT/2, 2, 2);


            isEven=true;
            for (double i = -WIDTH/2; i < WIDTH/2; i++){
                if (J(x) != J(-x)){
                    isEven = false;
                }
            }


            isOdd = true;
            for (double i = -WIDTH/2; i < WIDTH/2; i++){
                if (J(-x) != -1*J(x)){
                    isOdd = true;
                }
            }



            areInverses = true;
            for (double i = -WIDTH/2; i < WIDTH/2; i++){
                if (J(K(x)) != x){
                    areInverses = false;
                }
            }





        }
        //draw the image of the astronaut


        g.dispose();

        bufferStrategy.show();
    }

    public void checker(){

        if (isEven == true){
            System.out.println("the function is an even function ");
        }
        if(isEven == false){
            System.out.println("this is not an even function");
        }

        if (isOdd == true){
            System.out.println("the function is an odd function ");
        }
        if(isOdd==false){
            System.out.println("this is not an odd function");
        }
        if (areInverses == true){
            System.out.println("these two functions are inverses of each other");
        }
        if(areInverses == false){
            System.out.println("these two functions are not inverses. ");
        }
    }

    private void setUpGraphics() {
        frame = new JFrame("Application Template");   //Create the program window or frame.  Names it.

        panel = (JPanel) frame.getContentPane();  //sets up a JPanel which is what goes in the frame
        panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));  //sizes the JPanel
        panel.setLayout(null);   //set the layout

        // creates a canvas which is a blank rectangular area of the screen onto which the application can draw
        // and trap input events (Mouse and Keyboard events)
        canvas = new Canvas();
        canvas.setBounds(0, 0, WIDTH, HEIGHT);
        canvas.setIgnoreRepaint(true);

        panel.add(canvas);  // adds the canvas to the panel.

        // frame operations
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //makes the frame close and exit nicely
        frame.pack();  //adjusts the frame and its contents so the sizes are at their default or larger
        frame.setResizable(false);   //makes it so the frame cannot be resized
        frame.setVisible(true);      //IMPORTANT!!!  if the frame is not set to visible it will not appear on the screen!

        // sets up things so the screen displays images nicely.
        canvas.createBufferStrategy(2);
        bufferStrategy = canvas.getBufferStrategy();
        canvas.requestFocus();
        System.out.println("DONE graphic setup");

    }
    public void pause(int time ){
        //sleep
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {

        }
    }

    public void run() {

        //for the moment we will loop things forever.
        while (true) {


            render();  // paint the graphics
            pause(20); // sleep for 20 ms
        }
    }
}