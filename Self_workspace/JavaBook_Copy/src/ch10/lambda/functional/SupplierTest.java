package ch10.lambda.functional;

import java.util.function.Supplier;

public class SupplierTest {

	public void useSupplier(Supplier<String> sup) {
		System.out.println(sup.get());
	}
	
	public static void main(String[] args) {
		SupplierTest supT = new SupplierTest();
		Supplier<String> sup = ()->{
			return "Hello";
		};
		
		supT.useSupplier(sup);

		supT.useSupplier(()->{
			return "Lambda";
		});
		supT.useSupplier(()->"World");
	}

}
