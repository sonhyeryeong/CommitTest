

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class PrizeNum {

	public ArrayList<Integer> PrizeNum() {

		// 숫자 7개짜리 배열이 만들어진다 ( 겹칠 수 있다.)
		ArrayList<Integer> arr = new ArrayList<>();
		Random random = new Random(); 

		for (int i = 0; i < 7; i++) {
			// arr에다가 랜덤 7개를 넣어줌
			arr.add(random.nextInt(45) + 1);
		}

		// 중복을 없애기 위해서 다시 set에다가 넣어준다.
		Set<Integer> set = new HashSet<>(arr); // 길이가 얼마인지 모름
		
		int plusNum = 0;

		// for는 일곱번 돌아가는데,

		// 1 2 3 4 5 5 5 -> arr1
		// set -> 1 2 3 4 5 [] []

			for (int i = 0; i < arr.size(); i ++ ) {
				if (arr.size() != set.size()) {
					plusNum = random.nextInt(45) + 1;
					set.add(plusNum);
				}
			}
		// set이 하나 새로 만들어졌다. set 길이는 ??? = 
		ArrayList<Integer> arr2 = new ArrayList<>(set);
		return arr2;
	}

}
