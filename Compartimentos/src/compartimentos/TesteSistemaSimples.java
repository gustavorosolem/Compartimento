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
        double rk11, rk12, rk13, rk14;
        double rk21, rk22, rk23, rk24;
        double rk31, rk32, rk33, rk34;
        double x1 = 100, x2 = 0, x3 = 20;
        double k12 = 0.03;
        double k21 = 0.02;
        double k20 = 0.01;
        double k31 = 0.08;
        double auxa = 0, auxc = 0, erro;
        SistemaSimples ss = new SistemaSimples();
        try {
            FileWriter writer = new FileWriter("doa.txt");
            PrintWriter saida = new PrintWriter(writer);
            while (t < 4) {
                auxa = x2;
                auxc = x1;
                rk11 = h * ss.kUm1(x1, x2, x3, k12, k21, k31);
                rk12 = h * ss.kDois1(x1, x2, x3, k12, k21, k31, rk11);
                rk13 = h * ss.kTres1(x1, x2, x3, k12, k21, k31, rk12);
                rk14 = h * ss.kQuatro1(x1, x2, x3, k12, k21, k31, rk13);
                rk21 = h * ss.kUm2(x1, x2, k12, k21, k20);
                rk22 = h * ss.kDois2(x1, x2, k12, k21, k20, rk21);
                rk23 = h * ss.kTres2(x1, x2, k12, k21, k20, rk22);
                rk24 = h * ss.kQuatro2(x1, x2, k12, k21, k20, rk23);
                rk31 = h * ss.kUm3(x3, k31);
                rk32 = h * ss.kDois3(x3, k31, rk31);
                rk33 = h * ss.kTres3(x3, k31, rk32);
                rk34 = h * ss.kQuatro3(x3, k31, rk33);
                System.out.println(t + "\t" + x1 + "\t" + x2 + "\t" + x3);
                saida.println(t + "\t" + x1 + "\t" + x2 + "\t" + x3);
                x1 = x1 + (rk11 + 2 * rk12 + 2 * rk13 + rk14) / 6;
                x2 = x2 + (rk21 + 2 * rk22 + 2 * rk23 + rk24) / 6;
                x3 = x3 + (rk31 + 2 * rk32 + 2 * rk33 + rk34) / 6;
                erro = (x2 - auxa) / auxa + (x1 - auxc) / auxc;
                t = t + h;
            }
        } catch(IOException e){
            JOptionPane.showMessageDialog(null, "O arquivo destino esta aberto!");
        }
    }
}