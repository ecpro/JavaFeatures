package com.piyush.inputOutput;

public class MyAutoClosable implements AutoCloseable {

	public void doSomething() throws Exception {
		System.out.println("called method doSomething()");
		//throw new Exception("fuck you");
	}

	@Override
	public void close() throws Exception {
		System.out.println("Called close()");
	}

	public static void main(String[] args) {
		try (MyAutoClosable mac = new MyAutoClosable()) {
			mac.doSomething();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
