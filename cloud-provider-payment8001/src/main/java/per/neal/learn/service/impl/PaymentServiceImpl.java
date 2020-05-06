package per.neal.learn.service.impl;

import per.neal.learn.entities.Payment;
import org.springframework.stereotype.Service;
import per.neal.learn.dao.PaymentDao;
import per.neal.learn.service.PaymentService;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
