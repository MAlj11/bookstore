package MA.biz.front.index.service;

import java.util.List;
import MA.biz.front.index.dao.IndexDaoImpl;
import MA.entity.Books;
import MA.entity.types;
/**
 * Ö÷Ò³µÄservice   types
 * @author MA
 *
 */
public class IndexServiceImpl implements IndexService {
	IndexDaoImpl ido = new IndexDaoImpl();

	public List<types> QueryTypes() {
		return ido.QueryTypes();
	}

	public List<Books> QueryBooks(String typeid) {
		
		return ido.QueryBooks(typeid);
		
	}

	public Books queryBook(String id) {
	
		return ido.queryBook(id);
	}

}
