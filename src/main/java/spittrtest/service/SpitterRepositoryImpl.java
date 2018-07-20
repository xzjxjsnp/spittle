package spittrtest.service;

import lombok.Data;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.MessageDigestPasswordEncoder;
import org.springframework.stereotype.Component;
import spittrtest.dataConnection.DataConnection;
import spittrtest.exception.DuplicateSpitterException;
import spittrtest.exception.SpitterNotFoundException;
import spittrtest.model.Spitter;

import java.io.IOException;

@Data
@Component
public class SpitterRepositoryImpl implements SpitterRepository {
    private MessageDigestPasswordEncoder passwordEncoder = new MessageDigestPasswordEncoder("MD5");

    @Autowired
    private Spitter spitter;

    @Autowired
    private DataConnection dataConnection;

    public void saveSpitter(Spitter spitter) throws IOException {
        this.spitter = spitter;
        SqlSession sqlSession = dataConnection.getSqlSession();
        Spitter spitterTemp = sqlSession.selectOne("spittle.findSpitterByUsername",spitter.getUsername());
        if(spitterTemp != null){
            throw new DuplicateSpitterException();
        }
        spitter.setPassword(passwordEncoder.encodePassword(spitter.getPassword(),spitter.getUsername()));
        sqlSession.insert("spittle.insertSpitter", spitter);
        sqlSession.commit();
        sqlSession.close();
    }

    public Spitter findUser(String username) throws IOException{
        SqlSession sqlSession = dataConnection.getSqlSession();
        Spitter spitterTemp = sqlSession.selectOne("spittle.findSpitterByUsername",username);
//        if(spitterTemp == null){
//            throw new SpitterNotFoundException();
//        }
        return spitterTemp;
    }
}
