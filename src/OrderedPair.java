import java.awt.*;

public class OrderedPair {
    public double x;
    public double y,yf;
    public Color myColor;

    public OrderedPair(double a,double b){
         x=a;
         y=b;
         yf= 700-y;
    }
    public OrderedPair(int a, int b){
        x= a;
        y=b;
    }

    public void printinfo(){
        System.out.println("("+x+" , "+y+")");
    }
}
