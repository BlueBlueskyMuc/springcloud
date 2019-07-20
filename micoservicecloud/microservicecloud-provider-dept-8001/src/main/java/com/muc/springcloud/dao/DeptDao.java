package com.muc.springcloud.dao;

import com.muc.springcloud.entities.Dept;

import java.util.List;

public interface DeptDao {

    public boolean addDept(Dept dept);

    public Dept findById(Long id);

    public List<Dept> findAll();
}
