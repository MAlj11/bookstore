package MA.biz.front.index.dao;

import java.util.List;

import MA.entity.Books;
import MA.entity.types;

public interface IndexDao {

	//��Ŀ����
	public List<types> QueryTypes();
	//���໧������鼮
	public List<Books> QueryBooks(String typeid);
	//�鿴ͼ������
	public Books queryBook(String id);
}
