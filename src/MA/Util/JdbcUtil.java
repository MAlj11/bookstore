package MA.Util;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * ���ӳذ汾��jdbcUtil
 *
 */
public class JdbcUtil {

	//�������ӳض���
	private static DataSource ds = new ComboPooledDataSource(); 
	
	/**
	 * ��ȡ���ӳض���
	 */
	public static DataSource getDataSource(){
		return ds;
	}
	
	
	
}
