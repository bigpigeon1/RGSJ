 <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<?php
session_start();
$_SESSION['name']="";
class chkinput{
   function checkinput(){
     header("location:index.php");
     exit;
     }    
   }
  $obj=new chkinput();
    $obj->checkinput();
?>