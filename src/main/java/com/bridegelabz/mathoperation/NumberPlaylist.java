package com.bridegelabz.mathoperation;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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

		List<Double> streamList = myNumberList.stream()
				.map(toDoubleFunction)
				.collect(Collectors.toList());
		System.out.println("Method10:"+streamList);

		List<Double> evenStreamList = myNumberList.stream()
				.filter(isEvenFunction)
				.map(toDoubleFunction)
				.collect(Collectors.toList());
		System.out.println("Method11:"+evenStreamList);


		Double topValue = evenStreamList.stream()
				.peek(n -> {System.out.println("Method12:"+n);})
				.findFirst()
				.orElse(null);
		System.out.println("Method12:"+topValue);

		Integer minValue = myNumberList.stream()
				.filter(isEvenFunction)
				.min(Comparator.comparing(Integer::intValue))
				.orElse(null);
		System.out.println("Method13 Minimum:"+minValue);

		Integer maxValue = myNumberList.stream()
				.filter(isEvenFunction)
				.max(Comparator.comparing(Integer::intValue))
				.orElse(null);
		System.out.println("Method13 Maximum:"+maxValue);

		Integer sum = myNumberList.stream()
				.reduce(0,Integer::sum);
		System.out.println("Method14 Sum:"+sum);

		long count = myNumberList.stream().count();
		System.out.println("Method14 Count:"+count);

		System.out.println("Method14 Average:"+sum/count);

		System.out.println("Method15 All Even? :"+myNumberList.stream().allMatch(isEvenFunction));
		System.out.println("Method15 Any Even? :"+myNumberList.stream().anyMatch(isEvenFunction));
		System.out.println("Method15 None as multiple of six? :"+myNumberList.stream().noneMatch(n-> n>0 && n%6==0));
	}
}