package com.muc.springcloud.entities;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;


@SuppressWarnings("serial")
@NoArgsConstructor // 无参
@Data // get/set
@Accessors(chain = true) // 链式操作
public class Dept implements Serializable { //必须序列化

    //主键
    private Long  deptno;

    //部门名称
    private String  dname;

    //来自那个数据库，因为微服务架构可以一个服务对应一个数据库，同一个信息被存储到不同数据库
    private String  db_source;

    public Dept(String dname) {
        this.dname = dname;
    }

}
