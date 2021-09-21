package uz.apelsin.apelsinserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.apelsin.apelsinserver.entity.Detail;
import uz.apelsin.apelsinserver.entity.Invoice;
import uz.apelsin.apelsinserver.entity.Order;
import uz.apelsin.apelsinserver.payload.OrderDto;
import uz.apelsin.apelsinserver.payload.Response;
import uz.apelsin.apelsinserver.repository.*;


import java.sql.Date;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    DetailRepository detailRepository;

    @Autowired
    InvoiceRepository invoiceRepository;

    public Response save(OrderDto dto){

        java.util.Date date = new java.util.Date();
        long due = 604800000L;
        long l = date.getTime() + due;
        java.util.Date expireDate = new java.util.Date(l);
        Integer invoiceNumber=0;


        Order order=new Order();
        try {
            order.setCustomer(customerRepository.getById(dto.getCustomerId()));
            order.setDate(new Date(new java.util.Date().getTime()));
            orderRepository.save(order);
            try {
                Detail detail=new Detail();
                detail.setOrder(order);
                detail.setProduct(productRepository.getById(dto.getProductId()));
                detail.setQuantity(dto.getQuantity());
                detailRepository.save(detail);
            }catch (Exception e){
                e.printStackTrace();
            }

            try {
                Invoice invoice=new Invoice();
                invoice.setOrder(order);
                invoice.setAmount(1);
                invoice.setDue(new Date(expireDate.getTime()));
                invoice.setIssued(new Date(new java.util.Date().getTime()));
                invoiceRepository.save(invoice);
                invoiceNumber=invoice.getId();
            }catch (Exception e){
                e.printStackTrace();
            }
            return new Response("SUCCESS",invoiceNumber,null);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new Response("FAILED");
    }

    public OrderDto getOrderById(Integer orderId){
        return getOrderDto(orderRepository.getById(orderId));
    }

    public OrderDto getOrderDto(Order order){
        OrderDto dto=new OrderDto();
        Detail detail = detailRepository.getDetailByOrderId(order.getId());
        dto.setQuantity(detail.getQuantity());
        dto.setCustomer(order.getCustomer());
        dto.setProductName(detail.getProduct().getName());
        dto.setDate(order.getDate());
        return dto;
    }

}
