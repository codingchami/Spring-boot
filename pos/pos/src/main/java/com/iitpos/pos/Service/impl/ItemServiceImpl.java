package com.iitpos.pos.Service.impl;

import com.iitpos.pos.Service.ItemService;
import com.iitpos.pos.dto.request.ItemSaveRequestDTO;
import com.iitpos.pos.dto.response.ItemResponseDTO;
import com.iitpos.pos.entity.Item;
import com.iitpos.pos.repo.ItemRepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public String save(ItemSaveRequestDTO requestDTO) {
        //way 1
//        Item item = new Item(
//                requestDTO.getName(),
//                requestDTO.getMeasuringType(),
//                requestDTO.getSupplierPrice(),
//                requestDTO.getDisplayPrice(),
//                requestDTO.getSellingPrice(),
//                requestDTO.getQtyOnHand(),
//                requestDTO.isActiveState()
//        );

        //way 2
//        Item item = new Item();
//        item.setName(requestDTO.getName());


        //way3
        //How to use model mapper(here we put the data from Dto to entity expect generated item id)
        Item item = modelMapper.map(requestDTO,Item.class);

        if(!itemRepo.existsById(item.getItemID())){
            itemRepo.save(item);
            return "Saved..!";
        }else{
            return "Item already exists!....";
        }


//        itemRepo.save(item);
//        return "Item Saved!....";


//        if you want to put data from entity to requestDTO, in this way you can use model mapper below this.
//        ItemSaveRequestDTO dto = modelMapper(item,ItemSaveRequestDTO.class);
    }

    @Override
    public List<ItemResponseDTO> getItemByName(String ItemName) {
        List<Item> items = itemRepo.findAllByNameEqualsAndActiveStateEquals(ItemName,true);

        if(!items.isEmpty()){
            List<ItemResponseDTO> itemResponseDTOS = modelMapper.map(
                    items,new TypeToken<List<ItemResponseDTO>>(){
                    }.getType()
            );

            return itemResponseDTOS;
        }else{
            return null;
        }
    }
}
