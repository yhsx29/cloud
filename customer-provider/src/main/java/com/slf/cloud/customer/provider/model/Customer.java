package com.slf.cloud.customer.provider.model;

import com.baomidou.mybatisplus.annotation.KeySequence;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.Version;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author slf
 * @since 2020-04-09
 */

@Data
@TableName("customer")
@KeySequence("Sustomer_SEQ")
public class Customer implements Serializable {

	private static final long serialVersionUID = 1L;



    /* ID*/
	@TableId(value="id", type= IdType.INPUT)
	private Integer id;


    /* 姓名*/
	private String name;


    /* 密码*/
	private String password;


    /* 年龄*/
	private Integer age;


    /* 性别*/
	private String sex;


    /* 手机号*/
	private String phone;


    /* 证件号*/
	private String idNumber;


    /* 证件类型*/
	private String idType;


    /* 邮箱*/
	private String email;


}
