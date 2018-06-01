package com.piyush.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import com.piyush.multithreading.BankAccount;

class ReflectionExample {

	public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException {
		
		// get Class object of the desired class
		Class<BankAccount> bac = BankAccount.class;

		// get methods and fields from Class's object
		Method[] methods = bac.getMethods();
		for (Method m : methods) {
			System.out.println("method " + m.getName());
		}

		// get modifiers
		int modifiers = methods[1].getModifiers();
		System.out.println(modifiers);
		
		// check modifier's actual value
		/*
		 * Modifier.isAbstract(int modifiers) Modifier.isFinal(int modifiers)
		 * Modifier.isInterface(int modifiers) Modifier.isNative(int modifiers)
		 * Modifier.isPrivate(int modifiers) Modifier.isProtected(int modifiers)
		 * Modifier.isPublic(int modifiers) Modifier.isStatic(int modifiers)
		 * Modifier.isStrict(int modifiers) Modifier.isSynchronized(int modifiers)
		 * Modifier.isTransient(int modifiers) Modifier.isVolatile(int modifiers)
		 */
		System.out.println(Modifier.isPublic(modifiers));

		BankAccount ba = new BankAccount(12.2);
		Field field = bac.getField("amount");
		field.setAccessible(true);
		field.set(ba, 234.53);

		System.out.println(ba.getAmount());


	}
}
