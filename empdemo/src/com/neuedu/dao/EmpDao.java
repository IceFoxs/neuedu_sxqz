package com.neuedu.dao;

import java.util.List;

import com.neuedu.entity.Emp;

public interface EmpDao {

	/**
	 * ��ѯ������Ա����Ϣ
	 * @return
	 */
	public List<Emp> selectEmpList();
	
	/**
	 * ����id��ѯemp
	 * @param id
	 * @return
	 */
	public Emp selectEmpById(int id);
	
}
