package MA.biz.front.index.dao;

import java.util.List;

import MA.entity.Books;
import MA.entity.types;

public interface IndexDao {

	//书目分类
	public List<types> QueryTypes();
	//分类户具体的书籍
	public List<Books> QueryBooks(String typeid);
	//查看图书详情
	public Books queryBook(String id);
}
