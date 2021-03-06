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
    public static void fehlberg() {
        /*double a = 0;//Double.valueOf(JOptionPane.showInputDialog(null,"Digite o 'a'"));
        double b = 100;//Double.valueOf(JOptionPane.showInputDialog(null,"Digite o 'b'"));
        double alfa = 1000;//Double.valueOf(JOptionPane.showInputDialog(null,"Digite o 'alfa'"));
        double hmax = 1.f;//Double.valueOf(JOptionPane.showInputDialog(null,"Digite o 'hmax'"));
        double hmin = 0.000001f;//Double.valueOf(JOptionPane.showInputDialog(null,"Digite o 'hmin'"));
        double TOL = 0.0001f;//Double.valueOf(JOptionPane.showInputDialog(null,"Digite o 'TOL'"));
        double t = a;
        double w = alfa;
        double h = hmax;
        int FLAG = 1;
        double k1, k2, k3, k4, k5, k6;
        double R;
        double waux = w;
        try {
            FileWriter writer = new FileWriter("fehlberg.txt");
            PrintWriter saida = new PrintWriter(writer);
            saida.println("t\t w\t h\t k1\t k2\t k3\t k4\t k5\t k6\t Erro\t dw/dt");
            while(FLAG == 1) {
                k1 = - h * (t * w);
                k2 = - h * (t + (h/4)) * (w + (k1/4));
                k3 = - h * (t + (3/8*h)) * (w + (3/32*k1) + (9/32*k2));
                k4 = - h * (t + (12/13*h)) * (w + (1932/2197*k1) - (7200/2197*k2) + (7296/2197*k3));
                k5 = - h * (t + h) * (w + (439/216*k1) - 8*k2 + (3680/513*k3) - (845/4104*k4));
                k6 = - h * (t + (h/2)) * (w - (8/27*k1) + 2*k2 - (3544/2565*k3) + (1859/4104*k4) - (11/40*k5));
                R = 1/h * Math.abs((1/360*k1) - (128/4275*k3) - (2197/75240*k4) + (1/50*k5) + (2/55*k6));
                if (R <= TOL) {
                    t = t + h;
                    waux = w;
                    w = w + 25*k1/216 + 1408*k3/2565 + 2197*k4/4104 - 1*k5/5;
                    System.out.println(w);
                    saida.println(t + "\t" + w + "\t" + h + "\t" + k1 + "\t" + k2 + "\t" + k3 + "\t" + k4 + "\t" + k5 + "\t" + k6 + "\t" + (w-waux) + "\t" + 3*Math.pow(w,2) + w);
                }
                double delta = 0.84 * Math.pow(TOL/R, 1/4);
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
            saida.close();  
            writer.close();
        } catch(IOException e){
            JOptionPane.showMessageDialog(null, "O arquivo destino esta aberto!");
        }*/
        double t = 0;
        double a = 0;
        double b = 4000;
        double W = 1000;//condição inicial
        double hMax = 1.f;
        double hMin = 0.000000000001f;
        double h = hMax;
        double K1 = 0, K2 = 0, K3 = 0, K4 = 0, K5 = 0, K6 = 0;
        double R = 0;
        double TOL = 0.0001f;//tolerância no erro
        double delta = 0;
        double Wa = 0;
        double erro = 0;
        int FLAG = 1;
        try {
            FileWriter writer = new FileWriter("fehlberg.txt");
            PrintWriter saida = new PrintWriter(writer);
            while (FLAG == 1) {
                K1 = h * (3.0f *W*W + W);
                K2 = h * (3.0f *(W + K1 / 4)*(W + K1 / 4)+(W + K1 / 4));
                K3 = h * (3.0f *(W + 3 * K1 / 32 + 9 * K2 / 32)*(W + 3 * K1 / 32 + 9 * K2 / 32)+(W + 3 * K1 / 32 + 9 * K2 / 32));
                K4 = h * (3.0f *(W + 1932 * K1 / 2197 - 7200 * K2 / 2197 + 7296 * K3 / 2197)*(W + 1932 * K1 / 2197 - 7200 * K2 / 2197 + 7296 * K3 / 2197)+(W + 1932 * K1 / 2197 - 7200 * K2 / 2197 + 7296 * K3 / 2197));
                K5 = h * (3.0f *(W + 439 * K1 / 216 - 8 * K2 + 3680 * K3 / 513 - 845 * K4 / 4104)*(W + 439 * K1 / 216 - 8 * K2 + 3680 * K3 / 513 - 845 * K4 / 4104)+(W + 439 * K1 / 216 - 8 * K2 + 3680 * K3 / 513 - 845 * K4 / 4104));
                K6 = h * (3.0f *(W - 8 * K1 / 27 + 2 * K2 - 3544 * K3 / 2565 + 1859 * K4 / 4104 - 11 * K5 / 40)*(W - 8 * K1 / 27 + 2 * K2 - 3544 * K3 / 2565 + 1859 * K4 / 4104 - 11 * K5 / 40)+(W - 8 * K1 / 27 + 2 * K2 - 3544 * K3 / 2565 + 1859 * K4 / 4104 - 11 * K5 / 40));
                R = Math.abs(K1 / 360 - 128 * K3 / 4275 - 2197 * K4 / 75240 + K5 / 50 + 2 * K6 / 55) / h;
                if (R < TOL) {
                    Wa=W;
                    t = t + h;
                    W = W + 25 * K1 / 216 + 1408 * K3 / 2565 + 2197 * K4 / 4104 - K5 / 5;
                    erro = (W-Wa)*100f/Wa;
                    saida.println(t + "\t" + W + "\t" + h+"\t"+Wa+"\t"+erro);
                }
                delta = 0.84 * Math.pow(TOL / R, 0.25);
                if (delta <= 0.1) {
                    h = 0.1f * h;
                } else if (delta > 4) {
                    h = 4 * h;
                } else {
                    h = delta * h;
                }
                if (h > hMax) {
                    h = hMax;
                }
                if (t >= b) {
                    FLAG = 0;
                } else if ((t + h) > b) {
                    h = b - t;
                } else if (h < hMin) {
                    FLAG = 0;
                    System.out.println("Terminado sem sucesso!");
                }
            }//fim while
            saida.close();  
            writer.close();
        } catch(IOException e){
            JOptionPane.showMessageDialog(null, "O arquivo destino esta aberto!");
        }
    }
    
    /*public static void main(String args[]) {
        /*double h = Double.valueOf(JOptionPane.showInputDialog(null,"Digite o passo"));
        int tam = Integer.valueOf(JOptionPane.showInputDialog(null,"Digite o numero linhas"));
        double x[] = new double[tam+1];
        double y[] = new double[tam+1];
        x[0] = 0;
        y[0] = 1;
        euler(h, tam, x, y);
        rungeKuttaQuatro(h, tam, x, y);
        //fehlberg();
    }*/
}