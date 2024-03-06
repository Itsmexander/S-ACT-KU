package com.saku.onlineprototype.entity;

import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

public class ItemList {
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ActivityID")
    private Activity activityID;
}
