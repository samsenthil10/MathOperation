package com.bridegelabz.mathoperation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class NumberPlaylist {

	public static void main(String[] args) {

		List<Integer> myNumberList = new ArrayList<Integer>();
		for(int index=0;index<5;index++) {
			myNumberList.add(index);
		}
		
		Iterator<Integer> iterator = myNumberList.iterator();
		while(iterator.hasNext()) {

			Integer number=iterator.next();
			System.out.println("Method1: Iterator value: "+number);
		}

		class MyConsumer implements Consumer<Integer> {

			@Override
			public void accept(Integer number) {

				System.out.println("Method2: Consumer implemented value: "+number);
			}

		}
		MyConsumer action = new MyConsumer();
		myNumberList.forEach(action);


		myNumberList.forEach(new Consumer<Integer>() {
			public void accept(Integer number) {
				System.out.println("Method3: foreach anonymous class value: "+number);

			}
		});

		Consumer<Integer> myListAction=number->{System.out.println("Method4: foreach "+number+" lambda implement value: "+number);};
		myNumberList.forEach(myListAction);

		myNumberList.forEach(number->{System.out.println("Method5: foreach "+number+" lambda implement value: "+number);});
	
		Function<Integer, Double> toDoubleFunction = Integer::doubleValue; 
		myNumberList.forEach(number->{System.out.println("Method6: foreach "+number+" lambda double value: "+toDoubleFunction.apply(number));});
		
		Predicate<Integer> isEvenFunction = number->number>0 && number%2==0;
		myNumberList.forEach(number->{System.out.println("Method7: foreach "+number+" lambda check even : "+isEvenFunction.test(number));});
		
		
		myNumberList.stream()
		.forEach(n-> {System.out.println("Method8: foreach:"+n);});
		
		myNumberList.stream()
					.map(toDoubleFunction)
					.forEach(n-> {System.out.println("Method9: foreach:"+n);});
		
	}
}