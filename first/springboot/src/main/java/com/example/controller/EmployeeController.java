package com.example.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.entity.Employee;
import com.example.entity.SysUser;
import com.example.service.IEmployeeService;
import com.example.service.ISysUserService;
import com.example.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@Api(tags = "职工")
@RequestMapping("/employee")
public class EmployeeController {

    @Resource
    private IEmployeeService employeeService;

    @GetMapping("/list")
    @ApiOperation("列表")
    public R list(@RequestParam(name = "page", defaultValue = "1") Integer page,
                  @RequestParam(name = "limit", defaultValue = "20") Integer limit,
                  HttpServletRequest req) {
        QueryWrapper<Employee> queryWrapper = new QueryWrapper<>();
        String empName = req.getParameter("empName");
        if (empName != null && !empName.isEmpty()) {
            queryWrapper.eq("emp_name",empName);
        }

        String deptName = req.getParameter("deptName");
        if (deptName != null && !deptName.isEmpty()) {
            queryWrapper.eq("dept_name",deptName);
        }

        String empDegreeName = req.getParameter("empDegreeName");
        if (empDegreeName != null && !empDegreeName.isEmpty()) {
            queryWrapper.eq("emp_degree_name",empDegreeName);
        }

        String sort = req.getParameter("sort");
        if (sort != null && !sort.isEmpty()) {
            char firstChar = sort.charAt(0);
            String sortField = sort.substring(1);
            if (firstChar == '+')
                queryWrapper.orderByAsc(sortField);
            else
                queryWrapper.orderByDesc(sortField);
        }
        Page<Employee> pageMo = new Page<>(page, limit);
        IPage<Employee> pageList = employeeService.page(pageMo, queryWrapper);
        return R.ok(pageList);
    }


    @ApiOperation("添加职工")
    @PostMapping(value = "/add")
    public R add(@RequestBody Employee employee) {
        employeeService.save(employee);
        return R.ok("添加成功！");
    }

    @ApiOperation("编辑职工")
    @PutMapping(value = "/edit")
    public R edit(@RequestBody Employee employee) {
        employeeService.updateById(employee);
        return R.ok("编辑成功!");
    }

    @ApiOperation("删除职工")
    @DeleteMapping(value = "/delete")
    public R delete(@RequestParam(name = "id", required = true) Integer id) {
        employeeService.removeById(id);
        return R.ok("删除成功!");
    }

}
