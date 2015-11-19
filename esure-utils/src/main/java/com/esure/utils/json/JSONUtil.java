package com.esure.utils.json;

import java.util.List;
import java.util.Map;

import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * JSON工具类，是通过封装jackson得到，为的是更简单的使用jackson
 * 
 * @description JSONUtil
 * @author ligy
 * @date 2015年11月19日 下午2:04:20
 *
 */
public class JSONUtil {

	private static org.slf4j.Logger logback = LoggerFactory
			.getLogger(JSONUtil.class);

	/**
	 * 对象转化为json数据
	 * 
	 * @description object2Json
	 * @author ligy
	 * @date 2015年11月19日 下午2:04:04
	 * @param object
	 * @return
	 */
	public static String object2Json(Object object) {
		logback.debug(JSONUtil.class.getName() + ".object2Json");
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			return objectMapper.writeValueAsString(object);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("对象转化为json数据出错，可能是对象类型不匹配");
		}
	}

	/**
	 * json数据转化为对象
	 * 
	 * @description json2Object
	 * @author ligy
	 * @date 2015年11月19日 下午2:03:53
	 * @param jsonString
	 * @param destClass
	 * @return
	 */
	public static <T> T json2Object(String jsonString, Class<T> destClass) {
		logback.debug(JSONUtil.class.getName() + ".jackson2Object");
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			return objectMapper.readValue(jsonString, destClass);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("json数据转化为对象时出错，可能是对象类型不匹配");
		}
	}

	/**
	 * 将list的json串转换为list对象
	 * 
	 * @description json2List
	 * @author ligy
	 * @date 2015年11月19日 下午2:03:07
	 * @param jsonString
	 * @param collectionClass
	 * @param elementClasses
	 * @return
	 */
	public static <T> List<T> json2List(String jsonString,
			Class<?> collectionClass, Class<?> elementClasses) {
		logback.debug(JSONUtil.class.getName() + ".jackson2List");
		ObjectMapper objectMapper = new ObjectMapper();
		JavaType javaType = objectMapper.getTypeFactory()
				.constructParametrizedType(collectionClass, collectionClass,
						elementClasses);

		List<T> list = null;
		try {
			list = objectMapper.readValue(jsonString, javaType);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("json数据转化为对象时出错，可能是对象类型不匹配");
		}
		return list;
	}

	/**
	 * 将json串转换为Map
	 * 
	 * @description json2Map
	 * @author ligy
	 * @date 2015年11月19日 下午2:03:26
	 * @param jsonString
	 * @param mapClass
	 * @param keyClasses
	 * @param valueClasses
	 * @return
	 */
	public static <K, V> Map<K, V> json2Map(String jsonString,
			Class<?> mapClass, Class<?> keyClasses, Class<?> valueClasses) {
		logback.debug(JSONUtil.class.getName() + ".jackson2Map");
		ObjectMapper objectMapper = new ObjectMapper();
		JavaType javaType = objectMapper.getTypeFactory()
				.constructParametrizedType(mapClass, mapClass, keyClasses,
						valueClasses);
		Map<K, V> map = null;
		try {
			map = objectMapper.readValue(jsonString, javaType);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("json数据转化为对象时出错，可能是对象类型不匹配");
		}
		return map;
	}

}
