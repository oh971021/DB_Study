
public class PMain {
	public static void main(String[] args) {
		
		// 규칙
		int 총데이터수 = 11;
		int 한페이지당보여줄개수 = 3;
		
		// 페이지 개수
		int 총페이지수 = (int)Math.ceil((double)총데이터수 / 한페이지당보여줄개수);
		System.out.println(총페이지수);
		
		System.out.println("================");
		
		// 페이징
			// 1p : 1, 2, 3
			// 2p : 4, 5, 6
			// 3p : 7, 8, 9
			// 4p : 10, 11
		int 페이지번호 = 2;
		
		// 시작데이터번호, 끝데이터번호
		int 시작데이터번호1 = (페이지번호 - 1) * 한페이지당보여줄개수 + 1;
						// 2p = (2-1) * 3 + 1; 		4
						// 4p = (4-1) * 3 + 1;  	10
		
		// 역순
		int 시작데이터번호2 = 총데이터수 - (한페이지당보여줄개수 * (페이지번호 - 1));
						// 1p = 11 - (3 * (1-1));	11
						// 2p = 11 - (3 * (2-1));	8
		
		// 삼향연산자 = ifelse
		int 끝데이터번호1 = (페이지번호 == 총페이지수) ? 총데이터수 : 시작데이터번호2 + 한페이지당보여줄개수 - 1;
				// 2p = (2 == 4) :					  : 4 + 3 - 1;				6
				// 4p = (4 == 4) :			   11;								11
		
		// 역순
		int 끝데이터번호2 = (페이지번호 == 총페이지수) ? -1 : 시작데이터번호2 - (한페이지당보여줄개수 + 1);
				// 1p = (1 == 4) :				  : 11 - (3+1);		7
				// 2p = (2 == 4) : 				  : 8 - (3+1);		4
	}
}
