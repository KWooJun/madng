package com.green.madang.manager.book;


import com.green.madang.common.model.MyResponse;
import com.green.madang.manager.book.model.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j //print 대신 log.info, warn,
@RequestMapping("manager/book")
@RestController
@RequiredArgsConstructor
@Tag(name = "도서", description = "도서 API")
public class BookController {
    private final BookService service;

    @PostMapping
    @Operation(summary = "도서 입고", description = "도서 입고 처리 API")//<br></br> 개행 (HTML)
    public MyResponse<Integer> postBook(@RequestBody BookPostReq p){
        log.info("info ------------ {}", p);
        // 무슨 데이터가 들어 왔는지 {} 자리에 문자열 p 가 들어감
        log.warn("warn"); // 경고메세지
        log.error("error"); // 에러메세지

        int result = service.postBook(p);
        MyResponse<Integer> response = new MyResponse<>("책 등록 완료", result);
        return response;
    }

    @GetMapping
    @Operation(summary = "도서 리스트", description = "도서 정보 리스트 보기 API")
    public MyResponse<List<BookGetRes>> getBookList(@ParameterObject @ModelAttribute BookGetReq p){
        List<BookGetRes> list = service.getBookList(p);
        return new MyResponse<>(p.getPage() + "페이지 데이터", list);
    }

    @PutMapping
    @Operation(summary = "도서 수정")
    public MyResponse<Integer> putBook(@RequestBody BookUpdateReq p){
        int result = service.putBook(p);
        return new MyResponse<>("책 업데이트 완료", result);
    }

    @DeleteMapping
    @Operation(summary = "도서 삭제")
    public MyResponse<Integer> delBook(BookDelReq p){
        int result = service.delBook(p);
        return new MyResponse<>("책 삭제 완료", result);
    }

}
