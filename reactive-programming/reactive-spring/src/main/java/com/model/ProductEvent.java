package com.model;

import java.util.Objects;

public class ProductEvent {

	private Long eventId;
	private String eventType;
	public ProductEvent() {}
	public ProductEvent(Long eventId, String eventType) {
		this.eventId = eventId;
		this.eventType = eventType;
	}
	public Long getEventId() {
		return eventId;
	}
	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}
	public String getEventType() {
		return eventType;
	}
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}
	@Override
	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((eventId == null) ? 0 : eventId.hashCode());
//		result = prime * result + ((eventType == null) ? 0 : eventType.hashCode());
//		return result;
		
		//using java 8
		return Objects.hash(eventId,eventType);
		
	}
	@Override
	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		ProductEvent other = (ProductEvent) obj;
//		if (eventId == null) {
//			if (other.eventId != null)
//				return false;
//		} else if (!eventId.equals(other.eventId))
//			return false;
//		if (eventType == null) {
//			if (other.eventType != null)
//				return false;
//		} else if (!eventType.equals(other.eventType))
//			return false;
//		return true;
		
		//using java 8
		if(this == obj) {
			return true;
		}
		if(obj == null) {
			return false;
		}
		if(obj == null || getClass() != obj.getClass()) {
			return false;
		}
		ProductEvent that = (ProductEvent)obj;
		return Objects.equals(eventId, that.eventId) && Objects.equals(eventType, that.eventType);
	}
	@Override
	public String toString() {
		return "ProductEvent [eventId=" + eventId + ", eventType=" + eventType + "]";
	}
	
	
}
