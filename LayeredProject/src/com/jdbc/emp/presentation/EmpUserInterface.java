package com.jdbc.emp.presentation;

import java.sql.SQLException;

public interface EmpUserInterface {
	void inputAddEmp() throws SQLException;
	void inputDeleteEmp() throws SQLException;
	void inputUpdateEmp() throws SQLException;
	void inputFindEmpbyID() throws SQLException;
	void inputFindAllEmp() throws SQLException;
}
