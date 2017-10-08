package ittalents.couchshare.model.POJO;

import java.util.*;

public class Country {
private int id;
private String name;

public Country( String name) {
	this.name = name;
}
public Country(int id, String name) {
	this(name);
	this.id = id;

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
