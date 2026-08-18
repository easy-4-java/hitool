/*
 * Copyright (c) 2018, hiwepy (https://github.com/easy-4-java).
 * All Rights Reserved. 
 */
package hitool.core.collections;

import org.apache.commons.collections.Predicate;

import hitool.core.collections.functors.TreeMapPredicate;

public class PredicateUtils extends org.apache.commons.collections.PredicateUtils {
	
	public static Predicate treeMapPredicate(String key,String parent) {
		return new TreeMapPredicate(key,parent);
	} 
	
}
