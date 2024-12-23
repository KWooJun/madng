package com.green.madang.manager.book;


import com.green.madang.manager.book.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
//BookMapper.xml 이랑 연결
public interface BookMapper {
    int insBook(BookPostReq p);
    List<BookGetRes> selBookList(BookGetReq p);
    int updateBook(BookUpdateReq p);
    int delBook(BookDelReq p);
}
