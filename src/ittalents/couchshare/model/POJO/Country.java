package ittalents.couchshare.model.POJO;

import java.util.*;

public class Country {
private int id;
private String name;

public Country(int id, String name) {
	super();
	this.id = id;
	this.name = name;
}

public int getId() {
	return id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
}
