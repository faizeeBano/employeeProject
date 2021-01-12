/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empMgmtApp.pojo;

/**
 *
 * @author asus
 */
public class EmpPojo {
    private int empNo;
    private String name;
    private double Sal;

    public EmpPojo(int empNo, String name, double Sal) {
        this.empNo = empNo;
        this.name = name;
        this.Sal = Sal;
    }
    public EmpPojo(){
        
    }

    public int getEmpNo() {
        return empNo;
    }

    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSal() {
        return Sal;
    }

    public void setSal(double Sal) {
        this.Sal = Sal;
    }
    
    
    
}
