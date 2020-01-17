package com.example.animator.utils;

import android.util.Log;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Created by animator on 2020/1/14.
 */
public class IsSecondNumZero {
    public static boolean isAvailable(String str){
        ArrayList<Integer> divlist=new ArrayList<>();//储存除号索引
        ArrayList<Integer> alllist=new ArrayList<>();//储存所有运算符索引

        for(int i=0;i<str.length();i++)
        {
            if(str.charAt(i)=='/')
            {
                divlist.add(i);
                alllist.add(i);
            }
            else if(str.charAt(i)=='+'||str.charAt(i)=='-'||str.charAt(i)=='*'||str.charAt(i)=='=')
            {
                alllist.add(i);
            }
        }
        Log.v("divsize",divlist.size()+"");
        Log.v("allsize",alllist.size()+"");
        for(int i=0;i<divlist.size();i++){
            String string=str.substring(divlist.get(i)+1,alllist.get(alllist.indexOf(divlist.get(i)) + 1));
            BigDecimal num = new BigDecimal(string);
            if(num.compareTo(new BigDecimal("0"))==0)
                return true;
        }
        return false;

    }
}
