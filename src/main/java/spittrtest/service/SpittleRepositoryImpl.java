package spittrtest.service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import spittrtest.dataConnection.DataConnection;
import spittrtest.exception.SpittleNotFoundException;
import spittrtest.model.Spittle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Component
public class SpittleRepositoryImpl implements SpittleRepository {
    @Autowired
    MessageSource messageSource;

    @Autowired
    DataConnection dataConnection;

    public List<Spittle> findSpittle(int count) throws IOException {
        SqlSession sqlSession = dataConnection.getSqlSession();
        List<Spittle> spittles = sqlSession.selectList("spittle.findLeast10spittle",count);
        sqlSession.close();
        return spittles;
    }

    public List<Spittle> splitSpittle(long max, int count) throws IOException{
        SqlSession sqlSession = dataConnection.getSqlSession();
        int num = (int)max <= count ? (int)max : count;
        List<Spittle> spittles = sqlSession.selectList("spittle.splitSpittle",num);
        sqlSession.close();
        return spittles;
    }

    public Spittle findOneSpittle(int id) throws IOException{
        SqlSession sqlSession = dataConnection.getSqlSession();
        Spittle spittles = sqlSession.selectOne("spittle.findOneSpittle",id);
//        if(spittles == null) {
//            throw new SpittleNotFoundException();
//        }
        sqlSession.close();
        return spittles;
    }

    public Spittle insertSpittle(Spittle spittle) throws IOException{
        SqlSession sqlSession = dataConnection.getSqlSession();
        spittle.setTime(new Date());
        sqlSession.insert("spittle.insertSpittle", spittle);
        sqlSession.commit();
        sqlSession.close();
        return spittle;
    }
}
