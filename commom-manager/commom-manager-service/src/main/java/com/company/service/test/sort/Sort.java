package com.company.service.test.sort;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tomyu on 2019/1/11.
 */
public class Sort {

	private static  List<Integer> list = SortNumberUtils.readNumberFromFile(new Integer(0));

	//直接插排序 平均时间复杂度O(N^2)
	@Test
	public void SimpleInsertSort(){

		for (int i=1;i<list.size();i++){
			Integer temp=list.get(i);
			int j;
			for (j=i-1; j>=0 && list.get(j)>temp ;j--){
				Integer big = list.get(j);
				list.set(j+1,big);
			}
			list.set(j+1,temp);
		}
		System.out.println(list);

	}

	//shell排序
	@Test
	public void ShellInsertSort(){

		for (int gap=list.size()/2;gap>0;gap/=2){

			for (int i=gap;i<list.size();i++){
				int temp=list.get(i);
				int j;
				for ( j=i-gap;j>=0 && list.get(j)>temp;j-=gap){
					Integer max = list.get(j);
					int tempIndex=j+gap;
					list.set(tempIndex,max);
				}
				list.set(j+=gap,temp);
			}
		}
		System.out.println(list);

	}

	//堆排序
	@Test
	public void heapSort(){
		printTree(list);
		List<Integer> tempList;
		//第一次生成最大堆
		for (int i=list.size()/2-1;i>=0;i--){
			perDown(list,i,list.size()-1);
		}
		printTree(list);
		for (int lastIndex=list.size()-1;lastIndex>=0;lastIndex--){
			Integer temp = list.get(lastIndex);
			list.set(lastIndex,list.get(0));
			list.set(0,temp);

			printTree(list);

			for (int i=(lastIndex)/2-1;i>=0;i--){
				perDown(list,i,lastIndex-1);
			}
//			perDown(list,0,lastIndex-1);

			printTree(list);
		}
		System.out.println(list);
	}

	//将二叉树从下往上生成最大堆
	//从index节点开始向下找，把最大值放到index位置
	private static <AnyType extends Comparable<? super AnyType>> void perDown(List<AnyType> list,int index,int maxIndex){
		int tempIndex;
		int childIndex;
		AnyType tempValue=list.get(index);

		for (tempIndex=index;(childIndex=2*tempIndex+1)<=maxIndex;tempIndex=childIndex){
			if (childIndex !=maxIndex  && list.get(childIndex).compareTo(list.get(childIndex+1))<0){
				childIndex++;
			}
			if (list.get(tempIndex).compareTo(list.get(childIndex))<0){
				list.set(tempIndex,list.get(childIndex));
			}else
				break;
		}
		list.set(tempIndex,tempValue);
	}

	@Test
	public void test(){
		printTree(list);
//		System.out.println(Math.log(16));
//		System.out.println(Math.log(2));
//		double log1 = Math.log(16);
//		double log2 = Math.log(2);
//		System.out.println(log1/log2);
		List<Integer> list=new ArrayList<>();
		//list set方法：是替换操作，前提是这个位置必须要有元素
		list.set(0,0);
	}

	//将list按照二叉树打印
	private static void printTree(List<Integer> list){
		double k = Math.log(list.size() + 1) / Math.log(2);
		int n=(int)Math.ceil(k);
		int maxNum=(int)Math.pow(2,n-1);
		int maxCount=2*maxNum-1;
		for (int i=1;i<=n;i++){
			for (int j=(int)Math.pow(2,n-i)-1;j>0;j--){
				System.out.print(" ");
			}
			int lineStart = (int)Math.pow(2, i - 1);
			int lineEnd = (int)Math.pow(2, i)-1;
			for (int index=lineStart-1;index<=lineEnd-1 && index<list.size();index++){
				System.out.print(list.get(index));
				for (int m=(int)Math.pow(2,n-i+1)-1;m>0;m--){
					System.out.print(" ");
				}
			}
			System.out.print("\n");
		}


	}

	//归并排序
	@Test
	public void mergeSort(){
		mergeSortStep1(list,new ArrayList<Integer>(),0,list.size()-1 );
		System.out.println(list);
	}
	//这个位置是递归，把数据拆分处理：分治策略
	public <AnyType extends Comparable<? super AnyType>> void mergeSortStep1(
			List<AnyType> targetList,List<AnyType> tempList,int startIndex,int endIndex){
		if (startIndex<endIndex){
			int center=(startIndex+endIndex)/2;
			mergeSortStep1(targetList,tempList,startIndex,center);
			mergeSortStep1(targetList,tempList,center+1,endIndex);
			mergeSortStep2(targetList,tempList,startIndex,center,endIndex);
		}
	}

	//这里处理分治策略的基本单元
	public <AnyType extends Comparable<? super AnyType>> void mergeSortStep2(
			List<AnyType> targetList,List<AnyType> tempList,int leftStartIndex,int leftEndIndex,int rightEndIndex){
		//实际上是把数据看成左右两段
		int rightStartIndex=leftEndIndex+1;

		//这个位置是标记暂存list的位置
		int tempStartIndex=leftStartIndex;
		//这个是为了后把tempList 赋值给 targetList做准备
		int originalStartIndex=leftStartIndex;
		int originalEndIndex=rightEndIndex;
		//这个就是归并的 “并比较”，比较两个已经排序的序列，按照大小放置到tempList
		while (leftStartIndex<=leftEndIndex && rightStartIndex<=rightEndIndex){
			if (targetList.get(leftStartIndex).compareTo(targetList.get(rightStartIndex))<0){
				tempList.add(tempStartIndex++,targetList.get(leftStartIndex++));
			}else {
//				tempList.set(tempStartIndex++,targetList.get(rightStartIndex++));
				AnyType anyType = targetList.get(rightStartIndex);
				tempList.add(tempStartIndex,anyType);
				rightStartIndex++;
				tempStartIndex++;
			}
		}
		while (leftStartIndex<=leftEndIndex){
			tempList.add(tempStartIndex++,targetList.get(leftStartIndex++));
		}
		while (rightStartIndex<=rightEndIndex){
			tempList.add(tempStartIndex++,targetList.get(rightStartIndex++));
		}

		for (int i=originalStartIndex;i<=originalEndIndex;i++){
			targetList.set(i,tempList.get(i));
		}
		//不可以清空，比如第8个位置放入数据的时候，前面7个位置需要有数据占位。
//		tempList.clear();
	}


	//快速排序
	@Test
	public void quickSort(){
		quickSortStep(list);
		System.out.println(list);
	}


	public <AnyType extends Comparable<? super AnyType>> void quickSortStep(List<AnyType> targetList){
		//最后增加的条件，判断是否进入
		if (targetList==null || targetList.size()<2)
			return;

		List<AnyType> smallerList=new ArrayList<>();
		List<AnyType> bigerList=new ArrayList<>();
		List<AnyType> chosenList=new ArrayList<>();

		//选一个中间值，分组放置其他数值
		AnyType center = targetList.get(targetList.size() / 2);
		for (AnyType item:targetList){
			if (item.compareTo(center)<0){
				smallerList.add(item);
			}else if (item.compareTo(center)>0){
				bigerList.add(item);
			}else if (item.compareTo(center)==0){
				chosenList.add(item);
			}
		}

		//递归排训
		quickSortStep(smallerList);
		quickSortStep(bigerList);

		//把排序后的集合 合并
		targetList.clear();

		targetList.addAll(smallerList);
		targetList.addAll(chosenList);
		targetList.addAll(bigerList);
	}

	@Test
	public void quickSort2(){
		quickSortStepMethod2(list,0,list.size()-1);
		System.out.println(list);
	}

//	另外一个方法，不增加新建的 new ArrayList<>()
	public <AnyType extends Comparable<? super AnyType>> void quickSortStepMethod2(List<AnyType> targetList,int left,int right){

		if (right<=left)
			return;

		int leftPoint=left;
		int rightPoint=right;

		AnyType temp=targetList.get(left);
		//移动左指针
		while (leftPoint<rightPoint){
			while (leftPoint<rightPoint &&  targetList.get(leftPoint).compareTo(temp)<=0){
				leftPoint++;
			}
			//移动由指针
			while (leftPoint<rightPoint &&  targetList.get(rightPoint).compareTo(temp)>0){
				rightPoint--;
			}
			//leftPoint 与  rightPoint 交换
			if (leftPoint<rightPoint){
				change(list,leftPoint,rightPoint);
			}
		}

		if (targetList.get(leftPoint).compareTo(temp)<=0){
			change(list,left,leftPoint);
//			leftPoint++;
		}else {
			change(list,left,leftPoint-1);
			leftPoint--;
		}

		//递归
		quickSortStepMethod2(targetList,left,leftPoint-1);

		quickSortStepMethod2(targetList,leftPoint+1,right);



	}
	// 交换list两个位置的元素
	public <AnyType extends Comparable<? super AnyType>> void change(List<AnyType> targetList,int left,int right){
		AnyType temp2=targetList.get(left);
		targetList.set(left,targetList.get(right));
		targetList.set(right,temp2);
	}

	}
