package MA.Util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

//���û��������md5����   �����ؼ��ܺ��32λʮ���������� 

public class MD5Util {
	public static String md5(String password) {

		try {
			// ��ȡmd5����
			MessageDigest md = MessageDigest.getInstance("md5");
			// ��ȡ���ܺ�����벢����ʮ�����ֽ�����
			byte[] bytes = md.digest(password.getBytes());

			// ��������õ�ÿ��ʮ��������ת����ʮ������

			StringBuffer sb = new StringBuffer();
			for (byte b : bytes) {

				// ��ÿ����ת��ʮ������ ����ַ���
				sb.append(toHex(b));
			}
			String finish = sb.toString();
			return finish;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}

	// ʮ����תʮ�����Ʒ���
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
