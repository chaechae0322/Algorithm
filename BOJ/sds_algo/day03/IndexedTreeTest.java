package BOJ.sds_algo.day03;

import java.util.Arrays;

/*
 * 인덱스 트리 구현
 */
public class IndexedTreeTest {
	
	public static void main(String[] args) {
		int[] inputs = {0,3,2,4,5,1,6,2,7}; // 8개;
		//depth 3 -> leaf 8개
		IndexedTree it = new IndexedTree(inputs);
		System.out.println(it);
		it.makeTree(1, 1, it.leafSize);
		System.out.println(it);
		
		// 3~7 부분합
		System.out.println(it.query(1, 1, it.leafSize, 3, 7));
		
		//index 3 : 4 -> 3 으로 변경
		int targetIndex=3;
		int targetValue=3;
		int diff= targetValue - inputs[targetIndex];
		it.update(1, 1, it.leafSize, targetIndex, diff);
		inputs[targetIndex]=targetValue;
		System.out.println(it);
	}

}

class IndexedTree {
	int[] tree;
	int[] nums;
	int leafSize, depth;
	
	public IndexedTree(int[] nums) {
		this.nums=nums;
		depth=0;
		while(Math.pow(2, depth) < nums.length - 1) {
			//depth 알기
			depth++;
		}
		
		leafSize=(int) Math.pow(2, depth);
		tree= new int[(int)Math.pow(2, depth+1)]; // 높이 : depth + 1 , 총 노드수 = 2^높이-1
		
	}
	//내부노드에 값을 채워준다
	public int makeTree(int node, int left, int right) {
		
		//리프 노드일 경우에는 데이터를 채워준다
		if(left==right) {
			// leaf node
			if(left<= nums.length) {
				return tree[node]=nums[left];
			}else {
				return tree[node]=0;
			}
		}
		
		//리프노드가 아닐경우에는 완쪽오른쪽 으로 갈라서 재귀
		int mid=(left+right)/2;
		tree[node] = makeTree(node*2, left, mid);
		tree[node] += makeTree(node*2+1, mid+1, right);
		
		return tree[node];
	}
	
	//원하는 구간의 합 or 문제의 답을 구한다
	public int query(int node, int left, int right, int qLeft, int qRight) {
		if(qRight < left || qLeft > right) { // 범위가 아닌 경우
			return 0;
		} else if(qLeft <= left && qRight >= right) { // 완전히 속해있는 경우
			return tree[node];
		}else { // 애매하게 걸ㅊ있는 경우
			int mid = (left+right)/2;
			return query(node*2, left, mid, qLeft, qRight)
					+ query(node*2+1, mid+1, right, qLeft, qRight);
		
		}
	}
	//특정값을 갱신한다.
	public void update(int node, int left, int right, int index, int diff) {
		if(index < left || index > right) return;
		else {
			tree[node]+=diff;
			if(left != right) {
				int mid=(left+right)/2;
				update(node*2, left, mid, index, diff);
				update(node*2+1, mid+1, right, index, diff);
			}
		}
	}
	@Override
	public String toString() {
		return "IndexedTree [tree=" + Arrays.toString(tree) + ", nums=" + Arrays.toString(nums) + ", leafSize="
				+ leafSize + ", depth=" + depth + "]";
	}
	
}
