package com.soubu.CRMProject.base.greendao;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.soubu.CRMProject.base.greendao.User;
import com.soubu.CRMProject.base.greendao.Product;
import com.soubu.CRMProject.base.greendao.Client;
import com.soubu.CRMProject.base.greendao.Clue;

import com.soubu.CRMProject.base.greendao.UserDao;
import com.soubu.CRMProject.base.greendao.ProductDao;
import com.soubu.CRMProject.base.greendao.ClientDao;
import com.soubu.CRMProject.base.greendao.ClueDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig userDaoConfig;
    private final DaoConfig productDaoConfig;
    private final DaoConfig clientDaoConfig;
    private final DaoConfig clueDaoConfig;

    private final UserDao userDao;
    private final ProductDao productDao;
    private final ClientDao clientDao;
    private final ClueDao clueDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        userDaoConfig = daoConfigMap.get(UserDao.class).clone();
        userDaoConfig.initIdentityScope(type);

        productDaoConfig = daoConfigMap.get(ProductDao.class).clone();
        productDaoConfig.initIdentityScope(type);

        clientDaoConfig = daoConfigMap.get(ClientDao.class).clone();
        clientDaoConfig.initIdentityScope(type);

        clueDaoConfig = daoConfigMap.get(ClueDao.class).clone();
        clueDaoConfig.initIdentityScope(type);

        userDao = new UserDao(userDaoConfig, this);
        productDao = new ProductDao(productDaoConfig, this);
        clientDao = new ClientDao(clientDaoConfig, this);
        clueDao = new ClueDao(clueDaoConfig, this);

        registerDao(User.class, userDao);
        registerDao(Product.class, productDao);
        registerDao(Client.class, clientDao);
        registerDao(Clue.class, clueDao);
    }
    
    public void clear() {
        userDaoConfig.getIdentityScope().clear();
        productDaoConfig.getIdentityScope().clear();
        clientDaoConfig.getIdentityScope().clear();
        clueDaoConfig.getIdentityScope().clear();
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public ProductDao getProductDao() {
        return productDao;
    }

    public ClientDao getClientDao() {
        return clientDao;
    }

    public ClueDao getClueDao() {
        return clueDao;
    }

}