CREATE TABLE category
(
    id              BIGINT NOT NULL AUTO_INCREMENT,
    created_at      datetime NULL,
    last_updated_at datetime NULL,
    is_deleted      BIT(1) NOT NULL,
    name            VARCHAR(255) NULL,
    CONSTRAINT pk_category PRIMARY KEY (id)
);

CREATE TABLE join_instructor
(
    user_id           BIGINT NOT NULL,
    number_of_classes INT    NOT NULL,
    CONSTRAINT pk_join_instructor PRIMARY KEY (user_id)
);

CREATE TABLE join_mentor
(
    user_id BIGINT NOT NULL,
    rating  VARCHAR(255) NULL,
    CONSTRAINT pk_join_mentor PRIMARY KEY (user_id)
);

CREATE TABLE join_user
(
    id       BIGINT NOT NULL,
    name     VARCHAR(255) NULL,
    password VARCHAR(255) NULL,
    CONSTRAINT pk_join_user PRIMARY KEY (id)
);

CREATE TABLE mp_instructor
(
    id                BIGINT NOT NULL,
    name              VARCHAR(255) NULL,
    password          VARCHAR(255) NULL,
    number_of_classes INT    NOT NULL,
    CONSTRAINT pk_mp_instructor PRIMARY KEY (id)
);

CREATE TABLE mp_mentor
(
    id       BIGINT NOT NULL,
    name     VARCHAR(255) NULL,
    password VARCHAR(255) NULL,
    rating   VARCHAR(255) NULL,
    CONSTRAINT pk_mp_mentor PRIMARY KEY (id)
);

CREATE TABLE product
(
    id              BIGINT NOT NULL AUTO_INCREMENT,
    created_at      datetime NULL,
    last_updated_at datetime NULL,
    is_deleted      BIT(1) NOT NULL,
    title           VARCHAR(255) NULL,
    price DOUBLE NOT NULL,
    category_id     BIGINT NULL,
    `description`   VARCHAR(255) NULL,
    image_url       VARCHAR(255) NULL,
    CONSTRAINT pk_product PRIMARY KEY (id)
);

CREATE TABLE single_table_user
(
    id                BIGINT NOT NULL,
    user_type         INT NULL,
    name              VARCHAR(255) NULL,
    password          VARCHAR(255) NULL,
    rating            VARCHAR(255) NULL,
    number_of_classes INT    NOT NULL,
    CONSTRAINT pk_single_table_user PRIMARY KEY (id)
);

CREATE TABLE tpc_instructor
(
    id                BIGINT NOT NULL,
    name              VARCHAR(255) NULL,
    password          VARCHAR(255) NULL,
    number_of_classes INT    NOT NULL,
    CONSTRAINT pk_tpc_instructor PRIMARY KEY (id)
);

CREATE TABLE tpc_mentor
(
    id       BIGINT NOT NULL,
    name     VARCHAR(255) NULL,
    password VARCHAR(255) NULL,
    rating   VARCHAR(255) NULL,
    CONSTRAINT pk_tpc_mentor PRIMARY KEY (id)
);

CREATE TABLE tpc_user
(
    id       BIGINT NOT NULL,
    name     VARCHAR(255) NULL,
    password VARCHAR(255) NULL,
    CONSTRAINT pk_tpc_user PRIMARY KEY (id)
);

ALTER TABLE join_instructor
    ADD CONSTRAINT FK_JOIN_INSTRUCTOR_ON_USER FOREIGN KEY (user_id) REFERENCES join_user (id);

ALTER TABLE join_mentor
    ADD CONSTRAINT FK_JOIN_MENTOR_ON_USER FOREIGN KEY (user_id) REFERENCES join_user (id);

ALTER TABLE product
    ADD CONSTRAINT FK_PRODUCT_ON_CATEGORY FOREIGN KEY (category_id) REFERENCES category (id);