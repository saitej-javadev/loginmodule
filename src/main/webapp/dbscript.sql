CREATE TABLE user (
    userId INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(100),
    password VARCHAR(100)
)


SELECT * FROM schooldb.user;

insert into schooldb.user(username,password) values('saitej','saitej');