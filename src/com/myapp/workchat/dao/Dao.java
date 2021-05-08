package com.myapp.workchat.dao;

import java.util.List;
import java.util.Optional;

public interface Dao <T,K>{
	
	public List<K> findAll ();
	
	public Optional<K> findById (T id);
	
	public void update (T id);
	
	public Boolean delete (T id);
	
	public K save (K entity);
}
