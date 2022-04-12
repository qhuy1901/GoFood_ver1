package com.example.myapplication.models;

import com.google.firebase.firestore.Exclude;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Order {
    private String orderId;
    private String userId;
    private String storeId;
    private List<CartItem> orderDetail;
    private int applyFee;
    private int deliveryFee;
    private int doorDelivery;
    private String paymentMethod;
    private int total;

    public Order() {
    }

    public Order(String orderId, String userId, String storeId, List<CartItem> orderDetail, int applyFee, int deliveryFee, int doorDelivery, String paymentMethod, int total) {
        this.orderId = orderId;
        this.userId = userId;
        this.storeId = storeId;
        this.orderDetail = orderDetail;
        this.applyFee = applyFee;
        this.deliveryFee = deliveryFee;
        this.doorDelivery = doorDelivery;
        this.paymentMethod = paymentMethod;
        this.total = total;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public List<CartItem> getOrderDetail() {
        return orderDetail;
    }

    public void setOrderDetail(List<CartItem> orderDetail) {
        this.orderDetail = orderDetail;
    }

    public int getApplyFee() {
        return applyFee;
    }

    public void setApplyFee(int applyFee) {
        this.applyFee = applyFee;
    }

    public int getDeliveryFee() {
        return deliveryFee;
    }

    public void setDeliveryFee(int deliveryFee) {
        this.deliveryFee = deliveryFee;
    }

    public int getDoorDelivery() {
        return doorDelivery;
    }

    public void setDoorDelivery(int doorDelivery) {
        this.doorDelivery = doorDelivery;
    }



    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("orderId", orderId);
        result.put("userId", userId);
        result.put("storeId", storeId);
        result.put("orderDetail", orderDetail);
        result.put("applyFee", applyFee);
        result.put("deliveryFee", deliveryFee);
        result.put("doorDelivery", doorDelivery);
        result.put("paymentMethod", paymentMethod);
        result.put("total", total);
        return result;
    }
}
