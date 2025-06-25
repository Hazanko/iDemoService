CREATE TABLE person(
    id          INTEGER         NOT NULL,
    name        VARCHAR(255),
    birth_date  DATE,
    parent_1    INTEGER,
    parent_2    INTEGER,
    partner     INTEGER,
    PRIMARY KEY (id)
    CONSTRAINT fk_parent_1_id FOREIGN KEY (parent_1) REFERENCES person(id)
    CONSTRAINT fk_parent_2_id FOREIGN KEY (parent_2) REFERENCES person(id)
    CONSTRAINT fk_partner_id FOREIGN KEY (partner) REFERENCES person(id)
)

CREATE TABLE parent_child_relation(
    parent_id   INTEGER     NOT NULL,
    child_id    INTEGER     NOT NULL,
    PRIMARY KEY (parent_id, child_id)
    CONSTRAINT fk_parent_id_relation FOREIGN KEY (parent_id) REFERENCES person(id)
    CONSTRAINT fk_child_id_relation FOREIGN KEY (child_id) REFERENCES person(id)
)