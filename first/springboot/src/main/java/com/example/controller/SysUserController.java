package com.example.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.entity.SysUser;
import com.example.service.ISysUserService;
import com.example.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
@Api(tags = "用户")
@RequestMapping("/user")
public class SysUserController {

    @Resource
    private ISysUserService sysUserService;

    @PostMapping("/login")
    @ApiOperation("登录")
    public R login(@RequestBody SysUser sysUser) {
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name",sysUser.getName());
        SysUser loginUser = sysUserService.getOne(queryWrapper);

        if (loginUser == null) {
            return R.fail("用户不存在");
        }
        if (!loginUser.getPassword().equals(sysUser.getPassword())) {
            return R.fail("密码错误");
        }

        Map<String, Object> map = new HashMap<>();
        map.put("token", "admin-token");
        return R.ok(map);
    }

    @GetMapping("/info")
    @ApiOperation("用户信息")
    public R info(@RequestParam(name = "token", required = true) String token) {
        if (Objects.equals(token, "admin-token")) {
            QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("name", "admin");
            SysUser loginUser = sysUserService.getOne(queryWrapper);

            Map<String, Object> map = new HashMap<>();
            map.put("roles", loginUser.getRoles());
            map.put("name", loginUser.getName());
            map.put("avatar", loginUser.getAvatar());
            return R.ok(map);
        }
        return R.fail("token不正确");
    }
}
