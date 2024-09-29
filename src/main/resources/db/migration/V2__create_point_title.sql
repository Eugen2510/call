CREATE TABLE IF NOT EXISTS point(
    id BIGSERIAL PRIMARY KEY,
    key_point VARCHAR,
    category_id BIGINT,
    CONSTRAINT fk_point_category
                                FOREIGN KEY (category_id) REFERENCES category(id)
);