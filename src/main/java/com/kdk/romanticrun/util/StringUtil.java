package com.kdk.romanticrun.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * StringUtil
 * @description: 字符串工具类
 **/
public class StringUtil {

    /**
     * 判断是否为空字符串最优代码
     * @param str
     * @return 如果为空，则返回true
     */
    public static boolean isEmpty(String str){
        return str == null || str.trim().length() == 0;
    }

    /**
     * 判断字符串是否非空
     * @param str 如果不为空，则返回true
     * @return
     */
    public static boolean isNotEmpty(String str){
        return !isEmpty(str);
    }

    public static String listToString(List<String> list){

        if(list==null){
            return null;
        }

        StringBuilder result = new StringBuilder();
        boolean first = true;

        //第一个前面不拼接","
        for(String string :list) {
            if(first) {
                first=false;
            }else{
                result.append(",");
            }
            result.append(string);
        }
        return result.toString();
    }

    public static List<String> stringToList(String strs){
        if(strs == null) return null;
        String[] str = strs.split(",");
        return Arrays.asList(str);
    }
}