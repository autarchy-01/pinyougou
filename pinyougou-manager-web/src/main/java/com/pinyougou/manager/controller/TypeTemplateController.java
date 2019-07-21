package com.pinyougou.manager.controller;

import java.util.List;

import com.pinyougou.pojo.TypeTemplate;
import org.springframework.web.bind.annotation.*;
import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.sellergoods.service.TypeTemplateService;

import com.github.pagehelper.PageInfo;
import com.pinyougou.entity.Result;

/**
 * controller
 *
 * @author Administrator
 */
@RestController
@RequestMapping("/typeTemplate")
public class TypeTemplateController {

    @Reference
    private TypeTemplateService typeTemplateService;

    /**
     * 返回全部列表
     *
     * @return
     */
    @RequestMapping("/findAll")
    public List<TypeTemplate> findAll() {
        return typeTemplateService.findAll();
    }


    @RequestMapping("/findPage")
    public PageInfo<TypeTemplate> findPage(@RequestParam(value = "pageNo", defaultValue = "1", required = true) Integer pageNo,
                                           @RequestParam(value = "pageSize", defaultValue = "10", required = true) Integer pageSize) {
        return typeTemplateService.findPage(pageNo, pageSize);
    }

    /**
     * 增加
     *
     * @param typeTemplate
     * @return
     */
    @RequestMapping("/add")
    public Result add(@RequestBody TypeTemplate typeTemplate) {
        try {
            typeTemplateService.add(typeTemplate);
            return new Result(true, "增加成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "增加失败");
        }
    }

    /**
     * 修改
     *
     * @param typeTemplate
     * @return
     */
    @RequestMapping("/update")
    public Result update(@RequestBody TypeTemplate typeTemplate) {
        try {
            typeTemplateService.update(typeTemplate);
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
    public TypeTemplate findOne(@PathVariable(value = "id") Long id) {
        return typeTemplateService.findOne(id);
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
            typeTemplateService.delete(ids);
            return new Result(true, "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "删除失败");
        }
    }


    @RequestMapping("/search")
    public PageInfo<TypeTemplate> findPage(@RequestParam(value = "pageNo", defaultValue = "1", required = true) Integer pageNo,
                                           @RequestParam(value = "pageSize", defaultValue = "10", required = true) Integer pageSize,
                                           @RequestBody TypeTemplate typeTemplate) {
        return typeTemplateService.findPage(pageNo, pageSize, typeTemplate);
    }

}
