package com.iitpos.pos.dto.response;

import com.iitpos.pos.util.enums.MeasuringType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ItemResponseDTO {
    private String itemName;
    private MeasuringType measuringType;
    private double supplierPrice;
    private double displayPrice;
    private double sellingPrice;
    private int qtyOnHand;
    private boolean activeState;
}
