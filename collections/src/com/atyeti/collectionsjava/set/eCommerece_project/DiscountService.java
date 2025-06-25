package com.atyeti.collections.set.eCommerece_project;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class DiscountService {

    private final Set<String> appliedCoupons = ConcurrentHashMap.newKeySet();

    public void applyCoupon(String userId, String couponCode) {
          String key = userId +" " + couponCode;
        if (appliedCoupons.add(key)) {
        System.out.println("coupon applied: " + couponCode + " for user " + userId);
        } else {
            System.out.println("duplicate coupon ignored for: " + userId);
        }

        }

}
