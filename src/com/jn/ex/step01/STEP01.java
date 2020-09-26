package com.jn.ex.step01;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class STEP01 {
	public static void main(String[] args) {
		// Object(BookDTO) -> JSON(String)
		System.out.println("�ȳ��ϼ���");
		BookDTO dto = new BookDTO("�ڹ�", 21000, "������", 670);
		Gson g = new Gson();
		String json = g.toJson(dto);
		System.out.println(json);
		
		BookDTO dto1 = g.fromJson(json, BookDTO.class);
		System.out.println(dto1);
		System.out.println(dto1.getTitle() +"\t" + dto1.getPrice());
		
		// Object(List<BookDTO>) -> JSON(String) : [{ },{} .... ]
		List<BookDTO> list = new ArrayList<BookDTO>();
		list.add(new BookDTO("�ڹ�1",21000,"������1",570));
		list.add(new BookDTO("�ڹ�2",31000,"������2",370));
		list.add(new BookDTO("�ڹ�3",41000,"������3",270));
		list.add(new BookDTO("�ڹ�4",51000,"������4",570));
		
		String lstJson = g.toJson(list);
		System.out.println(lstJson);
		
		// JSON(String) -> Object(List<BookDTO>)
		// ���÷��� ���. (�� ������ �ؼ� �հ��� ������ ����)
		List<BookDTO> list1 = g.fromJson(lstJson, new TypeToken<List<BookDTO>>(){}.getType());
		for(BookDTO vo : list1 ) {
			System.out.println(vo);
		}
		
		
	}
}
