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
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

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

    @ApiOperation("统计性别")
    @GetMapping(value = "/sex_count")
    public R sexCount() {
        List<Map<String, Object>> responseList = new ArrayList<>();

        // 获取员工列表
        List<Employee> employeeList = employeeService.list();

        // 统计各性别人数的Map
        Map<String, Integer> sexCountMap = new HashMap<>();

        // 遍历员工列表，统计各性别人数
        for (Employee employee : employeeList) {
            String degree = employee.getSex();

            // 更新性别人数统计
            sexCountMap.put(degree, sexCountMap.getOrDefault(degree, 0) + 1);
        }

        // 统计性别人数
        for (Map.Entry<String, Integer> entry : sexCountMap.entrySet()) {
            Map<String, Object> responseEntry = new HashMap<>();
            responseEntry.put("name", entry.getKey());
            responseEntry.put("value", entry.getValue());
            responseList.add(responseEntry);
        }

        return R.ok(responseList);
    }

    @ApiOperation("统计部门")
    @GetMapping(value = "/dept_count")
    public R deptCount() {
        List<Map<String, Object>> responseList = new ArrayList<>();

        // 获取员工列表
        List<Employee> employeeList = employeeService.list();

        // 统计各部门人数的Map
        Map<String, Integer> deptCountMap = new HashMap<>();

        // 遍历员工列表，统计各部门人数
        for (Employee employee : employeeList) {
            String degree = employee.getDeptName();

            // 更新部门人数统计
            deptCountMap.put(degree, deptCountMap.getOrDefault(degree, 0) + 1);
        }

        // 统计部门人数
        for (Map.Entry<String, Integer> entry : deptCountMap.entrySet()) {
            Map<String, Object> responseEntry = new HashMap<>();
            responseEntry.put("name", entry.getKey());
            responseEntry.put("value", entry.getValue());
            responseList.add(responseEntry);
        }

        return R.ok(responseList);
    }

    @ApiOperation("统计学历")
    @GetMapping(value = "/degree_count")
    public R degreeConut() {
        List<Map<String, Object>> responseList = new ArrayList<>();

        // 获取员工列表
        List<Employee> employeeList = employeeService.list();

        // 统计各学历人数的Map
        Map<String, Integer> degreeCountMap = new HashMap<>();

        // 遍历员工列表，统计各学历人数
        for (Employee employee : employeeList) {
            String degree = employee.getEmpDegreeName();

            // 更新学历人数统计
            degreeCountMap.put(degree, degreeCountMap.getOrDefault(degree, 0) + 1);
        }

        // 统计学历人数
        for (Map.Entry<String, Integer> entry : degreeCountMap.entrySet()) {
            Map<String, Object> responseEntry = new HashMap<>();
            responseEntry.put("name", entry.getKey());
            responseEntry.put("value", entry.getValue());
            responseList.add(responseEntry);
        }

        return R.ok(responseList);
    }
}
