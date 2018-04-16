package MA.biz.admin.types.dao;

import java.util.List;

import org.junit.Test;

import MA.Util.BaseDao;
import MA.entity.types;

public class typesDaoImpl extends BaseDao<types> implements typesDao {
  
	
	
	@Test
	public void test(){
		typesDaoImpl dao = new typesDaoImpl();
		List<types> list = dao.findAll();
		for(types a : list){
			System.out.println(a);
		}
		
	}
	
}


