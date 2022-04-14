package com.example.myapplication.models;

import com.google.firebase.firestore.Exclude;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Order implements Serializable {
    private String orderId;
    private String userId;
    private String storeId;
    private List<CartItem> orderDetail;
    private int applyFee;
    private int deliveryFee;
    private int doorDelivery;
    private String paymentMethod;
    private int total;
    private String orderStatus;
    private Date orderDate;
    private String cancelReason;
    private Date finishTime;


    public Order() {
    }

    public Order(String orderId, String userId, String storeId, List<CartItem> orderDetail, int applyFee, int deliveryFee, int doorDelivery, String paymentMethod, int total, String orderStatus, Date orderDate) {
        this.orderId = orderId;
        this.userId = userId;
        this.storeId = storeId;
        this.orderDetail = orderDetail;
        this.applyFee = applyFee;
        this.deliveryFee = deliveryFee;
        this.doorDelivery = doorDelivery;
        this.paymentMethod = paymentMethod;
        this.total = total;
        this.orderStatus = orderStatus;
        this.orderDate = orderDate;
    }

    public Date getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }

    public String getCancelReason() {
        return cancelReason;
    }

    public void setCancelReason(String cancelReason) {
        this.cancelReason = cancelReason;
    }
    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
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
        result.put("orderStatus", orderStatus);
        result.put("orderDate", orderDate);
        result.put("cancelReason", cancelReason);
        result.put("finishTime", finishTime);
        return result;
    }
}
