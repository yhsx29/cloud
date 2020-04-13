package util;

import java.util.HashMap;
import java.util.Map;

public class CustomerUtil {
	
	
	//参与查询的属性和对应的数据库字段
	public static Map<String, String> getMap() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", "id");
		map.put("name", "name");
		map.put("password", "password");
		map.put("age", "age");
		map.put("sex", "sex");
		map.put("phone", "phone");
		map.put("idNumber", "id_number");
		map.put("idType", "id_type");
		map.put("email", "email");
		return map;
	}
	
	//不参加查询属性 notMap
	public static Map<String, String> getNotMap() {
		Map<String, String> map = new HashMap<String, String>();
		return map;
	}
}