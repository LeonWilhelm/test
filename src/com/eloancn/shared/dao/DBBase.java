package com.eloancn.shared.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.eloancn.shared.common.Base;
import com.eloancn.shared.common.DBData;

public class DBBase {
	
	Base base = new Base();
	//数据库驱动、访问地址、用户名、密码
	public String DRIVER = "";
	public static String URL    = "";
	public static String DBNAME = "";
	public static String DBPASS = "";
	
	public DBBase(){
		String properties = "db216.properties";
		if (base.indexURL.contains("inclient")) {
			properties = "db213.properties";
		}
		String curPath = new File("").getAbsolutePath();//当前路径
     	InputStream is = null;
		try {
			is = new FileInputStream(curPath+File.separator+properties);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		Properties property = new Properties();
		try {
			property.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
		DRIVER = property.getProperty("jdbc.driverClassName");
		URL = property.getProperty("jdbc.url");
		DBNAME = property.getProperty("jdbc.username");
		DBPASS = property.getProperty("jdbc.password");
	}
	
	
	/**
	 * 得到数据库连接
	 * @return 数据库连接对象
	 * @author 江渤洋 2015-4-24
	 */
	public Connection getConnection(String dbURL, String dbName, String dbPass){
		Connection connection = null;
		try {
			Class.forName(DRIVER);
			connection = DriverManager.getConnection(dbURL, dbName, dbPass);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e){
			e.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		}
		return connection;
	}
	
	/**
	 * 释放连接数据库资源
	 * @param connection 数据库连接
	 * @param statement
	 * @param resultSet 结果集
	 * @author 江渤洋 2015-4-24
	 */
	public static void closeAll(Connection connection, Statement statement, ResultSet resultSet){
		if((resultSet!=null)&&(statement!=null)&&(connection!=null)){
			try {
				resultSet.close();
				statement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 获取数据库某表全部列的名称
	 * @param tableName 表名
	 * @return 列名集合
	 * @author 江渤洋 2016-1-15
	 */
	public List<String> getColumnName(String tableName){
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<String> list = new ArrayList<String>();
		String sql = "SELECT * FROM " + tableName;
		try {
			connection = new DBData().getConnection(URL, DBNAME, DBPASS);
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery(sql);
			ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
			int size = resultSetMetaData.getColumnCount();
			for (int i = 1; i <= size; i++) {
				list.add(resultSetMetaData.getColumnName(i));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBData.closeAll(connection, preparedStatement, resultSet);
		}
		return list;
	}
	
	/**
	 * 获取数据库某表全部列的类型
	 * @param tableName
	 * @return 列的类型集合
	 * @author 江渤洋 2016-1-15
	 */
	public List<String> getColumnTypeName(String tableName){
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<String> list = new ArrayList<String>();
		String sql = "SELECT * FROM " + tableName;
		String temp = "";
		try {
			connection = new DBData().getConnection(URL, DBNAME, DBPASS);
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery(sql);
			ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
			int size = resultSetMetaData.getColumnCount();
			for (int i = 1; i <= size; i++) {
				temp = resultSetMetaData.getColumnTypeName(i).toLowerCase();
				if(temp.equals("varchar")){
					temp = "String";
				}
				else if(temp.equals("decimal")){
					temp = "BigDecimal";
				}
				list.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBData.closeAll(connection, preparedStatement, resultSet);
		}
		return list;
	}
	
	public static void main(String[] args){
		List<String> typeNameList = new ArrayList<String>();
		List<String> columnNameList = new ArrayList<String>();
		typeNameList = new DBBase().getColumnTypeName("d_wmps_record");
		columnNameList = new DBBase().getColumnName("d_wmps_record");
		System.out.println("表中列数有: " + typeNameList.size() + " 个");
		for(int i = 0; i < typeNameList.size(); i++){
			System.out.println("String " + columnNameList.get(i) + ";");
		}
	}
	
}
