<!doctype html>
<?php 
require_once('conn.php'); 
session_start();
$name=$_SESSION['name'];
?>
<html>
<head>
<meta charset="utf-8">
<title>我的店铺</title>
</head>
<body>
<table width="800" border="1">
  <tbody>
	<tr>
      <td>名称</td>
      <td>价格</td>
	  <td>简介</td>
	  <td>上架时间</td>
	  <td>特征</td>
	  <td>下架商品</td>
    </tr>
	<?php
 	 $sql=mysqli_query($conn,"select * from shop where username='$name'");
     $info=mysqli_fetch_array($sql);
	 $id=$info['id'];
	 $sql1=mysqli_query($conn,"select * from item where id='$id'");
	 if(($info1=mysqli_fetch_array($sql1))==false){
		 echo "暂无上架商品";
	 }else{
		 $sql2=mysqli_query($conn,"select * from item where id='$id'");
		 while($row=mysqli_fetch_array($sql2)){
	 
	?>
    <tr>
      <td><?php echo $row['name'] ?></td>
      <td><?php echo $row['price'] ?></td>
	  <td><?php echo $row['brief'] ?></td>
	  <td><?php echo $row['stime'] ?></td>
	  <td>
		<?php 
		if($row['attribute']=="dailysupplies")
		echo "日常用品";
		else if($row['attribute']=="clothing")
		echo "服装";
		else if($row['attribute']=="electronic")
		echo "电子商品";
		else
		echo "古董装饰";
		  ?>
		</td>
  	<td>
   	<form method="post" action="down.php">
   		<input type="text" style="display:none" value="<?php echo $row['tid'] ?>" name="tid">
   		<input type="submit" value="下架" >
   	</form>
   	</td>
    </tr>
	<?php
		 }
	 }
	 ?>
  </tbody>
</table>
	<form method="post" action="shelf.php">
		<input type="submit" value="上架">
	</form>
	<a href="Personalhomepage.php">返回</a> 
</body>
</html>