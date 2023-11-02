package com.jdbc.emp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jdbc.emp.entity.Emp12;

public class EmpDao implements EmpDaoInterface{
	Connection connection;
	PreparedStatement pstatement;
	String sql;
	ResultSet resultSet;
	
	public EmpDao() {
		connection=MyConnection.getMyConnection();
	}
	
	public String addEmp(Emp12 emp) throws SQLException{
		sql="insert into emp12 values(?, ?, ?, ?)";
		pstatement=connection.prepareStatement(sql);
		pstatement.setInt(1, emp.getEno());
		pstatement.setString(2, emp.getEname());
		pstatement.setInt(3, emp.getSalary());
		pstatement.setString(4, emp.getDept());
		pstatement.executeUpdate();
		return "Record Added Successfully....";
	}
	
	public String deleteEmp(Integer eno) throws SQLException{
		sql="delete from emp12 where eno=?";
		pstatement=connection.prepareStatement(sql);
		pstatement.setInt(1, eno);
		if(pstatement.executeUpdate()>0) {
			return "Details Deleted....";
		}
		else {
			return "No Such Details Found....";
		}
	}
	
	public String updateEmp(Emp12 emp) throws SQLException{
		sql="update emp12 set salary=? where eno=?";
		pstatement=connection.prepareStatement(sql);
		pstatement.setInt(1, emp.getSalary());
		pstatement.setInt(2, emp.getEno());
		if(pstatement.executeUpdate()>0) {
			return "Details Updated....";
		}
		else {
			return "Details Not Found....";
		}
	}
	
	public Emp12 findEmpbyID(Integer eno) throws SQLException{
		sql="select * from emp12 where eno=?";
		pstatement=connection.prepareStatement(sql);
		pstatement.setInt(1, eno);
		resultSet=pstatement.executeQuery();
		Emp12 emp=null;
		if(resultSet.next()) {
			emp=new Emp12();
			emp.setEno(resultSet.getInt(1));
			emp.setEname(resultSet.getString(2));
			emp.setSalary(resultSet.getInt(3));
			emp.setDept(resultSet.getString(4));
		}
		return emp;
	}
	
	public List<Emp12> findAllEmp() throws SQLException{
		sql="select * from emp12";
		pstatement=connection.prepareStatement(sql);
		resultSet=pstatement.executeQuery();
		Emp12 emp=null;
		List<Emp12> list=new ArrayList<Emp12>();
		while(resultSet.next()) {
			emp=new Emp12();
			emp.setEno(resultSet.getInt(1));
			emp.setEname(resultSet.getString(2));
			emp.setSalary(resultSet.getInt(3));
			emp.setDept(resultSet.getString(4));
			list.add(emp);
		}
		return list;
	}
}
