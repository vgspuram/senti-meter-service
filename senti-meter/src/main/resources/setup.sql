CREATE TABLE emotion_incident (
    id BIGSERIAL,
	emotion TEXT,
    cause TEXT,
    userName TEXT,
    time TIMESTAMP,
    channel TEXT,
    comments TEXT,
    contactPreference TEXT,
	primary key(id)
);