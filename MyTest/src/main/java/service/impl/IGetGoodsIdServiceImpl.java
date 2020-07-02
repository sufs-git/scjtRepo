package service.impl;

import dao.IGetGoodsId;
import factory.BeanFactory;
import service.IGetGoodsIdService;

public class IGetGoodsIdServiceImpl implements IGetGoodsIdService {

    public void getId(){
        try{
            IGetGoodsId getGoodsId = (IGetGoodsId)BeanFactory.getBean("iGetGoodsId");
            getGoodsId.getId();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
