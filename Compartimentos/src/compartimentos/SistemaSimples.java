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

    public double kUm1(double x1, double x2, double k12, double k21) {
        return k21 * x2 - k12 * x1;
    }

    public double kDois1(double x1, double x2, double k12, double k21, double k1) {
        return k21 * (x2 + k1) - k12 * (x1 + k1);
    }

    public double kTres1(double x1, double x2, double k12, double k21, double k2) {
        return k21 * (x2 + k2) - k12 * (x1 + k2);
    }

    public double kQuatro1(double x1, double x2, double k12, double k21, double k3) {
        return k21 * (x2 + k3) - k12 * (x1 + k3);
    }

    public double kUm2(double x1, double x2, double k12, double k21, double k20) {
        return k12 * x1 -(k21 + k20) * x2;
    }

    public double kDois2(double x1, double x2, double k12, double k21, double k20, double k1) {
        return k12 * (x1 + k1) -(k21 + k20) * (x2 + k1);
    }

    public double kTres2(double x1, double x2, double k12, double k21, double k20, double k2) {
        return k12 * (x1 + k2) -(k21 + k20) * (x2 + k2);
    }

    public double kQuatro2(double x1, double x2, double k12, double k21, double k20, double k3) {
        return k12 * (x1 + k3) -(k21 + k20) * (x2 + k3);
    }
}