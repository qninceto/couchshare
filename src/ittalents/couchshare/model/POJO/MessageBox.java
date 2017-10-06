package ittalents.couchshare.model.POJO;

import java.time.LocalDate;
import java.util.*;

public class MessageBox {
private Collection<Message> messages;//composition!
private User interlocutor;//sybesednik
private User me;//leader of the conversation:me
private HostingStatusOfPost messageBoxType;
private final LocalDate chatCreationDate;
}
