package MA.Util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

//将用户密码进行md5加密   并返回加密后的32位十六进制密码 

public class MD5Util {
	public static String md5(String password) {

		try {
			// 获取md5对象
			MessageDigest md = MessageDigest.getInstance("md5");
			// 获取加密后的密码并返回十进制字节数组
			byte[] bytes = md.digest(password.getBytes());

			// 遍历数组得到每个十进制数并转换成十六进制

			StringBuffer sb = new StringBuffer();
			for (byte b : bytes) {

				// 把每个数转成十六进制 存进字符中
				sb.append(toHex(b));
			}
			String finish = sb.toString();
			return finish;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}

	// 十进制转十六进制方法
	private static String toHex(byte b) {

		int target = 0;

		if (b < 0) {
			target = 255 + b;
		} else {
			target = b;
		}

		int first = target / 16;
		int second = target % 16;

		return Hex[first] + Hex[second];
	}

	static String[] Hex = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9",
			"a", "b", "c", "d", "e", "f" };

	/*public static void main(String[] args) {
		String a = MD5Util.md5("1234");
		System.out.println(a);
	}*/
}
