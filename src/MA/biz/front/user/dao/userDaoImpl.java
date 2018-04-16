package MA.biz.front.user.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import MA.Util.JdbcUtil;
import MA.entity.Users;

public class userDaoImpl implements userDao {

	public Users findByName(String name) {
		try {
			QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
			return (Users) qr.query("select * from users where NAME = ?",
					new BeanHandler(Users.class), new Object[] { name });
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

}
