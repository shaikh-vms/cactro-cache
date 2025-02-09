package com.cactro.cache.api.model;

public class CacheData {

	String key;
	Object value;
	String expireAfterMiliseconds;
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public Object getValue() {
		return value;
	}
	public void setValue(Object value) {
		this.value = value;
	}
	public String getExpireAfterMiliseconds() {
		return expireAfterMiliseconds;
	}
	public void setExpireAfterMiliseconds(String expireAfterMiliseconds) {
		this.expireAfterMiliseconds = expireAfterMiliseconds;
	}
	
}
