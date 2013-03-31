package compartimentos;
import javax.swing.JOptionPane;
import java.io.*;

public class Compartimentos {
    public static void main(String args[]) {
        double h = Double.valueOf(JOptionPane.showInputDialog(null,"Digite o passo"));
        int tam = Integer.valueOf(JOptionPane.showInputDialog(null,"Digite o numero linhas"));
        double x[] = new double[tam+1];
        double y[] = new double[tam+1];
        double yexato[] = new double[tam+1];
        double erro[] = new double[tam+1];
        x[0] = 0;
        y[0] = 1;
        try {
            FileWriter writer = new FileWriter("resultado.txt");
            PrintWriter saida = new PrintWriter(writer);
            for (int l=1; l <= tam+1; l++) {
                x[l-1] = x[0] + (l - 1) * h;
            }
            for (int l=1; l <= tam; l++) {
                y[l] = y[l-1] + h * (-x[l-1]) * y[l-1];
                yexato[l] = (double)Math.exp(-x[l]*x[l]/2);
                erro[l] = (y[l] - yexato[l])*100/yexato[l];
            }
            for (int l=0; l <= tam; l++) {
                saida.println(//"L = " + l + 
                x[l] + 
                "\t" + y[l] + 
                //"\t" + (-(x[l]*y[l])) + 
                "\t" + (double)Math.exp(-x[l]*x[l]/2)// + 
                //"\tErro = " + erro[l]
                );
            }// 0.1 = 0.5 = 1
            //runge kutta 4
            saida.close();  
            writer.close();
        } catch(IOException e){
            //e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Resultado Invalido!");
        }
    }
}