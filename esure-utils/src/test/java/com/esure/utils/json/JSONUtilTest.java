package com.esure.utils.json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.esure.utils.json.model.Person;

public class JSONUtilTest {

	@Test
	public void testObject2JacksonString() {
		List<Person> ps = new ArrayList<Person>();
		Person p = new Person();
		p.setId(1);
		p.setName("小马");
		ps.add(p);
		
		String jsonString = JSONUtil.object2Json(ps);
		System.out.println("jsonString : " + jsonString);
	}

	@Test
	public void testJackson2Object() {
		Person p = new Person();
		p.setId(1);
		p.setName("小马");
		
		String jsonString = JSONUtil.object2Json(p);
		System.out.println("jsonString : " + jsonString);
		
		Person p2 = JSONUtil.json2Object(jsonString, Person.class);
		
		System.out.println(JSONUtil.object2Json(p2));
	}
	
	@Test
	public void testJackson2List() {
		List<Person> ps = new ArrayList<Person>();
		Person p = new Person();
		p.setId(1);
		p.setName("小马");
		ps.add(p);
		
		String jsonString = JSONUtil.object2Json(ps);
		System.out.println("jsonString : " + jsonString);
		List<Person> ps1 = JSONUtil.json2List(jsonString, List.class, Person.class);
		
		System.out.println("ps1 : " + JSONUtil.object2Json(ps1));
		
		Person px = ps1.get(0);
		System.out.println("px : " + JSONUtil.object2Json(px));
	}

	@Test
	public void testJackson2Map() {
		Map<Person, Person> map = new HashMap<Person, Person>();
		Person p = new Person();
		p.setId(1);
		p.setName("小马");
		Person p1 = new Person();
		p1.setId(2);
		p1.setName("小马2");
		map.put(p, p1);
		
		String jsonString = JSONUtil.object2Json(map);
		System.out.println("jsonString : " + jsonString);
		
		Map<String, Person> map1 = JSONUtil.json2Map(jsonString, Map.class, Person.class, Person.class);
		
		Person p2 = map1.get(p);
		
		System.out.println("p2 : " + JSONUtil.object2Json(p2));
	}

}
