package io.geekidea.springbootplus.system.controller;

import io.geekidea.springbootplus.common.api.ApiResult;
import io.geekidea.springbootplus.common.controller.BaseController;
import io.geekidea.springbootplus.common.vo.Paging;
import io.geekidea.springbootplus.system.entity.SysDepartment;
import io.geekidea.springbootplus.system.param.SysDepartmentQueryParam;
import io.geekidea.springbootplus.system.service.SysDepartmentService;
import io.geekidea.springbootplus.system.vo.SysDepartmentQueryVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * <pre>
 * 部门 前端控制器
 * </pre>
 *
 * @author geekidea
 * @since 2019-10-24
 */
@Slf4j
@RestController
@RequestMapping("/sysDepartment")
@Api("部门 API")
public class SysDepartmentController extends BaseController {

    @Autowired
    private SysDepartmentService sysDepartmentService;

    /**
     * 添加部门
     */
    @PostMapping("/add")
    @ApiOperation(value = "添加SysDepartment对象", notes = "添加部门", response = ApiResult.class)
    public ApiResult<Boolean> addSysDepartment(@Valid @RequestBody SysDepartment sysDepartment) throws Exception {
            boolean flag = sysDepartmentService.saveSysDepartment(sysDepartment);
            return ApiResult.result(flag);
    }

    /**
     * 修改部门
     */
    @PostMapping("/update")
    @ApiOperation(value = "修改SysDepartment对象", notes = "修改部门", response = ApiResult.class)
    public ApiResult<Boolean> updateSysDepartment(@Valid @RequestBody SysDepartment sysDepartment) throws Exception {
            boolean flag = sysDepartmentService.updateSysDepartment(sysDepartment);
            return ApiResult.result(flag);
    }

    /**
     * 删除部门
     */
    @PostMapping("/delete/{id}")
    @ApiOperation(value = "删除SysDepartment对象", notes = "删除部门", response = ApiResult.class)
    public ApiResult<Boolean> deleteSysDepartment(@PathVariable("id") Long id) throws Exception {
            boolean flag = sysDepartmentService.deleteSysDepartment(id);
            return ApiResult.result(flag);
    }

    /**
     * 获取部门
     */
    @GetMapping("/info/{id}")
    @ApiOperation(value = "获取SysDepartment对象详情", notes = "查看部门", response = SysDepartmentQueryVo.class)
    public ApiResult<SysDepartmentQueryVo> getSysDepartment(@PathVariable("id") Long id) throws Exception {
        SysDepartmentQueryVo sysDepartmentQueryVo = sysDepartmentService.getSysDepartmentById(id);
        return ApiResult.ok(sysDepartmentQueryVo);
    }

    /**
     * 部门分页列表
     */
    @PostMapping("/getPageList")
    @ApiOperation(value = "获取SysDepartment分页列表", notes = "部门分页列表", response = SysDepartmentQueryVo.class)
    public ApiResult<Paging<SysDepartmentQueryVo>> getSysDepartmentPageList(@Valid @RequestBody SysDepartmentQueryParam sysDepartmentQueryParam) throws Exception {
        Paging<SysDepartmentQueryVo> paging = sysDepartmentService.getSysDepartmentPageList(sysDepartmentQueryParam);
        return ApiResult.ok(paging);
    }

}

