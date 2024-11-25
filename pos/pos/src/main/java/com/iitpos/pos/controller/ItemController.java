package com.iitpos.pos.controller;

import com.iitpos.pos.Service.ItemService;
import com.iitpos.pos.dto.request.ItemSaveRequestDTO;
import com.iitpos.pos.dto.response.ItemResponseDTO;
import com.iitpos.pos.util.enums.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/item")
public class ItemController {

    @Autowired
    private ItemService itemService;

//    @PostMapping("/item-save")
//    public String saveItem(@RequestBody ItemSaveRequestDTO requestDTO){
//        String message = itemService.save(requestDTO);
//        return message;
//    }


    //how to work with standared response as the company standard way
    @PostMapping("/item-save")
    public ResponseEntity<StandardResponse> saveItem(@RequestBody ItemSaveRequestDTO requestDTO){
        String message = itemService.save(requestDTO);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201,"Success",message), HttpStatus.CREATED
        );
    }

//    @GetMapping(
//            path = "/get-by-name",
//            params = "name"
//    )
//    public List<ItemResponseDTO> getItembyName(@RequestParam(value = "name")String name){
//        List<ItemResponseDTO> responseDTOS = itemService.getItemByName(name);
//        return responseDTOS;
//    }

    @GetMapping(
            path = "/get-by-name",
            params = "name"
    )
    public ResponseEntity<StandardResponse> getItembyName(@RequestParam(value = "name")String name){
        List<ItemResponseDTO> responseDTOS = itemService.getItemByName(name);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201,"Success",responseDTOS),HttpStatus.CREATED
        );
    }


}
