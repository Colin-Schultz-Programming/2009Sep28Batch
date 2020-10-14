package com.projectzero.repo;

import java.util.List;
/**
 * 
 * @authors Paul Bender, Revature
 * 
 * @param <T> //type of model
 * @param <I> //primary key for the model
 * 
 **/
public interface DaoContract<T, I> {
	/**
	 * 
	 * @return a list of all instances in the database
	 **/
	List<T> findAll();
	
	/**
	 * 
	 * @param i primary key of the instance
	 * @return the instance with the same primary key
	 **/
	T findById(I i);
	
	/**
	 * 
	 * @param t the instance to update
	 * @return the updated instance
	 **/
	T update(T t);
	
	/**
	 * 
	 * @param t the instance to create
	 * @return the created instance
	 **/
	T create(T t);
	
	/**
	 * 
	 * @param i the primary key of the instance to be removed
	 * @return how many were removed [ if failure, 1 is success]
	 **/
	int delete(I i);	
}		