package service;


import controller.Executer;

public class ExecuteService {

	public void executeStatement(String database, String sqlStatement, String type) {
		Executer executer = new Executer();
		executer.executeStatement(database,sqlStatement,type);
	}
}
