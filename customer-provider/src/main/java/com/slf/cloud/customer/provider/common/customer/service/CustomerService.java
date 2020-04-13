package com.slf.cloud.customer.provider.common.customer;

import com.slf.cloud.common.model.Customer;
import com.slf.cloud.customer.provider.model.Customer;
import com.slf.cloud.parent.base.service.BaseService;
import com.chris.commons.result.PageInfo;
/**
 * <p>
 *  服务类
 * </p>
 *
 * @author slf
 * @since 2020-04-09
 */
public interface CustomerService extends BaseService<Customer> {
	 public void selectDataGrid(PageInfo pageInfo);
}
