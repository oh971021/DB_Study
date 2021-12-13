function check() {
	
	let ImgInput = document.myForm.img;
	
	if(isNotType(ImgInput, "jpg") && isNotType(ImgInput, "png")) {
		alert('file error');
		return false;
	}
	
	return true;
}