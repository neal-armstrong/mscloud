package per.neal.learn.service;

import per.neal.learn.entities.Payment;

public interface PaymentService {
    int create(Payment payment);

    Payment getPaymentById(Long id);
}
