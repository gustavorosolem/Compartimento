/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compartimentos;

import java.io.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Treewy-Netbook
 */
public class TesteSistemaSimples {

    public static void main(String args[]) {
        double h = 0.01, t = 0.1;
        double k11 = 0, k12 = 0, k13 = 0, k14 = 0;
        double k21 = 0, k22 = 0, k23 = 0, k24 = 0;
        double x1 = 0, x2 = 0;
        double auxa = 0, auxc = 0, erro;
        SistemaSimples ss = new SistemaSimples();
        try {
            FileWriter writer = new FileWriter("doa.txt");
            PrintWriter saida = new PrintWriter(writer);
            while (t < 4) {
                auxa = x2;
                auxc = x1;
                k11 = h * ss.kUm1(t, x1, x2);
                k21 = h * ss.kUm2(t, x1, x2);
                k12 = h * ss.kDois1(t, x1, x2, k11, h);
                k22 = h * ss.kDois2(t, x1, x2, k21, h);
                k13 = h * ss.kTres1(t, x1, x2, k12, h);
                k23 = h * ss.kTres2(t, x1, x2, k22, h);
                k14 = h * ss.kQuatro1(t, x1, x2, k13, h);
                k24 = h * ss.kQuatro2(t, x1, x2, k23, h);
                saida.println(t + "\t" + x1 + "\t" + x2);
                x1 = x1 + (k11 + 2 * k12 + 2 * k13 + k14) / 6;
                x2 = x2 + (k21 + 2 * k22 + 2 * k23 + k24) / 6;
                erro = (x2 - auxa) / auxa + (x1 - auxc) / auxc;
                t = t + h;
            }
        } catch(IOException e){
            JOptionPane.showMessageDialog(null, "O arquivo destino esta aberto!");
        }
    }
}