package cn.ly.mvntest.mapper;

import cn.ly.mvntest.pojo.Dept;

import java.util.List;

/**
 * @author ly@雪夜梅花香
 * @create 2023-01-12-16:30
 */
public interface DeptMapper {
    Dept getDeptByDeptno(int deptno);
    List<Dept> getDepts();
}
