package com.iitpos.pos.dto.request;

import com.iitpos.pos.util.enums.MeasuringType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ItemSaveRequestDTO {
    private String name;
    private MeasuringType measuringType;
    private double supplierPrice;
    private double displayPrice;
    private double sellingPrice;
    private int qtyOnHand;
    private boolean activeState;
}
