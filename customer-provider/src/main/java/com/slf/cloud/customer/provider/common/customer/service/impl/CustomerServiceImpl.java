package com.slf.cloud.customer.provider.common.customer.service.impl;

import com.slf.cloud.customer.provider.common.customer.mapper.CustomerMapper;
import com.slf.cloud.customer.provider.common.customer.service.CustomerService;
import com.slf.cloud.customer.provider.model.Customer;
import com.slf.cloud.parent.base.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;


/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author slf
 * @since 2020-04-09
 */
@Service
public class CustomerServiceImpl extends BaseServiceImpl<CustomerMapper, Customer>  implements CustomerService<Customer> {


}
