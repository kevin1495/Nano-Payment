package id.co.bca.spring.NanoPayment.controller;

import id.co.bca.spring.NanoPayment.model.PaymentModel;
import id.co.bca.spring.NanoPayment.repository.PaymentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api")
public class PaymentController {
    @Autowired
    PaymentRepo paymentRepo;
    @GetMapping("/pay")
    @ResponseStatus(HttpStatus.OK)
    public List<PaymentModel> findAll(){return paymentRepo.findAll();}
    @GetMapping("/pay/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional findPaymentById(@PathVariable("id") int id){
        return paymentRepo.findById(id);
    }
    @PostMapping("/pay")
    @ResponseStatus(HttpStatus.OK)
    public PaymentModel addPayment(@RequestBody PaymentModel paymentModel){
        paymentRepo.save(paymentModel);
        return paymentModel;
    }
    @PutMapping("/pay/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PaymentModel updatePayment(@RequestBody PaymentModel paymentModel, @PathVariable("id") int id){
        paymentModel.setId(id);
        paymentRepo.save(paymentModel);
        return paymentModel;
    }
    @DeleteMapping("/pay/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deletePayment(@PathVariable("id") int id){
        paymentRepo.deleteById(id);
    }

}
