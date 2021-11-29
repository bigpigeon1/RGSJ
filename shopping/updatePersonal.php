<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>修改个人信息</title>
</head>
<body>
	<form method="post" action="update.php">
		昵称：<input type="text" name="name"><p>
		年龄：<input type="text" name="age"><p>
		性别：<select name="sex">
		<option>男</option>
		<option>女</option>
		</select><p>
		邮箱：<input type="text" name="email"><p>
		常用地址：<input type="text" name="address"><p>
		<input type="submit" value="修改">
	</form>
	
	<form action="updatePwd.php">
		<input type="submit" value="修改密码">
	</form>
	<p>
	<a href="Personalhomepage.php">返回</a>
</body>
</html>