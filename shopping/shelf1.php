 <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<?php
include("conn.php");
session_start();
$username=$_SESSION['name'];
$name=$_POST['name'];
$price=$_POST['price'];
$brief=$_POST['brief'];
$stime=date("Y-m-d", time());
$attribute=$_POST['attribute'];

class chkinput{
   var $username;
   var $name;
	var $price;
	var $brief;
	var $stime;
	var $attribute;
   function chkinput($x,$y,$a,$b,$c,$d){
     $this->username=$x;
     $this->name=$y;
	   $this->price=$a;
	   $this->brief=$b;
	   $this->stime=$c;
	   $this->attribute=$d;
    }

   function checkinput(){
     include("conn.php");
     $sql=mysqli_query($conn,"select * from shop where username='".$this->username."'");
     $info=mysqli_fetch_array($sql);
	 $id=$info['id'];
	 $shopname=$info['name'];
	 if($this->attribute=="日常用品")
		 $this->attribute="dailysupplies";
	 else if($this->attribute=="电子商品")
		 $this->attribute="electronic";
	 else if($this->attribute=="服装")
		 $this->attribute="clothing";
	 else if($this->attribute=="古董装饰")
		 $this->attribute="antique";
	 
	   
	 if($_FILES["uploadfile"]["name"]==''){
	 $sql1="INSERT INTO item (id, name, price, brief, stime, attribute,shopname,image) VALUES('$id','".$this->name."','".$this->price."','".$this->brief."','".$this->stime."','".$this->attribute."','$shopname','')";
	 mysqli_query($conn,$sql1);
     header("location:openshop.php");
     exit;
	 }else{
    $allowedExts = array("gif", "jpeg", "jpg", "png");
	$temp = explode(".", $_FILES["uploadfile"]["name"]);
	$extension = end($temp);     // 获取文件后缀名
	if ((($_FILES["uploadfile"]["type"] == "image/gif")
	|| ($_FILES["uploadfile"]["type"] == "image/jpeg")
	|| ($_FILES["uploadfile"]["type"] == "image/jpg")
	|| ($_FILES["uploadfile"]["type"] == "image/pjpeg")
	|| ($_FILES["uploadfile"]["type"] == "image/x-png")
	|| ($_FILES["uploadfile"]["type"] == "image/png"))
	&& in_array($extension, $allowedExts)){
	   
	   $UploadPath = "./image/";
	   $source_filename = $_FILES['uploadfile']['tmp_name'];
	   $dest_filename = $UploadPath . $_FILES["uploadfile"]["name"];
	   $i=1;
	   while(file_exists($dest_filename)) {
    	$_FILES["uploadfile"]["name"] = $i . $_FILES["uploadfile"]["name"];
		$dest_filename = $UploadPath . $_FILES["uploadfile"]["name"];
		$i=$i+1;
	   } 
     move_uploaded_file($source_filename, $dest_filename);
	 $sql1="INSERT INTO item (id, name, price, brief, stime, attribute,shopname,image) VALUES('$id','".$this->name."','".$this->price."','".$this->brief."','".$this->stime."','".$this->attribute."','$shopname','{$_FILES["uploadfile"]["name"]}')";
	 mysqli_query($conn,$sql1);
     header("location:openshop.php");
	}else{
	 echo "<script language='javascript'>alert('格式错误！请选择后缀为gif、jpeg、jpg、png的文件');history.back(); </script>";
	 exit;
	}
	 }
     }    
   }
  $obj=new chkinput(trim($username),trim($name),trim($price),trim($brief),trim($stime),trim($attribute));
    $obj->checkinput();
