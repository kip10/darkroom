<html>
<head>
	<link rel="stylesheet" href="/DropZone/css/dropzonecss.css">
	<script src="/Dropzone/js/dropzone.js"></script>
</head>
<body>

<div class="well well-small canbehidden"><p>Upload files by clicking on the box below or by dragging files into it</p></div>

		<form action="Test1.php" method="post" enctype = "multipart/form-data" class="dropzone" id="filedrop" name="upload">
		
			<script>
			// filedrop is the configuration for the element that has an id attribute
			// with the value filedrop
			Dropzone.options.filedrop = {
				init: function() {
				this.on("addedfile", function(file) {

					// Create the remove button
					var removeButton = Dropzone.createElement("<button>Remove</button>");


					// Capture the Dropzone instance as closure.
					var _this = this;

					// Listen to the click event
					removeButton.addEventListener("click", function(e) {
					// Make sure the button click doesn't submit the form:
					e.preventDefault();
					e.stopPropagation();

					// Remove the file preview.
					_this.removeFile(file);
					// If you want to the delete the file on the server as well,
					// you can do the AJAX request here.
					});

					// Add the button to the file preview element.
					file.previewElement.appendChild(removeButton);
					
				
				});
				}
			};
			</script>
		</form>
<?php
if(isset($_POST['upload'])){
	$image_name = $_FILES['image']['name'];
	$image_type = $_FILES['image']['type'];
	$image_size = $_FILES['image']['size'];
	$image_tmp_name = $_FILES['image']['tmp_name'];
		
	if($image_name==''){
	echo "<script>alert('Please select an Image')</script>";
	exit();
	
	}
	else
	move_uploaded_file($image_tmp_name,"photos/$image_name");
	echo "Image uploaded successfully";
}

?>
</body>

</html>