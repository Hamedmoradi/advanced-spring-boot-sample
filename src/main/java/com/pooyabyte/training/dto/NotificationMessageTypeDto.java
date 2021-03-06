package com.pooyabyte.training.dto;

import com.pooyabyte.training.domain.Customer;
import com.pooyabyte.training.domain.NotificationMessageType;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.*;

@XmlRootElement(name = "NotificationMessageType")
public class NotificationMessageTypeDto implements Serializable {


    private Integer id;
    private String[] messageTitle;
    private boolean active;
    private String type;
    private Customer customerId;

    public Customer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Customer customerId) {
        this.customerId = customerId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String[] getMessageTitle() {
        return messageTitle;
    }

    public void setMessageTitle(String[] messageTitle) {
        this.messageTitle = messageTitle;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    public static Optional<NotificationMessageTypeDto > notificationMessageTypeToDto(NotificationMessageType notificationMessageType) {
        if (notificationMessageType != null) {
            NotificationMessageTypeDto notificationMessageTypeDto = new NotificationMessageTypeDto();
            notificationMessageTypeDto.setId(notificationMessageType.getId());
            notificationMessageTypeDto.setMessageTitle(notificationMessageType.getMessageTitle());
            notificationMessageTypeDto.setActive(notificationMessageType.isActive());
            notificationMessageTypeDto.setType(notificationMessageType.getType());
            notificationMessageTypeDto.setCustomerId(notificationMessageType.getCustomerId());
            return Optional.of(notificationMessageTypeDto);
        } else {
            return Optional.empty();
        }
    }

    public static List<Optional<NotificationMessageTypeDto>> notificationMessageTypeToDto(Collection<NotificationMessageType> notificationMessageTypes) {
        if ((null != notificationMessageTypes) && (notificationMessageTypes.size() > 0)) {
            List<Optional<NotificationMessageTypeDto>> notificationMessageTypeDtoList = new ArrayList<>(notificationMessageTypes.size());
            for (NotificationMessageType notificationMessageType : notificationMessageTypes) {
                notificationMessageTypeDtoList.add(notificationMessageTypeToDto(notificationMessageType));
            }
            return notificationMessageTypeDtoList;
        } else {
            return Collections.EMPTY_LIST;
        }
    }


}

