package com.jdbc.emp.dao;

import java.sql.SQLException;
import java.util.List;

import com.jdbc.emp.entity.Emp12;

public interface EmpDaoInterface {
	String addEmp(Emp12 emp) throws SQLException;
	String deleteEmp(Integer eno) throws SQLException;
	String updateEmp(Emp12 emp) throws SQLException;
	Emp12 findEmpbyID(Integer eno) throws SQLException;
	List<Emp12> findAllEmp() throws SQLException;
}
