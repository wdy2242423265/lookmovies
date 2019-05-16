package com.qhit.lookMovies.service;

import java.util.List;
import com.qhit.lookMovies.pojo.LookMovies;
/**
* Created by GeneratorCode on 2019/05/06
*/
public interface ILookMoviesService {

    boolean insert(Object object);

    boolean  update(Object object);

    boolean  updateSelective(Object object);

    boolean delete(Object id);

    List findAll();

    LookMovies findById(Object id);

    List<LookMovies> search(LookMovies lookMovies);

    List<LookMovies> selectMoviesidAndCtaegoryid(Integer moviesid);
}