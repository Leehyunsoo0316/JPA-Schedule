use schedule_jpa;

-- 테이블 생성
CREATE TABLE schedule (
                          id BIGINT AUTO_INCREMENT PRIMARY KEY,
                          task VARCHAR(255) NOT NULL,
                          name VARCHAR(255) NOT NULL,
                          password VARCHAR(255) NOT NULL,
                          created_at DATETIME NOT NULL,
                          updated_at TIMESTAMP NOT NULL
);