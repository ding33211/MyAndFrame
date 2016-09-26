package com.example;

import org.greenrobot.greendao.generator.DaoGenerator;
import org.greenrobot.greendao.generator.Entity;
import org.greenrobot.greendao.generator.Schema;

public class MyDaoGenerator {
    public static void main(String[] args) throws Exception {
        //生成的相关文件的包名路径
        Schema schema = new Schema(1, "com.soubu.CRMProject.base.greendao");
        addTable(schema);
        //生成相关文件的具体路径
        new DaoGenerator().generateAll(schema, "../CRMProject/app/src/main/java");
    }

    //客户表
    private static void addTable(Schema schema) {
        //用户表
        Entity user = schema.addEntity("User");
        user.setTableName("User");
        //id主键自增长
        user.addIdProperty().primaryKey().autoincrement();
        user.addStringProperty("name");
        user.addStringProperty("phone");
        user.addStringProperty("user_id").notNull();
        user.addDateProperty("password");

        //产品表
        Entity product = schema.addEntity("Product");
        product.setTableName("Product");
        product.addIdProperty().primaryKey().autoincrement();
        product.addLongProperty("product_id").notNull();
        product.addLongProperty("classification");
        product.addStringProperty("title");
        product.addDoubleProperty("price");
        product.addStringProperty("img");
        //库存
        product.addLongProperty("stock");
        //成本
        product.addLongProperty("cost");
        //购买方式,现货还是订货
        product.addIntProperty("buy_state");
        //幅宽
        product.addLongProperty("width");
        //品名
        product.addStringProperty("product_name");
        //成分
        product.addStringProperty("ingredient");
        //用途
        product.addStringProperty("use");
        //季节
        product.addIntProperty("season");
        //工艺
        product.addIntProperty("crafts");
        //颜色
        product.addStringProperty("color");
        //花型
        product.addStringProperty("flower");

        //客户表
        Entity client = schema.addEntity("Client");
        client.setTableName("Client");
        client.addIdProperty().primaryKey().autoincrement();
        //客户id
        client.addLongProperty("client_id").notNull();
        client.addStringProperty("name");
        client.addIntProperty("type");
        client.addStringProperty("phone");
        client.addStringProperty("email");
        //传真
        client.addStringProperty("fax");
        //网址
        client.addStringProperty("network");
        //地区
        client.addStringProperty("area");
        //简介
        client.addStringProperty("summary");
        //邮编
        client.addStringProperty("zip_code");
        //跟进状态
        client.addStringProperty("follow_state");
        //客户来源
        client.addStringProperty("from");
        //行业
        client.addStringProperty("industry");
        //规模
        client.addIntProperty("scale");
        //负责人
        client.addStringProperty("principal");
        //地址
        client.addStringProperty("address");
        //主营产品
        client.addStringProperty("main_products");
        //营业额
        client.addStringProperty("turnover");
        //经验模式
        client.addStringProperty("empirical_mode");
        //主营行业
        client.addStringProperty("major_business");



        //线索表
        Entity clue = schema.addEntity("Clue");
        clue.setTableName("Clue");
        clue.addIdProperty().primaryKey().autoincrement();
        //线索id
        clue.addStringProperty("clue_id").notNull();
        clue.addStringProperty("wechat");
        clue.addStringProperty("phone");
        //座机
        clue.addStringProperty("landline");
        //职务
        clue.addStringProperty("post");
        //部门
        clue.addStringProperty("department");
        //公司名称
        clue.addStringProperty("company");
        //线索来源
        clue.addIntProperty("from");
        //姓名
        clue.addStringProperty("name");
        //负责人
        clue.addStringProperty("principal");
        //地区
        clue.addStringProperty("area");
        //地址
        clue.addStringProperty("address");
        //邮编
        clue.addStringProperty("zip_code");
        //备注
        clue.addStringProperty("remark");
        //网址
        clue.addStringProperty("network");
        //邮箱
        clue.addStringProperty("email");
        //旺旺号
        clue.addStringProperty("wangwang");
        //跟进状态
        clue.addIntProperty("follow_state");
        //qq
        clue.addStringProperty("qq");



    }

}
