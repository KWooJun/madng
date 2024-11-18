package com.green.madang.manager.book.model;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
//#{}안에 있는거는 멤버필드만 넣어야 한다
public class BookPostReq {
    @Schema(title = "도서 이름", description = "설명할것들", example = "학교 종이 떙떙떙!", requiredMode = Schema.RequiredMode.REQUIRED)
    private String bookName;
    @Schema(title = "출판사 이름", example = "한빛출판사", requiredMode = Schema.RequiredMode.REQUIRED)
    private String publisher;
    @Schema(title = "도서 가격", example = "12000", requiredMode = Schema.RequiredMode.REQUIRED)
    private int price;
}
