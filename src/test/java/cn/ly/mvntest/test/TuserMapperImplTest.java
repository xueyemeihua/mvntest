package cn.ly.mvntest.test;

import cn.ly.mvntest.dao.TuserMapperImpl;
import org.junit.Test;

/**
 * @author ly@雪夜梅花香
 * @create 2023-01-12-18:46
 */
public class TuserMapperImplTest {

    TuserMapperImpl tuserMapper = new TuserMapperImpl();
    @Test
    public void testInsertTuser() {
        //System.out.println(tuserMapper.insertTuser(new Tuser("马超", "555", "555", 23)));
        //System.out.println(tuserMapper.delTuserByTid(8));
        System.out.println(tuserMapper.updateTuserByTid(23, 4));
        System.out.println(tuserMapper.getTuserByTid(1));
        tuserMapper.getAllTuser().forEach(tuer-> System.out.println(tuer));

    }

}
