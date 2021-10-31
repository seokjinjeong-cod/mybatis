package co.seokjin.mybatis.notice.service;

import java.util.List;

public interface NoticeMapper {
	List<NoticeVO> noticeSelectList();
	NoticeVO noticeSelect(NoticeVO vo);
	int noticeInsert(NoticeVO vo);
	int noticeUpdate(NoticeVO vo);
	int noticeDelete(NoticeVO vo);
	int hitUpdate(NoticeVO vo);
	List<NoticeVO> titleSearchList(NoticeVO vo);
	List<NoticeVO> nameSearchList(NoticeVO vo);

}
