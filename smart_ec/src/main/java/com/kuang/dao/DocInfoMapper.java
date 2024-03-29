package com.kuang.dao;


import com.kuang.dto.DocRateDTO;
import com.kuang.pojo.DocInfo;
import com.kuang.pojo.DocRate;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
@Mapper
public interface DocInfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table doc_info
     *
     * @mbggenerated Mon Mar 27 23:08:10 CST 2023
     */
    int countByExample(DocInfo example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table doc_info
     *
     * @mbggenerated Mon Mar 27 23:08:10 CST 2023
     */
    int deleteByExample(DocInfo example);

    List<DocInfo> selectAllDoc();

    DocInfo selectDocByid(Long id);

    DocInfo selectDocByPhone(String phone);
    int deleteByPrimaryKey(Long id);

    /**
     * 注册使用
     */
    int insert(DocInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table doc_info
     *
     * @mbggenerated Mon Mar 27 23:08:10 CST 2023
     */
    int insertSelective(DocInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table doc_info
     *
     * @mbggenerated Mon Mar 27 23:08:10 CST 2023
     */
    List<DocInfo> selectByExample(DocInfo example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table doc_info
     *
     * @mbggenerated Mon Mar 27 23:08:10 CST 2023
     */
    DocInfo selectByPrimaryKey(String phone,String password);
    List<DocInfo> selectByProStats (Integer proStatus);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table doc_info
     *
     * @mbggenerated Mon Mar 27 23:08:10 CST 2023
     */
    int updateByExampleSelective(@Param("record") DocInfo record, @Param("example") DocInfo example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table doc_info
     *
     * @mbggenerated Mon Mar 27 23:08:10 CST 2023
     */
    int updateByExample(@Param("record") DocInfo record, @Param("example") DocInfo example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table doc_info
     *
     * @mbggenerated Mon Mar 27 23:08:10 CST 2023
     */
    int updateByPrimaryKeySelective(DocInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table doc_info
     *
     * @mbggenerated Mon Mar 27 23:08:10 CST 2023
     */
    int updateByPrimaryKey(DocInfo record);
    int upAllScoreByPhone(DocRateDTO docRateDTO);
    int upProById(DocInfo docInfo);
}