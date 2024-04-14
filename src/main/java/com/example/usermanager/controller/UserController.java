package com.example.usermanager.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.usermanager.entity.User;
import com.example.usermanager.entity.UserSearch;
import com.example.usermanager.mapper.UserMapper;
import com.example.usermanager.util.ResultUtil;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Marsli
 * @since 2024-04-09
 */

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {
    //依赖注入
    @Resource
    private UserMapper userMapper;

    //查询所有未被删除的用户信息
    @GetMapping("/getAllUsers")
    public Object getAllUsers(){
        List<User> users = userMapper.selectList(null);
        return ResultUtil.isSuccess(users);

    }

    //增加用户
    @PostMapping("/addUser")
    public Object addUser(@RequestBody User user){
        int i =userMapper.insert(user);
        if(i==1){
            return ResultUtil.isSuccess("添加成功",null);
        }else{
            return ResultUtil.isFail(500,"添加失败");
        }
    }

    //更新用户
    @PostMapping("/updateUser")
    public Object updateUser(@RequestBody User user){
        int i =userMapper.updateById(user);
        if(i==1){
            return ResultUtil.isSuccess("更新成功",null);
        }else{
            return ResultUtil.isFail(500,"更新失败");
        }
    }

    //删除用户，逻辑删除,deleted改为1,实际上并未删除
    @PostMapping("/delUser")
    public Object delUser(Integer userId){
        int i =userMapper.deleteById(userId);
        if(i==1){
            return ResultUtil.isSuccess("删除成功",null);
        }else{
            return ResultUtil.isFail(500,"删除失败");
        }
    }

    //多条件分页查询
    @RequestMapping("/getAllUserByCon")
    public Object getAllUserByCon(@RequestBody UserSearch userSearch){
        //分页对象
        Page<User> page=new Page<>(userSearch.getPageNo(),userSearch.getPageSize());
        //条件构造器
        QueryWrapper<User> wrapper=new QueryWrapper<>();

        //like：模糊查询
        if(userSearch.getUserName()!=null&&!userSearch.getUserName().equals("")){
            wrapper.like("username",userSearch.getUserName());
        }
        if(userSearch.getRoleId()!=null){
            wrapper.eq("roleId",userSearch.getRoleId());
        }
        List<User> users = userMapper.selectList(page, wrapper);//多条件分页后的数据
        System.out.println("总记录数："+page.getTotal());
        return ResultUtil.isSuccess(users);
    }



}
