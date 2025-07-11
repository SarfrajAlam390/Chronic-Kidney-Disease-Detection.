<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>Chronic Kidney Disease Model</title>

</head>
<body><div class="blurred-background">
    <div style="color:black;" class="container">
        <h2 class='container-heading'><span class="heading_font">Chronic Kidney Disease Prediction</span></h2>
    </div>

    <div style="color:black;" class="ml-container">
        <form action="predict" method="POST">
            <br>
            <br>
            <h3>Specific Gravity</h3>
            <input  type="text" id="first" name="sg" placeholder="Ex: (1.005,1.010,1.015,1.020,1.025)" required="required">
            <br>
            <h3>Hyper Tension</h3>
            <input type="text" id="second" name="htn" placeholder="Yes = 1, No=0" required="required">
            <br>
            <h3>Hemoglobin</h3>
            <input type="text" id="third" name="hemo" placeholder="11.7,12.5" required="required">
            <br>
            <h3>Diabetes Mellitus</h3>
            <input type="text" id="fourth" name="dm" placeholder="Yes = 1, No=0" required="required">
            <br>
            <h3>Albumin</h3>
            <input type="text" id="fifth" name="al" placeholder="(0,1,2,3,4,5)" required="required">
            <br>
            <h3>Appetite</h3>
            <input type="text" id="sixth" name="appet" placeholder="Good = 1, Poor = 0" required="required">
            <br>
            <h3>Red Blood Cell Count</h3>
            <input type="text" id="seventh" name="rc" placeholder="in Millions/cmm" required="required">
            <h3>Pus Cell</h3>
            <input type="text" id="eight" name="pc" placeholder="Normal = 0, Abnormal = 1" required="required">
            <br>
            <br>
            <br>
            <button id="sub" type="submit ">Submit</button>
            <br>
            <br>
            <br>
            <br>
            <p class='footer-description'></p>

        </form>
    </div></div>




<style>

/* Background Image */
body
{
background-image:url('Images/kidney2.jpg');
height: 100%;

/* Center and scale the image nicely */
background-position: center;
background-repeat: no-repeat;
background-size: 100% 100%;

}

/* Color */
body{
	font-family: Arial, Helvetica,sans-serif;
    text-align: center;
    margin: 0;
    padding: 0;
    width: 100%;
	height: 100%;
	display: flex;
	flex-direction: column;
}


/* Heading Font */
.container-heading{
    margin: 0;
}

./* blurred-background {
      position: absolute;
      top: 0;
      left: 0;
      width: 100%;
      height: 100%;
      background-image: inherit; /* Inherit background image from the body */
      background-size: inherit;
      background-position: inherit;
      filter: blur(8px); /* Apply the blur effect (adjust the px value for more/less blur) */
      z-index: -1; /* Place the blurred background behind the content */
    } */

.heading_font{
    color: #black;
	font-family: 'Pacifico', cursive;
	font-size: 50px;
	font-weight: normal;
}



/* Box */
        #first {
            border-radius: 14px;
            height: 30px;
            width: 300px;
            font-size: 18px;
            text-align: center;
        }

        #second {
            border-radius: 14px;
            height: 25px;
            width: 160px;
            font-size: 20px;
            text-align: center;
        }

        #third {
            border-radius: 14px;
            height: 25px;
            width: 120px;
            font-size: 20px;
            text-align: center;
        }

        #fourth {
            border-radius: 14px;
            height: 25px;
            width: 160px;
            font-size: 20px;
            text-align: center;
        }

        #fifth {
            border-radius: 14px;
            height: 25px;
            width: 130px;
            font-size: 20px;
            text-align: center;
        }

        #sixth {
            border-radius: 14px;
            height: 25px;
            width: 200px;
            font-size: 20px;
            text-align: center;
        }

        #seventh {
            border-radius: 14px;
            height: 25px;
            width: 180px;
            font-size: 20px;
            text-align: center;
        }

        #eight {
            border-radius: 14px;
            height: 25px;
            width: 260px;
            font-size: 20px;
            text-align: center;
        }


/* Submit Button */
#sub {
            width: 120px;
            height: 43px;
            text-align: center;
            border-radius: 14px;
            font-size: 18px;
        }




<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

</style>


</body>
</html>