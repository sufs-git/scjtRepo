package client;

import factory.BeanFactory;
import service.IGetGoodsIdService;
import service.impl.IGetGoodsIdServiceImpl;

public class clientTest {

    public static void main(String[] args) {
        IGetGoodsIdService goodsIdService= null;
        try {
            for(int i=0;i<5;i++) {
                goodsIdService =(IGetGoodsIdService) BeanFactory.getBean("iGetGoodsIdService");
                System.out.println(goodsIdService);
            }
            goodsIdService.getId();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
