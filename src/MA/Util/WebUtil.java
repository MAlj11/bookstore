package MA.Util;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;

/**
 * web工具类
 * 
 * @author MA
 * 
 */
public class WebUtil {

	/**
	 * 将resquest请求数据复制到javabean中
	 * 
	 * @param request
	 * @param clazz
	 * @return
	 */
	public static <T> T copuRequestToBean(HttpServletRequest request,
			Class<T> clazz) {

		try {
			// 创建接收复制request的对象
			T obj = clazz.newInstance();
            
			// 将request取出放到Map中
			Map map = request.getParameterMap();
		
           
			// 使用javabean工具复制
			BeanUtils.copyProperties(obj, map);
             System.out.println(obj);
			return obj;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}

}
