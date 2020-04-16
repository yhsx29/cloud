package com.slf.cloud.customer.provider.common.customer.controller;

import com.slf.cloud.customer.provider.common.customer.service.CustomerService;
import com.slf.cloud.customer.provider.model.Customer;
import com.slf.cloud.parent.base.controller.BaseController;
import com.slf.cloud.parent.base.page.BasePage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author slf
 * @since 2020-04-09
 */
@Controller
@RequestMapping("/customer")
public class CustomerController extends BaseController {
    @Autowired private CustomerService customerService;
    
    @GetMapping("/manager")
    public String manager() {
        return "base/customer/customerList";
    }
    
    @PostMapping("/dataGrid")
    @ResponseBody
    public BasePage dataGrid(Customer customer, Integer page, Integer rows, String sort, String order) {
        BasePage basePage = new BasePage();
        customerService.page(basePage);
        return basePage;
    }
    
    /**
     * 添加页面
     * @return
     */
    @GetMapping("/addPage")
    public String addPage() {
        return "base/customer/customerAdd";
    }
    
    /**
     * 添加
     * @param 
     * @return
     */
    @PostMapping("/add")
    @ResponseBody
    public Object add(@Valid Customer customer) {

        return "add";
    }
    
    /**
     * 删除
     * @param id
     * @return
     */
    @PostMapping("/delete")
    @ResponseBody
    public Object delete(Long id) {
        return "delete";
    }
    
    /**
     * 编辑
     * @param model
     * @param id
     * @return
     */
    @GetMapping("/editPage")
    public String editPage(Model model, Long id) {
        Customer customer = (Customer) customerService.getById(id);
        model.addAttribute("customer", customer);
        return "base/customer/customerEdit";
    }
    
    /**
     * 编辑
     * @param 
     * @return
     */
    @PostMapping("/edit")
    @ResponseBody
    public Object edit(@Valid Customer customer) {
        return "edit";
    }
}
