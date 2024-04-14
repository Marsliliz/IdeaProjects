package com.example.usermanager.serviceImpl;

import com.example.usermanager.entity.User;
import com.example.usermanager.mapper.UserMapper;
import com.example.usermanager.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Marsli
 * @since 2024-04-09
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
