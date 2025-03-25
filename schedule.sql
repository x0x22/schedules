
CREATE TABLE schedules
(
    schedule_id BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '일정ID',
    user_name VARCHAR(20) COMMENT '유저이름',
    plan VARCHAR(100) COMMENT '일정',
    content MEDIUMTEXT COMMENT '일정 메모',
    schedule_date DATETIME COMMENT '일정날짜',
    create_date DATETIME COMMENT '일정 생성일',
    edit_date DATETIME COMMENT '일정 수정일',
    passwords VARCHAR(20) COMMENT '비밀번호'
);

