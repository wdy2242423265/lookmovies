package com.qhit.lookMovies.pojo;


/** 
* Created by GeneratorCode on 2019/05/06
*/ 

public class LookMovies { 
    private Integer moviesid;    //视频id 
    private String moviesName;    //视频名称 
    private String pinyin;    //名称拼音 
    private String datetime;    //上传时间 
    private Integer grade;    //视频等级(1普通,2vip) 
    private String image;    //视频图片 
    private String sonImage;    //子图片

    private Integer categoryid;

    public Integer getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(Integer categoryid) {
        this.categoryid = categoryid;
    }

    public Integer getMoviesid() {
        return moviesid;
    }

    public void setMoviesid(Integer moviesid) { 
        this.moviesid = moviesid;
    } 

    public String getMoviesName() { 
        return moviesName;
    }

    public void setMoviesName(String moviesName) { 
        this.moviesName = moviesName;
    }
    public String getPinyin() { 
        return pinyin;
    }

    public void setPinyin(String pinyin) { 
        this.pinyin = pinyin;
    }
    public String getDatetime() { 
        return datetime;
    }

    public void setDatetime(String datetime) { 
        this.datetime = datetime;
    }
    public Integer getGrade() { 
        return grade;
    }

    public void setGrade(Integer grade) { 
        this.grade = grade;
    } 

    public String getImage() { 
        return image;
    }

    public void setImage(String image) { 
        this.image = image;
    }
    public String getSonImage() { 
        return sonImage;
    }

    public void setSonImage(String sonImage) { 
        this.sonImage = sonImage;
    }

 }