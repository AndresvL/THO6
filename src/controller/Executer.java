package controller;

import model.Businessrule;

public class Executer {
	
	public Executer(){}
	private Businessrule businessrule = new Businessrule();
	
	public void executeStatement(String database, String sqlStatement, String type){
		businessrule.executeStatement(database,sqlStatement,type);
	}
}
