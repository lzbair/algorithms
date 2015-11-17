package io.mergesort;

public interface BlocExecutor<T> {

	T doExecution() throws Exception;

	default T execute(String operation) throws Exception {
		long start = System.currentTimeMillis();
		T result = doExecution();
		long end = System.currentTimeMillis();
		System.out.println(operation + " : " + ((end - start) / 1000) + " Seconds");
		return result;
	}



}
