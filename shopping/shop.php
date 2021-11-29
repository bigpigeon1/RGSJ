<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<?php
session_start();
$name=$_SESSION['name'];
class chkinput{
   var $name;

   function chkinput($x){
     $this->name=$x;
    }

   function checkinput(){
     include("conn.php");
     $sql=mysqli_query($conn,"select * from shop where username='".$this->name."'");
     $info=mysqli_fetch_array($sql);
     if($info==false){
          header("location:createshop.php");
          exit;
       }
	   else{
          header("location:openshop.php");
          exit;
            
       }
      }    
   }
   $obj=new chkinput(trim($name));
    $obj->checkinput();
?>