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