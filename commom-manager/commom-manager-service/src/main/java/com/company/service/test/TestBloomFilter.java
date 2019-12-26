package com.company.service.test;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

import java.nio.charset.Charset;
import java.util.*;

/**
 * @author yl
 * @date 2019-08-27
 */
public class TestBloomFilter {

    public static void main(String[] args) {

        List<String> list= Arrays.asList("a","b","c","d","c","e","c","e","c","f","c","f","c","g","c","g","c","h","h","i");

        BloomFilter<String> bloomFilter=BloomFilter.create(Funnels.stringFunnel(Charset.forName("utf-8")),100,0.001);

        long timeMillis1 = System.currentTimeMillis();
        list.stream().forEach(s -> {
//            System.out.println(s);
//            当mightContain返回True时，可以99%确定元素在集合中，有1%的False Positive误判率；  初始化的时候有误判的概率
//            当mightContain返回False时，可以100%肯定元素不在集合中。
            if (!bloomFilter.mightContain(s)){
                bloomFilter.put(s);

            }else {
            }
        });
        long timeMillis2 = System.currentTimeMillis();
        System.out.println(timeMillis2-timeMillis1+"=耗时ms"); //57=耗时ms

        //set 更快
        Set<String> set =new HashSet<>();
         timeMillis1 = System.currentTimeMillis();
        list.stream().forEach(s -> {
            set.add(s);
        });
         timeMillis2 = System.currentTimeMillis();
        System.out.println(timeMillis2-timeMillis1+"=耗时ms");//1=耗时ms


    }
}
