<!doctype html>
<?php 
require_once('conn.php'); 
session_start();
$name=$_SESSION['name'];
?>
<html>
<head>
<meta charset="utf-8">
<title>消费记录</title>
</head>
<body>
<table width="800" border="1">
  <tbody>
    <tr>
      <td>商品名称</td>
      <td>价格</td>
      <td>购买时间</td>
      <td>详情</td>
      <td>商家</td>
    </tr>
     <?php
 	 $sql=mysqli_query($conn,"select * from records where username='$name'");
     while($info=mysqli_fetch_array($sql)){
	?>
    <tr>
      <td><?php echo $info['itemname'] ?></td>
      <td><?php echo $info['price'] ?></td>
      <td><?php echo $info['stime'] ?></td>
      <td>
      	<?php 
		if($info['attribute']=="dailysupplies")
		echo "日常用品";
		else if($info['attribute']=="clothing")
		echo "服装";
		else if($info['attribute']=="electronic")
		echo "电子商品";
		else
		echo "古董装饰";
		?>
      </td>
      <td><?php echo $info['shopname'] ?></td>
    </tr>
    <?php
	 }
	?>
  </tbody>
</table>
<a href="Personalhomepage.php">返回</a>
</body>
</html>