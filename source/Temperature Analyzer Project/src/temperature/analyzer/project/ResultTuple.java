/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package temperature.analyzer.project;

/** Java doesn't let you return by reference with a variable, thus this class is born.
 *
 * @author james
 */
public class ResultTuple {
    private double mean;
    private double sd;
    private int n;
    
    public ResultTuple(double mean, double sd, int n) {
        this.mean = mean;
        this.sd = sd;
        this.n = n;
    }
    
    public double mean() {
        return mean;
    }
    
    public double sd() {
        return sd;
    }
    
    public int n() {
        return n;
    }
}
