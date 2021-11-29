 <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<?php
include("conn.php");
session_start();
$name=$_SESSION['name'];
$tid=$_POST['tid'];

class chkinput{
   var $tid;
   var $name;
	
   function chkinput($x,$y){
     $this->tid=$x;
	 $this->name=$y;
    }

   function checkinput(){
     include("conn.php");

	 $sql=mysqli_query($conn,"select * from bask where tid = '".$this->tid."' and name = '".$this->name."'");
	  
	 $info=mysqli_fetch_array($sql);
	 if($info['isselect']==0){
		 mysqli_query($conn,"update bask set isselect = 1 where tid = '".$this->tid."' and name = '".$this->name."' ");
	 }else{
		 mysqli_query($conn,"update bask set isselect = 0 where tid = '".$this->tid."' and name = '".$this->name."' ");
	 }
	 
     header("location:buybask.php");
     exit;

      }    
   }
  $obj=new chkinput(trim($tid),trim($name));
    $obj->checkinput();
