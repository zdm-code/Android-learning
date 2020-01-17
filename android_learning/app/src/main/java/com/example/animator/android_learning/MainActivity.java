package com.example.animator.android_learning;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.animator.utils.Calculator;
import com.example.animator.utils.IsSecondNumZero;

public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    TextView textView;
    Button btn_1;
    Button btn_2;
    Button btn_3;
    Button btn_4;
    Button btn_5;
    Button btn_6;
    Button btn_7;
    Button btn_8;
    Button btn_9;
    Button btn_10;
    Button btn_11;
    Button btn_12;
    Button btn_13;
    Button btn_14;
    Button btn_15;
    Button btn_16;
    Button btn_17;
    Button btn_18;
    Button btn_19;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView= (TextView) findViewById(R.id.tv_show);
        btn_1= (Button) findViewById(R.id.btn_1);
        btn_2= (Button) findViewById(R.id.btn_2);
        btn_3= (Button) findViewById(R.id.btn_3);
        btn_4= (Button) findViewById(R.id.btn_4);
        btn_5= (Button) findViewById(R.id.btn_5);
        btn_6= (Button) findViewById(R.id.btn_6);
        btn_7= (Button) findViewById(R.id.btn_7);
        btn_8= (Button) findViewById(R.id.btn_8);
        btn_9= (Button) findViewById(R.id.btn_9);
        btn_10= (Button) findViewById(R.id.btn_10);
        btn_11= (Button) findViewById(R.id.btn_11);
        btn_12= (Button) findViewById(R.id.btn_12);
        btn_13= (Button) findViewById(R.id.btn_13);
        btn_14= (Button) findViewById(R.id.btn_14);
        btn_15= (Button) findViewById(R.id.btn_15);
        btn_16= (Button) findViewById(R.id.btn_16);
        btn_17= (Button) findViewById(R.id.btn_17);
        btn_18= (Button) findViewById(R.id.btn_18);
        btn_19= (Button) findViewById(R.id.btn_19);

        btn_1.setOnClickListener(this);
        btn_2.setOnClickListener(this);
        btn_3.setOnClickListener(this);
        btn_4.setOnClickListener(this);
        btn_5.setOnClickListener(this);
        btn_6.setOnClickListener(this);
        btn_7.setOnClickListener(this);
        btn_8.setOnClickListener(this);
        btn_9.setOnClickListener(this);
        btn_10.setOnClickListener(this);
        btn_11.setOnClickListener(this);
        btn_12.setOnClickListener(this);
        btn_13.setOnClickListener(this);
        btn_14.setOnClickListener(this);
        btn_15.setOnClickListener(this);
        btn_16.setOnClickListener(this);
        btn_17.setOnClickListener(this);
        btn_18.setOnClickListener(this);
        btn_19.setOnClickListener(this);



    }


    //根据手机的分辨率从dp单位转换成px单位
    public static int dip2px(Context context,float dpValue){
        //获取当前手机的像素密度
        final float scale=context.getResources().getDisplayMetrics().density;
        return (int)(dpValue*scale+0.5f); //四舍五入取整
    }

    //根据手机的分辨率从px单位转换成dp单位
    public static int px2dip(Context context,float pxValue){
        //获取当前手机的像素密度
        final float scale=context.getResources().getDisplayMetrics().density;
        return (int)(pxValue/scale+0.5f); //四舍五入取整
    }

    public static int getScreenWidth(Context context){
        //从系统服务中获取窗口管理器
        WindowManager windowManager=(WindowManager)context.getSystemService(context.WINDOW_SERVICE);
        DisplayMetrics displayMetrics=new DisplayMetrics();
        //从默认显示器中获取显示参数保存到displayMetrics对象中
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels; //返回屏幕的宽度数值
    }

    public static int getScreenHeight(Context context){
        //从系统服务中获取窗口管理器
        WindowManager windowManager=(WindowManager)context.getSystemService(context.WINDOW_SERVICE);
        DisplayMetrics displayMetrics=new DisplayMetrics();
        //从默认显示器中获取显示参数保存到displayMetrics对象中
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.heightPixels; //返回屏幕的高度数值
    }

    public static float getScreenDensity(Context context){
        //从系统服务中获取窗口管理器
        WindowManager windowManager=(WindowManager)context.getSystemService(context.WINDOW_SERVICE);
        DisplayMetrics displayMetrics=new DisplayMetrics();
        //从默认显示器中获取显示参数保存到displayMetrics对象中
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.density; //返回屏幕的高度数值
    }

    @Override
    public void onClick(View view) {
        String text=textView.getText().toString();
        String[] number=text.split("[+|-|*|/|=]");
        String lastnumber="";
        if(number.length>0)
            lastnumber=number[number.length-1];
        switch (view.getId()){
            case R.id.btn_1:
            case R.id.btn_16://删除数字键，计算完毕后点击全部清除，表达式书写中则去除最后一个字符
                if(text.contains("=")){
                    textView.setText("");
                }else {
                    if (text.length() > 0)
                        textView.setText(text.substring(0, text.length() - 1));
                }
                break;
            case R.id.btn_2:
                //除号键，判定是否计算完成，若完成则取结果继续运算
                if(text.length()>0) {
                    if(text.contains("=")){
                        textView.setText(lastnumber+"/");
                    }
                    //判断前面字符是否为符号，若是，则将其改为当前输入符号（注意两符号不能同时出现）
                    else {
                        if (text.substring(text.length() - 1).equals("+") == false && text.substring(text.length() - 1).equals("-") == false && text.substring(text.length() - 1).equals("*") == false &&
                                text.substring(text.length() - 1).equals("/") == false && text.substring(text.length() - 1).equals(".") == false)
                            textView.setText(text + "/");
                        else if (text.substring(text.length() - 1).equals("+") == true || text.substring(text.length() - 1).equals("-") == true || text.substring(text.length() - 1).equals("*") == true ||
                                text.substring(text.length() - 1).equals("/") == true)
                            textView.setText(text.substring(0, text.length() - 1) + "/");
                    }
                }
                break;
            case R.id.btn_3:
                //乘号键，用法大致同除号
                if(text.length()>0) {
                    if(text.contains("=")){
                        textView.setText(lastnumber+"*");
                    }
                    else {
                        if (text.substring(text.length() - 1).equals("+") == false && text.substring(text.length() - 1).equals("-") == false && text.substring(text.length() - 1).equals("*") == false &&
                                text.substring(text.length() - 1).equals("/") == false && text.substring(text.length() - 1).equals(".") == false)
                            textView.setText(text + "*");
                        else if (text.substring(text.length() - 1).equals("+") == true || text.substring(text.length() - 1).equals("-") == true || text.substring(text.length() - 1).equals("*") == true ||
                                text.substring(text.length() - 1).equals("/") == true)
                            textView.setText(text.substring(0, text.length() - 1) + "*");
                    }
                }
                break;
            case R.id.btn_4:
                //全部清除键
                textView.setText("");
                break;
            case R.id.btn_5:
                //数字7，判断组合数字首位是否为0，若是，则将其置为7,下面数字用法类似
                if(text.contains("="))
                {
                    textView.setText("7");
                }else if((text.length()>2&&text.charAt(text.length()-1)=='0'&&isOperation(text.charAt(text.length()-2)))||(text.length()==1&&text.charAt(0)=='0'))
                {
                    textView.setText(text.substring(0, text.length() - 1) + "7");
                }else
                    textView.setText(text+"7");
                break;
            case R.id.btn_6:
                if(text.contains("="))
                {
                    textView.setText("8");
                }else if((text.length()>2&&text.charAt(text.length()-1)=='0'&&isOperation(text.charAt(text.length()-2)))||(text.length()==1&&text.charAt(0)=='0'))
                {
                    textView.setText(text.substring(0, text.length() - 1) + "8");
                }else
                    textView.setText(text+"8");
                break;
            case R.id.btn_7:
                if(text.contains("="))
                {
                    textView.setText("9");
                }else if((text.length()>2&&text.charAt(text.length()-1)=='0'&&isOperation(text.charAt(text.length()-2)))||(text.length()==1&&text.charAt(0)=='0'))
                {
                    textView.setText(text.substring(0, text.length() - 1) + "9");
                }else
                    textView.setText(text+"9");
                break;
            case R.id.btn_8:
                if(text.length()>0) {
                    if(text.contains("=")){
                        textView.setText(lastnumber+"+");
                    }
                    else {
                        if (text.substring(text.length() - 1).equals("+") == false && text.substring(text.length() - 1).equals("-") == false && text.substring(text.length() - 1).equals("*") == false &&
                                text.substring(text.length() - 1).equals("/") == false && text.substring(text.length() - 1).equals(".") == false)
                            textView.setText(text + "+");
                        else if (text.substring(text.length() - 1).equals("+") == true || text.substring(text.length() - 1).equals("-") == true || text.substring(text.length() - 1).equals("*") == true ||
                                text.substring(text.length() - 1).equals("/") == true)
                            textView.setText(text.substring(0, text.length() - 1) + "+");
                    }
                }
                break;
            case R.id.btn_9:
                if(text.contains("="))
                {
                    textView.setText("4");
                }else if((text.length()>2&&text.charAt(text.length()-1)=='0'&&isOperation(text.charAt(text.length()-2)))||(text.length()==1&&text.charAt(0)=='0'))
                {
                    textView.setText(text.substring(0, text.length() - 1) + "4");
                }else
                    textView.setText(text+"4");
                break;
            case R.id.btn_10:
                if(text.contains("="))
                {
                    textView.setText("5");
                }else if((text.length()>2&&text.charAt(text.length()-1)=='0'&&isOperation(text.charAt(text.length()-2)))||(text.length()==1&&text.charAt(0)=='0'))
                {
                    textView.setText(text.substring(0, text.length() - 1) + "5");
                }else
                    textView.setText(text+"5");
                break;
            case R.id.btn_11:
                if(text.contains("="))
                {
                    textView.setText("6");
                }else if((text.length()>2&&text.charAt(text.length()-1)=='0'&&isOperation(text.charAt(text.length()-2)))||(text.length()==1&&text.charAt(0)=='0'))
                {
                    textView.setText(text.substring(0, text.length() - 1) + "6");
                }else
                    textView.setText(text+"6");
                break;
            case R.id.btn_12:
                if(text.length()>0) {
                    if(text.contains("=")){
                        textView.setText(lastnumber+"-");
                    }
                    else {
                        if (text.substring(text.length() - 1).equals("+") == false && text.substring(text.length() - 1).equals("-") == false && text.substring(text.length() - 1).equals("*") == false &&
                                text.substring(text.length() - 1).equals("/") == false && text.substring(text.length() - 1).equals(".") == false)
                            textView.setText(text + "-");
                        else if (text.substring(text.length() - 1).equals("+") == true || text.substring(text.length() - 1).equals("-") == true || text.substring(text.length() - 1).equals("*") == true ||
                                text.substring(text.length() - 1).equals("/") == true)
                            textView.setText(text.substring(0, text.length() - 1) + "-");
                    }
                }
                break;
            case R.id.btn_13:
                if(text.contains("="))
                {
                    textView.setText("1");
                }else if((text.length()>2&&text.charAt(text.length()-1)=='0'&&isOperation(text.charAt(text.length()-2)))||(text.length()==1&&text.charAt(0)=='0'))
                {
                    textView.setText(text.substring(0, text.length() - 1) + "1");
                }else
                    textView.setText(text+"1");
                break;
            case R.id.btn_14:
                if(text.contains("="))
                {
                    textView.setText("2");
                }else if((text.length()>2&&text.charAt(text.length()-1)=='0'&&isOperation(text.charAt(text.length()-2)))||(text.length()==1&&text.charAt(0)=='0'))
                {
                    textView.setText(text.substring(0, text.length() - 1) + "2");
                }else
                    textView.setText(text+"2");
                break;
            case R.id.btn_15:
                if(text.contains("="))
                {
                    textView.setText("3");
                }else if((text.length()>2&&text.charAt(text.length()-1)=='0'&&isOperation(text.charAt(text.length()-2)))||(text.length()==1&&text.charAt(0)=='0'))
                {
                    textView.setText(text.substring(0, text.length() - 1) + "3");
                }else
                    textView.setText(text+"3");
                break;
            case R.id.btn_17:
                if(text.contains("="))
                {
                    textView.setText("0");
                }else {
                    //判断当前数字是否仅为“0”，即不包含小数点，数字头不能出现多个0
                    if (lastnumber.equals("0") == false)
                        textView.setText(text + "0");
                }
                break;
            case R.id.btn_18:
                //小数点，判断是否计算完成，若是，则打印0.
                if(text.contains("="))
                {
                    textView.setText("0.");
                }else if(lastnumber.contains(".")==false){//保证同一数字里只有一个小数点
                    if (text.length() > 0) {
                        if (text.substring(text.length() - 1).equals("+") == false && text.substring(text.length() - 1).equals("-") == false && text.substring(text.length() - 1).equals("*") == false &&
                                text.substring(text.length() - 1).equals("/") == false && text.substring(text.length() - 1).equals(".") == false)
                            textView.setText(text + ".");
                        else if (text.substring(text.length() - 1).equals("+") == true || text.substring(text.length() - 1).equals("-") == true || text.substring(text.length() - 1).equals("*") == true ||
                                text.substring(text.length() - 1).equals("/") == true)
                            textView.setText(text + "0.");
                    } else {
                        textView.setText("0.");
                    }
                }
                break;
            case R.id.btn_19:
                if(text.contains("=")==false) {
                    if (IsSecondNumZero.isAvailable(text + "=")) {//判断除法是除数为0的情况
                        Toast.makeText(MainActivity.this, "除数不能为0", Toast.LENGTH_LONG).show();
                    } else {//通过栈进行结果运算
                        Calculator calculator = new Calculator();
                        String result = calculator.convertDoubleToString(calculator.calculate(text));
                        textView.setText(text + "=" + result);
                    }
                }
                break;
        }
    }

    public boolean isOperation(char c){
        return c=='+'||c=='-'||c=='*'||c=='/';
    }
}
