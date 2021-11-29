<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>无标题文档</title>
</head>
<body>
	 <?php 
	require_once('conn.php'); 
	session_start();
	$name=$_SESSION['name'];
	$sql=mysqli_query($conn,"select * from user where name='$name'");
    $info=mysqli_fetch_array($sql);
	
	?>
	<img src="head/<?php echo "$info[image]" ?>" width="50" height="50">
	<?php 
	echo $_SESSION['name'];
	?>
	<p>
	<a href="Personalhomepage.php">个人主页</a>
	<a href="shoppingMall.php?attribute=dailysupplies">日常用品</a>
	<a href="shoppingMall.php?attribute=electronic">电子商品</a>
	<a href="shoppingMall.php?attribute=clothing">服装</a>
	<a href="shoppingMall.php?attribute=antique">古董装饰</a>
</body>
</html>
