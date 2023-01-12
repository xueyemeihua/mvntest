package cn.ly.mvntest.dao;

import cn.ly.mvntest.mapper.EmpMapper;
import cn.ly.mvntest.pojo.Emp;
import cn.ly.mvntest.util.XmlUtil;

/**
 * @author ly@雪夜梅花香
 * @create $(YEAR)-$(MONTH)-$(DAY)-$(TIME)
 */
public class EmpDaoImpl extends BaseDao<Emp> implements EmpMapper {
    @Override
    public Emp getEmpByEmpno(int empno) {
        return super.getOne(XmlUtil.mapperMap.get("empmaper.getEmpByEmpno").getSql(), empno);
    }
}
