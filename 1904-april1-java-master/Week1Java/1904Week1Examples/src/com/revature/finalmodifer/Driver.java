package com.revature.finalmodifer;

public class Driver extends FinalExample{

	public static void main(String[] args) {
		FinalExample fe = new FinalExample();
		System.out.println(fe.FINAL_FIELD);
//		fe.FINAL_FIELD++; note we cannot change a final field
//		fe.FINAL_FIELD = 99; we cannot reassign them either


	}
	public void method1() {
		super.method1();
	}
	
// note that you cannot override method2() because it is final
//	public void method2() {
//		super.method2();
//	}

}
