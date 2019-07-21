package com.pinyougou.cart.controller;

import java.util.List;

import com.pinyougou.user.service.AddressService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.pojo.Address;
import com.github.pagehelper.PageInfo;
import com.pinyougou.entity.Result;

/**
 * controller
 *
 * @author Administrator
 */
@RestController
@RequestMapping("/address")
public class AddressController {

    @Reference
    private AddressService addressService;
    @RequestMapping("/findAddressListByUserId")
    public List<Address> findAddressListByUserId() {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        Address address = new Address();
        address.setUserId(name);
        return addressService.select(address);
    }

    /**
     * 返回全部列表
     *
     * @return
     */
    @RequestMapping("/findAll")
    public List<Address> findAll() {
        return addressService.findAll();
    }


    @RequestMapping("/findPage")
    public PageInfo<Address> findPage(@RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,
                                      @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        return addressService.findPage(pageNo, pageSize);
    }

    /**
     * 增加
     *
     * @param address
     * @return
     */
    @RequestMapping("/add")
    public Result add(@RequestBody Address address) {
        try {
            addressService.add(address);
            return new Result(true, "增加成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "增加失败");
        }
    }

    /**
     * 修改
     *
     * @param address
     * @return
     */
    @RequestMapping("/update")
    public Result update(@RequestBody Address address) {
        try {
            addressService.update(address);
            return new Result(true, "修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "修改失败");
        }
    }

    /**
     * 获取实体
     *
     * @param id
     * @return
     */
    @RequestMapping("/findOne/{id}")
    public Address findOne(@PathVariable(value = "id") Long id) {
        return addressService.findOne(id);
    }

    /**
     * 批量删除
     *
     * @param ids
     * @return
     */
    @RequestMapping("/delete")
    public Result delete(@RequestBody Long[] ids) {
        try {
            addressService.delete(ids);
            return new Result(true, "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "删除失败");
        }
    }


    @RequestMapping("/search")
    public PageInfo<Address> findPage(@RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,
                                      @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                      @RequestBody Address address) {
        return addressService.findPage(pageNo, pageSize, address);
    }

}
