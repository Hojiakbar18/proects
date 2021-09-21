package uz.apelsin.apelsinserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.apelsin.apelsinserver.payload.PaymentDto;
import uz.apelsin.apelsinserver.payload.Response;
import uz.apelsin.apelsinserver.service.PaymentService;


@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @PostMapping("/save")
    public HttpEntity<?> save(@RequestBody PaymentDto dto){
        Response save = paymentService.save(dto);
        return ResponseEntity.ok(save);
    }

    @GetMapping("/{detailId}")
    public HttpEntity<?> getOne(@PathVariable Integer detailId){
        return ResponseEntity.ok(paymentService.getById(detailId));
    }

    @GetMapping("/all")
    public HttpEntity<?> getAll(){
        return ResponseEntity.ok(paymentService.getAll());
    }

}
