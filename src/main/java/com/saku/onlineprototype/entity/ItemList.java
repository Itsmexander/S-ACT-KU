package com.saku.onlineprototype.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Itemlist")
public class ItemList {
    @Id
    @Column(name = "itemListID")
    private String listID;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ActivityID")
    private Activity activityID;

    @OneToMany(mappedBy = "itemList", fetch = FetchType.LAZY)
    private List<Item> itemList;
}