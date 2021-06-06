package com.tukjax.cargo.boot.dao;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import static com.baomidou.mybatisplus.annotation.IdType.AUTO;

@TableName("book")
public class Book {

    @TableId(type = AUTO)
    private Long id;

    @TableField("NAME")
    private String name;

}
