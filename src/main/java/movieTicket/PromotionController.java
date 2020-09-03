package movieTicket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
 public class PromotionController {

 @Autowired
 PromotionService promotionService;

 //static final Long makePaymentSuccess = 1L;
 static final Long noDiscount = 0L;

 // 결재 정보 생성  예약이 되었을때는 생성만 필요할듯
 @PostMapping("/promotions")
 public Long paymentInsert(@RequestBody Promotion promotion) {

  System.out.println("promotion . payment.getPaymentId :" + promotion.getPaymentId());
  System.out.println("promotion . payment.getPaymentType :" + promotion.getPaymentType());
  //payment.setPaymentStatus("succeeded");
  //payment.setPaymentType("credit card");

  Long discountRate = promotionService.checkPromotionInfo(promotion);
  System.out.println("discountRate return " + discountRate);

  if (discountRate > 0) {
   return discountRate;     // 성공시 생성된 ID를 실패시 0 리턴
  } else {
   return noDiscount;
  }
 }
}