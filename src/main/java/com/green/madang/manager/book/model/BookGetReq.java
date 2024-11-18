package com.green.madang.manager.book.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookGetReq {
    private int page; // 실제 받는 값
    private int size; // 실제 받는 값
    private String searchText;
    @JsonIgnore //Swagger 문서에서 멤버필드가 안나왔으면 할 때 이 애노테이션을 붙이면 된다.
    private int startIdx;// (page - 1) * size
}
