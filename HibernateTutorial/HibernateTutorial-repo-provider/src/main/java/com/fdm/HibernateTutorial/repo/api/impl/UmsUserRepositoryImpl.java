package com.fdm.HibernateTutorial.repo.api.impl;


import com.fdm.HibernateTutorial.repo.api.UmsUserRepository;
import cn.org.thinkcloud.repo.base.service.api.impl.BaseRepositoryImpl;
import org.apache.dubbo.config.annotation.DubboService;
import com.fdm.HibernateTutorial.domain.UmsUser;
import com.fdm.HibernateTutorial.repo.mapper.UmsUserMapper;

/**
 * @author : zhangqian9158@gmail.com
 */
@DubboService(version = "1.0.0")
public class UmsUserRepositoryImpl extends BaseRepositoryImpl<UmsUserMapper, UmsUser> implements UmsUserRepository {

}
