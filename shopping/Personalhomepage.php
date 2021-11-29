<!doctype html>
<?php 
require_once('conn.php'); 
session_start();
$name=$_SESSION['name'];
?>
<html>
<head>
<meta charset="utf-8">
<title>个人主页</title>
</head>
<body>
<table width="800" border="1">
  <tbody>
   <?php
 	 $sql=mysqli_query($conn,"select * from user where name='$name'");
     $info=mysqli_fetch_array($sql);
	?>
    <tr>
      <td>账号</td>
      <td><?php echo $info['account'] ?></td>
    </tr>
    <tr>
      <td>性别</td>
      <td><?php echo $info['sex'] ?></td>
    </tr>
    <tr>
      <td>年龄</td>
      <td><?php echo $info['age'] ?></td>
    </tr>
    <tr>
      <td>邮箱</td>
      <td><?php echo $info['email'] ?></td>
    </tr>
    <tr>
      <td>身份证号</td>
      <td><?php echo $info['idcard'] ?></td>
    </tr> 
    <tr>
      <td>常用地址</td>
      <td><?php echo $info['address'] ?></td>
    </tr>          
 </tbody>
</table>
 	<form method="post" action="logout.php">
   		<input type="submit" value="注销">
    </form> 
    
    <form enctype="multipart/form-data"  METHOD="post" action="uphead.php">
    	<INPUT TYPE="hidden" name="MAX_FILE_SIZE" value=5000000>
        <input type="file" name="uploadfile" size=30 >			
		<input type="submit" value="上传头像">
    </form> 
    
  	<a href="updatePersonal.php">修改个人信息</a>
	<a href="shop.php">我的店铺</a>
	<a href="buybask.php">购物车</a>
	<a href="records.php">消费记录</a>
	<a href="homepage.php">返回</a>
</body>
</html>