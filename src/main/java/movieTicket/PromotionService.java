package movieTicket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PromotionService {
    @Autowired
    PromotionRepository promotionRepository;

    // 해당하는 있는 프로모션이 있는지 확인
    public Long checkPromotionInfo(Promotion promotion) {
        try {
            Thread.currentThread().sleep((long) (400 + Math.random() * 220));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        promotionRepository.save(promotion);
        if ("card".equals(promotion.getPaymentType())) {

           System.out.println("card");
           return 5L;
        } else {
            return 0L;
        }

        //return promotionRepository.save(promotion).getPaymentId();

    }
}