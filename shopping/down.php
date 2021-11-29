 <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<?php
include("conn.php");
$tid=$_POST['tid'];
class chkinput{

   var $tid;
   function chkinput($y){
     $this->tid=$y;
    }

   function checkinput(){
     include("conn.php");
	 mysqli_query($conn,"DELETE FROM item WHERE tid='".$this->tid."'");
	 header("location:openshop.php");
	 exit();
      }    
   }
   $obj=new chkinput(trim($tid));
    $obj->checkinput();
?>