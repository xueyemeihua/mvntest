package cn.ly.mvntest.mapper;

import cn.ly.mvntest.pojo.Emp;

public interface EmpMapper {
    Emp getEmpByEmpno(int empno);
    int updateEmpByEmpno(int salary,int empno);
}
