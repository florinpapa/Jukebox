package utils;

import java.io.Serializable;
import java.util.LinkedList;


public class Message implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int type;
	LinkedList<Object> data;
}
