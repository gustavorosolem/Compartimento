/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compartimentos;

/**
 *
 * @author Treewy-Netbook
 */
public class SistemaSimples {

    public double kUm1(double x1, double x2, double x3, double k12, double k21, double k31) {
        return k31 * x3 + k21 * x2 - k12 * x1;
    }

    public double kDois1(double x1, double x2, double x3, double k12, double k21, double k31, double rk1) {
        return k31 * (x3 + rk1) + k21 * (x2 + rk1) - k12 * (x1 + rk1);
    }

    public double kTres1(double x1, double x2, double x3, double k12, double k21, double k31, double rk2) {
        return k31 * (x3 + rk2) + k21 * (x2 + rk2) - k12 * (x1 + rk2);
    }

    public double kQuatro1(double x1, double x2, double x3, double k12, double k21, double k31, double rk3) {
        return k31 * (x3 + rk3) + k21 * (x2 + rk3) - k12 * (x1 + rk3);
    }

    public double kUm2(double x1, double x2, double k12, double k21, double k20) {
        return k12 * x1 -(k21 + k20) * x2;
    }

    public double kDois2(double x1, double x2, double k12, double k21, double k20, double rk1) {
        return k12 * (x1 + rk1) -(k21 + k20) * (x2 + rk1);
    }

    public double kTres2(double x1, double x2, double k12, double k21, double k20, double rk2) {
        return k12 * (x1 + rk2) -(k21 + k20) * (x2 + rk2);
    }

    public double kQuatro2(double x1, double x2, double k12, double k21, double k20, double rk3) {
        return k12 * (x1 + rk3) -(k21 + k20) * (x2 + rk3);
    }
    
    public double kUm3(double x3, double k31) {
        return -k31 * x3;
    }

    public double kDois3(double x3, double k31, double rk1) {
        return -k31 * (x3 + rk1);
    }

    public double kTres3(double x3, double k31, double rk2) {
        return -k31 * (x3 + rk2);
    }

    public double kQuatro3(double x3, double k31, double rk3) {
        return -k31 * (x3 + rk3);
    }
    
}