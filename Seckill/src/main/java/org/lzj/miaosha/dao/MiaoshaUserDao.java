package org.lzj.miaosha.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.lzj.miaosha.domain.MiaoshaUser;

/**
 * @ClassName MiaoshaUserDao
 * @Description: TODO
 * @Author Keen
 * @DATE 2021/3/26 9:19
 * @Version 1.0
 **/

@Mapper
public interface MiaoshaUserDao {

    @Select("select * from miaosha_user where id = #{id}")
    public MiaoshaUser getById(long id);

    @Update("update miaosha_user set password = #{password} where id = #{id}")
    public void update(MiaoshaUser toBeUpdate);
}
