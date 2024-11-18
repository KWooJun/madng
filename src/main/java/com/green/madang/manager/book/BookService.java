package com.green.madang.manager.book;


import com.green.madang.manager.book.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //빈등록(객체 생성)
@RequiredArgsConstructor
public class BookService {
    private final BookMapper mapper;

    public int postBook(BookPostReq p){
        return mapper.insBook(p);
    }

    public List<BookGetRes> getBookList(BookGetReq p){
        int page = p.getPage();
        int size = p.getSize();
        int sIdx = (page - 1) * size;
        p.setStartIdx(sIdx);

        //p.setStartIdx((p.getPage() - 1) * p.getPage());
        return mapper.selBookList(p);
    }

    public int putBook(BookUpdateReq p){
        return mapper.updateBook(p);
    }

    public int delBook(BookDelReq p){
        return mapper.delBook(p);
    }
}
