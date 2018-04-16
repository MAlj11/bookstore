package MA.Util;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;

/**
 * web������
 * 
 * @author MA
 * 
 */
public class WebUtil {

	/**
	 * ��resquest�������ݸ��Ƶ�javabean��
	 * 
	 * @param request
	 * @param clazz
	 * @return
	 */
	public static <T> T copuRequestToBean(HttpServletRequest request,
			Class<T> clazz) {

		try {
			// �������ո���request�Ķ���
			T obj = clazz.newInstance();
            
			// ��requestȡ���ŵ�Map��
			Map map = request.getParameterMap();
		
           
			// ʹ��javabean���߸���
			BeanUtils.copyProperties(obj, map);
             System.out.println(obj);
			return obj;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}

}
