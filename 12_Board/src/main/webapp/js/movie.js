
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