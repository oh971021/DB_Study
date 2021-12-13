// JS 활용한 유효성 검사 lib 완성!
	
// 일반적으로 입력값의 유효성을 검사하는 것들
// 함수형태로 정리해놓기 (나중에 쓰려고)
// .jar 라이브러리 쓰는 것 처럼

	// 문제가 있으면 true, 없으면 false

// <input>을 넣으면..
	// 거기에 글자가 없으면 true 있으면 false
function isEmpty(input) {
	return !input.value // 값이 없으면 과 같음
}


// <input>랑 글자수를 넣으면..
	// 입력한 글자수 보다 적으면 true 아니면 false
function lessThan(input, length) {
	return input.value.length < length;
}


// <input>을 넣으면
	// 한글, 특수문자 들어있으면 true, 없으면 false
function containKR(input) {
	// 너무 많으니까 되는거만 적어놓기
	let ok = "qwertyuiopasdfgjklzxcvbnmQWERTYUIOPASDFGJKLZXCVBNM1234567890@._";
	
	for (let i = 0; i < input.value.length; i++) {
		// 사용자가 input에 입력한 값을 하나씩 반복해서 검사한다.
		if (ok.indexOf(input.value[i]) == -1) {
			return true;
		}
	}
}


// <input> x 2개 넣으면 
	// 내용이 다르면 true, 아니면 false
function notEquals(input, input1) {
	return input.value != input1.value;
}


// <input>, 문자열 세트
	// 그 문자열 세트가 포함 안되있으면 true
	// 들어있으면 false
function notContains(input, set) {
	// set : 0123456789 -> 숫자를 반드시 포함
	// set : QWERTYUIOPASDFGHJKLZXCVBNMqwertyuiopasdfghjklzxcvbnm -> 영문을 반드시 포함
	
	for (let i = 0; i < set.length; i++) {
		if (input.value.indexOf(set[i]) != -1) {
			return false;
		}		
	}
	// 돌려보고 포함되지 않았으면 true로 넘겨서 에러로 잡는다.
	return true;
}

// <input> 을 넣으면
	// 숫자가 아니면 true, 숫자면 false
function isNotNumber(input) {
	return isNaN(input.value);
}


// <input>, 확장자를 넣게 (확장자 제한)
// 최대한 넓은 범위로 활용하려 하는데
// 사이트마다 다 다를 수 있음.
// xxx(photoInput, "jpg")
// 그게 아니면 true, 그거면 false
function isNotType(input, type) {
	type = "." + type; // .jpg or .png
	
	return input.value.indexOf(type) == -1	// inputdp .jpg가 있나 없나 확인함
}








