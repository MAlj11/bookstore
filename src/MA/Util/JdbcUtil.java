package MA.Util;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * 连接池版本的jdbcUtil
 *
 */
public class JdbcUtil {

	//创建连接池对象
	private static DataSource ds = new ComboPooledDataSource(); 
	
	/**
	 * 获取连接池对象
	 */
	public static DataSource getDataSource(){
		return ds;
	}
	
	
	
}
