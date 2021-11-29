 <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<?php
include("conn.php");
$useraccount=$_POST['account'];
$userpwd=$_POST['password'];
class chkinput{
   var $account;
   var $pwd;

   function chkinput($x,$y){
     $this->account=$x;
     $this->pwd=$y;
    }

   function checkinput(){
     include("conn.php");
     $sql=mysqli_query($conn,"select * from user where account='".$this->account."'");
     $info=mysqli_fetch_array($sql);
     if($info==false){
          echo "<script language='javascript'>alert('用户输入错误或者不存在！');history.back();</script>";
          exit;
       }
	   else{
     if($info['password']==$this->pwd)
            {  
			   session_start();
	           $_SESSION['name']=$info['name'];
			   $_SESSION['attribute']="0";
               header("location:homepage.php");
               exit;
            }
          else {
			   echo "<script language='javascript'>alert('密码输入错误！');history.back(); </script>";
             exit;
           }
       }
      }    
   }
   $obj=new chkinput(trim($useraccount),trim($userpwd));
    $obj->checkinput();
?>