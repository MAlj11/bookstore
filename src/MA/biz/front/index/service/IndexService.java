package MA.biz.front.index.service;

import java.util.List;

import MA.entity.Books;
import MA.entity.types;

public interface IndexService{
	public List<types> QueryTypes();
	public List<Books> QueryBooks(String typeid);
	public Books queryBook(String id);

}