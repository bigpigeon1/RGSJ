<?php
//建立数据库连接；
 $conn=mysqli_connect("localhost","root","","shopping"); 
//设置字符为utf-8，@抑制字符变量的声明提醒。
@ mysqli_set_charset ($conn,utf8);
@ mysqli_query($conn,utf8);
//如果连接错误显示错误原因。
if (mysqli_connect_errno($conn)) 
{ 
    echo "连接 MySQL 失败: " . mysqli_connect_error(); 
}
?>