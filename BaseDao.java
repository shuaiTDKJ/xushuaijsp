package javaweb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class BaseDao {
	private static final String 
	DRIVER="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static final String
	URL="jdbc:sqlserver://localhost:1433;database=javawebDb";
	private static final String user="sa";
	private static final String pwd="123";
	
	private static Connection con=null;
	
	public static Connection getConnection(){
		try {
			Class.forName(DRIVER);
			con=DriverManager.getConnection(URL, user, pwd);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
		
	}
	public static boolean runUpdateSql(String sql,Object [] params){
		Connection con=null;
		PreparedStatement ps=null;
		try {
			con=getConnection();
			ps=con.prepareStatement(sql);
			for(int i=0;i<params.length;i++){
				ps.setObject(i+1,params[i]);
			}
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally{
			try {
				ps.close();
				con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
		}
	
		
	}
	
}
