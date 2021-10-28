package co.seokjin.mybatis.member.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.seokjin.mybatis.comm.DataSource;
import co.seokjin.mybatis.member.service.MemberMapper;
import co.seokjin.mybatis.member.service.MemberService;
import co.seokjin.mybatis.member.service.MemberVO;

public class MemberServiceImpl implements MemberService {
	private SqlSession sqlSession = DataSource.getInstance().openSession(true);	//연결하고, true(오토커밋)
	private MemberMapper map = sqlSession.getMapper(MemberMapper.class);	// Mapper활용
	@Override
	public List<MemberVO> memberSelectList() {
//		return sqlSession.selectList("memberSelectList");	//Mapper없이 사용할때
		return map.memberSelectList();
	}

	@Override
	public MemberVO memberSelect(MemberVO vo) {
//		return sqlSession.selectOne("memberSelect", vo);
		return map.memberSelect(vo);
	}

	@Override
	public int memberInsert(MemberVO vo) {
		return map.memberInsert(vo);
	}

	@Override
	public int memberUpdate(MemberVO vo) {
		return map.memberUpdate(vo);
	}

	@Override
	public int memberDelete(MemberVO vo) {
		return map.memberDelete(vo);
	}
}
