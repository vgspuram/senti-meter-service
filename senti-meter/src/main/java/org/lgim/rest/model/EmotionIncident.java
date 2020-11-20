package org.lgim.rest.model;

import org.lgim.data.orm.EmotionEntity;
import org.lgim.model.Channel;
import org.lgim.model.ContactPreference;
import org.lgim.model.Emotion;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

public class EmotionIncident {
    private Long id;
    private Emotion emotion;
    private String cause;
    private String userName;
    private LocalDateTime time;
    private Channel channel;
    private String comments;
    private ContactPreference contactPreference;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Emotion getEmotion() {
        return emotion;
    }

    public void setEmotion(Emotion emotion) {
        this.emotion = emotion;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public ContactPreference getContactPreference() {
        return contactPreference;
    }

    public void setContactPreference(ContactPreference contactPreference) {
        this.contactPreference = contactPreference;
    }

    public static EmotionEntity getEmotionEntity(final EmotionIncident emotionIncident) {
        final EmotionEntity emotionEntity = new EmotionEntity();
        emotionEntity.setEmotion(emotionIncident.getEmotion());
        emotionEntity.setCause(emotionIncident.getCause());
        emotionEntity.setUserName(emotionIncident.getUserName());
        emotionEntity.setContactPreference(emotionIncident.getContactPreference());
        emotionEntity.setComments(emotionIncident.getComments());
        emotionEntity.setChannel(emotionIncident.getChannel());
        emotionEntity.setTime(ZonedDateTime.now());
        return emotionEntity;
    }

    public static EmotionIncident getEmotionIncident(final EmotionEntity emotionEntity) {
        final EmotionIncident emotionIncident = new EmotionIncident();
        emotionIncident.setId(emotionEntity.getId());
        emotionIncident.setEmotion(emotionEntity.getEmotion());
        emotionIncident.setCause(emotionEntity.getCause());
        emotionIncident.setUserName(emotionEntity.getUserName());
        emotionIncident.setContactPreference(emotionEntity.getContactPreference());
        emotionIncident.setComments(emotionEntity.getComments());
        emotionIncident.setChannel(emotionEntity.getChannel());
        emotionIncident.setTime(emotionEntity.getTime().toLocalDateTime());
        return emotionIncident;
    }

    @Override
    public String toString() {
        return "EmotionInstance{" +
                "emotion=" + emotion +
                ", cause='" + cause + '\'' +
                ", userName='" + userName + '\'' +
                ", time=" + time +
                ", channel=" + channel +
                ", comments='" + comments + '\'' +
                ", contactPreference=" + contactPreference +
                '}';
    }
}
