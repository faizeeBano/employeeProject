/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empMgmtApp.dao;

import empMgmtApp.dbutil.DBConnection;
import empMgmtApp.pojo.EmpPojo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author asus
 */
public class EmpDAO {
    public static boolean addEmp(EmpPojo obj) throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("Insert into emp values(?,?,?)");
        ps.setInt(1,obj.getEmpNo());
        ps.setString(2, obj.getName());
        ps.setDouble(3,obj.getSal());
        int count=ps.executeUpdate();
        return (count==1);
        
    }
    public static ArrayList<EmpPojo> getAllEmp()throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery("Select * from emp");
        ArrayList<EmpPojo> empList=new ArrayList<>();
        while(rs.next())
        {
            int eno=rs.getInt(1);
            String ename=rs.getString(2);
            double sal=rs.getDouble(3);
            EmpPojo obj=new EmpPojo(eno,ename,sal);
            empList.add(obj);
        }
        return empList;
    }
    public static EmpPojo findEmpById(int eno) throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("Select * from emp where eno=?");
        ps.setInt(1,eno);
        ResultSet rs=ps.executeQuery();
        EmpPojo e=null;
        if(rs.next())
        {
            e =new EmpPojo();
            e.setName(rs.getString(2));
            e.setSal(rs.getDouble(3));
            e.setEmpNo(eno);
        }
        return e;
    }
    public static boolean updateEmp(EmpPojo obj) throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("Update emp set Ename=?,sal=? where eno=?");
        ps.setString(1, obj.getName());
        ps.setDouble(2,obj.getSal());
        ps.setInt(3,obj.getEmpNo());
        int count=ps.executeUpdate();
        if(count>0)
                    return true;
        else
                    return false;

    }

    public static boolean deleteEmp(int eno) throws SQLException{
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("Delete from emp where eno=?");
        ps.setInt(1,eno);
        int count=ps.executeUpdate();
        if(count>0)
                    return true;
        else
                    return false;

            
    }

    
}
