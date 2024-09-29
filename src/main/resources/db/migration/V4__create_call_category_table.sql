CREATE TABLE IF NOT EXISTS call_category
(
    call_id     BIGINT NOT NULL,
    category_id BIGINT NOT NULL,
    PRIMARY KEY (call_id, category_id),
    FOREIGN KEY (call_id) REFERENCES call (id) ON DELETE CASCADE,
    FOREIGN KEY (category_id) REFERENCES category (id) ON DELETE CASCADE
)