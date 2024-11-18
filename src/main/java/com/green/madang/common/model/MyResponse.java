package com.green.madang.common.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

// 응답할 때 사용하는 객체
@Getter
@Setter
@AllArgsConstructor //모든 멤버필드 초기화를 할 수 있는 생성자를 생성(static 이 들어가면 안됨)
public class MyResponse<T> {
    private String resultMessage;
    private T resultData;
}
