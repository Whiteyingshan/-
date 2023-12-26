package com.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.entity.Employee;
import com.example.mapper.EmployeeMapper;
import com.example.service.IEmployeeService;
import org.springframework.stereotype.Service;

@Service
public class EmployeeImpl extends ServiceImpl<EmployeeMapper, Employee> implements IEmployeeService {
}
