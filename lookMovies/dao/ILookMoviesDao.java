package com.qhit.lookMovies.dao;

import org.apache.ibatis.annotations.Mapper;
import com.qhit.lookMovies.pojo.LookMovies;
import java.util.List;

/** 
* Created by GeneratorCode on 2019/05/06
*/

@Mapper  
public interface ILookMoviesDao {

    boolean insert(Object object);

    boolean  update(Object object);

    boolean  updateSelective(Object object);

    boolean delete(Object object);

    List freeFind(String sql);

    List findAll();

    List findById(Object id);

    boolean freeUpdate(String sql);

    List<LookMovies> search(LookMovies lookMovies);

    List findByMoviesName(Object moviesName);

    List findByPinyin(Object pinyin);

    List findByDatetime(Object datetime);

    List findByGrade(Object grade);

    List findByImage(Object image);

    List findBySonImage(Object sonImage);

    List<LookMovies> selectMoviesidAndCtaegoryid(Integer moviesid);

}