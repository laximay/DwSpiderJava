package org.dwSpider.dao;

import org.apache.ibatis.annotations.Param;
import org.dwSpider.entity.Contact;

import java.util.Date;
import java.util.List;

/**
 * Created by wenjing on 2017/3/16.
 */
public interface ContactDao {

    int saveContact(Contact contact);

    List<Contact> showContact(@Param("offet") int offet, @Param("limit") int limit, @Param("updataDate") Date updataDate, @Param("casNO") String casNO,@Param("casName") String casName, @Param("cName")String cName);


}
