 <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<?php
include("conn.php");
session_start();
$username=$_SESSION['name'];
$tid=$_POST['id'];
$attribute=$_SESSION['attribute'];
class chkinput{
   var $username;
   var $tid;
   var $attribute;
	
   function chkinput($x,$y,$z){
     $this->username=$x;
     $this->tid=$y;
	 $this->attribute=$z;
    }

   function checkinput(){
     include("conn.php");
	 $sql= mysqli_query($conn,"select * from bask where name='".$this->username."'");
	 $is=true;
	 while($row=mysqli_fetch_array($sql)){
		 if($row[tid]==$this->tid){
			 $is=false;
			 break;
		 }
	 }
	 
	 if($is){
	 mysqli_query($conn,"INSERT INTO bask (tid, name,isselect) VALUES('".$this->tid."','".$this->username."',0)");
	 if($this->attribute=="dailysupplies")
	 header("location:shoppingMall.php?attribute=dailysupplies");
	 else if($this->attribute=="electronic")
	 header("location:shoppingMall.php?attribute=electronic");
	 else if($this->attribute=="clothing")
	 header("location:shoppingMall.php?attribute=clothing");
	 else if($this->attribute=="antique")
	 header("location:shoppingMall.php?attribute=antique");
     }else{
		 echo "<script language='javascript'>alert('该商品已在购物车中！');history.back(); </script>";
	 }

      }    
   }
  $obj=new chkinput(trim($username),trim($tid),trim($attribute));
    $obj->checkinput();
