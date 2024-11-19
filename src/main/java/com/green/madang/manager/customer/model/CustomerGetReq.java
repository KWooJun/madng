package com.green.madang.manager.customer.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


/*
    우리 만드는 API 는 응답 때 JSON 형태로 응답한다.
    응답 시 객체에 있는 특정 멤버 필드의 값을 제외하고 싶을 때
    @JsonIgnore 를 멤버필드에 붙이면 제외시킬 수 있다.
    (응답 때 JsonIgnore 를 쓰는 경우는 거의 없다.)

    Swagger 문서상에 응답 Schema 에서 안보이기도 한다.
 */

//immutable 객체
@Getter
@Setter
@ToString
public class CustomerGetReq {
    //@Schema , @JsonIgnore 애노테이션은 Swagger 용 애노테이션
    @Schema(description = "page 값", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
    private int page;
    @Schema(description = "페이지에 보이는 고객정보 수", example = "50", requiredMode = Schema.RequiredMode.REQUIRED)
    private int size;
    //@JsonIgnore 와 @Schema(hidden true)는 Swagger 문서 상에 Parameters 부분에서 보이지 않게 하는 역할
    @JsonIgnore
    //@Schema(hidden = true)
    private int startIdx; //(page - 1) * size
    @Schema(name = "search_type", description = "검색타입: {name, address, phone}중 한 값을 보낸다. ", example = "name")
    private String searchType;
    @Schema(name = "search_text", description = "검색내용", example = "ani")
    private String searchText;
}
