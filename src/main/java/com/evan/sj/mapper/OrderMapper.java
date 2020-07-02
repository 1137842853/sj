package com.evan.sj.mapper;

import com.evan.sj.pojo.Datas;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface OrderMapper {
    @Select("select count(orid) AS data,ostaid AS label FROM ordertable GROUP BY ostaid") //3
    List<Datas> get();

    @Select("select count(orid) AS data,ostaid AS label FROM ordertable GROUP BY ostaid") //3
    List<Map<String, Datas>> get1();

    @Select("select count(orid) AS data,(case Month(orftime) when '1' then '1月' \n" +
            "when '2' then '2月'\n" +
            "when '3' then '3月'\n" +
            "when '4' then '4月'\n" +
            "when '5' then '5月'\n" +
            "when '6' then '6月'\n" +
            "when '7' then '7月'\n" +
            "when '8' then '8月'\n" +
            "when '9' then '9月'\n" +
            "when '10' then '10月'\n" +
            "when '11' then '11月'\n" +
            "when '12' then '12月' end) AS label FROM ordertable GROUP BY Month(orftime)") //3
    List<Map<String, Datas>> get2();
}
