CREATE TABLE IF NOT EXISTS call
(
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR,
    location VARCHAR,
    emotional_tone VARCHAR NOT NULL CHECK (emotional_tone IN ('Neutral', ', Positive', ', Negative', 'Angry')),
    text VARCHAR
)
