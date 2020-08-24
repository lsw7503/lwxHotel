package com.lwx.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DBHelper {
	
	private String url = "jdbc:oracle:thin:@lockhost:1521:orcl";
	private String dbname = "scott";
	private String dbpwd = "a";
	
	//加载驱动
	static{
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	//连接数据库
	private Connection getConnection(){
		Connection conn = null;
		
		try {
			conn = DriverManager.getConnection(url,dbname,dbpwd);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
	}

	//关闭所有
	private void closeAll(ResultSet rs, PreparedStatement pstmt, Connection conn){
		try {
			if( rs!= null){
				rs.close();
			}
			if(pstmt != null){
				pstmt.close();
			}
			if(conn != null){
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	//设置参数
	private void setParams(PreparedStatement pstmt, Object... params){
		//如果没有占位符
		if(params == null || params.length == 0){
			return;
		}
		
		//设置占位符
		for(int i =0 ; i<params.length; i++){
			try {
				pstmt.setObject(i+1, params[i]);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public int doUpdate(String sql, Object...params){
		//首先建立连接
		Connection conn = getConnection();
		//创建一个返回结果  默认为失败
		int result = -1;
		
		try {
			//预处理对象
			PreparedStatement pstmt = conn.prepareStatement(sql);
			//处理占位符
			setParams(pstmt, params);
			//执行sql语句
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//返回结果
		return result;
	}
	
	//查询
	public List<Map<String, String>> queryAll(String sql, Object... params){
		List<Map<String, String>> list = new ArrayList<>();
		
		try {
			//建立连接
			Connection conn = this.getConnection();
			//创建预处理对象
			PreparedStatement pstmt = conn.prepareStatement(sql);
			//设置占位符
			setParams(pstmt, params);
			//获得结果集
			ResultSet rs = pstmt.executeQuery();
			//得到列名
			ResultSetMetaData rsmd = rs.getMetaData();
			String[] colunmNames = new String[rsmd.getColumnCount()];
			
			//循环	得到列名
			for(int i = 0; i<colunmNames.length; i++){
				colunmNames[i] = rsmd.getColumnName(i+1).toLowerCase();//小写化
			}
			
			//循环取键值
			while(rs.next()){
				Map<String, String> map = new HashMap<String, String>();
				
				for(String colunmName : colunmNames){
					String value = rs.getString(colunmName);
					map.put(colunmName, value);
				}
				list.add(map);
			}
			
			closeAll(rs,pstmt,conn);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	//单条查询
	public Map<String, String> querySingle(String sql, Object... params){
		Map<String, String> map = null;
		
		try {
			//建立连接
			Connection conn = this.getConnection();
			//创建预处理对象
			PreparedStatement pstmt = conn.prepareStatement(sql);
			//设置占位符
			setParams(pstmt, params);
			//获得结果集
			ResultSet rs = pstmt.executeQuery();
			//得到列名
			ResultSetMetaData rsmd = rs.getMetaData();
			String[] colunmNames = new String[rsmd.getColumnCount()];
			
			//循环	得到列名
			for(int i = 0; i<colunmNames.length; i++){
				colunmNames[i] = rsmd.getColumnName(i+1).toLowerCase();//小写化
			}
			
			//判断查询是否有数据
			if(rs.next()){
				map = new HashMap<>();
				
				for(String colunmName : colunmNames){
					String value = rs.getString(colunmName);
					map.put(colunmName, value);
				}
			}
			
			closeAll(rs,pstmt,conn);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return map;
	}
	
	//带有图片内容的查询
	public List<Map<String, Object>> queryAllWithPic(String sql, Object... params){
		List<Map<String, Object>> list = new ArrayList<>();
		
		try {
			//建立连接
			Connection conn = this.getConnection();
			//创建预处理对象
			PreparedStatement pstmt = conn.prepareStatement(sql);
			//设置占位符
			setParams(pstmt, params);
			//获得结果集
			ResultSet rs = pstmt.executeQuery();
			//得到列名
			ResultSetMetaData rsmd = rs.getMetaData();
			String[] columnNames = new String[rsmd.getColumnCount()];
			
			//循环	得到列名
			for(int i = 0; i<columnNames.length; i++){
				columnNames[i] = rsmd.getColumnName(i+1).toLowerCase();//小写化
			}
			
			//循环   通过列明对应取键值
			while(rs.next()){
				Map<String, Object> map = new HashMap<String, Object>();
				
				for(String columnName : columnNames){
					//判断  如果getString为空  那么该列为图片
					if( rs.getString(columnName) == null || "".equals(rs.getString(columnName))){
						map.put(columnName, rs.getBytes(columnName));
					}else{
						map.put(columnName, rs.getString(columnName));
					}
					
				}
				list.add(map);
			}
			
			closeAll(rs,pstmt,conn);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
}




















