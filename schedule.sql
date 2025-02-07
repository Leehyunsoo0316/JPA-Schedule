use schedule_jpa;

-- 테이블 생성
CREATE TABLE schedule (
                          id BIGINT AUTO_INCREMENT PRIMARY KEY,
                          user_name VARCHAR(255) NOT NULL,
                          title VARCHAR(255) NOT NULL,
                          contents VARCHAR(255) NOT NULL,
                          created_at DATETIME NOT NULL,
                          updated_at TIMESTAMP NOT NULL
);