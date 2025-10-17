-- 코드를 입력하세요
SELECT
    count(*)
FROM USER_INFO
WHERE
    AGE between 20 and 29
   AND DATE_FORMAT(JOINED,'%Y') = '2021'