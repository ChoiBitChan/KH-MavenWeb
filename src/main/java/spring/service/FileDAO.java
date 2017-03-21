package spring.service;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import spring.model.FileInfo;

public class FileDAO extends SqlSessionDaoSupport {
	
	public int insertFile(FileInfo file) {
		int i = getSqlSession().insert("file.addFile", file);
		return i;
	}

}
