package com.green.madang.client;


import com.green.madang.client.model.OrderPostReq;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ClientMapper {
    int insOrders(OrderPostReq p);

}
