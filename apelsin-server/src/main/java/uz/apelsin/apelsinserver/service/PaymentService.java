package uz.apelsin.apelsinserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.apelsin.apelsinserver.entity.Payment;
import uz.apelsin.apelsinserver.payload.PaymentDto;
import uz.apelsin.apelsinserver.payload.Response;
import uz.apelsin.apelsinserver.repository.InvoiceRepository;
import uz.apelsin.apelsinserver.repository.PaymentRepository;

import java.sql.Date;
import java.util.List;

@Service
public class PaymentService {

    @Autowired
    PaymentRepository paymentRepository;

    @Autowired
    InvoiceRepository invoiceRepository;

    public Response save(PaymentDto dto){
        Payment payment=new Payment();
        try {
            payment.setAmount(1);
            payment.setTime(new Date(new java.util.Date().getTime()));
            payment.setInvoice(invoiceRepository.getById(dto.getInvoiceId()));
            paymentRepository.save(payment);
            return new Response("SUCCESS",paymentRepository.getById(payment.getId()));
        }catch (Exception e){
            e.printStackTrace();
        }
        return new Response("FAILED");
    }

    public PaymentDto getById(Integer id){
        return getPaymentDto(paymentRepository.getById(id));
    }

    public List<Payment> getAll(){
        return paymentRepository.findAll();
    }

    public PaymentDto getPaymentDto(Payment payment){
        PaymentDto dto=new PaymentDto();

        dto.setAmount(payment.getAmount());
        dto.setInvoice(payment.getInvoice());
        dto.setTime(payment.getTime());
        return dto;
    }

}
