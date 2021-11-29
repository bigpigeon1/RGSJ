<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>上架</title>
</head>
<body>

	<form method="post" action="shelf1.php" enctype="multipart/form-data">
		商品名称：<input type="text" name="name"><p>
		价格：<input type="text" name="price"><p>
		简介(200字以内)：<p>
		<textarea name="brief" cols="60" rows="20"></textarea><p>
		类型：<select name="attribute">
			<option>日常用品</option>
			<option>电子商品</option>
			<option>服装</option>
			<option>古董装饰</option>
		</select><p>
		<INPUT TYPE="hidden" name="MAX_FILE_SIZE" value=5000000>
        <input type="file" name="uploadfile" size=30 ><p>
		<input type="submit" value="上架">
	</form>
</body>
</html>