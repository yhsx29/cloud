package com.slf.cloud.parent.base.service.impl;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.slf.cloud.parent.base.service.BaseService;

/**
 * @ClassName BaseServiceImpl
 * @Version @Date       @Author  @Description
 * 1.0      2020-04-08  Slf        服务层实现基础父类
 **/
public class BaseServiceImpl<M extends BaseMapper<T>, T> extends ServiceImpl<BaseMapper<T>,T> implements BaseService<T>{
}
