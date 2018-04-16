package MA.Util;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.SQLException;
import java.util.List;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

public class BaseDao<T> {
	private Class targetClass;
	private String tableName;

	public BaseDao() {
		/**
		 * 约定: 具体泛型类型的类名 和 表名 保持一致
		 */
		// 1)this : 代表当前运行的dao对象
		// 2)this.getClass(): 代表当前运行dao对象的Class对象
		Class clazz = this.getClass(); 
		// 3)clazz.getGenericSuperclass()： 得到当前dao对象的父类（参数化类型）
		Type type = clazz.getGenericSuperclass(); // BaseDao<Teacher>
		// 4)把父类的类型强转成子类（参数化类型: ParameterizedType）
		ParameterizedType param = (ParameterizedType) type; // BaseDao<Teacher>
		// 5)param.getActualTypeArguments():得到参数化类型 上面的泛型类型列表
		Type[] types = param.getActualTypeArguments(); // <Teacher>
		// 6)取出泛型类型列表中的第一个泛型类型
		Type target = types[0]; // Teacher
		// 7)强制成Class类型
		targetClass = (Class) target;

	
		tableName = targetClass.getSimpleName().toLowerCase();
	}

	public List<T> findAll() {
		try {
			QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
			return (List<T>) qr.query("select * from " + tableName + "",new BeanListHandler(targetClass));
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public T findById(int id) {
		try {
			QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
			return (T) qr.query("select * from " + tableName + " where id=?",new BeanHandler(targetClass), new Object[] { id });
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	//需要实现通用的   save(T t)    update(T t)  delete(String id)
}
