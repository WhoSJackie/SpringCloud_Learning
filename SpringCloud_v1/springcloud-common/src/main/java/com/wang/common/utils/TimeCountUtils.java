package com.wang.common.utils;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalTime;

@Slf4j
public class TimeCountUtils implements Runnable{

    public static void main(String[] args) {
        TimeCountUtils count = new TimeCountUtils();
        Thread thread = new Thread(count);
        thread.start();
    }

    @Override
    public void run() {
        while(true){
            try{
                Thread.sleep(1000);
            } catch(Exception e){
                log.info(e.toString());
            }

            LocalTime localTime = LocalTime.now().withNano(0);
            log.info("当前时间{}",localTime);
        }
    }
}
