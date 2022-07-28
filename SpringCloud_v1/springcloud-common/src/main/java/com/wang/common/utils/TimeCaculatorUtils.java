package com.wang.common.utils;

import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Scanner;

@Slf4j
public class TimeCaculatorUtils {

    /**
     *
     * @param gb 文件大小
     * @param rate MB/s(通常情况下)
     * @return
     */
    public static String getDownLoadRemainTime(Double gb,Double rate){
        Double time = gb*1024/rate/3600;
        int i=0;
        while (time>=1){
            time-=1;
            i++;
        }
        time = time*60;
        Long timeInt = time.longValue();
        Double timeDouble = time-timeInt;
        StringBuilder sb = new StringBuilder();
//        sb.append(i).append("h").append(new DecimalFormat("0.00").format(time*60)).append("min");
        sb.append(i).append("h").append(new BigDecimal(timeInt).setScale(3,BigDecimal.ROUND_HALF_UP).doubleValue()).append("min").append(timeDouble).append("s");

        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("请输入剩余空间（GB）");
        Double d1 = in.nextDouble();
        System.out.println("请输入下载速度（MB/s）");
        Double d2 = in.nextDouble();
        log.info("剩余下载量: {}GB，下载速度: {}MB/s，剩余时间: {}",d1,d2,getDownLoadRemainTime(d1,d2));
    }

}
