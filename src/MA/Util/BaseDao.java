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
		 * Լ��: ���巺�����͵����� �� ���� ����һ��
		 */
		// 1)this : ����ǰ���е�dao����
		// 2)this.getClass(): ����ǰ����dao�����Class����
		Class clazz = this.getClass(); 
		// 3)clazz.getGenericSuperclass()�� �õ���ǰdao����ĸ��ࣨ���������ͣ�
		Type type = clazz.getGenericSuperclass(); // BaseDao<Teacher>
		// 4)�Ѹ��������ǿת�����ࣨ����������: ParameterizedType��
		ParameterizedType param = (ParameterizedType) type; // BaseDao<Teacher>
		// 5)param.getActualTypeArguments():�õ����������� ����ķ��������б�
		Type[] types = param.getActualTypeArguments(); // <Teacher>
		// 6)ȡ�����������б��еĵ�һ����������
		Type target = types[0]; // Teacher
		// 7)ǿ�Ƴ�Class����
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

	//��Ҫʵ��ͨ�õ�   save(T t)    update(T t)  delete(String id)
}
