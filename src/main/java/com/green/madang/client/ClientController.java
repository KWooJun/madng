package com.green.madang.client;


import com.green.madang.client.model.OrderPostReq;
import com.green.madang.common.model.MyResponse;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("client")
@RestController
public class ClientController {
    private final ClientService service;

    //@ResponseBody RestController 라서 생략가능
    @PostMapping("order")
    @Operation(summary = "책 주문")
    public MyResponse<Integer> postOrders(@RequestBody OrderPostReq p){ //@RequestBody JSON 형태로 넘어와서 사용함
        int res = service.postOrders(p);
        return new MyResponse<>("책이 주문이 완료되었습니다.", res);
    }
}
