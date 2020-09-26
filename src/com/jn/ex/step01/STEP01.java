package com.jn.ex.step01;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class STEP01 {
	public static void main(String[] args) {
		// Object(BookDTO) -> JSON(String)
		System.out.println("안녕하세요");
		BookDTO dto = new BookDTO("자바", 21000, "에이콘", 670);
		Gson g = new Gson();
		String json = g.toJson(dto);
		System.out.println(json);
		
		BookDTO dto1 = g.fromJson(json, BookDTO.class);
		System.out.println(dto1);
		System.out.println(dto1.getTitle() +"\t" + dto1.getPrice());
		
		// Object(List<BookDTO>) -> JSON(String) : [{ },{} .... ]
		List<BookDTO> list = new ArrayList<BookDTO>();
		list.add(new BookDTO("자바1",21000,"에어콘1",570));
		list.add(new BookDTO("자바2",31000,"에어콘2",370));
		list.add(new BookDTO("자바3",41000,"에어콘3",270));
		list.add(new BookDTO("자바4",51000,"에어콘4",570));
		
		String lstJson = g.toJson(list);
		System.out.println(lstJson);
		
		// JSON(String) -> Object(List<BookDTO>)
		// 리플렉션 기법. (역 추적을 해서 먼가를 만들어내는 개념)
		List<BookDTO> list1 = g.fromJson(lstJson, new TypeToken<List<BookDTO>>(){}.getType());
		for(BookDTO vo : list1 ) {
			System.out.println(vo);
		}
		
		
	}
}
