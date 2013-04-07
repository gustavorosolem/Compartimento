package compartimentos;
import javax.swing.JOptionPane;
import java.io.*;

public class Compartimentos {
    
    //Euler
    public static void euler(double h, int tam, double x[], double y[]) {
        try {
            FileWriter writer = new FileWriter("euler.txt");
            PrintWriter saida = new PrintWriter(writer);
            for (int l=1; l <= tam+1; l++) {
                x[l-1] = x[0] + (l - 1) * h;
            }
            for (int l=1; l <= tam; l++) {
                y[l] = y[l-1] + h * (-x[l-1]) * y[l-1];
                //yexato[l] = (double)Math.exp(-x[l]*x[l]/2);
                //erro[l] = (y[l] - yexato[l])*100/yexato[l];
            }
            for (int l=0; l <= tam; l++) {
                saida.println(
                    x[l] + 
                    "\t" + y[l] + 
                    "\t" + (double)Math.exp(-x[l]*x[l]/2)
                );
            }
            saida.close();  
            writer.close();
        } catch(IOException e){
            JOptionPane.showMessageDialog(null, "O arquivo destino esta aberto!");
        }
    }
    
    //Runge Kutta de ordem 4
    public static void rungeKuttaQuatro(double h, int tam, double x[], double y[]) {
        double k1[] = new double[tam+1];
        double k2[] = new double[tam+1];
        double k3[] = new double[tam+1];
        double k4[] = new double[tam+1];
        try {
            FileWriter writer = new FileWriter("rungekutta.txt");
            PrintWriter saida = new PrintWriter(writer);
            for (int l=1; l <= tam+1; l++) {
                x[l-1] = x[0] + (l - 1) * h;
            }
            for (int l=1; l <= tam; l++) {
                y[l] = y[l-1] + h * (-x[l-1]) * y[l-1];
            }
            saida.println("L\tX\tY\tK1\tK2\tK3\tK4\tYexato\tErro");
            for (int l=0; l <= tam; l++) {
                k1[l] = -x[l] * y[l];
                k2[l] = -(x[l] + h/2)*(y[l] + h/2 * k1[l]);
                k3[l] = -(x[l] + h/2)*(y[l] + h/2 * k2[l]);
                k4[l] = -(x[l] + h)*(y[l] + h * k3[l]);
                saida.println(
                    l + 
                    "\t" + x[l] + 
                    "\t" + y[l] + 
                    "\t" + k1[l] + 
                    "\t" + k2[l] + 
                    "\t" + k3[l] + 
                    "\t" + k4[l] + 
                    //"\t" + ((double)y[l] + h/6 * (k1[l] + k2[l] + k3[l] + k4[l]))
                    "\t" + (double)Math.exp(-x[l]*x[l]/2) +
                    "\t" + (double)((y[l] - (Math.exp(-x[l]*x[l]/2)))*100/(Math.exp(-x[l]*x[l]/2)))
                );
            }
            saida.close();  
            writer.close();
        } catch(IOException e){
            JOptionPane.showMessageDialog(null, "O arquivo destino esta aberto!");
        }
    }
    
    //Runge Kutta Fehlberg
    public static void fehlberg(double h, int tam, double x[], double y[]) {
        double a;
        double b;
        double alfa;
        double hmax;
        double hmin;
        double TOL;
        double delta;
        double t = a;
        double w = alfa;
        h = hmax;
        int FLAG = 0;
        double k1, k2, k3, k4, k5, k6;
        double R;
        while(FLAG == 1) {
            k1 = h f (t, w);
            k2 = h f (t + (1/4*h), w + (1/4*k1));
            k3 = h f (t + (3/8*h), w + (3/32*k1) + (9/32*k2));
            k4 = h f (t + (12/13*h), w + (1932/2197*k1) - (7200/2197*k2) + (7296/2197*k3));
            k5 = h f (t + h, w + (439/216*k1) - 8*k2 + (3680/513*k3) - (845/4104*k4));
            k6 = h f (t + (1/2*h), w - (8/27*k1) + 2*k2 - (3544/2565*k3) + (1859/4104*k4) - (11/40*k5));
            R = 1/h | (1/360*k1) - (128/4275*k3) - (2197/75240*k4) + (1/50*k5) + (2/55*k6) |;
            if (R <= TOL) {
                t = t + h;
                w = w + (25/216*k1) + (1408/2565*k3) + (2197/4104*k4) - (1/5*k5)
                System.out.println(t, w, h);
            }
            delta = 0.84 * Math.pow(TOL/R, 1/4);
            if (delta <= 0.1) {
                h = 0.1 * h;
            } else if (delta >= 4) {
                h = 4 * h;
            } else {
                h = 8 * h;
            }
            if (h > hmax) {
                h = hmax;
            }
            if (t >= b) {
                FLAG = 0;
            } else if (t+h > b) {
                h = b - t;
            } else if (h < hmin) {
                FLAG = 0;
                System.out.println("minimum h exceeded");
            }
            
            
        }
        
        
        try {
            FileWriter writer = new FileWriter("rungekutta.txt");
            PrintWriter saida = new PrintWriter(writer);
            /////////////////
            saida.close();  
            writer.close();
        } catch(IOException e){
            JOptionPane.showMessageDialog(null, "O arquivo destino esta aberto!");
        }
    }
    
    public static void main(String args[]) {
        double h = Double.valueOf(JOptionPane.showInputDialog(null,"Digite o passo"));
        int tam = Integer.valueOf(JOptionPane.showInputDialog(null,"Digite o numero linhas"));
        double x[] = new double[tam+1];
        double y[] = new double[tam+1];
        //double yexato[] = new double[tam+1];
        //double erro[] = new double[tam+1];
        x[0] = 0;
        y[0] = 1;
        euler(h, tam, x, y);
        rungeKuttaQuatro(h, tam, x, y);
    }
}