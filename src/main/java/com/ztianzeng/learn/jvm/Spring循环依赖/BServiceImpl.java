package com.ztianzeng.learn.jvm.Spring循环依赖;

public class BServiceImpl implements BService{

    AService aService;

    public void setaService(AService aService) {
        this.aService = aService;
    }

    @Override
    public void b() {
        System.out.println("bbbbbbbbb");
    }

    @Override
    public void bb() {
        aService.a();
    }
}
