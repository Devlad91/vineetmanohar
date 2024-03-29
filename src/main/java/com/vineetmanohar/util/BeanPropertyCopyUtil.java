package com.vineetmanohar.util;

import java.lang.reflect.InvocationTargetException;
import org.apache.commons.beanutils.BeanUtils;

/** 
 * @author Vineet Manohar
 */
public class BeanPropertyCopyUtil {
	/**
	 * copies properties from one object to another
	 * 
	 * @param src
	 *            the source object
	 * @param dest
	 *            the destination object
	 * @param properties
	 *            a list of property names that are to be copied. Each value has
	 *            the format "srcProperty destProperty". For example,
	 *            "name fullName" indicates that you want to copy the src.name
	 *            value to dest.fullName. If both the srcProperty and
	 *            destProperty property have the same name, you can omit the
	 *            destProperty. For example, "name" indicates that you want to
	 *            copy src.name to dest.name.
	 * 
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 */
	public static void copyProperties(Object src, Object dest,
			String... properties) throws IllegalAccessException,
			InvocationTargetException, NoSuchMethodException {
		for (String property : properties) {
			String[] arr = property.split(" ");
			String srcProperty;
			String destProperty;
			if (arr.length == 2) {
				srcProperty = arr[0];
				destProperty = arr[1];
			} else {
				srcProperty = property;
				destProperty = property;
			}
			BeanUtils.setProperty(dest, destProperty, BeanUtils.getProperty(
					src, srcProperty));
		}
	}
}