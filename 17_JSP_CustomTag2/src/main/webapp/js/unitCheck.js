function block() {
	
	let name = document.getElementById('name');
	let weight = document.getElementById('weight');
	let height = document.getElementById('height');
	
	if (isEmpty(name) || lessThan(name, 2)) {
		alert('이름을 입력하세요');
		
		name.focus();
		name.value = "";
		
		return false;
	}
	
	if (isEmpty(height) || lessThan(height, 3) || isNotNumber(height)) {
		alert('키를 입력하세요');
		
		height.focus();
		height.value = "";
		
		return false;
	}	
	
	if (isEmpty(weight) || isNotNumber(weight)) {
		alert('몸무게를 입력하세요');
		
		weight.focus();
		weight.value = "";
		
		return false;
	}
	
	return true;
	
}