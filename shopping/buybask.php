<!doctype html>
<?php 
require_once('conn.php'); 
session_start();
$name=$_SESSION['name'];
?>
<html>
<head>
<meta charset="utf-8">
<title>购物车</title>
</head>
<body>
<table width="800" border="1">
  <tbody>
    <tr>
      <td>名称</td>
      <td>价格</td>
      <td>简介</td>
      <td>上架时间</td>
      <td>商家</td>
      <td>类型</td>
      <td>&nbsp;</td>
    </tr>
	<?php 
	  $sql=mysqli_query($conn,"select * from bask where name = '$name'");
	  while($row=mysqli_fetch_array($sql)){
		  $sql1=mysqli_query($conn,"select * from item where tid = '{$row['tid']}' ");
		  $info=mysqli_fetch_array($sql1);
		  ?>
	<tr>
	  <td><?php echo $info['name'] ?></td>
      <td><?php echo $info['price'] ?></td>
      <td><?php echo $info['brief'] ?></td>
      <td><?php echo $info['stime'] ?></td>
      <td><?php echo $info['shopname'] ?></td>
      <?php 
		if($info['attribute']=="dailysupplies")
		echo "<td>日常用品</td>";
		else if($info['attribute']=="clothing")
		echo "<td>服装</td>";
		else if($info['attribute']=="electronic")
		echo "<td>电子商品</td>";
		else
		echo "<td>古董装饰</td>";
		?>
		<td>
			<form method="post" action="select.php">
				<input type="text" style="display:none" value="<?php echo $row['tid'] ?>" name="tid">
				<input type="submit" value="选择">
				<?php echo $row['isselect'] ?>
			</form>
		</td>
	</tr>	
	<?php
	  }
	  ?>
  </tbody>
</table>
	<form method="post" action="settlement.php">
		<input type="submit" value="结算">
		<a href="Personalhomepage.php">返回</a>
	</form>
	
</body>
</html>