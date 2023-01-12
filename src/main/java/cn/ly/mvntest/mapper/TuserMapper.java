package cn.ly.mvntest.mapper;

import cn.ly.mvntest.pojo.Tuser;

import java.util.List;

/**
 * @author ly@雪夜梅花香
 * @create 2023-01-12-18:11
 */
public interface TuserMapper {
    int insertTuser(Tuser tuser);
    int delTuserByTid(int tid);
    int updateTuserByTid(int tage,int tid);
    Tuser getTuserByTid(int tid);
    List<Tuser> getAllTuser();
}
