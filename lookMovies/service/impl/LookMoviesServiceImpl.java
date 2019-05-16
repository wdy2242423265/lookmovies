package com.qhit.lookMovies.service.impl;

import com.qhit.lookMovies.service.ILookMoviesService;
import java.util.List;
import com.qhit.lookMovies.dao.ILookMoviesDao;
import com.qhit.lookMovies.pojo.LookMovies;
import org.springframework.stereotype.Service;
import javax.annotation.Resource; 

/**
* Created by GeneratorCode on 2019/05/06
*/

@Service 
public class LookMoviesServiceImpl  implements ILookMoviesService {

    @Resource 
    ILookMoviesDao dao;

    @Override 
    public boolean insert(Object object) { 
        return dao.insert(object); 
    } 

    @Override 
    public boolean update(Object object) { 
        return dao.update(object); 
    } 

    @Override 
    public boolean updateSelective(Object object) { 
        return dao.updateSelective(object); 
    } 

    @Override 
    public boolean delete(Object id) { 
        LookMovies lookMovies = findById(id); 
        return dao.delete(lookMovies); 
    } 

    @Override 
    public List findAll() { 
        return dao.findAll(); 
    } 

    @Override 
    public LookMovies findById(Object id) { 
        List<LookMovies> list = dao.findById(id); 
        return  list.get(0); 
    } 

    @Override 
    public List<LookMovies> search(LookMovies lookMovies) { 
        return dao.search(lookMovies); 
    }

    @Override
    public List<LookMovies> selectMoviesidAndCtaegoryid(Integer moviesid) {
        return dao.selectMoviesidAndCtaegoryid(moviesid);
    }

}