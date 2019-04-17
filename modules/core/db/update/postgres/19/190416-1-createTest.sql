create table COMPOSITEDATATYPE_TEST (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255),
    COMMENT_ text,
    CD varchar(4096),
    --
    primary key (ID)
);
