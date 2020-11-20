package org.lgim.data.orm;

import org.lgim.model.Channel;
import org.lgim.model.ContactPreference;
import org.lgim.model.Emotion;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity
@Table(name = "emotion_incident")
@NamedQuery(name = "emotions.findAll", query = "SELECT e FROM EmotionEntity e ORDER BY e.time")
public class EmotionEntity {

    public EmotionEntity() {
    }

    private Long id;
    private Emotion emotion;
    private String cause;
    private String userName;
    private ZonedDateTime time;
    private Channel channel;
    private String comments;
    private ContactPreference contactPreference;

    //    @Id
//    @SequenceGenerator(name = "emotionSeq", sequenceName = "emotion_id_seq", allocationSize = 1, initialValue = 1)
//    @GeneratedValue(generator = "emotionSeq")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Enumerated(EnumType.STRING)
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

    public ZonedDateTime getTime() {
        return time;
    }

    public void setTime(ZonedDateTime time) {
        this.time = time;
    }

    @Enumerated(EnumType.STRING)
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

    @Enumerated(EnumType.STRING)
    public ContactPreference getContactPreference() {
        return contactPreference;
    }

    public void setContactPreference(ContactPreference contactPreference) {
        this.contactPreference = contactPreference;
    }

    @Override
    public String toString() {
        return "EmotionEntity{" +
                "id=" + id +
                ", emotion=" + emotion +
                ", cause='" + cause + '\'' +
                ", userName='" + userName + '\'' +
                ", time=" + time +
                ", channel=" + channel +
                ", comments='" + comments + '\'' +
                ", contactPreference=" + contactPreference +
                '}';
    }
}
