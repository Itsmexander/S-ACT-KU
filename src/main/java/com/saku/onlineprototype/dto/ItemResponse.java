package com.saku.onlineprototype.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.saku.onlineprototype.entity.Activity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@ToString
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ItemResponse {
    private Activity activityID;
    private int itemNumber;
    private String itemDescription;
    private double price;

    public static ItemResponse from(ItemRequest itemRequest) {
        return new ItemResponse()
                .setActivityID(itemRequest.getActivityID())
                .setItemNumber(itemRequest.getItemNumber())
                .setItemDescription(itemRequest.getItemDescription())
                .setPrice(itemRequest.getPrice());
    }

}
