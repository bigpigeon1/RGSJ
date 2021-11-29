 <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<?php
include("conn.php");
session_start();
$name=$_SESSION['name'];
$tid=$_POST['id'];
$attribute=$_SESSION['attribute'];
class chkinput{
   var $name;
   var $tid;
   var $attribute;
   function chkinput($x,$y,$z){
     $this->name=$x;
     $this->tid=$y;
	 $this->attribute=$z;
    }

   function checkinput(){
     include("conn.php");
     $sql=mysqli_query($conn,"select * from item where tid='".$this->tid."'");
     $info=mysqli_fetch_array($sql);
	 mysqli_query($conn,"INSERT INTO records (username, itemname, stime, price, attribute, shopname) VALUES('".$this->name."','{$info['name']}','{$info['stime']}','{$info['price']}','{$info['attribute']}','{$info['shopname']}')");
	 mysqli_query($conn,"DELETE FROM item WHERE tid='".$this->tid."'");
	   
	   
	 if($this->attribute=="dailysupplies")
	 header("location:shoppingMall.php?attribute=dailysupplies");
	 else if($this->attribute=="electronic")
	 header("location:shoppingMall.php?attribute=electronic");
	 else if($this->attribute=="clothing")
	 header("location:shoppingMall.php?attribute=clothing");
	 else if($this->attribute=="antique")
	 header("location:shoppingMall.php?attribute=antique");
      }    
   }
   $obj=new chkinput(trim($name),trim($tid),trim($attribute));
    $obj->checkinput();
?>