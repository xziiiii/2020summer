package edu.bjtu.summer.service;

import edu.bjtu.summer.mapper.StoreMapper;
import edu.bjtu.summer.model.Store;
import edu.bjtu.summer.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class StoreService {

    public List<Store> getStoreListWithLimit(int left, int right){
        SqlSession sqlSession = MybatisUtil.getSession();
        StoreMapper storeMapper = sqlSession.getMapper(StoreMapper.class);

        return storeMapper.getStoreListWithLimit(left, right - left + 1);
    }

    public List<Store> getStoreListByManagerId(int manager_id){
        SqlSession sqlSession = MybatisUtil.getSession();
        StoreMapper storeMapper = sqlSession.getMapper(StoreMapper.class);

        return storeMapper.getStoreListByManagerId(manager_id);
    }

    public int addStore(Store store){
        SqlSession sqlSession = MybatisUtil.getSession();
        StoreMapper storeMapper = sqlSession.getMapper(StoreMapper.class);

        int store_id = storeMapper.getMaxStoreId() + 1;
        store.setStore_id(store_id);

        boolean result = storeMapper.insertStore(store);
        sqlSession.commit();
        sqlSession.close();

        if (result){
            return store_id;
        }else{
            return -1;
        }
    }

    public boolean updateStore(Store store){
        SqlSession sqlSession = MybatisUtil.getSession();
        StoreMapper storeMapper = sqlSession.getMapper(StoreMapper.class);

        boolean result = storeMapper.updateStore(store);
        sqlSession.commit();
        sqlSession.close();

        return result;
    }

    public boolean deleteStore(int store_id){
        SqlSession sqlSession = MybatisUtil.getSession();
        StoreMapper storeMapper = sqlSession.getMapper(StoreMapper.class);

        boolean result = storeMapper.deleteStore(store_id);
        sqlSession.commit();
        sqlSession.close();

        return result;
    }
}
