package MA.biz.front.index.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import MA.Util.JdbcUtil;
import MA.entity.Books;
import MA.entity.types;

/**
 * 
 * 主页的Dao
 * 
 * @author MA
 * 
 */

public class IndexDaoImpl implements IndexDao {

	public List<types> QueryTypes() {
		QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
		try {
			return (List<types>) qr.query("select * from types",
					new BeanListHandler(types.class));
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	
	
	
	
	//select id,NAME,img,round(price*rebate,2) as currentprice from books where id in(SELECT bookid FROM booktype WHERE typeid='"
	//+ typeid + "' )
	public List<Books> QueryBooks(String typeid) {
		StringBuffer sql = new StringBuffer(
				"select id,NAME,img,round(price*rebate,2) as currentprice from books  ");
		if (typeid != null && !typeid.equals("")) {
			sql.append(" where id in(SELECT bookid FROM booktype WHERE typeid='"
					+ typeid + "' )");
		}
		try {
			QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
			return (List<Books>) qr.query(sql.toString(), new BeanListHandler(
					Books.class));
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}



	
	
	
	
	
	
	
	
/**
 * 查看图书详情
 */

	public Books queryBook(String id) {
	 QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
	 try {
			return (Books)qr.query("select id,name,price,rebate,round(price*rebate,2) as currentPrice,auth,img from books where id=?", new BeanHandler(Books.class),new Object[]{id});
	} catch (SQLException e) {
		e.printStackTrace();
		throw new RuntimeException(e);
	}
		
	}
	
	/*public static void main(String[] args) {
		IndexDaoImpl dao = new IndexDaoImpl();
		List<Books> list = dao.QueryBooks(null);
		for (Books books : list) {
			System.out.println(books);
		}
	}*/

}
