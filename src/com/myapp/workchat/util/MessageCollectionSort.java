package com.myapp.workchat.util;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.myapp.workchat.entity.Message;

import lombok.experimental.UtilityClass;

@UtilityClass
public class MessageCollectionSort {
	
	private MessageComparator messageComparator = new MessageComparator();
	
	public List<Message> sortMessageByDate (List<Message> messageCollection) {
		
		Collections.sort(messageCollection, messageComparator);
		return messageCollection;
	}
	
	
	
	private class MessageComparator implements Comparator<Message>{

		public int compare(Message o1, Message o2) {
			if(o1.getSendDate().isBefore(o2.getSendDate())){
				return 1;
			}
			if(o1.getSendDate().isAfter(o2.getSendDate())) {
				return -1;
			}
			return 0;
		}
	}
	
}
