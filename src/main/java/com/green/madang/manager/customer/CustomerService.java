package com.green.madang.manager.customer;


import com.green.madang.manager.customer.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerMapper mapper;

    public int postCustomer(CustomerPostReq p){
        return mapper.insCustomer(p);
    }

    public List<CustomerGetRes> getCustomerList(CustomerGetReq p){
//        int page = p.getPage();
//        int size = p.getSize();
//        int sIdx = (page-1) * size;
        int startIdx = ((p.getPage() - 1) * p.getSize());
        p.setStartIdx(startIdx);
        return mapper.selCustomerList(p);
    }

    public int putCustomer(CustomerPutReq p){
        return mapper.updCustomer(p);
    }

    public int delCustomer(CustomerDelReq p){
        return mapper.delCustomer(p);
    }
}
