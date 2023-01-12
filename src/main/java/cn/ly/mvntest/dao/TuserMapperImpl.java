package cn.ly.mvntest.dao;

import cn.ly.mvntest.mapper.TuserMapper;
import cn.ly.mvntest.pojo.Tuser;
import cn.ly.mvntest.util.XmlUtil;

import java.util.List;

/**
 * @author ly@雪夜梅花香
 * @create 2023-01-12-18:18
 */
public class TuserMapperImpl extends BaseDao<Tuser> implements TuserMapper {
    @Override
    public int insertTuser(Tuser tuser) {
        return super.executeUpdate(XmlUtil.mapperMap.get("tusermapper.insertTuser").getSql(),
                tuser.getTname(),tuser.getTpwd(),tuser.getTphone(),tuser.getTage());
    }

    @Override
    public int delTuserByTid(int tid) {
        return super.executeUpdate(XmlUtil.mapperMap.get("tusermapper.delTuserByTid").getSql(),tid);
    }

    @Override
    public int updateTuserByTid(int tage,int tid) {
        return super.executeUpdate(XmlUtil.mapperMap.get("tusermapper.updateTuserByTid").getSql(),tage,tid);
    }

    @Override
    public Tuser getTuserByTid(int tid) {
        return super.getOne(XmlUtil.mapperMap.get("tusermapper.getTuserByTid").getSql(),tid);
    }

    @Override
    public List<Tuser> getAllTuser() {
        return super.getAll(XmlUtil.mapperMap.get("tusermapper.getAllTuser").getSql());
    }
}
