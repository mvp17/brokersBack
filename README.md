# Mount volume

docker rm -f mysql-db

docker volume prune

docker volume create mysql-db-data

docker volume ls

docker run -d -p 33060:3306 --name mysql-db  -e MYSQL_ROOT_PASSWORD=secret --mount src=mysql-db-data,dst=/var/lib/mysql mysql

# Create db
docker exec -it mysql-db mysql -p

create database brokers;

show databases;

# DB
USE brokers;
CREATE TABLE predefined_rates (
id INT AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(255) NOT NULL,
single BOOLEAN NOT NULL
);
SHOW TABLES;
DESCRIBE table_name;




