package com.spring.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.spring.member.vo.MemberVO;

@Repository("memberDAO")
public class MemberDAOImpl implements MemberDAO {
	@Autowired
	private SqlSession sqlSession;

	/*
	 * public void setSqlSession(SqlSession sqlSession) { this.sqlSession =
	 * sqlSession; }
	 */

	@Override
	public List selectAllMemberList() throws DataAccessException {
//		System.out.println("sqlSession : "+sqlSession);
		List<MemberVO> membersList = sqlSession.selectList("mapper.member.selectAllMemberList");
		return membersList;
	}

	@Override
	public void addMember(MemberVO memberVO) throws DataAccessException {
		 sqlSession.insert("mapper.member.insertMember",memberVO);
		
	}

	@Override
	public void updateMember(MemberVO memberVO) throws DataAccessException {
		 sqlSession.update("mapper.member.updateMember",memberVO);
	}

}
