package com.buzl.springboot.mapper;

import com.buzl.springboot.db.model.Demo;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface DemoMappper {
	
	@Select("select * from demo where name like CONCAT(#{name},'%')")
	public List<Demo> likeName(String name);

	@Select("select * from demo where id = #{id}")
	public Demo getById(long id);

	@Select("select name from demo where id = #{id}")

	public String getNameById(long id);
}
