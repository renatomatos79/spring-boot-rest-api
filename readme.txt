 docker run --name mysqlsrv5 -p 3306:3306 -p 33060:33060 -e MYSQL_ROOT_PASSWORD=mysql@123 -d mysql:5
 
 tasklist | grep 16560
 netstat -a -b -o | grep 16560