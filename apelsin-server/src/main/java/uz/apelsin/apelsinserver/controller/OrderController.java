package uz.apelsin.apelsinserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.apelsin.apelsinserver.payload.OrderDto;
import uz.apelsin.apelsinserver.payload.Response;
import uz.apelsin.apelsinserver.service.OrderService;


@RestController
@RequestMapping("/api/order/")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/save")
    public HttpEntity<?> save(@RequestBody OrderDto dto){
        Response save = orderService.save(dto);
        return ResponseEntity.ok(save);
    }

    @GetMapping("{orderId}")
    public HttpEntity<?> getOne(@PathVariable Integer orderId){
        return ResponseEntity.ok(orderService.getOrderById(orderId));
    }


}
