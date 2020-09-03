package movieTicket;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;

@Entity
@Table(name="Promotion_table")
public class Promotion {



    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long promotionId;
    private Long discountRate;
    private Long paymentId;
    private String paymentType;
    private String note;

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    @PrePersist
    public void onPrePersist(){
        InsertedPromotion insertedPromotion = new InsertedPromotion();
        BeanUtils.copyProperties(this, insertedPromotion);
        insertedPromotion.publishAfterCommit();


        AppliedDiscount appliedDiscount = new AppliedDiscount();
        BeanUtils.copyProperties(this, appliedDiscount);
        appliedDiscount.publishAfterCommit();
    }


    public Long getPromotionId() {
        return promotionId;
    }

    public void setPromotionId(Long promotionId) {
        this.promotionId = promotionId;
    }

    public Long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Long paymentId) {
        this.paymentId = paymentId;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }


    public Long getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(Long discountRate) {
        this.discountRate = discountRate;
    }


}
