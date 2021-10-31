package co.seokjin.mybatis.notice.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.seokjin.mybatis.comm.DataSource;
import co.seokjin.mybatis.notice.service.NoticeMapper;
import co.seokjin.mybatis.notice.service.NoticeService;
import co.seokjin.mybatis.notice.service.NoticeVO;

public class NoticeServiceImpl implements NoticeService {
	private SqlSession sqlSession = DataSource.getInstance().openSession(true);
	private NoticeMapper map = sqlSession.getMapper(NoticeMapper.class);
	
	@Override
	public List<NoticeVO> noticeSelectList() {
		return map.noticeSelectList();
	}
	@Override
	public NoticeVO noticeSelect(NoticeVO vo) {
		hitUpdate(vo);
		return map.noticeSelect(vo);
	}
	@Override
	public int noticeInsert(NoticeVO vo) {
		return map.noticeInsert(vo);
	}
	@Override
	public int noticeUpdate(NoticeVO vo) {
		return map.noticeUpdate(vo);
	}
	@Override
	public int noticeDelete(NoticeVO vo) {
		return map.noticeDelete(vo);
	}
	@Override
	public int hitUpdate(NoticeVO vo) {
		return map.hitUpdate(vo);
	}
	@Override
	public List<NoticeVO> titleSearchList(NoticeVO vo) {
		return map.titleSearchList(vo);
	}
	@Override
	public List<NoticeVO> nameSearchList(NoticeVO vo) {
		return map.nameSearchList(vo);
	}
	@Override
	public List<NoticeVO> contentsSearchList(NoticeVO vo) {
		return map.contentsSearchList(vo);
	}
	
}
