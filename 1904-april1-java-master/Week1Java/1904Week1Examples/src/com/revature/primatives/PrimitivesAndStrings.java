package com.revature.primatives;

public class PrimitivesAndStrings {
	//Java has 8 primitive (Non object) datatypes.
			int i; //32 bit
			short s; //16 bit number
			long l; //64 bit number
			byte b; //8 bit number
			char c = 97; //16 bit character range of 0-65535
			float f; //32 bit decimal number
			double d;//64 bit decimal number 
			boolean bool; //Anywhere from 1-8 bits. 
			/*
			 * Due to the the nature of keeping memory allocations of the size of multiples
			 * of 8 bits, it would be too difficult to have a datatype of 1 bit (true/false)
			 * So Java allocates 8 bits allegedly.
			 */
			
			//Another common datatype you will see is String
			//it is not a primitive datatype. it is an object
			String str;
			
			
			public static void main(String[] args) {
				PrimitivesAndStrings p = new PrimitivesAndStrings();
				p.doStuff();
			}
			
			public void doStuff(){
				System.out.println(i);
				System.out.println(s);
				System.out.println(l);
				System.out.println(b);
				System.out.println(c);
				System.out.println(f);
				System.out.println(d);
				System.out.println(bool);
			}
			
			public void castingStuff(){
				/*
				 * Variable casting is the conversion of on variable's datatype to another.
				 * Casting comes in two flavors:
				 * -implicit casting (widening)
				 * 		-You do not have to actually write out the cast
				 * -explicit casting (narrowing)
				 * 		-You DO write out the cast: (newDatatype)varName/primitive
				 */
				
				/*
				 * When it comes to primitive casting, you can mostly perform implicit casting if
				 * you are converting a smaller datatype to a bigger one.
				 * However when converting from bigger to smaller, explicitly stating the cast is
				 * required.
				 */
				
				i = (int)d;
				d = i;
				s = (short)l;
				l = s;
				l = (long)f;
				
				b = (byte)c;
				c = (char)b;
			}
}
