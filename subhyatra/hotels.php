<?php

	$area = $_REQUEST["placename"];
	$conn = mysqli_connect("localhost","root","","subhayatra");

	$qry = "select * from hotels where Area = '$area'";

	$result = mysqli_query($conn,$qry);

	$res = array();
	if(mysqli_num_rows($result)>0)
	{
		while($row = mysqli_fetch_assoc($result))
		{
	array_push($res,array('Placename'=>$row["HotelName"]));
		}
		//print(json_encode($row));
		

		echo json_encode(array("result"=>$res));
	}
	mysqli_close($conn);
?>

