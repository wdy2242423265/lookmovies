package com.qhit.lookMovies.controller; 

import com.qhit.lookActor.controller.LookActorController;
import com.qhit.lookActor.pojo.LookActor;
import com.qhit.lookCategory.controller.LookCategoryController;
import com.qhit.lookCategory.pojo.LookCategory;
import com.qhit.lookMovies.pojo.LookMovies;
import com.qhit.lookMovies.service.ILookMoviesService;
import com.qhit.lookSecondcategory.controller.LookSecondcategoryController;
import com.qhit.lookSecondcategory.pojo.LookSecondcategory;
import com.qhit.utils.StringUtils;
import com.qhit.utils.ZhongWenToPinYin;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.DecimalFormat;
import java.text.Format;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RestController;

/** 
* Created by GeneratorCode on 2019/05/06
*/ 

@RestController 
@RequestMapping("/lookMovies")
public class LookMoviesController { 

    @Resource 
    ILookMoviesService lookMoviesService;
    @Resource
    LookActorController lookActorController;
    @Resource
    LookCategoryController lookCategoryController;
    @Resource
    LookSecondcategoryController lookSecondcategoryController;

    @RequestMapping("/insert") 
    public void insert(LookMovies lookMovies) { 
        lookMoviesService.insert(lookMovies); 
    } 

    @RequestMapping("/delete") 
    public void delete(Integer moviesid) { 
        lookMoviesService.delete(moviesid); 
    } 

    @RequestMapping("/update") 
    public void update(LookMovies lookMovies) { 
        lookMoviesService.update(lookMovies); 
    } 

    @RequestMapping("/updateSelective") 
    public void updateSelective(LookMovies lookMovies) { 
        lookMoviesService.updateSelective(lookMovies); 
    } 

    @RequestMapping("/load") 
    public LookMovies load(Integer moviesid) { 
        LookMovies lookMovies = lookMoviesService.findById(moviesid); 
        return lookMovies; 
    } 

    @RequestMapping("/list") 
    public List<LookMovies> list(HttpSession session)  {
        session.setAttribute("test","test");
        List<LookMovies> list = lookMoviesService.findAll(); 
        return list; 
    } 

    @RequestMapping("/search")
    public List<LookMovies> search(LookMovies lookMovies) {
        List<LookMovies> list = lookMoviesService.search(lookMovies);
        return list;
    }

    //        data[
//                    {moviesid:,ctaegoryid:}
//                ];
    @RequestMapping("/LookMoviesPinYin")
    public List<LookMovies> LookMoviesPinYin(String string) {
        //汉字转拼音
        StringUtils stringUtils = new StringUtils();
        String[] pinyinStr = stringUtils.toPinyinArray(string);
        //汉字转拼音的长度
        int pinyinStrLen =pinyinStr.length;
        //查询所有视频
        List<LookMovies> list = lookMoviesService.findAll();
        List<LookMovies> NewList = new ArrayList<>();
        //便利出所有视频的拼音名
        for (int i=0; i<list.size(); i++){
            int equalCount =0;
            double selectOK=0;
            int MovieNamePinYinLen=0;
            //第i个视频的拼音名
            String MoviePinyinName = list.get(i).getPinyin();
            //视频的拼音名不为空
            if (MoviePinyinName!=null){
                //视频拼音名里 找 pinyinStr数组里的每个字的拼音，如果找的到相似次数就+1
                for (int j=0; j<pinyinStr.length; j++){
                    if (MoviePinyinName.indexOf(pinyinStr[j])!=-1){
                        equalCount++;
                    }
                }
                //如果视频拼音名里面能找到pinyinStr数组里的所有拼音
                if (equalCount==pinyinStrLen){
                    //视频拼音名的长度
                    MovieNamePinYinLen=MoviePinyinName.length();
                    //相似率:相似次数/视频拼音名的长度
                    selectOK =(double)equalCount/MovieNamePinYinLen;
//                    System.out.println(selectOK);
                    // 1/20=0.05 （在片名长度20字以内 如果有一个字相同就能找的到）
                    if (selectOK>=0.05){
                        NewList.add(list.get(i));
                    }
                }
            }
        }
        return NewList;
    }
    @RequestMapping("/selectOverall")
    public List<Map> selectAll(String string) {
        Map<Object,Object> map = null;
        List data = new ArrayList();
//        data:[
//            {id:,type:},
//            {},
//                ]
        //视频
        List<LookMovies> MoviesList = LookMoviesPinYin(string);
        if (MoviesList.size()!=0){
            for (int i=0; i<MoviesList.size(); i++){
                map=new HashMap();
                map.put("id",MoviesList.get(i).getMoviesid());
                map.put("type",MoviesList.get(i).getCategoryid());
                data.add(map);
            }
        }
        //一级分类
        List<LookCategory> CategoryList = lookCategoryController.LookCategoryPinYin(string);
        if (CategoryList.size()!=0){
            for (int i=0; i<CategoryList.size(); i++){
                map=new HashMap<>();
                map.put("id",CategoryList.get(i).getMoviesid());
                map.put("type",CategoryList.get(i).getCategoryid());
                data.add(map);
            }
        }
        //二级分类
        List<LookSecondcategory> SecondcategoryList = lookSecondcategoryController.LookMoviesPinYin(string);
        if (SecondcategoryList.size()!=0){
            for (int i=0; i<SecondcategoryList.size(); i++){
                map=new HashMap<>();
                map.put("id",SecondcategoryList.get(i).getMoviesid());
                map.put("type",SecondcategoryList.get(i).getCategoryid());
                data.add(map);
            }
        }
        //演员
        List<LookActor> ActorsList = lookActorController.LookActorPinYin(string);
        if (ActorsList.size()!=0){
            for (int i=0; i<ActorsList.size(); i++){
                map=new HashMap<>();
                map.put("id",ActorsList.get(i).getMoviesid());
                map.put("type",ActorsList.get(i).getCategoryid());
                data.add(map);
            }
        }
        return data;
    }




} 
