function call() {
	
	// 값
	let input = document.getElementById('i1');
	
	if (isEmpty(input) || isNotNumber(input)) {
		alert('값을 입력하세요.')
		
		input.focus();
		input.value = "";
		
		return false;	
	}
	
}