-- begin COMPOSITEDATATYPE_TEST
create table COMPOSITEDATATYPE_TEST (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255),
    COMMENT_ longvarchar,
    CD longvarchar,
    --
    primary key (ID)
)^
-- end COMPOSITEDATATYPE_TEST
-- begin COMPOSITEDATATYPE_PERSONAL
create table COMPOSITEDATATYPE_PERSONAL (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    FIO varchar(255),
    --
    primary key (ID)
)^
-- end COMPOSITEDATATYPE_PERSONAL
-- begin COMPOSITEDATATYPE_DRIVER
create table COMPOSITEDATATYPE_DRIVER (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    FIO varchar(255),
    AGE integer,
    --
    primary key (ID)
)^
-- end COMPOSITEDATATYPE_DRIVER
