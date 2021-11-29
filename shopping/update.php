<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<?php
include("conn.php");
$newname=$_POST['name'];
$age=$_POST['age'];
$sex=$_POST['sex'];
$email=$_POST['email'];
$address=$_POST['address'];
session_start();
$name=$_SESSION['name'];
class chkinput{
   var $newname;
   var $age;
	var $sex;
	var $email;
	var $address;
	var $name;
   function chkinput($x,$y,$a,$b,$c,$d){
     $this->newname=$x;
     $this->age=$y;
	    $this->sex=$a;
	    $this->email=$b;
	    $this->address=$c;
	    $this->name=$d;
    }

   function checkinput(){
     include("conn.php");
	 if($this->newname!=""){
	 $sql=mysqli_query($conn,"select * from user where name='".$this->newname."'");
     $info=mysqli_fetch_array($sql);
     if($info==true){
          echo "<script language='javascript'>alert('该昵称已存在！');history.back();</script>";
          exit;
       }
    }else{
		$this->newname=$this->name;
	}
	 $sql=mysqli_query($conn,"select * from user where name='".$this->name."'");
     $info=mysqli_fetch_array($sql);
	 	 if($this->age=="")
		 $this->age=$info['age'];
	   	 if($this->email=="")
		 $this->email=$info['email'];
	   	 if($this->address=="")
		 $this->address=$info['address'];
	   $sql1="update user set name='".$this->newname."' ,age='".$this->age."',sex='".$this->sex."',email='".$this->email."',address='".$this->address."'where name='".$this->name."'";
//	   echo $sql1;
	   mysqli_query($conn,$sql1);
	   $_SESSION['name']=$this->newname;
       header("location:Personalhomepage.php");
              
	   exit;
      }    
   }
   $obj=new chkinput(trim($newname),trim($age),trim($sex),trim($email),trim($address),trim($name));
    $obj->checkinput();
?>