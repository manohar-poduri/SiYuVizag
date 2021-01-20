<?php

	$area = $_REQUEST["placename"];
	$type= $_REQUEST["Type"];
	
	$conn = mysqli_connect("localhost","root","","subhayatra");

	$qry = "select * from restaurants where Type = '$type' and Area= '$area'";

	$result = mysqli_query($conn,$qry);

	$res = array();
	if(mysqli_num_rows($result)>0)
	{
		while($row = mysqli_fetch_assoc($result))
		{
	array_push($res,array('Placename'=>$row["Name"]));
		}
		//print(json_encode($row));
		

		echo json_encode(array("result"=>$res));
	}
	mysqli_close($conn);
?>

