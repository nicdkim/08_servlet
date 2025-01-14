package com.ohgiraffers.mvc.employee.model.dao;

import com.ohgiraffers.mvc.common.config.ConfigLocation;
import com.ohgiraffers.mvc.employee.model.dto.EmployeeDTO;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static com.ohgiraffers.mvc.common.jdbc.JDBCTemplate.close;

public class EmployeeDAO {

    private final Properties prop;

    public EmployeeDAO() {
        prop = new Properties();

        try {
            prop.loadFromXML(new FileInputStream(ConfigLocation.MAPPER_LOCATION + "employee-mapper.xml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public EmployeeDTO selectEmpById(Connection con, String empId) {

        PreparedStatement pstmt = null;
        ResultSet rset = null;

        EmployeeDTO selectEmp = null;

        String query = prop.getProperty("selectEmpById");

        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, empId);

            rset = pstmt.executeQuery();

            if (rset.next()) {
                selectEmp = new EmployeeDTO();

                selectEmp.setEmpId(rset.getInt("EMP_ID"));
                selectEmp.setEmpName(rset.getString("EMP_NAME"));
                selectEmp.setDeptCode(rset.getString("DEPT_CODE"));
                selectEmp.setJobCode(rset.getString("JOB_CODE"));
                selectEmp.setSalary(rset.getInt("SALARY"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(rset);
            close(pstmt);
        }

        return selectEmp;
    }

    public List<EmployeeDTO> selectAllQNEmployees(Connection con) {

        PreparedStatement pstmt = null;
        ResultSet rset = null;
        List<EmployeeDTO> empList = new ArrayList<>();

        String query =  prop.getProperty("selectEmpList");

        try {
            pstmt = con.prepareStatement(query);
            rset = pstmt.executeQuery();

            while (rset.next()) {
                EmployeeDTO emp = new EmployeeDTO();

                emp.setEmpId(rset.getInt("EMP_ID"));
                emp.setEmpName(rset.getString("EMP_NAME"));
                emp.setEmpNo(rset.getString("EMP_NO"));
                emp.setEmail(rset.getString("EMAIL"));
                emp.setPhone(rset.getString("PHONE"));
                emp.setDeptCode(rset.getString("DEPT_CODE"));
                emp.setJobCode(rset.getString("JOB_CODE"));
                emp.setSalLevel(rset.getString("SAL_LEVEL"));
                emp.setSalary(rset.getInt("SALARY"));
                emp.setBonus(rset.getDouble("BONUS"));
                emp.setManagerId(rset.getString("MANAGER_ID"));
                emp.setHireDate(rset.getDate("HIRE_DATE"));
                emp.setEntDate(rset.getDate("ENT_DATE"));
                emp.setEntYn(rset.getString("ENT_YN"));
                empList.add(emp);
            }

        } catch (SQLException e) {
            throw new RuntimeException("직원 정보 조회 중 오류 발생", e);
        } finally {
            close(rset);
            close(pstmt);
        }

        return empList;
    }

    public int selectNewEmpId(Connection con) {

        PreparedStatement pstmt = null;
        ResultSet rset = null;

        int newEmpId = 0;

        String query = prop.getProperty("selectNewEmpId");

        try {
            pstmt = con.prepareStatement(query);
            rset = pstmt.executeQuery();

            if(rset.next()) {
                newEmpId = rset.getInt("EMP_ID");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(rset);
            close(pstmt);
        }

        return newEmpId;
    }

    public int insertEmp(Connection con, EmployeeDTO emp) {

        PreparedStatement pstmt = null;
        int result = 0;

        String query = prop.getProperty("insertEmp");

        try {
            pstmt = con.prepareStatement(query);
            pstmt.setInt(1, emp.getEmpId());
            pstmt.setString(2, emp.getEmpName());
            pstmt.setString(3, emp.getEmpNo());
            pstmt.setString(4, emp.getEmail());
            pstmt.setString(5, emp.getPhone());
            pstmt.setString(6, emp.getDeptCode());
            pstmt.setString(7, emp.getJobCode());
            pstmt.setString(8, emp.getSalLevel());
            pstmt.setInt(9, emp.getSalary());
            pstmt.setDouble(10, emp.getBonus());
            pstmt.setString(11, emp.getManagerId());
            pstmt.setDate(12, emp.getHireDate());

            result = pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(pstmt);
        }
        return result;
    }

    public int updateEmp(Connection con, int empId, Date entDate) {

        PreparedStatement pstmt = null;
        int result = 0;

        String query = prop.getProperty("updateEmp");

        try {
            pstmt = con.prepareStatement(query);

            System.out.println("DAO empId: " + empId);
            System.out.println("DAO entDate: " + entDate);

            pstmt.setDate(1, entDate);
            pstmt.setInt(2, empId);

            result = pstmt.executeUpdate();
            System.out.println("Update result: " + result);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(pstmt);
        }
        return result;
    }

    public int deleteEmployee(Connection con, int empId) {

        PreparedStatement pstmt = null;
        int result = 0;

        String query = prop.getProperty("deleteEmp");

        try {
            pstmt = con.prepareStatement(query);
            pstmt.setInt(1, empId);

            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(pstmt);
        }

        return result;
    }

}
