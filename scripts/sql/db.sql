-- entities
CREATE TABLE system_state
(
    state_id UUID NOT NULL,
    state    VARCHAR(255),
    CONSTRAINT pk_systemstate PRIMARY KEY (state_id)
);

CREATE TABLE device_model
(
    device_model_id   UUID NOT NULL,
    model_name        VARCHAR(255),
    model_description VARCHAR(255),
    CONSTRAINT pk_devicemodel PRIMARY KEY (device_model_id)
);

CREATE TABLE role
(
    role_id   UUID NOT NULL,
    role_name VARCHAR(255),
    scope     VARCHAR(255),
    CONSTRAINT pk_role PRIMARY KEY (role_id)
);

CREATE TABLE type_of_device
(
    type_of_device_id UUID NOT NULL,
    type_name         VARCHAR(255),
    CONSTRAINT pk_typeofdevice PRIMARY KEY (type_of_device_id)
);



CREATE TABLE area
(
    area_id               UUID NOT NULL,
    area_name             VARCHAR(255),
    system_state_state_id UUID,
    CONSTRAINT pk_area PRIMARY KEY (area_id)
);

CREATE TABLE device_state
(
    state_id          UUID NOT NULL,
    state_description VARCHAR(255),
    CONSTRAINT pk_devicestate PRIMARY KEY (state_id)
);


ALTER TABLE area
ADD CONSTRAINT FK_AREA_ON_SYSTEM_STATE_STATE
FOREIGN KEY (system_state_state_id) REFERENCES system_state (state_id);

CREATE TABLE manufacturer
(
    manufacturer_id      UUID NOT NULL,
    manufacturer_name    VARCHAR(255),
    system_state_sate_id UUID,
    CONSTRAINT pk_manufacturer PRIMARY KEY (manufacturer_id)
);

ALTER TABLE manufacturer
ADD CONSTRAINT FK_MANUFACTURER_ON_SYSTEM_STATE_SATE
FOREIGN KEY (system_state_sate_id) REFERENCES system_state (state_id);

CREATE TABLE device_model_manufacturer
(
    manufacturer_manufacturer_id UUID NOT NULL,
    device_model_device_model_id UUID NOT NULL,
    CONSTRAINT pk_devicemodelmanufacturer PRIMARY KEY (manufacturer_manufacturer_id, device_model_device_model_id)
);

ALTER TABLE device_model_manufacturer
ADD CONSTRAINT FK_DEVICEMODELMANUFACTURER_ON_DEVICE_MODEL_DEVICE_MODEL
    FOREIGN KEY (device_model_device_model_id)
        REFERENCES device_model (device_model_id);

ALTER TABLE device_model_manufacturer
ADD CONSTRAINT FK_DEVICEMODELMANUFACTURER_ON_MANUFACTURER_MANUFACTURER
FOREIGN KEY (manufacturer_manufacturer_id)
    REFERENCES manufacturer (manufacturer_id);

CREATE TABLE user_principal
(
    user_id              UUID NOT NULL,
    user_type            VARCHAR(255),
    id_number            VARCHAR(255),
    name                 VARCHAR(255),
    second_name          VARCHAR(255),
    first_last_name      VARCHAR(255),
    second_last_name     VARCHAR(255),
    email                VARCHAR(255),
    phone                VARCHAR(255),
    user_name            VARCHAR(255),
    password             VARCHAR(255),
    role_role_id         UUID,
    area_area_id         UUID,
    system_state_sate_id UUID,
    CONSTRAINT pk_userprincipal PRIMARY KEY (user_id)
);

ALTER TABLE user_principal
    ADD CONSTRAINT FK_USERPRINCIPAL_ON_AREA_AREA FOREIGN KEY (area_area_id) REFERENCES area (area_id);

ALTER TABLE user_principal
    ADD CONSTRAINT FK_USERPRINCIPAL_ON_ROLE_ROLE FOREIGN KEY (role_role_id) REFERENCES role (role_id);

ALTER TABLE user_principal
    ADD CONSTRAINT FK_USERPRINCIPAL_ON_SYSTEM_STATE_SATE FOREIGN KEY (system_state_sate_id) REFERENCES system_state (state_id);

CREATE TABLE device
(
    deviceid                         UUID NOT NULL,
    name                             VARCHAR(255),
    comments                         VARCHAR(255),
    serial_number                    VARCHAR(255),
    inventory_number                 INTEGER,
    device_state_state_id            UUID,
    type_of_device_type_of_device_id UUID,
    manufacturer_manufacturer_id     UUID,
    user_principal_user_id           UUID,
    CONSTRAINT pk_device PRIMARY KEY (deviceid)
);

ALTER TABLE device
    ADD CONSTRAINT FK_DEVICE_ON_DEVICE_STATE_STATE FOREIGN KEY (device_state_state_id) REFERENCES device_state (state_id);

ALTER TABLE device
    ADD CONSTRAINT FK_DEVICE_ON_MANUFACTURER_MANUFACTURER FOREIGN KEY (manufacturer_manufacturer_id) REFERENCES manufacturer (manufacturer_id);

ALTER TABLE device
    ADD CONSTRAINT FK_DEVICE_ON_TYPE_OF_DEVICE_TYPE_OF_DEVICE FOREIGN KEY (type_of_device_type_of_device_id) REFERENCES type_of_device (type_of_device_id);

ALTER TABLE device
    ADD CONSTRAINT FK_DEVICE_ON_USER_PRINCIPAL_USER FOREIGN KEY (user_principal_user_id) REFERENCES user_principal (user_id);

CREATE SEQUENCE device_inventory_number START 1;


CREATE OR REPLACE FUNCTION set_autoincremental_value()
RETURNS TRIGGER AS $$
BEGIN
    NEW.inventory_number = NEXTVAL('device_inventory_number');
RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER before_insert_device
    BEFORE INSERT ON device
    FOR EACH ROW
    EXECUTE FUNCTION set_autoincremental_value();


INSERT INTO system_state (state_id, state)
VALUES
    ('8a25d9d8-12d7-4b7b-b528-5f6f36d2b7fa', 'ACTIVE'),
    ('0ac0e71c-7f8f-44c8-87f6-38b926975034', 'DISABLED');


