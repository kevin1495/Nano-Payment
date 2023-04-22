package id.co.bca.spring.NanoPayment.repository;

import id.co.bca.spring.NanoPayment.model.PaymentModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepo extends JpaRepository<PaymentModel, Integer> {
}
