package com.ztianzeng.learn.jvm.Spring循环依赖;

public class AServiceImpl implements AService {
    BService bService;

    public void setbService(BService bService) {
        this.bService = bService;
    }

    @Override
    public void a() {
        System.out.println("aaaaaaa");
        bService.b();
    }
}
