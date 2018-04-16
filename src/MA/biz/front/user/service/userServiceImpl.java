package MA.biz.front.user.service;

import MA.biz.front.user.dao.userDao;
import MA.biz.front.user.dao.userDaoImpl;
import MA.entity.Users;

public class userServiceImpl implements userService {

	
	userDao ud = new userDaoImpl();
	public Users login(String name) {
		
		return ud.findByName(name);
	}

}
