package ittalents.couchshare.model.interfaces;

import java.util.List;

import ittalents.couchshare.model.POJO.Request;
import ittalents.couchshare.model.exceptions.PostException;
import ittalents.couchshare.model.exceptions.RequestException;
import ittalents.couchshare.model.exceptions.UserException;

public interface IRequestDAO {
	public int addRequest(Request request) throws PostException, RequestException;
	public boolean updateRequstToAccepted(Request request) throws RequestException;
	public boolean updateRequstToDenied(Request request) throws RequestException;
	public Request getRequestById(int reqId) throws RequestException, PostException, UserException;
	public List<Request> getListOfRequestsSentFromUser(int userId) throws RequestException, PostException, UserException;
	public List<Request> getListOfRequestsReceivedByUser(int userId) throws RequestException, PostException, UserException;
}
