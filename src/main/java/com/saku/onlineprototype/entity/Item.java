package com.saku.onlineprototype.entity;

import jakarta.persistence.*;

public class Item{
    @OneToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "ActivityID")
    private Activity activityID;
    @Column(name="itemNumber")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int itemNumber;
    @Column(name = "itemDescription")
    private String itemDescription;
    @Column(name = "price")
    private double price;

}
