CREATE TABLE member (
	m_id 			VARCHAR(20)		NOT NULL,
	m_pass			VARCHAR(20)		NOT NULL,
	m_date			VARCHAR(10)		NOT NULL,
	m_availability	BOOLEAN			NOT NULL
);

INSERT INTO member (m_id, m_pass, m_date, m_availability) VALUES
	('osse', '1234', CURRENT_DATE, true);

SELECT * FROM member WHERE m_id='osse';

DELETE FROM member WHERE m_id='osse';

SELECT CURRENT_DATE;
DROP TABLE member;