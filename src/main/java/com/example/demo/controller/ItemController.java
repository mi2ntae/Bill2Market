package com.example.demo.controller;

import com.example.demo.exception.item.ItemNotFoundException;
import com.example.demo.model.item.ItemSearchRequest;
import com.example.demo.model.item.ItemSaveRequest;
import com.example.demo.model.response.CommonResult;
import com.example.demo.service.ResponseService;
import com.example.demo.service.item.ItemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"3. Item"})
@RequiredArgsConstructor
@RestController
public class ItemController {

    private final ResponseService responseService;
    private final ItemService itemService;

    @ApiOperation(value = "기본 물품 리스트 조회", notes = "사용자와의 거리에 따른 물품 리스트를 조회한다.")
    @PostMapping("/items")
    public CommonResult itemList(@RequestBody ItemSearchRequest itemSearchRequest){
        return responseService.getSingleResult(itemService.findItemList(itemSearchRequest));
    }

    @ApiOperation(value = "기본 물품 상세 조회", notes = "번호에 맞는 물품을 조회한다.")
    @GetMapping("/item/{item-index}")
    public CommonResult itemDetail(@PathVariable("item-index") Integer itemIndex){
        return responseService.getSingleResult(itemService.findItemOne(itemIndex).orElseThrow(ItemNotFoundException::new));
    }
    
    @ApiOperation(value = "임시 게시물 저장", notes = "임시 게시물 저장")
    @PostMapping("/item")
    public CommonResult itemSave(@RequestBody ItemSaveRequest itemSaveRequest){
        itemService.saveItem(itemSaveRequest);
        return responseService.getSuccessfulResult();
    }


}
