<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta charset="ISO-8859-1">
<meta http-equiv = "X-UA-Compatible"  content = "IE=Edge">
<title>Reading TXT file</title>
</head>
<body>
<form method="POST" action="/uploadfile" enctype="multipart/form-data">
		<input type="file" name="file" /><br />
		<br /> <input type="submit" value="Submit" />
	</form>
<!-- <script>
  async function uploadFile() {
    let formData = new FormData();
    formData.append("file", ajaxfile.files[0]);
    await fetch('fileuploadservlet', {
      method: "POST",
      body: formData
    });
    alert('The file upload success!');
  }
  </script> -->
</body>
</html>

    
<!-- <script>
var file = localStorage.getItem("file");
function save(){
	var Item = document.getElementById("input").value;
	localStorage.setItem("file", item);
	
}
</script> -->


<!-- <form method = "post"  action = "/home" enctype="multipart/form-data">
<input type = "file" id= "input" required/>
<input type = "submit" value = "submit" onsubmit = "save()"/> 
</form> -->