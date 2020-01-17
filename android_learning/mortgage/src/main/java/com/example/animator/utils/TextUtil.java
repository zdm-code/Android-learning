package com.example.animator.utils;

/**
 * Created by animator on 2020/1/16.
 */
public class TextUtil {
    public static boolean isNum(String string){
        int flag=0;
        if(string.charAt(0)=='0'&&string.charAt(1)!='.')
            return false;
        if(string.charAt(0)=='.')
            return false;
        for(int i=0;i<string.length();i++)
        {
            if((string.charAt(i)<'0'||string.charAt(i)>'9')&&string.charAt(i)!='.')
                return false;
            else if(string.charAt(i)=='.')
            {
                flag++;
                if(flag>1)
                    return false;
            }
        }
        return true;
    }
}
