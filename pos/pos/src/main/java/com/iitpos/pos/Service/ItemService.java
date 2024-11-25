package com.iitpos.pos.Service;

import com.iitpos.pos.dto.request.ItemSaveRequestDTO;
import com.iitpos.pos.dto.response.ItemResponseDTO;

import java.util.List;

public interface ItemService {
    String save(ItemSaveRequestDTO requestDTO);

    List<ItemResponseDTO> getItemByName(String ItemName);
}
