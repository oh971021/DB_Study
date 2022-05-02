
/* 데이터 삭제 */
function deleteMovie(n) {
	/* 지우기 전 물어보기 위해 JS 사용 */
	let ok = confirm('정말 삭제 합니까?');
	// alert(ok);
	if(ok) {
		location.href='MovieDelController?no=' + n;
	} else {
		alert('실패요 ㅋㅋ');
	}
}

function updateMovie(t, a, s, n) {
	
	let t1 = prompt("수정 할 제목", t);

	if (t1 != null && t1 != '') {
		let a1 = prompt("수정 할 배우", a);
		let s1 = prompt("수정 할 줄거리", s);
		location.href='MovieUpdateC?title=' + t1 + '&actor=' + a1 + '&story=' + s1 + '&no=' + n;
	}
	
}