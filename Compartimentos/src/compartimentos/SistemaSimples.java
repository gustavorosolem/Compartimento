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

    /*
    public double kUm1(double t, double c, double a) {
        return c / (Math.exp(t) - 1) + 2 * Math.sin(t) * a / (Math.cos(t) * (1 + Math.exp(-t)));
    }

    public double kDois1(double t, double c, double a, double k1, double h) {
        return (c + k1 / 2) / (Math.exp(t + h / 2) - 1) + 2 * Math.sin(t + h / 2) * (a + k1 / 2) / (Math.cos(t + h / 2) * (1 + Math.exp(-(t + h / 2))));
    }

    public double kTres1(double t, double c, double a, double k2, double h) {
        return (c + k2 / 2) / (Math.exp(t + h / 2) - 1) + 2 * Math.sin(t + h / 2) * (a + k2 / 2) / (Math.cos(t + h / 2) * (1 + Math.exp(-(t + h / 2))));
    }

    public double kQuatro1(double t, double c, double a, double k3, double h) {
        return (c + k3) / (Math.exp(t + h / 2) - 1) + 2 * Math.sin(t + h / 2) * (a + k3) / (Math.cos(t + h / 2) * (1 + Math.exp(-(t + h / 2))));
    }

    public double kUm2(double t, double c, double a) {
        return 2 * a / (Math.exp(2 * t) - 1) - 2 * (1 + Math.exp(-t)) * Math.cos(t) * c / Math.sin(t);
    }

    public double kDois2(double t, double c, double a, double k1, double h) {
        return 2 * (a + k1 / 2) / (Math.exp(2 * (t + h / 2)) - 1) - 2 * (1 + Math.exp(-(t + h / 2))) * Math.cos(t + h / 2) * (c + k1 / 2) / Math.sin(t + h / 2);
    }

    public double kTres2(double t, double c, double a, double k2, double h) {
        return 2 * (a + k2 / 2) / (Math.exp(2 * (t + h / 2)) - 1) - 2 * (1 + Math.exp(-(t + h / 2))) * Math.cos(t + h / 2) * (c + k2 / 2) / Math.sin(t + h / 2);
    }

    public double kQuatro2(double t, double c, double a, double k3, double h) {
        return 2 * (a + k3) / (Math.exp(2 * (t + h / 2)) - 1) - 2 * (1 + Math.exp(-(t + h / 2))) * Math.cos(t + h / 2) * (c + k3) / Math.sin(t + h / 2);
    }*/
    public double kUm1(double t, double x1, double x2) {
        return x1 + x2;
    }

    public double kDois1(double t, double x1, double x2, double k1, double h) {
        return (x1 + k1) + (x2 + k1);
    }

    public double kTres1(double t, double x1, double x2, double k2, double h) {
        return (x1 + k2) + (x2 + k2);
    }

    public double kQuatro1(double t, double x1, double x2, double k3, double h) {
        return (x1 + k3) + (x2 + k3);
    }

    public double kUm2(double t, double x1, double x2) {
        return -x1 + x2;
    }

    public double kDois2(double t, double x1, double x2, double k1, double h) {
        return (-x1 + k1) + (x2 + k1);
    }

    public double kTres2(double t, double x1, double x2, double k2, double h) {
        return (-x1 + k2) + (x2 + k2);
    }

    public double kQuatro2(double t, double x1, double x2, double k3, double h) {
        return (-x1 + k3) + (x2 + k3);
    }
}