<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<?php
include("conn.php");
$name=$_POST['name'];
session_start();
$username=$_SESSION['name'];
class chkinput{
   var $name;
   var $username;

   function chkinput($x,$y){
     $this->name=$x;
     $this->username=$y;
    }

   function checkinput(){
     include("conn.php");
     $sql=mysqli_query($conn,"select * from shop where name='".$this->name."'");
     $info=mysqli_fetch_array($sql);
     if($info==true){
          echo "<script language='javascript'>alert('该店铺名称已被使用！');history.back();</script>";
          exit;
       }
	   else{
		  mysqli_query($conn,"INSERT INTO shop (name, username) VALUES('".$this->name."','".$this->username."')");
		  header("location:shop.php");
       }
      }    
   }
   $obj=new chkinput(trim($name),trim($username));
    $obj->checkinput();
?>