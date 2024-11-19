package com.green.madang.manager.customer;


import com.green.madang.common.model.MyResponse;
import com.green.madang.manager.customer.model.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("manager/customer")
@RestController
@Tag(name = "고객", description = "고객 관리")
public class CustomerController {
    private final CustomerService service;

    @PostMapping
    @Operation(summary = "고객 등록") // description  프론트에게 남기고 싶은말이 있으면 적으면 됨
    public MyResponse<Integer> postCustomer(@RequestBody CustomerPostReq p){
        int result = service.postCustomer(p);
        return new MyResponse<>("고객이 등록되었습니다.", result);
    }
    //@ParameterObject - swagger 용 애노테이션, RequestParam 으로 설성했을 때 FORM 처럼 되게 한다.
    @GetMapping
    @Operation(summary = "고객 리스트", description = "검색할 내용이 있을 시 검색 타입, 검색내용을 모두 보내주어야한다.")
    public MyResponse<List<CustomerGetRes>> getCustomerList(@ParameterObject CustomerGetReq p) {
        log.info("get-req : {}", p);
        List<CustomerGetRes> res = service.getCustomerList(p);
        return new MyResponse<>(p.getPage() + "페이지 데이터", res);
    }

//    @GetMapping
//    @Operation(summary = "고객 리스트2", description = "검색할 내용 있을 시 검색타입, 검색내용을 모두 보내주어야한다.")
//    public MyResponse<List<CustomerGetRes>> getCustomerList(@RequestParam int page,
//                                                            @RequestParam int size,
//                                                            @RequestParam(name = "search_type") String searchType,
//                                                            @RequestParam(name = "search_text") String searchText) {
//
//        CustomerGetRes p = new CustomerGetReq(page, size, searchType, searchText);
//
//        log.info("get-ren : {}", p);
//        List<CustomerGetRes> res = service.getCustomerList(p);
//        return new MyResponse<>(p.getPage() + "페이지 데이터", res);
//    }

    @PutMapping
    public MyResponse<Integer> putCustomer(@RequestBody CustomerPutReq p){
        int result = service.putCustomer(p);
        return new MyResponse<>(p.getCustId() + "번 고객이 업데이트 되었습니다.", result);
    }

    @DeleteMapping
    public MyResponse<Integer> delCustomer(CustomerDelReq p){
        int result = service.delCustomer(p);
        return new MyResponse<>(p.getCustId() + "번 고객이 삭제되었습니다.", result);
    }
}
