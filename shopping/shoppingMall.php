<!doctype html>
<?php 
require_once('conn.php');
session_start();
$attribute=$_GET['attribute'];
$_SESSION['attribute']=$_GET['attribute'];
?>
<html>
<head>
<meta charset="utf-8">
<title>
		<?php 
		if($attribute=="dailysupplies")
		echo "日常用品";
		else if($attribute=="clothing")
		echo "服装";
		else if($attribute=="electronic")
		echo "电子商品";
		else
		echo "古董装饰";
		?>
</title>
</head>
<body>
	<a href="Personalhomepage.php">个人主页</a>
	<a href="shoppingMall.php?attribute=dailysupplies">日常用品</a>
	<a href="shoppingMall.php?attribute=electronic">电子商品</a>
	<a href="shoppingMall.php?attribute=clothing">服装</a>
	<a href="shoppingMall.php?attribute=antique">古董装饰</a>
<form method="post" action="finditem.php">
	<input type="text" name="name" value placeholder="请输入商品名称">
	<input type="submit" value="搜索">
</form>
<table width="800" border="1">
  <tbody>      
      <td>名称</td>
      <td>价格</td>
	  <td>简介</td>
	  <td>上架时间</td>
	  <td>商家</td>
	  <td>  </td>
	  <td>  </td>
    <?php
	$sql=mysqli_query($conn,"select * from item where attribute='$attribute'");
	$info=mysqli_fetch_array($sql);
	if($info==false){
		echo "暂无商品信息";
	}else{
		$sql1=mysqli_query($conn,"select * from item where attribute='$attribute'");
		while($row=mysqli_fetch_array($sql1)){
	?>
    <tr>
      <td><?php echo $row['name'] ?></td>
      <td><?php echo $row['price'] ?></td>
	  <td><?php echo $row['brief'] ?></td>
	  <td><?php echo $row['stime'] ?></td>
	  <td><?php echo $row['shopname']?></td>
	  <td>
	  	<form method="post" action="buy.php">
	  		<input type="text" style="display:none" value="<?php echo $row['tid'] ?>" name="id">
	  		<input type="submit" value="购买">
	  	</form>
	  </td>
	  <td>
	  	<form method="post" action="addbuybask.php">
	  		<input type="text" style="display:none" value="<?php echo $row['tid'] ?>" name="id">
	  		<input type="submit" value="加入购物车">
	  	</form>
	  </td>
    </tr>
	<?php		
		}
	}
	?>
  </tbody>
</table>

	
</body>
</html>