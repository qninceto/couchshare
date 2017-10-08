package itttalents.couchshare.model.interfaces;

import ittalents.couchshare.model.POJO.Event;
import ittalents.couchshare.model.exception.EventException;

public interface IEventDAO {
	public int createEvent(Event event) throws EventException;
}
