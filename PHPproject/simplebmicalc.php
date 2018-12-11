<html>
<head>
	<title>BMI Calculator</title>
	<link rel ="stylesheet" type="text/css" href="sample.css" >
</head>
<body>


	<?php
		$weight = $_POST["weight"];
		$feet = $_POST["feet"];
		$inches = $_POST["inch"];

		$height = $feet * 12 + $inches;
		$bmi = 703 * $weight / ($height * $height);

	 	echo ("Your BMI is: ");
		echo round($bmi, 3);
	?>

</body>
</html>
