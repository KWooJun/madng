package com.green.madang.client;


import com.green.madang.client.model.OrderPostReq;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientService {
    private final ClientMapper mapper;

    public int postOrders(OrderPostReq p){
        return mapper.insOrders(p);
    }
}
